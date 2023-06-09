package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;


@Repository
public class Task_userRepository
{
    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    //Get users assigned to this on task_user table
    public List<User> getUsersOnTask(int taskId)
    {
        ArrayList<User> userList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT u.user_id, u.username, u.email, u.full_name " +
                                        "FROM calendue.user u JOIN calendue.task_user t " +
                                            "WHERE t.task_id = "+taskId+
                                                " AND t.user_id = u.user_id" +
                                                    " ORDER BY u.full_name";
            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            while(resultSet.next())
            {
                User user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setFull_name(resultSet.getString(4));
                userList.add(user);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get users on task");
        }
        return userList;
    }

    //Gets users assigned to all tasks in task_user table, belonging to the subproject
    public List<User> getUsersOnSubproject(int subprojectID)
    {
        ArrayList<User> userList = new ArrayList<>();
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    "SELECT u.user_id, u.username, u.email, u.full_name " +
                            "FROM calendue.user u " +
                            "JOIN calendue.task_user t ON u.user_id = t.user_id " +
                            "JOIN calendue.task tk ON t.task_id = tk.task_id " +
                            "WHERE tk.subproject_id = " + subprojectID;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);


            while (resultSet.next())
            {
                User user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(3));
                user.setFull_name(resultSet.getString(4));
                userList.add(user);
            }
            HashSet h = new HashSet(userList);
            userList.clear();
            userList = new ArrayList<>(h);

        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get users on subproject");
        }

        return userList;
    }

    //Assigns user to task in task_user table
    public void assignUserToTask(int taskId, int userId)
    {
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String SQL_QUERY = "INSERT INTO calendue.task_user(task_id, user_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

            preparedStatement.setInt(1, taskId);
            preparedStatement.setInt(2, userId);

            preparedStatement.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not assign user to task");
        }
    }

    //Checks for existence of task_user assignment
    public boolean doesTaskAssignmentExist(int taskId, int tempUserId)
    {
        boolean exists = false;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT COUNT(user_id)" +
                    " FROM calendue.task_user" +
                    " WHERE user_id = " + tempUserId +
                    " AND task_id = " + taskId;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);
            resultSet.next();
            int existCounter = resultSet.getInt(1);
            if(existCounter > 0)
            {
                exists = true;
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not tell if user is assigned to task");
        }
        return exists;

    }

    //Deletes assignment in task_user table.
    public void deleteTaskAssignment(int userId, int taskId)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "DELETE FROM calendue.task_user " +
                    "WHERE user_id = " + userId +
                    " AND task_id = " + taskId;
            statement.executeUpdate(SQL_QUERY);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not delete task-user assignment");
        }
    }

}
