package dk.kea.calendue.repository;

import dk.kea.calendue.model.Project;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepository
{
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

    public List<Project> getAllMyProjects(int user_id)
    {
        List<Project> pList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    "SELECT * FROM calendue.project" +
                    "WHERE project_id IN" +
                        ("SELECT project_id " +
                         "FROM calendue.project_user " +
                         "WHERE user_id =" + user_id);

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
}
