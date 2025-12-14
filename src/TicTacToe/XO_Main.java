package TicTacToe;
import java.util.Scanner;

public class XO_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game version:");
        System.out.println("1 - Self vs Self (two threads)");
        System.out.println("2 - User vs Self (user chooses cells)");
        System.out.print("Your choice: ");

        int choice = scanner.nextInt();
        Game game;
        Thread player1Thread;
        Thread player2Thread;

        game = new SelfGame();
        if(choice == 1) {
            player1Thread = new Thread(new SelfPlayer(game, PlayerType.X), "Self - x ");
            player2Thread = new Thread(new SelfPlayer(game, PlayerType.O), "Self - o ");
        } else {
            player1Thread = new Thread(new UserPlayer(game, PlayerType.X, scanner), "User - x ");
            player2Thread = new Thread(new SelfPlayer(game, PlayerType.O), "Self - o ");
        }

        game.printBoard();

        player1Thread.start();
        player2Thread.start();

        try {
            player1Thread.join();
            player2Thread.join();
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e);
        }

        PlayerType winner = game.getWinner();
        if(winner != null) {
            System.out.println("Winner is : " + winner);
        } else {
            System.out.println("It's a draw!");
        }

    }
}
