package dk.kea.calendue.repository;

import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class Project_userRepository {

    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    //Adds a row to project_user and assigns the user a role for the project
    public void setRole(int projectID, int userID, String role)
    {
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String SQL_QUERY = "INSERT INTO calendue.project_user(project_id, user_id, role) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

            preparedStatement.setInt(1,projectID);
            preparedStatement.setInt(2, userID);
            preparedStatement.setString(3, role);

            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not set role");
        }
    }

    //Updates the user's role on the project_user assignment
    public void updateRole(int projectID, int userID, String EditRole)
    {
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "UPDATE calendue.project_user" +
                                        " SET role = '" + EditRole +
                                            "' WHERE project_id = " + projectID +
                                                " AND user_id = " + userID;
            statement.executeUpdate(SQL_QUERY);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not update role");
        }
    }


    //Checks for the existence of a project_user assignment
    public boolean doesAssignmentExist(int userId, int projectId)
    {
        boolean exists = false;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    "SELECT COUNT(user_id)" +
                        " FROM calendue.project_user" +
                            " WHERE user_id = " + userId +
                                " AND project_id = " + projectId;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            resultSet.next();
            int existCounter = resultSet.getInt(1);
            if(existCounter > 0)
            {
                exists = true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not look for project-user assignment");
        }
        return exists;
    }

    //Deletes a project_user assignment
    public void deleteProjectAssignment(int userId, int projectId)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "DELETE FROM calendue.project_user " +
                    "WHERE user_id = " + userId +
                    " AND project_id = " + projectId;
            statement.executeUpdate(SQL_QUERY);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not delete project-user assignment");
        }
    }
}
