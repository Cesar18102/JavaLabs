package oleh.kyrychenko.lab2.repo;

import oleh.kyrychenko.lab2.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepo extends CrudRepository<Person, Integer> {
}
