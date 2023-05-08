package dk.kea.calendue.model;

import org.springframework.stereotype.Repository;

@Repository
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
}
