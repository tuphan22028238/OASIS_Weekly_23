public class Point {
    private double pointX;
    private double pointY;

    /**
     * Constructor with given value.
     * @param x given x value
     * @param y given y value
     */
    public Point(double x, double y) {
        pointX = x;
        pointY = y;
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
     * Return distance of two points.
     * @param other other point
     * @return distance of two points
     */
    public double distance(Point other) {
        return Math.sqrt((this.getPointX() - other.getPointX())
                * (this.getPointX() - other.getPointX())
                + (this.getPointY() - other.getPointY())
                * (this.getPointY() - other.getPointY()));
    }
}
