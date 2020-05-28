package oleh.kyrychenko.lab3.services;

import oleh.kyrychenko.lab3.models.ConcretePlane;
import oleh.kyrychenko.lab3.dto.ConcretePlaneDto;

import oleh.kyrychenko.lab3.models.Plane;
import oleh.kyrychenko.lab3.dto.PlaneDto;

import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public interface PlaneService {
    Iterable<Plane> getAllPlanes();
    Plane getPlaneById(int id);
    Plane deletePlane(int id) throws NoSuchElementException;
    Plane createPlane(PlaneDto planeDto);
    Plane editPlaneWithId(int id, PlaneDto planeDto) throws NoSuchElementException;

    ConcretePlane registerConcretePlane(ConcretePlaneDto concretePlaneDto);
    Iterable<ConcretePlane> getConcretePlanes();
}
