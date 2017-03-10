package chess;

import java.util.Scanner;

/**
 * User interface for two player chess console.
 *
 * @author John Phillips
 */
public class ChessUI {

    ChessBoard myBoard;
    Scanner sc = new Scanner(System.in);

    /**
     * Main UI loop allows for one or more two-player chess games to be played.
     */
    public ChessUI() {
        String playAgain = "y";
        while (playAgain.equalsIgnoreCase("y")) {
            myBoard = new ChessBoard();
            playGame();
            System.out.print("\nPlay another game (y/n)? ");
            playAgain = sc.nextLine();
        }
    }

    /**
     * Loop to play a single game of chess.
     */
    public final void playGame() {
        boolean gameOver = false;
        String from, to;
        int count = 0;
        System.out.println(myBoard);

        // loop until the game is over
        while (!gameOver) {
            if (count % 2 == 0) {
                System.out.println("White's move.");
            } else {
                System.out.println("Black's move.");
            }

            // loop until a valid move is entered or the user quits
            while (true) {
                System.out.print("Enter location to move from (e.g. h2): ");
                from = sc.nextLine();
                System.out.print("Enter location to move to (e.g. h4): ");
                to = sc.nextLine();
                if (!(ChessBoard.isValidPosition(from) && ChessBoard.isValidPosition(to))) {
                    System.out.println("Invalid position(s). Please try again.");
                    continue;
                }
                System.out.println("Do you want to move your "
                        + myBoard.getPiece(from).getName()
                        + " from " + from + " to " + to + "?");
                System.out.print("y for yes or r to redo or q to quit game: ");
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    break;
                } else if (choice.equalsIgnoreCase("q")) {
                    gameOver = true;
                    break;
                }
            }

            // make the move and display the board
            myBoard.move(from, to);
            System.out.println(myBoard);
            count++;
        }
    }

    /**
     * Get the chess application started.
     *
     * @param args
     */
    public static void main(String[] args) {
        ChessUI game = new ChessUI();
    }
}