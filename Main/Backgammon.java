package Main;

import java.util.Scanner;

import Model.Dice;
import Model.Player;
import Model.Points;
import Setup.Setup;
import View.Board;

public class Backgammon {

    public static void main(String[] args) { 

        Setup.setupMessage();

        Scanner in = new Scanner(System.in);

        Dice[] bothDie = Setup.setupDie();
        Points[] allPoints = Setup.defaultBoard();
        
        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer(in);
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer(in);

        Setup.getFirstTurn(bothDie,player_1,player_2);

        while (player_1.getCheckerCount()!=0 || player_2.getCheckerCount()!=0) {

            Board.Draw(allPoints, bothDie, player_1, player_2);

            System.out.println("Please enter your move");
            String move = in.nextLine();
            if (move.equalsIgnoreCase("Q")) {
                break;
            } else if (move.equalsIgnoreCase("R")) {
                Dice.rollDie(bothDie);
            }
        }

        in.close();
        System.out.println("Game over!");

    }
    
    public static void swapTurn(Player player1, Player player2){
        player1.setTurn(-player1.getTurn());
        player2.setTurn(-player2.getTurn());
    }
    
}
