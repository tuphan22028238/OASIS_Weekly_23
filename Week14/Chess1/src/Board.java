import java.util.ArrayList;

public class Board {
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;
    private ArrayList<Piece> pieces = new ArrayList<>();

    public Board() {

    }

    /**
     * Add a piece into the chessboard.
     * @param piece given piece
     */
    public void addPiece(Piece piece) {
        if (validate(piece.getCoordinatesX(), piece.getCoordinatesY())) {
            for (int i = 0; i < pieces.size(); i++) {
                if (piece.checkPosition(pieces.get(i))) {
                    return;
                }
            }
            pieces.add(piece);
        }
    }

    public boolean validate(int x, int y) {
        return (((x >= 1) && (x <= WIDTH))
                && ((y >= 1) && (y <= HEIGHT)));
    }

    /**
     * Get piece at the specified position.
     * @param x x coordinate
     * @param y y coordinate
     * @return the piece at (x, y) coordinate if this exists, otherwise return null
     */
    public Piece getAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                return pieces.get(i);
            }
        }
        return null;
    }

    /**
     * Remove piece at the specified position.
     * @param x x coordinate
     * @param y y coordinate
     */
    public void removeAt(int x, int y) {
        for (int i = 0; i < pieces.size(); i++) {
            if (pieces.get(i).getCoordinatesX() == x
                    && pieces.get(i).getCoordinatesY() == y) {
                pieces.remove(pieces.get(i));
                break;
            }
        }
    }

    public ArrayList<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
}
