package oleh.kyrychenko.lab3.services;

import oleh.kyrychenko.lab3.dto.PersonDto;
import oleh.kyrychenko.lab3.models.Person;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    Person registerPerson(PersonDto personDto);
    Iterable<Person> getPeople();
}
