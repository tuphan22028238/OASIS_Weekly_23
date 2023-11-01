import java.util.Objects;

public class Circle extends Shape {
    protected double radius;
    protected Point center = new Point(0, 0);
    

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Constructor twith given param.
     * @param radius radius
     * @param color color
     * @param filled filled
     */
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    /**
     * Constructor with given values.
     * @param center center
     * @param radius radius
     * @param color color
     * @param filled filled
     */
    public Circle(Point center, double radius, String color, boolean filled) {
        super(color, filled);
        this.center = center;
        this.radius = radius;
    }

    public Point getCenter() {
        return this.center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    /**
     * Get the area of the circle.
     * @return area of the circle
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Get the perimeter of the circle.
     * @return perimeter of the circle
     */
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[center=" + center.toString()
                + ",radius=" + (double) Math.round(radius * 10) / 10
                + ",color=" + getColor() + ",filled=" + isFilled() + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0 && Objects.equals(center, circle.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius, center);
    }
}
