package dk.kea.calendue.model;

import org.springframework.stereotype.Repository;


public class Task
{
    private int task_id;
    private int subproject_id;
    private String task_name;
    private String task_description;
    private String task_comment;
    private String task_start;
    private int task_hours;
    private int task_priority;
    private String task_status;

    public Task(int task_id, int subproject_id, String task_name, String task_description, String task_comment, String task_start, int task_hours, int task_priority, String task_status)
    {
        this.task_id = task_id;
        this.subproject_id = subproject_id;
        this.task_name = task_name;
        this.task_description = task_description;
        this.task_comment = task_comment;
        this.task_start = task_start;
        this.task_hours = task_hours;
        this.task_priority = task_priority;
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
                ", task_start='" + task_start + '\'' +
                ", task_hours=" + task_hours +
                ", task_priority=" + task_priority +
                ", task_status='" + task_status + '\'' +
                '}';
    }
}
