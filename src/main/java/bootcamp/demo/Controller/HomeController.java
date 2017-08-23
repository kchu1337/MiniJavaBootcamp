package bootcamp.demo.Controller;


import bootcamp.demo.Model.*;
import bootcamp.demo.Repository.*;
import bootcamp.demo.configs.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;


@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
    // First let's create an actor
    Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

    // Now let's create a movie
    Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis");
        movieRepository.save(movie);
        movie = movieRepository.findOne((long) 1);


    // Add the list of movies to the actor's movie list
        actor.getMovies().add(movie);

    // Save the actor to the database
        actorRepository.save(actor);

    // Grab all the actors from the database and send them to
    // the template
        model.addAttribute("actorList", actorRepository.findAll());
        return "index";
}
}
