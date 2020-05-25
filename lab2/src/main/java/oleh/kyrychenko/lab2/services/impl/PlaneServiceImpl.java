package oleh.kyrychenko.lab2.services.impl;

import oleh.kyrychenko.lab2.dto.PlaneDto;
import oleh.kyrychenko.lab2.models.Plane;
import oleh.kyrychenko.lab2.repo.PlaneRepo;
import oleh.kyrychenko.lab2.services.PlaneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    private PlaneRepo planeRepo;

    @Override
    public Iterable<Plane> getAllPlanes() {
        return planeRepo.findAll();
    }

    @Override
    public Plane getPlaneById(int id) {
        Optional<Plane> found = planeRepo.findById(id);
        return found.isPresent() ? found.get() : null;
    }

    @Override
    public Plane deletePlane(int id) throws NoSuchElementException {
        Plane found = getPlaneById(id);

        if(found == null) {
            throw new NoSuchElementException();
        }

        planeRepo.delete(found);
        return found;
    }

    @Override
    public Plane createPlane(PlaneDto planeDto) {
        Plane plane = new Plane(planeDto);
        planeRepo.save(plane);
        return plane;
    }

    @Override
    public Plane editPlaneWithId(int id, PlaneDto planeDto) {
        Plane plane = getPlaneById(id);

        if(plane == null) {
            throw new NoSuchElementException();
        }

        plane.MapFrom(planeDto);
        planeRepo.save(plane);

        return plane;
    }
}
