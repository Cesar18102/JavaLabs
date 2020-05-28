package oleh.kyrychenko.lab3.controllers;

import oleh.kyrychenko.lab3.dto.PersonDto;
import oleh.kyrychenko.lab3.models.Person;
import oleh.kyrychenko.lab3.services.PersonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<Person> registerPerson(@RequestBody PersonDto personDto) {
        Person person = personService.registerPerson(personDto);
        return new ResponseEntity<Person>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Person>> getPeople() {
        Iterable<Person> people = personService.getPeople();
        return new ResponseEntity<Iterable<Person>>(people, HttpStatus.OK);
    }
}
