package bootcamp.demo.Repository;

import bootcamp.demo.Model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
