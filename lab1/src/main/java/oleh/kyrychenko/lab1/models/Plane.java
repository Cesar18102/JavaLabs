package oleh.kyrychenko.lab1.models;

public class Plane {
    private int id;
    private String modelName;
    private double maxVelocity;
    private double maxHeight;
    private int minPilotsNumber;

    public Plane(int id, String modelName, double maxVelocity,
                 double maxHeight, int minPilotsNumber) {
        this.id = id;
        this.modelName = modelName;
        this.maxVelocity = maxVelocity;
        this.maxHeight = maxHeight;
        this.minPilotsNumber = minPilotsNumber;
    }

    public int getId() {
        return id;
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
