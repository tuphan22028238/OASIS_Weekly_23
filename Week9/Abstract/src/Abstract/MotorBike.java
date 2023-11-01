public class MotorBike extends Vehicle {
    private boolean hasSidecar;

    public MotorBike(String brand, String model,  String registrationNumber,
                     Person owner, boolean hasSideCar) {
        super(brand, model, registrationNumber, owner);
        this.hasSidecar = hasSideCar;
    }

    /**
     * Get info of motorbike.
     * @return info of bike
     */
    @Override
    public String getInfo() {
        return "Motor Bike:\n\tBrand: " + this.getBrand()
                + "\n\tModel: " + this.getModel()
                + "\n\tRegistration Number: " + this.getRegistrationNumber()
                + "\n\tHas Side Car: " + this.isHasSidecar() + "\n\tBelongs to "
                + this.getOwner().getName() + " - "
                + this.getOwner().getAddress();
    }

    public boolean isHasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }
}
