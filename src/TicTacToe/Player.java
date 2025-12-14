package TicTacToe;

public abstract class Player implements Runnable  {
    protected final Game game;
    protected final PlayerType type;

    public Player(Game game, PlayerType type) {
        this.game = game;
        this.type = type;
    }
}
