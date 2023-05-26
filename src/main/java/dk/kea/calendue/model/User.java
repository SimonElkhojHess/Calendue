package dk.kea.calendue.model;

import java.util.Objects;

public class User
{
    private int user_id;
    private String username;
    private String email;
    private int is_admin;
    private String full_name;
    private String role;

    private String password;


    public User(int user_id, String username, String email, int is_admin)
    {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.is_admin = is_admin;
    }
    public User(int user_id, String username, String email, int is_admin, String full_name)
    {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.is_admin = is_admin;
        this.full_name = full_name;
    }
    public User(int user_id, String username,String full_name, String password, String email, int is_admin)
    {
        this.user_id = user_id;
        this.username = username;
        this.full_name = full_name;
        this.password = password;
        this.email = email;
        this.is_admin = is_admin;

    }

    public User(String username, String full_name, String password, String email, int is_admin)
    {
        this.username = username;
        this.full_name = full_name;
        this.password = password;
        this.email = email;
        this.is_admin = is_admin;
    }

    public User(int user_id, String username, String email, int is_admin, String full_name, String role) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.is_admin = is_admin;
        this.full_name = full_name;
        this.role = role;
    }




    public User(){}


    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

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

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", is_admin=" + is_admin +
                ", full_name='" + full_name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        /*if (this == o) return true;*/
        if (!(o instanceof User)) return false;
        User otherUser = (User) o;
        return this.user_id == otherUser.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
