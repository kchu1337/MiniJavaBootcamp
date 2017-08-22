package bootcamp.demo.Controller;


import bootcamp.demo.Model.*;
import bootcamp.demo.Repository.CourseRepository;
import bootcamp.demo.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class HomeController {
    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String listJobs(Model model){
        model.addAttribute("courses", courseRepository.findAll());
        return "courselist";
    }

    @GetMapping("/add")
    public String courseForm(Model model){
        model.addAttribute("couse", new Course());
        return "addcourse";
    }

    @PostMapping("/add")
    public String processForm(@Valid Course course, BindingResult result){
        if (result.hasErrors()){
            return "addcourse";
        }
       courseRepository.save(course);
        return "redirect:/";
    }

    @PostMapping("/view/{id}")
    public String detail(@PathVariable("id") long id, Model model ){
        model.addAttribute("course", courseRepository.findOne(id));
        return "show";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model ){
        model.addAttribute("course", courseRepository.findOne(id));
        return "update";
    }

    @PostMapping("/view/{id}")
    public String delete(@PathVariable("id") long id, Model model ){
        courseRepository.delete(id);
        return "redirect:/";
    }



}
