package bootcamp.demo.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class HomeController {

    @RequestMapping("/")
    public String listJobs(Model model){
        return "index";
    }


}
