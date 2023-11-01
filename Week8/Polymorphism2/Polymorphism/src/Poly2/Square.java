import java.util.Objects;

public class Square extends Rectangle {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public Square(Point topLeft, double side, String color, boolean filled) {
        super(topLeft, side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    /**
     * Set side of the square.
     * @param side side
     */
    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    /**
     * Set side of the square.
     * @param side given side
     */
    @Override
    public void setWidth(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Set side of the square.
     * @param side side
     */
    @Override
    public void setLength(double side) {
        super.setWidth(side);
        super.setLength(side);
    }

    /**
     * Compare an object with the square.
     * @param o object
     * @return true if they are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }


    /**
     * Give the information of the square.
     * @return information of the square
     */
    @Override
    public String toString() {
        return "Square[topLeft=" + topLeft.toString()
                + ",side=" + (double) Math.round(getWidth() * 10) / 10
                + ",color=" + getColor() + ",filled=" + isFilled() + "]";
    }
}
