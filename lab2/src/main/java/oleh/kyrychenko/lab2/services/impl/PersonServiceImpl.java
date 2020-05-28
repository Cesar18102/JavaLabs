package oleh.kyrychenko.lab2.services.impl;

import oleh.kyrychenko.lab2.dto.PersonDto;
import oleh.kyrychenko.lab2.models.Person;
import oleh.kyrychenko.lab2.repo.PersonRepo;
import oleh.kyrychenko.lab2.services.PersonService;

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
