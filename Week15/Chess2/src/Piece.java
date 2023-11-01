public abstract class Piece {
    private int coordinatesX;
    private int coordinatesY;
    private String color;

    /**
     * Constructor with given values.
     * @param coordinatesX given x coordinate
     * @param coordinatesY given y coordinate
     */
    public Piece(int coordinatesX, int coordinatesY) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = "white";
    }

    /**
     * Constructor with given values.
     * @param coordinatesX given x coordinate
     * @param coordinatesY given y coordinate
     * @param color given color for the piece
     */
    public Piece(int coordinatesX, int coordinatesY, String color) {
        this.coordinatesX = coordinatesX;
        this.coordinatesY = coordinatesY;
        this.color = color;
    }

    public abstract String getSymbol();

    public abstract boolean canMove(Board broad, int x, int y);

    public int getCoordinatesX() {
        return this.coordinatesX;
    }

    public void setCoordinatesX(int coordinatesX) {
        this.coordinatesX = coordinatesX;
    }

    public int getCoordinatesY() {
        return this.coordinatesY;
    }

    public void setCoordinatesY(int coordinatesY) {
        this.coordinatesY = coordinatesY;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Check if 2 pieces have the same position.
     * @param piece given piece
     * @return true if they are in the same position, false otherwise
     */
    public boolean checkPosition(Piece piece) {
        boolean check = (piece.getCoordinatesX() == this.coordinatesX)
                && (piece.getCoordinatesY() == this.coordinatesY);
        return check;
    }

}