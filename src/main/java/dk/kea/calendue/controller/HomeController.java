package dk.kea.calendue.controller;

import dk.kea.calendue.model.Project;
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

@Controller
public class HomeController {

    private UserRepository userRepo;
    private ProjectRepository projectRepo;
    private SubprojectRepository subprojectRepo;
    private TaskRepository taskRepo;
    private Project_userRepository project_userRepo;


    public HomeController(UserRepository userRepo, ProjectRepository projectRepo, SubprojectRepository subprojectRepo, TaskRepository taskRepo, Project_userRepository project_userRepo)

    {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
        this.subprojectRepo = subprojectRepo;
        this.taskRepo = taskRepo;
        this.project_userRepo = project_userRepo;
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
        /*if (session.getAttribute("user_id") == null)
        {
            return "redirect:/login";
        }*/
        model.addAttribute("project", projectRepo.getOneProject(project_id));
        model.addAttribute("subprojects", subprojectRepo.getAllSubprojects(project_id));
        model.addAttribute("assignedusers", userRepo.getUsersOnProject(project_id));
        model.addAttribute("all_users", userRepo.getAllUsers());

        int tempID = (int) session.getAttribute("user_id");

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



   @PostMapping("/assignproject")
    public String assignUser(@RequestParam("assign-email")String email, @RequestParam("role")String role, @RequestParam("projectId")int projectId, HttpSession session)
   {
       int assignuserId = userRepo.getUserIDFromEmail(email);
       project_userRepo.setRole(projectId, assignuserId, role);
       return "redirect:/project/" + projectId;
   }

   @PostMapping("/editrole")
   public String editRole(@RequestParam("user_id")int user_id, @RequestParam("project_id")int project_id, @RequestParam("role")String role)
   {
        project_userRepo.updateRole(project_id, user_id, role);
        return "redirect:/project/" + project_id;
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
    @GetMapping("/editproject/{id}")
    public String showEditProject(@PathVariable("id") int project_ID, HttpSession session, Model model)
    {
        session.setAttribute("projectID", project_ID);
        Project editProject = projectRepo.getOneProject(project_ID);
        model.addAttribute("project", editProject);
        return "editproject";
    }

    @PostMapping("/editproject")
    public String editProject(@RequestParam("projectID") int tempID, @RequestParam("projectName") String editName, @RequestParam("projectDescription") String editDescription, @RequestParam("projectStart") String editStart, @RequestParam("projectDeadline") String editDeadline, @RequestParam("projectHours") int editHours, @RequestParam("projectStatus") String editStatus, HttpSession session, Model model)
    {
        Project tempProject = new Project(tempID, editName, editDescription, editStart, editDeadline, editHours, editStatus);
        projectRepo.editProject(tempProject);


        return "redirect:/project/" + tempID;
    }
}
