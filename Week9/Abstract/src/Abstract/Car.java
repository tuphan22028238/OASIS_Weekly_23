public class Car extends Vehicle {
    private int numberOfDoors;

    /**
     * Constructor with given param.
     * @param brand brand
     * @param model model
     * @param registrationNumber registrationNumber
     * @param owner owner
     * @param numberOfDoors numberOfDoors
     */
    public Car(String brand, String model, String registrationNumber,
               Person owner, int numberOfDoors) {
        super(brand, model, registrationNumber, owner);
        this.numberOfDoors = numberOfDoors;
    }

    /**
     * Get information of the car.
     * @return info of car
     */
    @Override
    public String getInfo() {
        return "Car:\n\tBrand: " + this.getBrand()
                + "\n\tModel: " + this.getModel()
                + "\n\tRegistration Number: " + this.getRegistrationNumber()
                + "\n\tNumber of Doors: " + this.getNumberOfDoors() + "\n\tBelongs to "
                + this.getOwner().getName() + " - " + this.getOwner().getAddress();
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }
}
