package oleh.kyrychenko.lab2.services;

import oleh.kyrychenko.lab2.dto.PlaneDto;
import oleh.kyrychenko.lab2.models.Plane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface PlaneService {
    Iterable<Plane> getAllPlanes();
    Plane getPlaneById(int id);
    Plane deletePlane(int id) throws NoSuchElementException;
    Plane createPlane(PlaneDto planeDto);
    Plane editPlaneWithId(int id, PlaneDto planeDto) throws NoSuchElementException;
}
