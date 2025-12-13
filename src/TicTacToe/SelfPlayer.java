package TicTacToe;

import java.util.Random;
import java.util.ArrayList;
import java.util.function.IntUnaryOperator;

public class SelfPlayer extends Player {
    private final Random random  = new Random();

    public SelfPlayer(Game game , PlayerType type)  {
        super(game, type);
    }

    @Override
    public void run() {
        while(!game.isGameOver()) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                return;
            }
        if(game.isGameOver()) {
            return;
        }
        if(game.getTurn() != type) {
            continue;
        }

        ArrayList<Cell> freeCells = game.getAvailableCells();
        if(freeCells.isEmpty()) {
            System.out.println("No available moves left!");
            return;
        }
        int index = random.nextInt(freeCells.size());
        Cell chosenCell = freeCells.get(index);
        game.tryMove(type, chosenCell.getRow(), chosenCell.getCol());
        }
    }
}
