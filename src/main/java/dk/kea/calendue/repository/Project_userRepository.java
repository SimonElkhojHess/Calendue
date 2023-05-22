package dk.kea.calendue.repository;

import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

@Repository
public class Project_userRepository {
    /*private int project_id;
    private int user_id;
    private String role;*/

    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

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

    /*public int getMaxProject_idByUser(int user_id)
    {
        int tempProjectID = -99;
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT MAX(project_id) FROM calendue.project_user WHERE user_id ="+user_id;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            if(resultSet.next())
            {
                tempProjectID = resultSet.getInt(1);
            }

        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find project id by user");
        }

        return tempProjectID;
    }*/

    public boolean doesAssignmentExist(int userId, int projectId)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not look for project-user assignment");
        }
    }
}
