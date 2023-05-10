package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository
{
    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    //Compares password with hashed password from DB and logs in if it matches
    public boolean checkLogin(String username, String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); //The strength affects how long it takes to encrypt and decrypt the password. 10 takes about a second for us, so we will leave it there.

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            String SEARCH_QUERY = "SELECT password " +
                                    "FROM calendue.user " +
                                        "WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            String savedCode = resultSet.getString(1);
            System.out.println(savedCode);
            if(encoder.matches(password, savedCode))
            {
                return true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not verify login info");
        }
        return false;
    }

    //Searches for specific username in database table 'user'
    public boolean checkUsername(String username)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            String SEARCH_QUERY = "SELECT * " +
                                    "FROM calendue.user " +
                                        "WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();
            int rowCount = 0;
            while(resultSet.next())
            {
                rowCount++;
            }
            if(rowCount==0)
            {
                return false;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not check username");
        }
        return true;
    }

    //Returns all but password info for 1 user from database table 'user'
    public User getUserInfo(String username)
    {
        User tempUser = new User();
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            String SEARCH_QUERY = "SELECT user_id, username, email, is_admin " +
                                        "FROM calendue.user" +
                                            " WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            tempUser.setUser_id(resultSet.getInt(1));
            tempUser.setUsername(resultSet.getString(2));
            tempUser.setEmail(resultSet.getString(3));
            tempUser.setIs_admin(resultSet.getInt(4));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get user info");
        }

        return tempUser;
    }

    //Collects all users assigned to project, and their role from project_user table.
    public List<User> getUsersOnProject(int projectID)
    {
        ArrayList<User> userList = new ArrayList<>();
        try {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                            "SELECT u.user_id, u.username, u.email, u.is_admin, u.full_name, p.role " +
                                "FROM calendue.user u JOIN calendue.project_user p " +
                                    "WHERE p.project_id = "+projectID;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int tempUserid = resultSet.getInt(1);
                String tempUsername = resultSet.getString(2);
                String tempEmail = resultSet.getString(3);
                int tempIsadmin = resultSet.getInt(4);
                String tempFullname = resultSet.getString(5);
                String tempRole = resultSet.getString(6);
                User user = new User(tempUserid, tempUsername, tempEmail, tempIsadmin, tempFullname, tempRole);
                userList.add(user);
                System.out.println("Found: "+user);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get assigned users on project "+projectID);
        }
            return userList;
    }
}
