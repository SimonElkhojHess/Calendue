package dk.kea.calendue.repository;

import dk.kea.calendue.model.Project;
import dk.kea.calendue.model.Task;
import dk.kea.calendue.utility.ConnectionManager;
import org.apache.catalina.Host;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository
{
    @Value("${spring.datasource.url}")
    private String HOSTNAME;

    @Value("${spring.datasource.username}")
    private String USERNAME;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    //Liste over alle opgaver tilknyttet til et bruger-id
    public List<Task> getMyTasks(int user_id)
    {
        List<Task> tList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =

                    "SELECT * FROM calendue.task " +
                            "WHERE task_id IN" +
                    ("SELECT task_id " +
                            "FROM calendue.task_user " +
                            "WHERE user_id =" + user_id);

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);


            while(resultSet.next())
            {
                int task_id = resultSet.getInt(1);
                int subproject_id = resultSet.getInt(2);
                String task_name = resultSet.getString(3);
                String task_description = resultSet.getString(4);
                String task_comment = resultSet.getString(5);
                String task_start = resultSet.getString(6);
                int task_hours = resultSet.getInt(7);
                int task_priority = resultSet.getInt(8);
                String task_status = resultSet.getString(9);

                Task task = new Task(task_id, subproject_id, task_name, task_description, task_comment, task_start, task_hours,task_priority, task_status);
                tList.add(task);
                System.out.println("Found:" + task);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find all my tasks");
        }
        return tList;
    }

    public List<Task> getSubprojectTasks(int subproject_id)
    {
        List<Task> tList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    
                    "SELECT * FROM calendue.task " +
                    "WHERE subproject_id =" + subproject_id;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while (resultSet.next())
            {
                int task_id = resultSet.getInt(1);
                subproject_id = resultSet.getInt(2);
                String task_name = resultSet.getString(3);
                String task_description = resultSet.getString(4);
                String task_comment = resultSet.getString(5);
                String task_start = resultSet.getString(6);
                int task_hours = resultSet.getInt(7);
                int task_priority = resultSet.getInt(8);
                String task_status = resultSet.getString(9);

                Task task = new Task(task_id, subproject_id, task_name, task_description, task_comment, task_start, task_hours, task_priority, task_status);
                tList.add(task);
                System.out.println("Found :" + task);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find subproject tasks");
        }

        return tList;
    }

    public List<Task> getMySubprojectTasks(int user_id, int subproject_id)
    {
        List<Task> tList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY =
                    "SELECT * FROM calendue.task " +
                    "WHERE subproject_id =" + subproject_id +
                    " AND task_id IN" +
                    ("SELECT task_id" +
                            "FROM calendue.task_user " +
                            "WHERE user_id =" + user_id);

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while (resultSet.next())
            {
                int task_id = resultSet.getInt(1);
                subproject_id = resultSet.getInt(2);
                String task_name = resultSet.getString(3);
                String task_description = resultSet.getString(4);
                String task_comment = resultSet.getString(5);
                String task_start = resultSet.getString(6);
                int task_hours = resultSet.getInt(7);
                int task_priority = resultSet.getInt(8);
                String task_status = resultSet.getString(9);

                Task task = new Task(task_id, subproject_id, task_name, task_description, task_comment, task_start, task_hours, task_priority, task_status);
                tList.add(task);
                System.out.println("Found :" + task);
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find MY subproject tasks");
        }
        return tList;
    }

    public void createTask(Task task)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String CREATE_QUERY =
                    "INSERT INTO calendue.task(subproject_id, task_name) VALUES (?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_QUERY);

            preparedStatement.setInt(1, task.getSubproject_id());
            preparedStatement.setString(2, task.getTask_name());

            preparedStatement.executeUpdate();

        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not create new task");
        }
    }

    public int getMaxTaskId()
    {
        int tempTaskID = -99;
        try{
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT MAX(task_id) FROM calendue.task";

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            if(resultSet.next())
            {
                tempTaskID = resultSet.getInt(1);
            }

        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find max task id ");
        }

        return tempTaskID;
    }

    public Task getOneTask(int taskId)
    {
        Task task = new Task();
        task.setTask_id(taskId);
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT task_name, task_description, task_comment, task_start, task_hours, task_priority, task_status" +
                                        " FROM calendue.task WHERE task_id = " + taskId;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            if(resultSet.next())
            {
                task.setTask_name(resultSet.getString(1));
                task.setTask_description(resultSet.getString(2));
                task.setTask_comment(resultSet.getString(3));
                task.setTask_start(resultSet.getString(4));
                task.setTask_hours(resultSet.getInt(5));
                task.setTask_priority(resultSet.getInt(6));
                task.setTask_status(resultSet.getString(7));
            }
        } catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not find specific task");
        }

        return task;
    }


    public void editTask(Task task)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String UPDATE_QUERY =
                        "UPDATE calendue.task " +
                            "SET task_name=?, task_description=?, task_start=?, task_hours=?, task_priority=?, task_status=? " +
                                "WHERE task_id = " + task.getTask_id();

            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);

            preparedStatement.setString(1, task.getTask_name());
            preparedStatement.setString(2, task.getTask_description());
            preparedStatement.setString(3, task.getTask_start());
            preparedStatement.setInt(4, task.getTask_hours());
            preparedStatement.setInt(5, task.getTask_priority());
            preparedStatement.setString(6, task.getTask_status());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not edit task");
        }
    }

    public int getProjectIdFromTaskId(int taskId)
    {
        int projectId = 0;
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY=
                    "SELECT s.project_id " +
                            "FROM calendue.task t JOIN calendue.subproject s" +
                            " WHERE t.task_id = "+ taskId +
                            " AND t.subproject_id = s.subproject_id";

            ResultSet resultset = statement.executeQuery(SQL_QUERY);

            if(resultset.next())
            {
                projectId = resultset.getInt(1);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get project id from task id");
        }
        return projectId;
    }

    public void editTaskComment(int taskId, String taskComment)
    {
        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            final String SQL_QUERY = "UPDATE calendue.task SET task_comment = ? WHERE task_id = "+taskId;

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_QUERY);

            preparedStatement.setString(1, taskComment);

            preparedStatement.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not edit task comment");
        }
    }
}
