package bootcamp.demo.Controller;



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


    @RequestMapping("/")
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/page1")
    public String page1(Model model){
        return "page1";
    }
    @RequestMapping("/page2")
    public String page2(Model model){
        return "page2";
    }
}

