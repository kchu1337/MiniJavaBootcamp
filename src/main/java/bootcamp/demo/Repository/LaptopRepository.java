package bootcamp.demo.Repository;

import bootcamp.demo.Model.Laptop;
import org.springframework.data.repository.CrudRepository;

public interface LaptopRepository extends CrudRepository<Laptop, Long> {
}