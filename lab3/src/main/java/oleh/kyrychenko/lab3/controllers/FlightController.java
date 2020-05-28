package oleh.kyrychenko.lab3.controllers;

import oleh.kyrychenko.lab3.dto.FlightDto;
import oleh.kyrychenko.lab3.models.ConcretePlane;
import oleh.kyrychenko.lab3.services.FlightService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

@Controller
@RequestMapping("/api/flight")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<ConcretePlane> registerFlight(@RequestBody FlightDto flightDto) {
        try {
            ConcretePlane concretePlane = flightService.registerFlight(flightDto);
            return new ResponseEntity<ConcretePlane>(concretePlane, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<ConcretePlane>(HttpStatus.NOT_FOUND);
        } catch (IllegalArgumentException ex) {
            return new ResponseEntity<ConcretePlane>(HttpStatus.BAD_REQUEST);
        }
    }
}
