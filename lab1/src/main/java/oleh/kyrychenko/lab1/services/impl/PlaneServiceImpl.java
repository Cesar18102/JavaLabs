package oleh.kyrychenko.lab1.services.impl;

import oleh.kyrychenko.lab1.models.Plane;
import oleh.kyrychenko.lab1.services.PlaneService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

@Component
public class PlaneServiceImpl implements PlaneService {
    private int maxId = -1;
    private List<Plane> planes = new ArrayList<Plane>();

    private  int getPlaneListIndexById(int id) {
        for(int i = 0; i < planes.size(); i++) {
            if(planes.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public List<Plane> getAllPlanes() {
        return planes;
    }

    @Override
    public Plane getPlaneById(int id) {
        int index = getPlaneListIndexById(id);
        return index == -1 ? null : planes.get(index);
    }

    @Override
    public Plane deletePlane(int id) throws NoSuchElementException {
        int index = getPlaneListIndexById(id);

        if(index == -1) {
            throw new NoSuchElementException();
        }

        Plane temp = planes.get(index);
        planes.remove(index);
        return temp;
    }

    @Override
    public Plane createPlane(String modelName, double maxVelocity, double maxHeight, int minPilotsNumber) {
        Plane plane = new Plane(++maxId, modelName, maxVelocity, maxHeight, minPilotsNumber);
        planes.add(plane);
        return plane;
    }

    @Override
    public Plane editPlaneWithId(int id, String modelName, double maxVelocity, double maxHeight, int minPilotsNumber) {
        Plane plane = getPlaneById(id);

        if(plane == null) {
            throw new NoSuchElementException();
        }

        plane.setModelName(modelName);
        plane.setMaxVelocity(maxVelocity);
        plane.setMaxHeight(maxHeight);
        plane.setMinPilotsNumber(minPilotsNumber);

        return plane;
    }
}
