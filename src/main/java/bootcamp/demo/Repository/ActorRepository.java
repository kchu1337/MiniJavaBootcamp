package bootcamp.demo.Repository;

import bootcamp.demo.Model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRepository extends CrudRepository<Actor, Long> {
}
