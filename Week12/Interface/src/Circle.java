public class Circle implements GeometricObject {
    public static final double PI = 3.14;
    private Point center;
    private double radius;

    /**
     * Constructor with given values.
     * @param center given center
     * @param radius given radius
     */
    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }


    public double getPerimeter() {
        return PI * 2 * radius;
    }


    /**
     * Get info of Circle.
     * @return info of circle
     */
    public String getInfo() {
        return "Circle[("
                + String.format("%.2f", center.getPointX()) + ","
                + String.format("%.2f", center.getPointY()) + "),r="
                + String.format("%.2f", radius) + "]";
    }
}
