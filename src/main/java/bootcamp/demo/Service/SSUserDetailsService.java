package bootcamp.demo.Service;


import bootcamp.demo.Model.User;
import bootcamp.demo.Repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by student on 6/28/17.
 */
@Transactional
public class SSUserDetailsService implements UserDetailsService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SSUserDetailsService.class);
    private UserRepository userRepository;
    public SSUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            User user = userRepository.findByUsername(username);
            if (user == null) {
                LOGGER.debug("User not found");
                return null;
            }
            LOGGER.debug("User found");
            Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority(user.getAuthority()));
            return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), authorities);

        }
        catch(Exception e){
            throw new UsernameNotFoundException("User not found");
        }
    }


}
