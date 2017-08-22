package bootcamp.demo.Controller;


import bootcamp.demo.TvShow;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class HomeController {

    @GetMapping("/tv")
    public String tvload(Model model) {
        model.addAttribute("tvShow", new TvShow());
        return "tvform";
    }

    @PostMapping("/tv")
    public String tvshow(@Valid TvShow tvShow, BindingResult result, Model model) {

        if (result.hasErrors()){
            return "tvform";
        }
        model.addAttribute("tvShow", tvShow);
        return "tvoutput";
    }


}
