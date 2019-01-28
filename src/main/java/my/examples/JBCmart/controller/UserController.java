package my.examples.JBCmart.controller;

import my.examples.JBCmart.dto.User;
import my.examples.JBCmart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public String main(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
