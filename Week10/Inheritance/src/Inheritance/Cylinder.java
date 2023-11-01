public class Cylinder extends Circle {
    private double height;

    public Cylinder() {

    }

    public Cylinder(double height) {
        this.height = height;
    }

    /**
     * Constructor with given param.
     * @param height height
     * @param radius radius
     */
    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    /**
     * Constructor with given param.
     * @param height height
     * @param radius radius
     * @param color color
     */
    public Cylinder(double height, double radius, String color) {
        super(radius, color);
        this.height = height;
    }


    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * height;
    }

    /**
     * Give info of cylinder.
     * @return info of cylinder
     */
    public String toString() {
        return "Cylinder["
                + super.toString()
                + ",height="
                + height
                + "]";
    }

    /**
     * Get area of the cylinder.
     * @return area of the cylinder
     */
    @Override
    public double getArea() {
        return super.getArea() * 2
                + PI * 2 * this.getRadius() * height;
    }
}
