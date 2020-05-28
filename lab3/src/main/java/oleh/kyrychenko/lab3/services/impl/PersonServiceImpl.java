package oleh.kyrychenko.lab3.services.impl;

import oleh.kyrychenko.lab3.dto.PersonDto;
import oleh.kyrychenko.lab3.models.Person;
import oleh.kyrychenko.lab3.repo.PersonRepo;
import oleh.kyrychenko.lab3.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public Person registerPerson(PersonDto personDto) {
        Person person = new Person(personDto);
        return personRepo.save(person);
    }

    @Override
    public Iterable<Person> getPeople() {
        return personRepo.findAll();
    }
}
