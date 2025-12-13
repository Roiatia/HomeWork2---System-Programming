package TicTacToe;

public abstract class Player implements Runnable {
    protected Game game;
    protected Turn turn;

    public Player(Game game , Turn turn) {
        this.game = game;
        this.turn = turn;
    }
}
