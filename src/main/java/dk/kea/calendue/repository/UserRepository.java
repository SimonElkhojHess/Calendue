package dk.kea.calendue.repository;

import dk.kea.calendue.model.User;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.xml.transform.Result;
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

    public String encodePassword(String password)
    {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10); //The strength affects how long it takes to encrypt and decrypt the password. 10 takes about a second for us, so we will leave it there.
        return encoder.encode(password);
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
            String SEARCH_QUERY = "SELECT user_id, username, email, is_admin, full_name " +
                                        "FROM calendue.user" +
                                            " WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next())
            {
                tempUser.setUser_id(resultSet.getInt(1));
                tempUser.setUsername(resultSet.getString(2));
                tempUser.setEmail(resultSet.getString(3));
                tempUser.setIs_admin(resultSet.getInt(4));
                tempUser.setFull_name(resultSet.getString(5));
            }
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
                                "FROM calendue.project_user p JOIN calendue.user u " +
                                    "WHERE p.project_id = "+projectID+
                                        " AND p.user_id = u.user_id"+
                                            " ORDER BY p.role DESC, u.full_name ASC";


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

    //Collects all user IDs and emails for the datalist in the html file "subprojects" to assign users to a project.
    public List<User> getAllUsers()
    {
        ArrayList<User> userList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SEARCH_QUERY = "SELECT user_id, email from calendue.user";

            ResultSet resultSet = statement.executeQuery(SEARCH_QUERY);

            while(resultSet.next())
            {
                User user = new User();
                user.setUser_id(resultSet.getInt(1));
                user.setEmail(resultSet.getString(2));
                userList.add(user);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get all users");
        }
        return userList;
    }


    public int getUserIDFromEmail(String email)
    {
        int assignuserId = 0;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            String SEARCH_QUERY = "SELECT user_id"
                    + " FROM calendue.user"
                    + " WHERE email = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_QUERY);

            preparedStatement.setString(1, email);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next())
            {
                assignuserId = resultSet.getInt(1);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get user ID from email");
        }

        return assignuserId;

    }

    public boolean doesEmailExist(String email)
    {
        boolean exists = false;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String SQL_QUERY = "SELECT COUNT(email) FROM calendue.user WHERE email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int emailCounter = resultSet.getInt(1);
            if(emailCounter > 0)
            {
                exists = true;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not look for existing email");
        }
        return exists;
    }

    //Get all users for admin method
    public List<User> getAllUsersForAdmin()
    {
        ArrayList<User> userList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.user";

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int user_id = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(4);
                int is_admin = resultSet.getInt(5);
                String full_name = resultSet.getString(6);

                userList.add(new User(user_id, username, email, is_admin, full_name));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get all users for admin");
        }
        return userList;
    }

    public void createUser(User user)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME,PASSWORD);
            final String CREATE_QUERY = "INSERT INTO calendue.user(username, password, email, is_admin, full_name) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getIs_admin());
            preparedStatement.setString(5, user.getFull_name());

            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not create user");
        }
    }

    public User getOneUser(int id)
    {
        User user = new User();
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.user WHERE user_id = "+id;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            if(resultSet.next())
            {
                user.setUser_id(resultSet.getInt(1));
                user.setUsername(resultSet.getString(2));
                user.setEmail(resultSet.getString(4));
                user.setIs_admin(resultSet.getInt(5));
                user.setFull_name(resultSet.getString(6));
            }

    } catch(SQLException e) {
            e.printStackTrace();
            System.out.println("Could not get one user by id");
        }
        return user;
    }

    public void editUser(User user)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String UPDATE_QUERY = "UPDATE calendue.user SET username=?, email=?, is_admin=?, full_name=? WHERE user_id="+user.getUser_id();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getIs_admin());
            preparedStatement.setString(4, user.getFull_name());

            preparedStatement.executeUpdate();

            //If user does not edit password, the password is not touched in the DB at all
            if(!user.getPassword().equals("noEdit"))
            {
                final String PASSWORD_QUERY = "UPDATE calendue.user SET password=? WHERE user_id="+user.getUser_id();
                preparedStatement = connection.prepareStatement(PASSWORD_QUERY);
                preparedStatement.setString(1, user.getPassword());
                preparedStatement.executeUpdate();
            }

        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not edit user");
        }
    }

    public void deleteUser(int user_id)
    {
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String DELETE_ASSIGMENT_PROJECT_SQL = "DELETE FROM calendue.project_user WHERE user_id="+user_id;
            final String DELETE_ASSIGMENT_SUBPROJECT_SQL = "DELETE FROM calendue.subproject_user WHERE user_id="+user_id;
            final String DELETE_ASSIGMENT_TASK_SQL = "DELETE FROM calendue.task_user WHERE user_id="+user_id;
            final String DELETE_USER_SQL="DELETE FROM calendue.user WHERE user_id="+user_id;

            statement.executeUpdate(DELETE_ASSIGMENT_TASK_SQL);
            statement.executeUpdate(DELETE_ASSIGMENT_SUBPROJECT_SQL);
            statement.executeUpdate(DELETE_ASSIGMENT_PROJECT_SQL);
            statement.executeUpdate(DELETE_USER_SQL);

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Could not delete user");
        }
    }

}
