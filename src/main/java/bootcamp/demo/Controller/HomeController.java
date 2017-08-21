package bootcamp.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
    //Lesson 1
    @RequestMapping("/lesson1")
    public String lesson1() {
        return "lesson1";
    }

    //Lesson 2
    @RequestMapping("/lesson2")
    public String lesson2(Model model) {
        model.addAttribute("message", "Say Hello to the people");
        return "lesson2";

    }

    //Lesson 3
    @RequestMapping("/lesson3")
    public String lesson3(Model model) {

        return "lesson3";

    }

    //Lesson 4
    @GetMapping("/lesson4")
    public String lesson4Get(Model model) {
        return "lesson4_load";
    }
    @PostMapping("/lesson4")
    public String lesson4Post(@RequestParam("login")String login,  Model model) {
        model.addAttribute("login", login);
        return "lesson4_show";

    }
}
