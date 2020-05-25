package oleh.kyrychenko.lab1.services;

import oleh.kyrychenko.lab1.models.Plane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public interface PlaneService {
    List<Plane> getAllPlanes();
    Plane getPlaneById(int id);
    Plane deletePlane(int id) throws NoSuchElementException;
    Plane createPlane(String modelName, double maxVelocity, double maxHeight, int minPilotsNumber);
    Plane editPlaneWithId(int id, String modelName, double maxVelocity, double maxHeight, int minPilotsNumber) throws NoSuchElementException;
}
