package bootcamp.demo.Repository;

import bootcamp.demo.Model.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long>{

}
