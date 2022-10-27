package Controller;

import java.util.Scanner;

import Model.Player;
import Model.Dice;
import Setup.Setup;

public class Game {

    public static void PlayGame() {

        Scanner in = new Scanner(System.in);

        Setup.setupAndRun();
        
        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer(in);
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer(in);

        while (player_1.getCheckerCount()!=0 || player_2.getCheckerCount()!=0) {
            System.out.println("Please enter your move");
            String move = in.nextLine();
            if (move.equalsIgnoreCase("Q")) {
                break;
            } else if (move.equalsIgnoreCase("R")) {
                //Dice.rollDie();
            }
            
        }

        in.close();

    }
    
}
