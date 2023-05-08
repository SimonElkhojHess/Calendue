package dk.kea.calendue.repository;

import dk.kea.calendue.model.Subproject;
import dk.kea.calendue.utility.ConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SubprojectRepository
{
    @Value("$(spring.datasource.url)")
    private String HOSTNAME;

    @Value("$(spring.datasource.username)")
    private String USERNAME;

    @Value("$(spring.datasource.password")
    private String PASSWORD;

    public List<Subproject> getAllSubprojects(int project_id)
    {
        List<Subproject> sList = new ArrayList<>();

        try
        {
            Connection connection = ConnectionManager.getConnection(HOSTNAME, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            final String SQL_QUERY = "SELECT * FROM calendue.subproject WHERE project_id =" + project_id;

            ResultSet resultSet = statement.executeQuery(SQL_QUERY);

            while(resultSet.next())
            {
                int subproject_id = resultSet.getInt(1);
                project_id = resultSet.getInt(2); //HUSK DET HER! ER DEN NØDVENDIG?
                String subproject_name = resultSet.getString(3);
                String subproject_description = resultSet.getString(4);
                String subproject_deadline = resultSet.getString(5);
                int subproject_hours = resultSet.getInt(6);
                String subproject_status = resultSet.getString(7);

                Subproject subproject = new Subproject(subproject_id, project_id, subproject_name, subproject_description, subproject_deadline, subproject_hours, subproject_status);
                sList.add(subproject);
                System.out.println("Found: " + subproject);
            }


        } catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Could not get subprojects");
        }

        return sList;
    }
}
