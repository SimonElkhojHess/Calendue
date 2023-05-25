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

    public Subproject()
    {}

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

    public Subproject(int subproject_id, String subproject_name, String subproject_description, String subproject_deadline, int subproject_hours, String subproject_status)
    {
        this.subproject_id = subproject_id;
        this.subproject_name = subproject_name;
        this.subproject_description = subproject_description;
        this.subproject_deadline = subproject_deadline;
        this.subproject_hours = subproject_hours;
        this.subproject_status = subproject_status;
    }

    public int getSubproject_id()
    {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id)
    {
        this.subproject_id = subproject_id;
    }

    public int getProject_id()
    {
        return project_id;
    }

    public void setProject_id(int project_id)
    {
        this.project_id = project_id;
    }

    public String getSubproject_name()
    {
        return subproject_name;
    }

    public void setSubproject_name(String subproject_name)
    {
        this.subproject_name = subproject_name;
    }

    public String getSubproject_description()
    {
        return subproject_description;
    }

    public void setSubproject_description(String subproject_description)
    {
        this.subproject_description = subproject_description;
    }

    public String getSubproject_deadline()
    {
        return subproject_deadline;
    }

    public void setSubproject_deadline(String subproject_deadline)
    {
        this.subproject_deadline = subproject_deadline;
    }

    public int getSubproject_hours()
    {
        return subproject_hours;
    }

    public void setSubproject_hours(int subproject_hours)
    {
        this.subproject_hours = subproject_hours;
    }

    public String getSubproject_status()
    {
        return subproject_status;
    }

    public void setSubproject_status(String subproject_status)
    {
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
