package bootcamp.demo.Service;

import bootcamp.demo.Model.User;
import bootcamp.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * Created by daylinhenry on 7/17/17.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public  User findById(Long id){
        return userRepository.findOne(id);
    }

    public int countByEmail(String email) {
        return userRepository.countByEmail(email);
    }

    public User findbyUsername(String username) {return userRepository.findByUsername(username);}

    public void saveAccount(User user, String role) {
        user.setAuthority(role);
        userRepository.save(user);
    }
}