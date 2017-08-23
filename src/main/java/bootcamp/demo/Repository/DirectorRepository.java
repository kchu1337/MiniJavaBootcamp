package bootcamp.demo.Repository;

import bootcamp.demo.Model.Director;
import bootcamp.demo.Model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface DirectorRepository extends CrudRepository<Director, Long> {
}
