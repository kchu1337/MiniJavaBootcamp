package bootcamp.demo.Repository;

import bootcamp.demo.Model.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Long> {

}
