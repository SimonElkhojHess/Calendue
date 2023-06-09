package dk.kea.calendue.repository;

import dk.kea.calendue.model.Subproject;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubprojectRepository
{
    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    public List<Subproject> getAllSubprojects(int project_id)
    {
        List<Subproject> sList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.subproject WHERE project_id =" + project_id;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int subproject_id = resultSet.getInt(1);
                project_id = resultSet.getInt(2); //HUSK DET HER! ER DEN NØDVENDIG?
                String subproject_name = resultSet.getString(3);
                String subproject_description = resultSet.getString(4);
                String subproject_deadline = resultSet.getString(5);
                int subproject_hours = resultSet.getInt(6);
                String subproject_status = resultSet.getString(7);

                Subproject subproject = new Subproject(subproject_id, project_id, subproject_name, subproject_description, subproject_deadline, subproject_hours, subproject_status);
                sList.add(subproject);
                System.out.println("Found: " + subproject);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get subprojects");
        }

        return sList;
    }

    public void createSubProject(int project_id, String subprojectName)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String CREATE_QUERY =
                    "INSERT INTO calendue.subproject(project_id, subproject_name) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);

            preparedStatement.setInt(1, project_id);
            preparedStatement.setString(2, subprojectName);

            preparedStatement.executeUpdate();


        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not create new Project");
        }
    }

    //Gets the maximum subproject Id from database
    public int getMaxSubprojectId()
    {
        int tempSubprojectID = -99;
            try
            {
                Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
                Statement statement = connection.createStatement();
                final String SQL_QUERY = "SELECT MAX(subproject_id) FROM calendue.subproject";

                ResultSet resultSet = statement.executeQuery(SQL_QUERY);

                if(resultSet.next())
                {
                    tempSubprojectID = resultSet.getInt(1);
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
                System.out.println("Could not get max subproject id");
            }
            return tempSubprojectID;
    }

    public Subproject getOneSubproject(int subprojectID)
    {
        Subproject tempSubproject = new Subproject();
        try {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.subproject WHERE subproject_id =" + subprojectID;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            if(resultSet.next())
            {
                tempSubproject.setSubproject_id(subprojectID);
                tempSubproject.setProject_id(resultSet.getInt(2));
                tempSubproject.setSubproject_name(resultSet.getString(3));
                tempSubproject.setSubproject_description(resultSet.getString(4));
                tempSubproject.setSubproject_deadline(resultSet.getString(5));
                int manhours = 0;
                manhours = getTotalSubHours(subprojectID);
                tempSubproject.setSubproject_hours(manhours);
                tempSubproject.setSubproject_status(resultSet.getString(7));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get specific subproject info");
        }
        return tempSubproject;
    }

    public void deleteSubproject(int subprojectID)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String DELETE_QUERY = "DELETE FROM calendue.subproject WHERE subproject_id =" + subprojectID;

            statement.executeUpdate(DELETE_QUERY);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not delete subproject");
        }
    }

    public void editSubproject(Subproject subproject)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String UPDATE_QUERY =
                    "UPDATE calendue.subproject " +
                            "SET subproject_name=?, subproject_description=?, " +
                            "subproject_deadline=?, subproject_hours=?, subproject_status=? " +
                            "WHERE subproject_id = " + subproject.getSubproject_id();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, subproject.getSubproject_name());
            preparedStatement.setString(2, subproject.getSubproject_description());
            preparedStatement.setString(3, subproject.getSubproject_deadline());
            preparedStatement.setInt(4, subproject.getSubproject_hours());
            preparedStatement.setString(5, subproject.getSubproject_status());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not edit subproject");
        }
    }

    //Gets the total amount of task_hours belonging to subproject.
    public int getTotalSubHours(int subprojectId)
    {
        int totalSubHours = 0;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT SUM(task_hours)" +
                                        " FROM calendue.task" +
                                            " WHERE subproject_id = " + subprojectId;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            if(resultSet.next())
            {
                totalSubHours = resultSet.getInt(1);
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get total sub hours");
        }
        return totalSubHours;
    }
}
