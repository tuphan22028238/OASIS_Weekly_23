import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String address;
    List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Constructor with given param.
     * @param name name
     * @param address address
     */
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    /**
     * Remove vehicle.
     * @param registrationNumber registrationNumber
     */
    public void removeVehicle(String registrationNumber) {
        for (int i = 0; i < vehicleList.size(); i++) {
            if (vehicleList.get(i).getRegistrationNumber().equals(registrationNumber)) {
                vehicleList.remove(i);
                break;
            }
        }
    }

    /**
     * Get vehicle information.
     * @return vehicle information
     */
    public String getVehiclesInfo() {
        if (vehicleList.size() == 0) {
            return this.getName() + " has no vehicle!";
        }
        String s = this.getName() + " has:\n";
        for (Vehicle x : vehicleList) {
            s += "\n" + x.getInfo();
        }
        return s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
