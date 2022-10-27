package Controller;

import java.util.Scanner;

import Model.Player;
import Setup.Setup;

public class Game {

    public static void PlayGame() {

        Setup.setupAndRun();
        
        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer();
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer();

        Scanner in = new Scanner(System.in);

        while (player_1.getCheckerCount()!=0 || player_2.getCheckerCount()!=0) {
            System.out.println("Please enter your move");
            String move = in.nextLine();
            if (move.equalsIgnoreCase("Q")) {
                break;
            }
            
        }

        in.close();

    }
    
}
