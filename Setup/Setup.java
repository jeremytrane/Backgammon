package Setup;

import java.util.Scanner;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;

public class Setup {

    public static void setupMessage() {
        System.out.println(" _                _                                                   ");
        System.out.println("| |              | |                                                  ");
        System.out.println("| |__   __ _  ___| | ____ _  __ _ _ __ ___  _ __ ___   ___  _ __      ");
        System.out.println("| '_ \\ / _` |/ __| |/ / _` |/ _` | '_ ` _ \\| '_ ` _ \\ / _ \\| '_ \\ ");
        System.out.println("| |_) | (_| | (__|   < (_| | (_| | | | | | | | | | | | (_) | | | |    ");
        System.out.println("|_.__/ \\__,_|\\___|_|\\_\\__, |\\__,_|_| |_| |_|_| |_| |_|\\___/|_| |_|    ");
        System.out.println("                       __/ |                                          ");
        System.out.println("                      |___/                                       \n");

    }

    /**
     * @return Dice[]
     */
    public static Dice[] setupDie() {

        Dice[] bothDie = new Dice[2];
        bothDie[0] = new Dice(0);
        bothDie[1] = new Dice(0);

        return bothDie;

    }

    /**
     * @param in
     * @return Player
     */
    public static Player setupPlayer(Scanner in) {
        String name;
        final int INITIAL_CHECKERS = 15;

        name = in.nextLine();

        Player player = new Player(name, INITIAL_CHECKERS);
        return player;
    }

    /**
     * @return Points[]
     */
    public static Points[] defaultBoard() {

        Points[] allPoints = new Points[28];
        allPoints[0] = new Points(Colour.W, 2, 1);
        allPoints[1] = new Points(null, 0, 2);
        allPoints[2] = new Points(null, 0, 3);
        allPoints[3] = new Points(null, 0, 4);
        allPoints[4] = new Points(null, 0, 5);
        allPoints[5] = new Points(Colour.B, 5, 6);
        allPoints[6] = new Points(null, 0, 7);
        allPoints[7] = new Points(Colour.B, 3, 8);
        allPoints[8] = new Points(null, 0, 9);
        allPoints[9] = new Points(null, 0, 10);
        allPoints[10] = new Points(null, 0, 11);
        allPoints[11] = new Points(Colour.W, 5, 12);
        allPoints[12] = new Points(Colour.B, 5, 13);
        allPoints[13] = new Points(null, 0, 14);
        allPoints[14] = new Points(null, 0, 15);
        allPoints[15] = new Points(null, 0, 16);
        allPoints[16] = new Points(Colour.W, 3, 17);
        allPoints[17] = new Points(null, 0, 18);
        allPoints[18] = new Points(Colour.W, 5, 19);
        allPoints[19] = new Points(null, 0, 20);
        allPoints[20] = new Points(null, 0, 21);
        allPoints[21] = new Points(null, 0, 22);
        allPoints[22] = new Points(null, 0, 23);
        allPoints[23] = new Points(Colour.B, 2, 24);

        // This is the point for the white bar
        allPoints[24] = new Points(Colour.W, 0, 25);
        // This is the point for the black bar
        allPoints[25] = new Points(Colour.B, 0, 26);

        // This is the point for white stack-off
        allPoints[26] = new Points(Colour.W, 0, 27);
        // This is the point for black stack-off
        allPoints[27] = new Points(Colour.B, 0, 28);

        return allPoints;

    }

    /**
     * @param die
     * @param player1
     * @param player2
     */
    public static void getFirstTurn(Dice[] die, Player player1, Player player2) {
        int sum1, sum2;
        boolean equal = true;
        while (equal) {
            Dice.rollDie(die);
            System.out.println(player1 + " rolls: " + die[0].getDots() + " " + die[1].getDots());
            sum1 = die[0].getDots() + die[1].getDots();
            Dice.rollDie(die);
            System.out.println(player2 + " rolls: " + die[0].getDots() + " " + die[1].getDots());
            sum2 = die[0].getDots() + die[1].getDots();

            if (sum1 > sum2) {
                player1.setTurn(1);
                player2.setTurn(-1);
                equal = false;
                System.out.println(player1 + " rolls higher and goes first.");
            } else if (sum2 > sum1) {
                player1.setTurn(-1);
                player2.setTurn(1);
                equal = false;
                System.out.println(player2 + " rolls higher and goes first.");
            } else {
                System.out.println("Both are equal! Rolling again.");
            }
        }
    }

    /**
     * @param in
     * @return int
     */
    public static int getGameLength(Scanner in) {
        String tryThis = in.nextLine();
        try {
            Integer.parseInt(tryThis);
        } catch (NumberFormatException e) {
            System.out.println("Game length invalid, exiting!");
            System.exit(0);
        } catch (NullPointerException e) {
            System.out.println("Game length invalid, exiting!");
            System.exit(0);
        }
        // only got here if we didn't return false
        return Integer.parseInt(tryThis);
    }

}
