import java.util.ArrayList;

public class Game {
    private Board board;
    private final ArrayList<Move> moveHistory = new ArrayList<>();

    public Game(Board board) {
        this.board = board;
    }

    /**
     * Do moving the piece.
     * @param piece given piece
     * @param x given x coordination
     * @param y given y coordination
     */
    public void movePiece(Piece piece, int x, int y) {
        if (piece.canMove(board, x, y)) {
            if (board.getAt(x, y) == null) {
                Move move = new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece);
                moveHistory.add(move);
            } else {
                //move to kill another piece
                Move move = new Move(piece.getCoordinatesX(), x,
                        piece.getCoordinatesY(), y, piece, board.getAt(x, y));
                moveHistory.add(move);
                board.removeAt(x, y);
            }

            piece.setCoordinatesX(x);
            piece.setCoordinatesY(y);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<Move> getMoveHistory() {
        return moveHistory;
    }
}
