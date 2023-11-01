public class Circle {
    private double radius;
    private String color;
    protected static final double PI = Math.PI;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor with given param.
     * @param radius radius
     * @param color color
     */
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    /**
     * Give info of circle.
     * @return info of circle
     */
    public String toString() {
        return "Circle[radius="
                + this.getRadius()
                + ",color="
                + this.getColor()
                + "]";
    }
}
