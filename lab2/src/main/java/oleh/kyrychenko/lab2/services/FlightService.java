package oleh.kyrychenko.lab2.services;

import oleh.kyrychenko.lab2.dto.FlightDto;
import oleh.kyrychenko.lab2.models.ConcretePlane;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public interface FlightService {
    ConcretePlane registerFlight(FlightDto flightDto) throws NoSuchElementException, IllegalArgumentException;
}
