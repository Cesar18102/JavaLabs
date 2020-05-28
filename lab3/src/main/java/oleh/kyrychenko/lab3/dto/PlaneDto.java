package oleh.kyrychenko.lab3.dto;

import oleh.kyrychenko.lab3.models.Plane;

public class PlaneDto {
    private String modelName;
    private double maxVelocity;
    private double maxHeight;
    private int minPilotsNumber;

    public PlaneDto() { }

    public PlaneDto(Plane plane) {
        setModelName(plane.getModelName());
        setMaxVelocity(plane.getMaxVelocity());
        setMaxHeight(plane.getMaxHeight());
        setMinPilotsNumber(plane.getMinPilotsNumber());
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