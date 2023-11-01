public class Bishop extends Piece {
    public Bishop(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Bishop(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    /**
     * Check if the bishop can move to the specified position.
     * @param board the chessboard the bishop are on
     * @param x x coordinate
     * @param y y coordinate
     * @return true if the bishop can go to this destination, false otherwise
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        int currentX = this.getCoordinatesX();
        int currentY = this.getCoordinatesY();

        //if the x diff is not equal y diff
        // so it's not the bishop move
        if (Math.abs(x - currentX)
                != Math.abs(y - currentY)) {
            return false;
        }

        //the bishop go to the left
        if (x < currentX) {
            //bishop go down
            for (int i = 1; i < currentY - y; i++) {
                if (board.getAt(currentX - i,
                        currentY - i) != null) {
                    return false;
                }
            }

            //bishop go up
            for (int i = 1; i < y - currentY; i++) {
                if (board.getAt(currentX - i,
                        currentY + i) != null) {
                    return false;
                }
            }
        }

        //the bishop go to the right
        if (x > currentX) {
            //the bishop go down
            for (int i = 1; i < currentY - y; i++) {
                if (board.getAt(currentX
                        + i, currentY - i) != null) {
                    return false;
                }
            }

            //the bishop go up
            for (int i = 1; i < y - currentY; i++) {
                if (board.getAt(currentX + i,
                        currentY + i) != null) {
                    return false;
                }
            }
        }

        if (board.getAt(x, y) != null) {
            if (board.getAt(x, y).getColor().equals(this.getColor())) {
                return false;
            }
        }
        return true;
    }
}

