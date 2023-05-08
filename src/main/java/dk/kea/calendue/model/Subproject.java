package dk.kea.calendue.model;

public class Subproject
{
    private int subproject_id;
    private int project_id;
    private String subproject_name;
    private String subproject_description;
    private String subproject_deadline;
    private int subproject_hours;
    private String subproject_status;

    public Subproject(int subproject_id, int project_id, String subproject_name, String subproject_description, String subproject_deadline, int subproject_hours, String subproject_status)
    {
        this.subproject_id = subproject_id;
        this.project_id = project_id;
        this.subproject_name = subproject_name;
        this.subproject_description = subproject_description;
        this.subproject_deadline = subproject_deadline;
        this.subproject_hours = subproject_hours;
        this.subproject_status = subproject_status;
    }

    @Override
    public String toString()
    {
        return "Subproject{" +
                "subproject_id=" + subproject_id +
                ", project_id=" + project_id +
                ", subproject_name='" + subproject_name + '\'' +
                ", subproject_description='" + subproject_description + '\'' +
                ", subproject_deadline='" + subproject_deadline + '\'' +
                ", subproject_hours=" + subproject_hours +
                ", subproject_status='" + subproject_status + '\'' +
                '}';
    }
}
