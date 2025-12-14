package TicTacToe;

public class Cell  {
    private final int row;
    private final int col;

    // Constructor to initialize row and column
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // Getter methods for row and column
    public int getRow() { return row; }
    public int getCol() { return col; }
}