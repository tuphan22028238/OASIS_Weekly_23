import java.util.Objects;

public class Point {
    private double pointX;
    private double pointY;


    /**
     * Constructor.
     */
    public Point(double pointX, double pointY) {
        this.pointX = pointX;
        this.pointY = pointY;
    }

    public double getPointX() {
        return pointX;
    }

    public void setPointX(double pointX) {
        this.pointX = pointX;
    }

    public double getPointY() {
        return pointY;
    }

    public void setPointY(double pointY) {
        this.pointY = pointY;
    }

    /**
     * Calculate distance.
     * @param newPoint other point
     * @return distance
     */
    public double distance(Point newPoint) {
        return Math.sqrt((newPoint.getPointX() - pointX)
                * (newPoint.getPointX() - pointX)
        + (newPoint.getPointY() - pointY)
                * (newPoint.getPointY() - pointY));
    }

    /**
     * Compare.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return Double.compare(point.pointX, pointX) == 0
                && Double.compare(point.pointY, pointY) == 0;
    }

    /**
     * hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(pointX, pointY);
    }

    /**
     * String.
     */
    public String toString() {
        return "(" + (double) Math.round(pointX * 10) / 10 + ","
                + (double) Math.round(pointY * 10) / 10 + ")";
    }
}
