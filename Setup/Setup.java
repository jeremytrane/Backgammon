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

public static Dice[] setupDie() {

        Dice[] bothDie = new Dice[2];
        bothDie[0] = new Dice(0);
        bothDie[1] = new Dice(0);

        return bothDie;

    }

public static Player setupPlayer(Scanner in) {
    String name;
    final int INITIAL_CHECKERS=15;

    name = in.nextLine();

    Player player= new Player(name,INITIAL_CHECKERS);
    return player;
    }

public static Points[] defaultBoard() {

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

    return allPoints;

    }

public static void getFirstTurn(Dice[] die, Player player1, Player player2){
        int sum1,sum2;
        boolean equal = true;
        while(equal){
            Dice.rollDie(die);
            System.out.println(player1 + " rolls: " + die[0].getDots() + " " + die[1].getDots());
            sum1 = die[0].getDots() + die[1].getDots();
            Dice.rollDie(die);
            System.out.println(player2 + " rolls: " + die[0].getDots() + " " + die[1].getDots());
            sum2 = die[0].getDots() + die[1].getDots();

            if(sum1>sum2){
                player1.setTurn(1);
                player2.setTurn(-1);
                equal = false;
                System.out.println(player1 + " rolls higher and goes first.");
            }
            else if(sum2>sum1){
                player1.setTurn(-1);
                player2.setTurn(1);
                equal = false;
                System.out.println(player2 + " rolls higher and goes first.");
            }
            else{
                System.out.println("Both are equal! Rolling again.");
            }
        }
    }

}   
