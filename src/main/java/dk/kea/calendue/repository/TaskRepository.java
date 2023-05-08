package dk.kea.calendue.repository;

import dk.kea.calendue.model.Task;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.sql.Connection;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TaskRepository
{
    @Value("$(spring.datasource.url)")
    private String HOSTNAME;

    @Value("$(spring.datasource.username)")
    private String USERNAME;

    @Value("$(spring.datasource.password")
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
                    ("SELECT task_user_task_id " +
                            "FROM calendue.task_user " +
                            "WHERE task_user_user_id =" + user_id);

        } catch ()

    }

    public List<Task> getSubprojectTasks(int subproject_id)
    {

    }

    public List<Task> getMySubprojectTasks(int user_id)
    {

    }


}
