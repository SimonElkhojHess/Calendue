package dk.kea.calendue.model;

public class User
{
    int user_id;
    String username;
    String email;
    int is_admin;

    public User(int user_id, String username, String email, int is_admin)
    {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.is_admin = is_admin;
    }

    public User(){}
    public int getUser_id()
    {
        return user_id;
    }

    public void setUser_id(int user_id)
    {
        this.user_id = user_id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getIs_admin()
    {
        return is_admin;
    }

    public void setIs_admin(int is_admin)
    {
        this.is_admin = is_admin;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", is_admin='" + is_admin + '\'' +
                '}';
    }
}
