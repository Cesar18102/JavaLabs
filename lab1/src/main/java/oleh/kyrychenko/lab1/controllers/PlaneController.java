package oleh.kyrychenko.lab1.controllers;

import oleh.kyrychenko.lab1.models.Plane;
import oleh.kyrychenko.lab1.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @RequestMapping("/get")
    public ResponseEntity<List<Plane>> getAllPlanes() {
        return new ResponseEntity<List<Plane>>(
            planeService.getAllPlanes(),
            HttpStatus.OK
        );
    }

    @RequestMapping(value = "/get", params = "id")
    public ResponseEntity<Plane> getPlaneById(int id) {
        Plane found = planeService.getPlaneById(id);

        if(found == null) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Plane>(found, HttpStatus.OK);
    }

    @RequestMapping(value = "/create", params = { "modelName", "maxVelocity", "maxHeight", "minPilotsNumber" })
    public ResponseEntity<Plane> createPlane(String modelName, double maxVelocity, double maxHeight, int minPilotsNumber) {
        Plane plane = planeService.createPlane(modelName, maxVelocity, maxHeight, minPilotsNumber);
        return new ResponseEntity<Plane>(plane, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete", params = "id")
    public ResponseEntity<Plane> deletePlane(int id) {
        try {
            Plane deleted = planeService.deletePlane(id);
            return new ResponseEntity<Plane>(deleted, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/edit", params = { "id", "modelName", "maxVelocity", "maxHeight", "minPilotsNumber" })
    public ResponseEntity<Plane> editPlane(int id, String modelName, double maxVelocity, double maxHeight, int minPilotsNumber) {
        try {
            Plane edited = planeService.editPlaneWithId(id, modelName, maxVelocity, maxHeight, minPilotsNumber);
            return new ResponseEntity<Plane>(edited, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<Plane>(HttpStatus.NOT_FOUND);
        }
    }
}
