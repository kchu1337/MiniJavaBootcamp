package bootcamp.demo.Controller;



import bootcamp.demo.Model.User;
import bootcamp.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/login")
    public String login(Model model){
        return "login";
    }
    @RequestMapping("/secure")
    public String admin(Model model){
        return "secure";
    }
    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveAccount(@Valid User user, BindingResult result, Model model){
        model.addAttribute("user", user);
        if (result.hasErrors()){
            return "register";
        }

        userService.saveAccount(user,"USER");
        return "redirect:/";
    }


}

