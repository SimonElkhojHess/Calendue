package dk.kea.calendue.repository;

import dk.kea.calendue.model.Project;
import dk.kea.calendue.model.Subproject;
import dk.kea.calendue.utility.ConnectionManager;
import dk.kea.calendue.utility.DateCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository
{
    SubprojectRepository subprojectRepository = new SubprojectRepository();

    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    public List<Project> getAllProjects()
    {
        List<Project> pList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.project";

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int project_id = resultSet.getInt(1);
                String project_name = resultSet.getString(2);
                String project_description = resultSet.getString(3);
                String project_start = resultSet.getString(4);
                String project_deadline = resultSet.getString(5);
                String project_status = resultSet.getString(7);
                int project_hours_scheduled = 0;
                List<Subproject> subList = subprojectRepository.getAllSubprojects(project_id);
                for(int i = 0; i < subList.size(); i++)
                {
                    int subHours = subprojectRepository.getTotalSubHours(subList.get(i).getSubproject_id());
                    project_hours_scheduled += subHours;
                }
                int hours_per_day = 0;
                int project_days = 1;
                if(project_start != null && project_deadline != null)
                {
                    if (project_start.length() > 5 && project_deadline.length() > 5) {
                        project_days = DateCalculator.returnDateDifference(project_start, project_deadline);
                    }
                }
                int assigned_users = getProjectAssignmentCount(project_id);
                int project_hours = project_days*8;

                hours_per_day = project_hours_scheduled/project_days/assigned_users;

                Project project = new Project(project_id, project_name, project_description, project_start, project_deadline, project_hours, project_status, project_days, hours_per_day, assigned_users, project_hours_scheduled);
                pList.add(project);
                System.out.println("Found: " + project);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get projects");
        }

        return pList;
    }

    public List<Project> getAllMyProjects(int user_id)
    {
        List<Project> pList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    "SELECT * FROM calendue.project " +
                    "WHERE project_id IN " +
                        "(SELECT project_id " +
                         "FROM calendue.project_user " +
                         "WHERE user_id = " + user_id + ")";

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int project_id = resultSet.getInt(1);
                String project_name = resultSet.getString(2);
                String project_description = resultSet.getString(3);
                String project_start = resultSet.getString(4);
                String project_deadline = resultSet.getString(5);
                int project_hours = resultSet.getInt(6);
                String project_status = resultSet.getString(7);

                Project project = new Project(project_id, project_name, project_description, project_start, project_deadline, project_hours, project_status);
                pList.add(project);
                System.out.println("Found: " + project);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get projects");
        }

        return pList;

    }



    public void createProject(Project project)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String CREATE_QUERY =
                    "INSERT INTO calendue.project(project_name) VALUES (?)";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);

            preparedStatement.setString(1, project.getProject_name());

            preparedStatement.executeUpdate();


        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not create new Project");
        }
    }

    public int getMaxProjectId()
    {
        int tempProjectID = -99;
            try{
        Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
        Statement statement = connection.createStatement();
        final String SQL_QUERY = "SELECT MAX(project_id) FROM calendue.project";

        ResultSet resultSet = statement.executeQuery(SQL_QUERY);

        if(resultSet.next())
        {
            tempProjectID = resultSet.getInt(1);
        }

        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find max project id ");
        }

            return tempProjectID;
    }


    public Project getOneProject(int projectID)
    {
        Project tempProject = new Project();
        try {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.project WHERE project_id =" + projectID;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            if(resultSet.next())
            {
                tempProject.setProject_id(projectID);
                tempProject.setProject_name(resultSet.getString(2));
                tempProject.setProject_description(resultSet.getString(3));
                tempProject.setProject_start(resultSet.getString(4));
                tempProject.setProject_deadline(resultSet.getString(5));
                tempProject.setProject_hours(resultSet.getInt(6));
                tempProject.setProject_status(resultSet.getString(7));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get specific project info");
        }
         return tempProject;
    }

    public String getUserProjectAssignment(int user_id, int project_id)
    {
        String userAssignment = "none";
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT role " +
                                        "FROM calendue.project_user " +
                                            "WHERE user_id = "+user_id+
                                                " AND project_id = "+project_id;
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            if(resultSet.next())
            {
                userAssignment = resultSet.getString(1);
            }
        }
        catch(SQLException e)
        {

        }
        return userAssignment;
    }

    public int getProjectAssignmentCount(int projectId)
    {
        int assignmentCount = 0;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT COUNT(user_id)" +
                                        " from calendue.project_user" +
                                            " WHERE project_id = "+ projectId;
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            if(resultSet.next())
            {
                assignmentCount = resultSet.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get project assignment count");
        }
        return assignmentCount;
    }

    public void editProject(Project project)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String UPDATE_QUERY =
                    "UPDATE calendue.project " +
                            "SET project_name=?, project_description=?, project_start=?, " +
                            "project_deadline=?, project_hours=?, project_status=? " +
                            "WHERE project_id = " + project.getProject_id();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, project.getProject_name());
            preparedStatement.setString(2, project.getProject_description());
            preparedStatement.setString(3, project.getProject_start());
            preparedStatement.setString(4, project.getProject_deadline());
            preparedStatement.setInt(5, project.getProject_hours());
            preparedStatement.setString(6, project.getProject_status());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not edit project");
        }
    }

    public void deleteProject(int projectID)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String DELETE_QUERY = "DELETE FROM calendue.project WHERE project_id =" + projectID;

            statement.executeUpdate(DELETE_QUERY);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not delete project");
        }
    }

}
