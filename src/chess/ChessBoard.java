package chess;

/**
 * Represents a chess board. Each square on the chess board can hold a chessman
 * object.
 *
 * @author John Phillips
 */
public class ChessBoard {

    /**
     * String that represents the column names on the board.
     */
    public final static String FILE = "hgfedcba";

    /**
     * A two-dimensional array representing a chessboard and containing
     * chessmen.
     */
    protected Chessman[][] board = new Chessman[8][8];

    /**
     * When a new chessboard object is created the chessman objects are created
     * and placed in the starting positions.
     */
    public ChessBoard() {
        reset();
    }

    /**
     * Gets a chessman piece from the given position.
     *
     * @param position
     * @return chessman
     */
    public Chessman getPiece(String position) {
        int row = position2Row(position);
        int col = position2Column(position);
        return board[row][col];
    }

    /**
     * Given an array row (0-7) and column (0-7) return the position string
     * (e.g. 0,0 gives h1 and 7,7 gives a8)
     *
     * @param row
     * @param column
     * @return position string
     */
    public String rowCol2Position(int row, int column) {
        String file = FILE.substring(column, column + 1);
        String rank = "" + (row + 1);
        return file + rank;
    }

    /**
     * Given a position string return the array row number.
     *
     * @param position
     * @return row
     */
    public static int position2Row(String position) {
        return Integer.parseInt(position.substring(1, 2)) - 1;
    }

    /**
     * Given a position string return the array column number.
     *
     * @param position
     * @return column
     */
    public static int position2Column(String position) {
        return FILE.indexOf(position.substring(0, 1));
    }

    /**
     * Return true if the string represents a valid position on the chessboard.
     *
     * @param position
     * @return true or false
     */
    public static boolean isValidPosition(String position) {
        return position.matches("^[a-h][1-8]$");
    }

    /**
     * Given a position to move from and another to move to, move the chessman
     * and replace the empty square with a new empty chessman object.
     *
     * @param from
     * @param to
     */
    public void move(String from, String to) {
        int rowFrom = position2Row(from);
        int colFrom = position2Column(from);
        int rowTo = position2Row(to);
        int colTo = position2Column(to);

        board[rowTo][colTo] = board[rowFrom][colFrom];
        board[rowFrom][colFrom] = new Dash("white");
    }

    /**
     * Create all of the chessmen and place them on the board in the standard
     * positions.
     */
    public final void reset() {
        char[][] tempBoard = {
            {'r', 'h', 'b', 'q', 'k', 'b', 'h', 'r'},
            {'p', 'p', 'p', 'p', 'p', 'p', 'p', 'p'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'-', '-', '-', '-', '-', '-', '-', '-'},
            {'P', 'P', 'P', 'P', 'P', 'P', 'P', 'P'},
            {'R', 'H', 'B', 'Q', 'K', 'B', 'H', 'R'}
        };
        for (int row = 0; row < tempBoard.length; row++) {
            for (int col = 0; col < tempBoard[row].length; col++) {
                Chessman man;

                switch (tempBoard[row][col]) {
                    case 'p':
                        man = new Pawn("white");
                        break;
                    case 'P':
                        man = new Pawn("black");
                        break;
                    case 'r':
                        man = new Rook("white");
                        break;
                    case 'R':
                        man = new Rook("black");
                        break;
                    case 'h':
                        man = new Knight("white");
                        break;
                    case 'H':
                        man = new Knight("black");
                        break;
                    case 'b':
                        man = new Bishop("white");
                        break;
                    case 'B':
                        man = new Bishop("black");
                        break;
                    case 'q':
                        man = new Queen("white");
                        break;
                    case 'Q':
                        man = new Queen("black");
                        break;
                    case 'k':
                        man = new King("white");
                        break;
                    case 'K':
                        man = new King("black");
                        break;
                    case '-':
                        man = new Dash("white");
                        break;
                    default:
                        man = null;
                        System.out.println("Error on board reset");
                        break;
                }

                board[row][col] = man;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("  h g f e d c b a\n");
        for (int row = 0; row < board.length; row++) {
            sb.append(row + 1).append(" ");
            for (int col = 0; col < board[row].length; col++) {
                sb.append(board[row][col].getSymbol()).append(" ");
            }
            sb.append(row + 1).append("\n");
        }
        sb.append("  h g f e d c b a\n");
        return sb.toString();
    }
}