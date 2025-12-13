package TicTacToe;

import java.util.ArrayList;

public class Game {
private char[][] board =  new char[5][5];
private Turn currentPlayer = Turn.x;


public Game() {
    for (int i = 0; i < 5; i++ ) {
        for(int j = 0; j < 5; j++) {
            board[i][j] = '-';
        }
    }
}

public synchronized boolean makeMove(int row, int col , Turn Turn) {
    if(Turn != currentPlayer){
        return false;
    }
    if(board[row][col] != '-') {
        return false;
    }
    board[row][col] = (currentPlayer == Turn.x) ? 'X' : 'O';
    printBoard();

    //change turn
    currentPlayer = (currentPlayer == Turn.x) ? Turn.o : Turn.x;
    return True;

}

public synchronized void printBoard() {
    for(int i = 0; i < 5; i++) {
        for(int j = 0; j < 5; j++ ){
            System.out.print(board[i][j] + " ");
        }
        System.out.println();
    }
    System.out.println();
}


}
