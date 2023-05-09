package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.sql.*;

@Repository
public class UserRepository
{
    @Value("${spring.datasource.url}")
    private String DB_URL;

    @Value("${spring.datasource.username}")
    private String UID;

    @Value("${spring.datasource.password}")
    private String PWD;

    public boolean checkLogin(String username, String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); //The strength affects how long it takes to encrypt and decrypt the password. 10 takes about a second for us, so we will leave it there.

        try
        {
            Connection connection = DriverManager.getConnection(DB_URL, UID, PWD);
            String SEARCH_QUERY = "SELECT password FROM calendue.user WHERE username = ?";
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

    public boolean checkUsername(String username)
    {
        try
        {
            Connection connection = DriverManager.getConnection(DB_URL, UID, PWD);
            String SEARCH_QUERY = "SELECT * FROM calendue.user WHERE username = ?";
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

    public User getUserInfo(String username)
    {
        User tempUser = new User();
        try
        {
            Connection connection = DriverManager.getConnection(DB_URL, UID, PWD);
            String SEARCH_QUERY = "SELECT user_id, username, email, is_admin FROM calendue.user WHERE username = ?";
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


}
