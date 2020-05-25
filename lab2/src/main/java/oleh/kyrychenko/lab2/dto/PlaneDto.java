package oleh.kyrychenko.lab2.dto;

public class PlaneDto {
    private String modelName;
    private double maxVelocity;
    private double maxHeight;
    private int minPilotsNumber;

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