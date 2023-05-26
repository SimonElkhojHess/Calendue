package dk.kea.calendue.model;

import org.springframework.stereotype.Repository;


public class Task
{
    private int task_id;
    private int subproject_id;
    private String task_name;
    private String task_description;
    private String task_comment;
    private String task_deadline;
    private int task_hours;
    private int task_priority;
    private String task_status;

    public Task()
    {}

    public Task(int task_id, int subproject_id, String task_name, String task_description, String task_comment, String task_deadline, int task_hours, int task_priority, String task_status)
    {
        this.task_id = task_id;
        this.subproject_id = subproject_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_comment = task_comment;
        this.task_deadline = task_deadline;
        this.task_hours = task_hours;
        this.task_priority = task_priority;
        this.task_status = task_status;
    }
    public Task(int task_id, String task_name, String task_description, String task_deadline, int task_hours, int task_priority, String task_status)
    {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_deadline = task_deadline;
        this.task_hours = task_hours;
        this.task_priority = task_priority;
        this.task_status = task_status;
    }

    public int getTask_id()
    {
        return task_id;
    }

    public void setTask_id(int task_id)
    {
        this.task_id = task_id;
    }

    public int getSubproject_id()
    {
        return subproject_id;
    }

    public void setSubproject_id(int subproject_id)
    {
        this.subproject_id = subproject_id;
    }

    public String getTask_name()
    {
        return task_name;
    }

    public void setTask_name(String task_name)
    {
        this.task_name = task_name;
    }

    public String getTask_description()
    {
        return task_description;
    }

    public void setTask_description(String task_description)
    {
        this.task_description = task_description;
    }

    public String getTask_comment()
    {
        return task_comment;
    }

    public void setTask_comment(String task_comment)
    {
        this.task_comment = task_comment;
    }

    public String getTask_deadline()
    {
        return task_deadline;
    }

    public void setTask_deadline(String task_deadline)
    {
        this.task_deadline = task_deadline;
    }

    public int getTask_hours()
    {
        return task_hours;
    }

    public void setTask_hours(int task_hours)
    {
        this.task_hours = task_hours;
    }

    public int getTask_priority()
    {
        return task_priority;
    }

    public void setTask_priority(int task_priority)
    {
        this.task_priority = task_priority;
    }

    public String getTask_status()
    {
        return task_status;
    }

    public void setTask_status(String task_status)
    {
        this.task_status = task_status;
    }

    @Override
    public String toString()
    {
        return "Task{" +
                "task_id=" + task_id +
                ", subproject_id=" + subproject_id +
                ", task_name='" + task_name + '\'' +
                ", task_description='" + task_description + '\'' +
                ", task_comment='" + task_comment + '\'' +
                ", task_deadline='" + task_deadline + '\'' +
                ", task_hours=" + task_hours +
                ", task_priority=" + task_priority +
                ", task_status='" + task_status + '\'' +
                '}';
    }
}
