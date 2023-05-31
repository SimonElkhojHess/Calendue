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
    private int project_days;
    private double project_hours_per_day;
    private int users_assigned;
    private int project_hours_scheduled;

    public Project(int project_id, String project_name, String project_description, String project_start, String project_deadline, int project_hours, String project_status, int project_days, double project_hours_per_day, int users_assigned, int project_hours_scheduled)
    {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_start = project_start;
        this.project_deadline = project_deadline;
        this.project_hours = project_hours;
        this.project_status = project_status;
        this.project_days = project_days;
        this.project_hours_per_day = project_hours_per_day;
        this.users_assigned = users_assigned;
        this.project_hours_scheduled = project_hours_scheduled;
    }

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
    public Project(){}

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getProject_start() {
        return project_start;
    }

    public void setProject_start(String project_start) {
        this.project_start = project_start;
    }

    public String getProject_deadline() {
        return project_deadline;
    }

    public void setProject_deadline(String project_deadline) {
        this.project_deadline = project_deadline;
    }

    public int getProject_hours() {
        return project_hours;
    }

    public void setProject_hours(int project_hours) {
        this.project_hours = project_hours;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public int getProject_days()
    {
        return project_days;
    }

    public void setProject_days(int project_days)
    {
        this.project_days = project_days;
    }

    public double getProject_hours_per_day()
    {
        return project_hours_per_day;
    }

    public void setProject_hours_per_day(double project_hours_per_day)
    {
        this.project_hours_per_day = project_hours_per_day;
    }

    public int getUsers_assigned()
    {
        return users_assigned;
    }

    public void setUsers_assigned(int users_assigned)
    {
        this.users_assigned = users_assigned;
    }

    public int getProject_hours_scheduled()
    {
        return project_hours_scheduled;
    }

    public void setProject_hours_scheduled(int project_hours_scheduled)
    {
        this.project_hours_scheduled = project_hours_scheduled;
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

}
