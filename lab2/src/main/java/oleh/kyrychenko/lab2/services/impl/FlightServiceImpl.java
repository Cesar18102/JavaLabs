package oleh.kyrychenko.lab2.services.impl;

import oleh.kyrychenko.lab2.dto.FlightDto;
import oleh.kyrychenko.lab2.models.ConcretePlane;
import oleh.kyrychenko.lab2.models.Person;
import oleh.kyrychenko.lab2.repo.ConcretePlaneRepo;
import oleh.kyrychenko.lab2.repo.PersonRepo;
import oleh.kyrychenko.lab2.services.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private ConcretePlaneRepo concretePlaneRepo;

    @Autowired
    private PersonRepo personRepo;

    @Override
    public ConcretePlane registerFlight(FlightDto flightDto) {
        Optional<ConcretePlane> concretePlaneOptional = concretePlaneRepo.findById(flightDto.getConcretePlaneId());

        if(!concretePlaneOptional.isPresent()) {
            throw new NoSuchElementException();
        }
        
        ConcretePlane concretePlane = concretePlaneOptional.get();
        int declaredCrewSize = ((Collection<Integer>)flightDto.getCrew()).size();
        
        if(declaredCrewSize < concretePlane.getPlane().getMinPilotsNumber()) {
            throw new IllegalArgumentException();
        }

        Iterable<Person> crew = personRepo.findAllById(flightDto.getCrew());
        int foudndCrewSize = ((Collection<Person>)crew).size();

        if(foudndCrewSize != declaredCrewSize) {
            throw new NoSuchElementException();
        }

        Set<Person> planeCrew = concretePlane.getCrew();
        for (Person person: crew) {
            planeCrew.add(person);
            person.getFliedPlanes().add(concretePlane);
        }

        return concretePlaneRepo.save(concretePlane);
    }
}
