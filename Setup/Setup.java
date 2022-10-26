package Setup;

import java.util.Scanner;
import Model.Player;
import View.Board;

public class Setup {

    public static void setupAndRun() {
        setupMessage();
        setupPlayer();
        setupPieces();
        boardSetup();
    }

private static void setupMessage() {
    System.out.println(" _                _                                                   ");
    System.out.println("| |              | |                                                  ");
    System.out.println("| |__   __ _  ___| | ____ _  __ _ _ __ ___  _ __ ___   ___  _ __      ");
    System.out.println("| '_ \\ / _` |/ __| |/ / _` |/ _` | '_ ` _ \\| '_ ` _ \\ / _ \\| '_ \\ ");
    System.out.println("| |_) | (_| | (__|   < (_| | (_| | | | | | | | | | | | (_) | | | |    ");
    System.out.println("|_.__/ \\__,_|\\___|_|\\_\\__, |\\__,_|_| |_| |_|_| |_| |_|\\___/|_| |_|    ");
    System.out.println("                       __/ |                                          ");
    System.out.println("                      |___/                                       \n");

}

private static void setupPieces() {
        
    }

private static void boardSetup() {
        Board.Draw();
    }

public static void setupPlayer() {
    Scanner in = new Scanner(System.in);
    String name1, name2;
    final var INITIAL_CHECKERS=15;

    System.out.println("Please enter name of player 1:");
    name1 = in.nextLine();
    System.out.println("Please enter name of player 2");
    name2 = in.nextLine();

    Player player_1 = new Player(name1,INITIAL_CHECKERS);
    Player player_2 = new Player(name2,INITIAL_CHECKERS);
    in.close();
    }
}
