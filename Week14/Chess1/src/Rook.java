public class Rook extends Piece {
    public Rook(int coordinatesX, int coordinatesY) {
        super(coordinatesX, coordinatesY);
    }

    public Rook(int coordinatesX, int coordinatesY, String color) {
        super(coordinatesX, coordinatesY, color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    /**
     * Check whether the rook can move to the specified position.
     * @param board chessboard
     * @param x x coordination
     * @param y y coordination
     * @return true if the rook can move, false otherwise
     */
    @Override
    public boolean canMove(Board board, int x, int y) {
        //As the rook can just move horizontally or vertically
        if (x != this.getCoordinatesX() && y != this.getCoordinatesY()) {
            return false;
        }

        if (x < this.getCoordinatesX()) {
            //If the rook move horizontally

            ///if the rook move to the left: if on the road,
            /// the rook meet another piece so it is unable to move
            for (int i = this.getCoordinatesX() - 1; i > x; --i) {
                if (board.getAt(i, y) != null) {
                    return false;
                }
            }
        }

        if (x > this.getCoordinatesX()) {
            ///if the rook move to the right: if on the road,
            /// the rook meet another piece so it is unable to move
            for (int i = this.getCoordinatesX() + 1; i < x; ++i) {
                if (board.getAt(i, y) != null) {
                     return false;
                }
            }
        }

        if (y < this.getCoordinatesY()) {
            //Do the same with moving vertically
            for (int i = this.getCoordinatesY() - 1; i > y; --i) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        }

        if (y > this.getCoordinatesY()) {
            for (int i = this.getCoordinatesY() + 1; i < y; ++i) {
                if (board.getAt(x, i) != null) {
                    return false;
                }
            }
        }

        if (board.getAt(x, y) != null) {
            if (board.getAt(x, y).getColor().equals(this.getColor())) {
                //at that position, if it meets the same color piece
                return false;
            }
        }
        return true;
    }

}
