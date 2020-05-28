package oleh.kyrychenko.lab3.repo;

import oleh.kyrychenko.lab3.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Integer> {
}
