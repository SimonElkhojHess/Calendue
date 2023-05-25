package dk.kea.calendue.controller;

import dk.kea.calendue.model.Project;
import dk.kea.calendue.model.Subproject;
import dk.kea.calendue.model.Task;
import dk.kea.calendue.model.User;
import dk.kea.calendue.repository.*;
import dk.kea.calendue.repository.ProjectRepository;
import dk.kea.calendue.repository.SubprojectRepository;
import dk.kea.calendue.repository.TaskRepository;
import dk.kea.calendue.repository.UserRepository;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private UserRepository userRepo;
    private ProjectRepository projectRepo;
    private SubprojectRepository subprojectRepo;
    private TaskRepository taskRepo;
    private Project_userRepository project_userRepo;
    private Task_userRepository task_userRepo;


    public HomeController(UserRepository userRepo, ProjectRepository projectRepo, SubprojectRepository subprojectRepo, TaskRepository taskRepo, Project_userRepository project_userRepo, Task_userRepository task_userRepo)

    {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
        this.subprojectRepo = subprojectRepo;
        this.taskRepo = taskRepo;
        this.project_userRepo = project_userRepo;
        this.task_userRepo = task_userRepo;
    }

    @GetMapping("/")
    public String redirectLogin()
    {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(HttpSession session)
    {
        if(session.getAttribute("user_id") == null)
        {
            session.setAttribute("wronglogin", false);
            return "/login";
        }

        return "redirect:/homepage";
    }

    //First checks for user in table 'user', then tries login method
    @PostMapping("/login")
    public String tryLogin(@RequestParam String username, @RequestParam String password, HttpSession session)
    {
        if (userRepo.checkUsername(username))
        {
           if (userRepo.checkLogin(username, password))
           {
               User user = userRepo.getUserInfo(username);
               session.setAttribute("user_id", user.getUser_id());
               session.setAttribute("username", user.getUsername());
               session.setAttribute("email", user.getEmail());
               session.setAttribute("is_admin", user.getIs_admin());
               session.setAttribute("full_name", user.getFull_name());
               return "redirect:/homepage";
           }
        }
        session.setAttribute("wronglogin", true);
        return "/login";
    }

    //Removes session attributes from token
    @GetMapping("/logout")
    public String tryLogout(HttpSession session)
    {
        session.removeAttribute("user_id");
        session.removeAttribute("username");
        session.removeAttribute("email");
        session.removeAttribute("is_admin");

        return "redirect:/login";
    }

    @GetMapping("/homepage")
    public String showHomepage(HttpSession session, Model model)
    {
        if(session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }

        model.addAttribute("allprojectlist", projectRepo.getAllProjects());
        session.setAttribute("currentpage", "/homepage");


        return "homepage";
    }

    @PostMapping("/createproject")
    public String createProject(@RequestParam("project-name") String project_name, HttpSession session)
    {
        Project tempProject = new Project();

        tempProject.setProject_name(project_name);

        projectRepo.createProject(tempProject);

        int tempUserID = (int) session.getAttribute("user_id");

        int tempProjectID = projectRepo.getMaxProjectId();

        project_userRepo.setRole(tempProjectID, tempUserID, "Project Leader");

        session.setAttribute("project_role", "Project Leader");


        return "redirect:/project/" + tempProjectID;
    }


    @GetMapping("/project/{id}")
    public String showProject(@PathVariable("id")int project_id, HttpSession session, Model model)
    {
        if (session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }
        model.addAttribute("project", projectRepo.getOneProject(project_id));
        model.addAttribute("subprojects", subprojectRepo.getAllSubprojects(project_id));
        model.addAttribute("assignedusers", userRepo.getUsersOnProject(project_id));
        model.addAttribute("all_users", userRepo.getAllUsers());

        int tempID = (int) session.getAttribute("user_id");
        session.setAttribute("projectID", project_id);

        session.setAttribute("project_role", projectRepo.getUserProjectAssignment(tempID, project_id));

        return "subprojects";
    }

    @PostMapping("/createsubproject")
    public String createSubproject(@RequestParam("subprojectName")String subprojectName, @RequestParam("projectId")int projectId,HttpSession session)
    {
        if (subprojectName.equals("")) //Stops null subproject names
        {
            return "redirect:/project/" + projectId;
        }
        subprojectRepo.createSubProject(projectId, subprojectName);
        int subprojectId = subprojectRepo.getMaxSubprojectId();
        return "redirect:/subproject/" + subprojectId;
    }
    @GetMapping("/myprojects")
    public String showMyprojects(HttpSession session, Model model)
    {
        if(session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }

        int user_id = (int) session.getAttribute("user_id");
        model.addAttribute("allmyprojectlist", projectRepo.getAllMyProjects(user_id));
        session.setAttribute("currentpage", "/myprojects");
        return "myprojects";
    }

    @GetMapping("/mytasks")
    public String showMyTasks(Model model, HttpSession session)
    {
        if(session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }
        int user_id = (int) session.getAttribute("user_id");
        model.addAttribute("allmytasklist", taskRepo.getMyTasks(user_id));
        session.setAttribute("currentpage", "/mytasks");
        return "mytasks";
    }


   @PostMapping("/assignproject")
    public String assignUser(@RequestParam("assign-email")String email, @RequestParam("role")String role, @RequestParam("projectId")int projectId, HttpSession session)
   {
       if(userRepo.doesEmailExist(email))
       {
           session.setAttribute("assign_project_error", false);
           int assignuserId = userRepo.getUserIDFromEmail(email);

           if(!project_userRepo.doesAssignmentExist(assignuserId, projectId))
           {
               project_userRepo.setRole(projectId, assignuserId, role);
           }
       }
       else
       {
           session.setAttribute("assign_project_error", true);
       }
       return "redirect:/project/" + projectId;
   }

   @PostMapping("/editrole")
   public String editRole(@RequestParam("user_id")int user_id, @RequestParam("project_id")int project_id, @RequestParam("role")String role)
   {
        project_userRepo.updateRole(project_id, user_id, role);
        return "redirect:/project/" + project_id;
   }

   @GetMapping("/projectassignment/delete/{user_id}/{project_id}")
   public String deleteProjectAssignment(@PathVariable("user_id")int user_id, @PathVariable("project_id")int project_id)
   {
       project_userRepo.deleteProjectAssignment(user_id, project_id);

       return "redirect:/project/"+project_id;
   }

    @GetMapping("/manage")
    public String showManageUsers(HttpSession session, Model model)
    {
        model.addAttribute("userlist", userRepo.getAllUsersForAdmin());
        return "manageusers";
    }

    @GetMapping("/editusers/{id}")
    public String showEditUsers(@PathVariable("id")int tempId, Model model)
    {
        model.addAttribute("oneuser", userRepo.getOneUser(tempId));
        return "editusers";
    }

    @PostMapping("/edituser")
    public String editUser(@RequestParam("user_id") int user_id, @RequestParam("edit-username")String username, @RequestParam("edit-password")String password, @RequestParam("edit-email")String email, @RequestParam("edit-admin-privilege")int is_admin, @RequestParam("edit-full_name")String full_name)
    {
        if(password.length() > 0){
            password = userRepo.encodePassword(password);
        }
        else
        {
            password = "noEdit";
        }
        User user = new User(user_id, username, full_name, password, email, is_admin);
        userRepo.editUser(user);

        return "redirect:/manage";
    }

    @PostMapping("/createuser")
    public String createUser(@RequestParam("create-username") String username, @RequestParam("create-full_name")String fullname, @RequestParam("create-password")String password, @RequestParam("create-email")String email, @RequestParam("create-admin-privilege")int is_admin)
    {
        if(is_admin != 1)
        {
            is_admin = 0;
        }
        password = userRepo.encodePassword(password);
        User user = new User(username, fullname, password, email, is_admin);
        userRepo.createUser(user);

        return "redirect:/manage";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(@RequestParam("user_id")int userID) {
        userRepo.deleteUser(userID);

        return "redirect:/manage";
    }
    /*@GetMapping("/editproject/{id}")
    public String showEditProject(@PathVariable("id") int project_ID, HttpSession session, Model model)
    {
        Project editProject = projectRepo.getOneProject(project_ID);
        model.addAttribute("project", editProject);
        return "editproject";
    }*/

    @PostMapping("/editproject")
    public String editProject(@RequestParam("projectID") int tempID, @RequestParam("projectName") String editName, @RequestParam("projectDescription") String editDescription, @RequestParam("projectStart") String editStart, @RequestParam("projectDeadline") String editDeadline, @RequestParam("projectHours") int editHours, @RequestParam("projectStatus") String editStatus, HttpSession session, Model model)
    {
        Project tempProject = new Project(tempID, editName, editDescription, editStart, editDeadline, editHours, editStatus);
        projectRepo.editProject(tempProject);


        return "redirect:/project/" + tempID;
    }

    @GetMapping("/subproject/{id}")
    public String showSubproject(@PathVariable("id")int subproject_id, HttpSession session, Model model)
    {
        /*if (session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }*/
        model.addAttribute("subproject", subprojectRepo.getOneSubproject(subproject_id));
        model.addAttribute("tasks", taskRepo.getSubprojectTasks(subproject_id));
        model.addAttribute("assignedusers", task_userRepo.getUsersOnSubproject(subproject_id));
        //model.addAttribute("all_users", userRepo.getAllUsers());

        //int tempID = (int) session.getAttribute("user_id");

        //session.setAttribute("project_role", projectRepo.getUserProjectAssignment(tempID, project_id));

        return "subprojecttask";
    }

    @PostMapping("/editsubproject")
    public String editSubproject(@RequestParam("subprojectID") int tempID, @RequestParam("subprojectName") String editName, @RequestParam("subprojectDescription") String editDescription, @RequestParam("subprojectDeadline") String editDeadline, @RequestParam("subprojectHours") int editHours, @RequestParam("subprojectStatus") String editStatus, HttpSession session, Model model)
    {
        Subproject tempSubproject = new Subproject(tempID, editName, editDescription, editDeadline, editHours, editStatus);
        subprojectRepo.editSubproject(tempSubproject);


        return "redirect:/subproject/" + tempID;
    }

    @PostMapping("/createtask")
    public String createTask(@RequestParam("taskName") String task_name, @RequestParam("subprojectId")int subproject_id, HttpSession session)
    {
        Task tempTask = new Task();

        tempTask.setTask_name(task_name);
        tempTask.setSubproject_id(subproject_id);
        taskRepo.createTask(tempTask);

        int tempTaskID = taskRepo.getMaxTaskId();


        return "redirect:/task/" + tempTaskID;
    }

    @GetMapping("/task/{id}")
    public String showTask(@PathVariable("id")int task_id, HttpSession session, Model model)
    {
        if (session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }
        int tempProjectId = taskRepo.getProjectIdFromTaskId(task_id);
        ArrayList<User> newList = (ArrayList<User>) task_userRepo.getUsersOnTask(task_id);
        for(int i = 0; i < newList.size(); i++)
        {
            int tempUser_id = newList.get(i).getUser_id();
            String newRole = projectRepo.getUserProjectAssignment(tempUser_id, tempProjectId);
            newList.get(i).setRole(newRole);
        }
        model.addAttribute("task", taskRepo.getOneTask(task_id));
        Task task = (Task) model.getAttribute("task");
        int subproject_id = task.getSubproject_id();
        model.addAttribute("tasks", taskRepo.getSubprojectTasks(subproject_id));
        model.addAttribute("assignedusers", newList);
        model.addAttribute("all_users", userRepo.getAllUsers());

        return "task";
    }

    @PostMapping("/assigntask")
    public String assignToTask(@RequestParam("task-id")int taskId, @RequestParam("assign-email")String email, HttpSession session)
    {
        int tempUserId = userRepo.getUserIDFromEmail(email);
        int tempProjectId = taskRepo.getProjectIdFromTaskId(taskId);

        if(project_userRepo.doesAssignmentExist(tempUserId, tempProjectId))
        {
            if(!task_userRepo.doesTaskAssignmentExist(taskId, tempUserId))
            {
                task_userRepo.assignUserToTask(taskId, tempUserId);
                session.setAttribute("emailerror", false);
            }
        }
        else
        {
            session.setAttribute("emailerror", true);
        }

        return "redirect:/task/"+taskId;
    }

    @PostMapping("/edittask")
    public String editTask(@RequestParam("taskId")int taskId, @RequestParam("taskName")String taskName, @RequestParam("taskDescription")String taskDescription, @RequestParam("taskStart")String taskStart, @RequestParam("taskPriority")int taskPriority, @RequestParam("taskHours")int taskHours, @RequestParam("taskStatus")String taskStatus, HttpSession session)
    {
        Task task = new Task(taskId, taskName, taskDescription, taskStart, taskHours, taskPriority, taskStatus);
        taskRepo.editTask(task);
        return "redirect:/task/" + taskId;
    }

    @PostMapping("/editcomment")
    public String editComment(@RequestParam("taskId")int taskId, @RequestParam("taskComment")String taskComment)
    {
        if(taskComment.length() < 1000) {
            taskRepo.editTaskComment(taskId, taskComment);
        }
        return "redirect:/task/" + taskId;
    }

    @GetMapping("/deleteproject/{id}")
    public String deleteProject(@PathVariable("id") int projectID)
    {
        projectRepo.deleteProject(projectID);
        return "redirect:/homepage";

    }

    @GetMapping("/deletesubproject/{id}")
    public String deleteSubproject(@PathVariable("id") int subprojectID, HttpSession session)
    {
        subprojectRepo.deleteSubproject(subprojectID);
        int tempID = (int) session.getAttribute("projectID");

        return "redirect:/project/" + tempID;

    }

    @GetMapping("/resources")
    public String showResourcePage(HttpSession session, Model model)
    {
        model.addAttribute("resourceList", projectRepo.getAllProjects());


        return "resources";
    }
}
