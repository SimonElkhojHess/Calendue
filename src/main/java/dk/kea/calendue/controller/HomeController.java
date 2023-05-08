package dk.kea.calendue.controller;

import dk.kea.calendue.model.User;
import dk.kea.calendue.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    UserRepository userRepo;
    public HomeController(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

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
               return "redirect:/";
           }
        }
        session.setAttribute("wronglogin", true);
        return "/login";
    }
}
