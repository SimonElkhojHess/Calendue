package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.nimbus.State;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class Task_userRepository
{
    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

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
}
