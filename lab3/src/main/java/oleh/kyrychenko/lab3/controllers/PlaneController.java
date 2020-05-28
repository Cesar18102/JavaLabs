package oleh.kyrychenko.lab3.controllers;

import oleh.kyrychenko.lab3.dto.PlaneDto;
import oleh.kyrychenko.lab3.dto.ConcretePlaneDto;

import oleh.kyrychenko.lab3.models.Plane;
import oleh.kyrychenko.lab3.models.ConcretePlane;

import oleh.kyrychenko.lab3.services.PlaneService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Plane>> getAllPlanes() {
        return new ResponseEntity<Iterable<Plane>>(
            planeService.getAllPlanes(),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/get", params = "id", method = RequestMethod.GET)
    public ResponseEntity<Plane> getPlaneById(int id) {
        Plane found = planeService.getPlaneById(id);

        if(found == null) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Plane>(found, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Plane> createPlane(@RequestBody PlaneDto planeDto) {
        Plane plane = planeService.createPlane(planeDto);
        return new ResponseEntity<Plane>(plane, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", params = "id", method = RequestMethod.DELETE)
    public ResponseEntity<Plane> deletePlane(int id) {
        try {
            Plane deleted = planeService.deletePlane(id);
            return new ResponseEntity<Plane>(deleted, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/edit", params = "id", method = RequestMethod.POST)
    public ResponseEntity<Plane> editPlane(int id, @RequestBody PlaneDto planeDto) {
        try {
            Plane edited = planeService.editPlaneWithId(id, planeDto);
            return new ResponseEntity<Plane>(edited, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/concrete/add", method = RequestMethod.POST)
    public ResponseEntity<ConcretePlane> addConcretePlane(@RequestBody ConcretePlaneDto concretePlaneDto) {
        try {
            ConcretePlane concretePlane = planeService.registerConcretePlane(concretePlaneDto);
            return new ResponseEntity<ConcretePlane>(concretePlane, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<ConcretePlane>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/concrete/get", method = RequestMethod.GET)
    public ResponseEntity<Iterable<ConcretePlane>> getConcretePlanes() {
        Iterable<ConcretePlane> concretePlanes = planeService.getConcretePlanes();
        return new ResponseEntity<Iterable<ConcretePlane>>(concretePlanes, HttpStatus.OK);
    }
}
