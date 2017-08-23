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
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MovieRepository movieRepository;

        @RequestMapping("/")
        public String index(Model model){
            // First let's create a director
            Director director = new Director();
            director.setName("Stephen Bullock");
            director.setGenre("Sci Fi");


            // Now let's create a movie
            Movie movie = new Movie();
            movie.setTitle("Star Movie");
            movie.setYear(2017);
            movie.setDescription("About Stars...");
            movieRepository.save(movie);
            director.getMovies().add(movie);

            movie = new Movie();
            movie.setTitle("DeathStar Ewoks");
            movie.setYear(2011);
            movie.setDescription("About Ewoks on the DeathStar...");
            movieRepository.save(movie);
            director.getMovies().add(movie);

            // Save the director to the database
            directorRepository.save(director);

            // Grad all the directors from the database and send them to
            // the template
            model.addAttribute("directors", directorRepository.findAll());
            return "index";
        }
}

