import java.util.Objects;

public class Rectangle extends Shape {
    protected Point topLeft = new Point(0, 0);
    protected double width;
    protected double length;

    public Rectangle() {
        this.topLeft = new Point(0, 0);
    }

    /**
     * Constructor with given param.
     * @param width width
     * @param length length
     */
    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor with given values.
     * @param width width
     * @param length length
     * @param color color
     * @param filled filled
     */
    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    /**
     * Constructor with given values.
     * @param topLeft topLeft
     * @param width width
     * @param length length
     * @param color color
     * @param filled filled
     */
    public Rectangle(Point topLeft, double width, double length, String color, boolean filled) {
        super(color, filled);
        this.topLeft = topLeft;
        this.width = width;
        this.length = length;
    }

    public Point getTopLeft() {
        return this.topLeft;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return this.length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return width * length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length, topLeft);
    }

    /**
     * Compare given objects with rectangle.
     * @param o given object
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.width, width) == 0
                && Double.compare(rectangle.length, length) == 0
                && Objects.equals(topLeft, rectangle.topLeft);
    }

    /**
     * Get the string of information of the rectangle.
     * @return information of the rectangle
     */
    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft.toString()
                + ",width=" + (double) Math.round(width * 10) / 10
                + ",length=" + (double) Math.round(length * 10) / 10
                + ",color=" + getColor() + ",filled=" + isFilled() + "]";
    }
}
