package dk.kea.calendue.model;

public class Project
{
    private int project_id;
    private String project_name;
    private String project_description;
    private String project_start;
    private String project_deadline;
    private int project_hours;
    private String project_status;

    public Project(int project_id, String project_name, String project_description, String project_start, String project_deadline, int project_hours, String project_status)
    {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_start = project_start;
        this.project_deadline = project_deadline;
        this.project_hours = project_hours;
        this.project_status = project_status;
    }

    @Override
    public String toString()
    {
        return "Project{" +
                "project_id=" + project_id +
                ", project_name='" + project_name + '\'' +
                ", project_description='" + project_description + '\'' +
                ", project_start='" + project_start + '\'' +
                ", project_deadline='" + project_deadline + '\'' +
                ", project_hours=" + project_hours +
                ", project_status='" + project_status + '\'' +
                '}';
    }

    public int getProject_id() {
        return project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public String getProject_start() {
        return project_start;
    }

    public String getProject_deadline() {
        return project_deadline;
    }

    public int getProject_hours() {
        return project_hours;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public void setProject_start(String project_start) {
        this.project_start = project_start;
    }

    public void setProject_deadline(String project_deadline) {
        this.project_deadline = project_deadline;
    }

    public void setProject_hours(int project_hours) {
        this.project_hours = project_hours;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }
}
