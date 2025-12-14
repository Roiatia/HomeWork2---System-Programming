package TicTacToe;

import java.util.Scanner;

public class UserPlayer extends Player
{
    private final Scanner scanner;

    public UserPlayer(Game game, PlayerType type , Scanner scanner) {
        super(game, type);
        this.scanner = scanner;
    }

    @Override
    public void run()
    {
        while(!game.isGameOver())
        {
            if(game.getTurn() != type)
            {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
                continue;
            }

            if(game.isBoardFull()) {
                System.out.println("No available moves left!");
                return;
            }

            int r , c;
            while (true)
            {
                if(game.isGameOver()) {
                    return;
                }

                System.out.println("Enter row (0-4) and col (0-4): ");
                r = scanner.nextInt();
                c = scanner.nextInt();

                boolean ok = game.tryMove(type, r, c);
                if (ok) {
                    break;
                }
                System.out.println("Invalid move. Try again.");
            }
        }
    }

}
