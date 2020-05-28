package oleh.kyrychenko.lab3.services;

import oleh.kyrychenko.lab3.dto.FlightDto;
import oleh.kyrychenko.lab3.models.ConcretePlane;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public interface FlightService {
    ConcretePlane registerFlight(FlightDto flightDto) throws NoSuchElementException, IllegalArgumentException;
}
