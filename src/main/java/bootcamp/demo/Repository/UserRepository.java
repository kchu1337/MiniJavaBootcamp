package bootcamp.demo.Repository;


import bootcamp.demo.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface UserRepository extends CrudRepository<User, Long> {
     public User findByUsername(String username);

    public User findFirstById(int id);

    public User findByEmail(String email);

    public int countByUsername(String username);

    public int countByEmail(String email);
}
