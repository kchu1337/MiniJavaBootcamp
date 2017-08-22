package bootcamp.demo.Controller;


import bootcamp.demo.Model.Job;
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
    JobRepository jobRepository;

    @RequestMapping("/")
    public String listJobs(Model model){
        model.addAttribute("jobs", jobRepository.findAll());
        return "joblist";
    }

    @GetMapping("/add")
    public String jobForm(Model model){
        model.addAttribute("job", new Job());
        return "addjob";
    }

    @PostMapping("/add")
    public String processForm(@Valid Job job, BindingResult result){
        if (result.hasErrors()){
            return "addjob";
        }
        jobRepository.save(job);
        return "redirect:/";
    }



}
