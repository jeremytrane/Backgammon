package Setup;

import java.util.Scanner;

import Model.Colour;
import Model.Player;
import Model.Points;
import View.Board;

public class Setup {

    public static void setupAndRun() {
        setupMessage();
        setupPlayer();
        setupPieces();
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

        Points[] allPoints = new Points[24];
        allPoints[0] = new Points(Colour.W, 5);
        allPoints[1] = new Points(null, 0);
        allPoints[2] = new Points(null, 0);
        allPoints[3] = new Points(null, 0);
        allPoints[4] = new Points(Colour.B, 3);
        allPoints[5] = new Points(null, 0);
        allPoints[6] = new Points(Colour.B, 5);
        allPoints[7] = new Points(null, 0);
        allPoints[8] = new Points(null, 0);
        allPoints[9] = new Points(null, 0);
        allPoints[10] = new Points(null, 0);
        allPoints[11] = new Points(Colour.W, 2);
        allPoints[12] = new Points(Colour.B, 2);
        allPoints[13] = new Points(null, 0);
        allPoints[14] = new Points(null, 0);
        allPoints[15] = new Points(null, 0);
        allPoints[16] = new Points(null, 0);
        allPoints[17] = new Points(Colour.W, 5);
        allPoints[18] = new Points(null, 0);
        allPoints[19] = new Points(Colour.W, 3);
        allPoints[20] = new Points(null, 0);
        allPoints[21] = new Points(null, 0);
        allPoints[22] = new Points(null, 0);
        allPoints[23] = new Points(Colour.B, 5);
        boardSetup(allPoints);

    }

private static void boardSetup(Points[] allPoints) {
        Board.Draw(allPoints);
    }

public static Player setupPlayer() {
    Scanner in = new Scanner(System.in);
    String name;
    final var INITIAL_CHECKERS=15;

    name = in.nextLine();

    Player player_1 = new Player(name,INITIAL_CHECKERS);
    in.close();
    return player_1;
    }
}
