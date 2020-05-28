package oleh.kyrychenko.lab3.models;

import oleh.kyrychenko.lab3.dto.PlaneDto;

import javax.persistence.*;

@Entity
public class Plane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String modelName;
    private double maxVelocity;
    private double maxHeight;
    private int minPilotsNumber;

    public Plane() { }

    public Plane(PlaneDto planeDto) {
        MapFrom(planeDto);
    }

    public void MapFrom(PlaneDto planeDto)  {
        setModelName(planeDto.getModelName());
        setMaxVelocity(planeDto.getMaxVelocity());
        setMaxHeight(planeDto.getMaxHeight());
        setMinPilotsNumber(planeDto.getMinPilotsNumber());
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public double getMaxVelocity() {
        return maxVelocity;
    }
    public void setMaxVelocity(double maxVelocity) {
        this.maxVelocity = maxVelocity;
    }

    public double getMaxHeight() {
        return maxHeight;
    }
    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    public int getMinPilotsNumber() {
        return minPilotsNumber;
    }
    public void setMinPilotsNumber(int minPilotsNumber) {
        this.minPilotsNumber = minPilotsNumber;
    }
}
