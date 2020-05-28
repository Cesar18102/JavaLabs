package oleh.kyrychenko.lab3.services.impl;

import oleh.kyrychenko.lab3.dto.ConcretePlaneDto;
import oleh.kyrychenko.lab3.dto.PlaneDto;
import oleh.kyrychenko.lab3.models.ConcretePlane;
import oleh.kyrychenko.lab3.models.Plane;
import oleh.kyrychenko.lab3.repo.ConcretePlaneRepo;
import oleh.kyrychenko.lab3.repo.PlaneRepo;
import oleh.kyrychenko.lab3.services.PlaneService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class PlaneServiceImpl implements PlaneService {

    @Autowired
    private PlaneRepo planeRepo;

    @Autowired
    private ConcretePlaneRepo concretePlaneRepo;

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
        return planeRepo.save(plane);
    }

    @Override
    public Plane editPlaneWithId(int id, PlaneDto planeDto) {
        Plane plane = getPlaneById(id);

        if(plane == null) {
            throw new NoSuchElementException();
        }

        plane.MapFrom(planeDto);
        return planeRepo.save(plane);
    }

    @Override
    public ConcretePlane registerConcretePlane(ConcretePlaneDto concretePlaneDto) {
        Plane plane = getPlaneById(concretePlaneDto.getPlaneId());

        if(plane == null) {
            throw new NoSuchElementException();
        }

        ConcretePlane concretePlane = new ConcretePlane();
        concretePlane.setPlane(plane);
        concretePlane.setBuildYear(concretePlaneDto.getBuildYear());

        return concretePlaneRepo.save(concretePlane);
    }

    @Override
    public Iterable<ConcretePlane> getConcretePlanes() {
        return concretePlaneRepo.findAll();
    }
}