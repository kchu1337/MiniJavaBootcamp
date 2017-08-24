package bootcamp.demo.COnfig;

import bootcamp.demo.Model.User;
import bootcamp.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception{
        if (userRepository.countByUsername("bob")<1) {
            System.out.println("Loading Data");
            User user = new User("Bob Bobberson", "bob", "bob@bob.com", "bob");
            user.setAuthority("USER");
            userRepository.save(user);

            user = new User("Jim Jimmerson", "jim", "jim@jim.com", "jim");
            user.setAuthority("USER");
            userRepository.save(user);

            user = new User("Admin", "pass", "admin@admin.com", "admin");
            user.setAuthority("ADMIN");
            userRepository.save(user);

            user = new User("Sam Everyman", "pass", "sam@ev.com", "sam");
            user.setAuthority("ADMIN");
            userRepository.save(user);
        }
    }
}
