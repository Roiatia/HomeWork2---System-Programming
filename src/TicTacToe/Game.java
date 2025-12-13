package TicTacToe;
import java.util.ArrayList;

public abstract class Game {
    protected final char[][] gameBoard; // 5x5 board
    protected PlayerType turn; // Current player's turn
    protected boolean gameOver; // Flag to indicate if the game is over
    protected PlayerType winner; // Winner of the game

    // Constructor to initialize the game board
    public Game() {
        gameBoard = new char[5][5];
        // Initialize the board with empty cells
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] = '-');
            }
        }
        turn = PlayerType.X;
        gameOver = false;
        winner = null;
    }

    // Method to get the current player's turn
    public synchronized PlayerType getTurn() {
        return turn;
    }

    // Method to get the list of available cells
    public synchronized ArrayList<Cell> getAvailableCells() {
        ArrayList<Cell> availableCells = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (gameBoard[i][j] == '-') {
                    availableCells.add(new Cell(i, j));
                }
            }
        }
        return availableCells;
    }

    // Method to check if the board is full
    public synchronized boolean isBoardFull() {
        return getAvailableCells().isEmpty();
    }

    // Method to check if the game is over
    public synchronized boolean isGameOver() {
        return gameOver;
    }

    // Method to get the winner of the game
    public synchronized PlayerType getWinner() {
        return winner;
    }

    //print the game board
    public synchronized void printBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(gameBoard[i][j] + '-');
            }
            System.out.println();
        }
        System.out.println();
    }

    //
    public synchronized boolean tryMove(PlayerType player, int row, int col) {
        if (gameOver) {
            return false; // Game is already over
        }
        if (player != turn) {
            return false;
        }
        if (!isInBounds(row, col)) {
            return false; // Move is out of bounds
        }
        if (gameBoard[row][col] != '-') {
            return false; // Cell is already occupied
        }
        if (player == PlayerType.X) {
            gameBoard[row][col] = 'X';
        } else {
            gameBoard[row][col] = 'O';
        }
        printBoard();

        //check for win
        if(hasWon(player)){
            winner = player;
            gameOver = true;
            notifyAll();
            return true;
        }

        //check for draw/full board
        if(isBoardFull()){
            System.out.println("No more available moves. It's a draw!");
            gameOver = true;
            notifyAll();
            return true;
        }

        //switch turn
        turn =( turn == PlayerType.X) ? PlayerType.O : PlayerType.X;
        notifyAll();
        return true;

    }


    public boolean isInBounds(int r , int c) {
        return r >= 0 && r < 5 && c >=0 && c < 5;
    }

    public boolean hasWon(PlayerType p) {
        char ch = (p == PlayerType.X) ? 'X' : 'O';

            for(int r = 0; r < 5; r++) {
                for (int c = 0; c < 5; c++) {
                    if(gameBoard[r][c] == ch &&
                        gameBoard[r][c + 1] == ch &&
                    gameBoard[r][c + 2] == ch &&
                    gameBoard[r][c + 3] == ch &&) {
                        return true; // Horizontal win
                    }
                }
            }

            for(int c = 0; c < 5; c++) {
                for (int r = 0; r < 5; r++) {
                    if(gameBoard[r][c] == ch &&
                        gameBoard[r + 1][c] == ch &&
                    gameBoard[r + 2][c] == ch &&
                    gameBoard[r + 3][c] == ch ) {
                        return true; // Vertical win
                    }
                }
            }

            for (int r = 0; r <= 1; r++) {
                for (int c = 0; c < 5; c++) {
                    if (gameBoard[r][c] == ch &&
                        gameBoard[r + 1][c + 1] == ch &&
                        gameBoard[r + 2][c + 2] == ch &&
                        gameBoard[r + 3][c + 3] == ch) {
                        return true; // Diagonal win (top-left to bottom-right)
                    }
                }
            }

            for (int r = 0; r <= 1; r++) {
                for (int c = 3; c < 5; c++) {
                    if (gameBoard[r][c] == ch &&
                        gameBoard[r + 1][c - 1] == ch &&
                        gameBoard[r + 2][c - 2] == ch &&
                        gameBoard[r + 3][c - 3] == ch) {
                        return true; // Diagonal win (top-right to bottom-left)
                    }
                }
            }
            return false; // No win found

    }
}
