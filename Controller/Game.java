package Controller;

import java.util.Scanner;
import Model.*;
import Setup.*;
import View.Board;

public class Game {

    public static void PlayGame() {

        Setup.setupMessage();

        Scanner in = new Scanner(System.in);

        Dice[] bothDie = Setup.setupDie();
        Points[] allPoints = Setup.defaultBoard();
        
        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer(in);
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer(in);

        while (player_1.getCheckerCount()!=0 || player_2.getCheckerCount()!=0) {

            Board.Draw(allPoints, bothDie);

            System.out.println("Please enter your move");
            String move = in.nextLine();
            if (move.equalsIgnoreCase("Q")) {
                break;
            } else if (move.equalsIgnoreCase("R")) {
                Dice.rollDie(bothDie);
            }
        }

        in.close();

    }
    
}
