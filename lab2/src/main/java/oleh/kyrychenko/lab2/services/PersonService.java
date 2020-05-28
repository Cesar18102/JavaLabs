package oleh.kyrychenko.lab2.services;

import oleh.kyrychenko.lab2.dto.PersonDto;
import oleh.kyrychenko.lab2.models.Person;

import org.springframework.stereotype.Service;

@Service
public interface PersonService {
    Person registerPerson(PersonDto personDto);
    Iterable<Person> getPeople();
}
