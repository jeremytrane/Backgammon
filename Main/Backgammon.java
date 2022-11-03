package Main;

import java.util.Scanner;

import Model.Colour;
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
        player_1.setColour(Colour.W);
        player_2.setColour(Colour.B);

        Setup.getFirstTurn(bothDie,player_1,player_2);

        while (player_1.getCheckerCount()!=0 || player_2.getCheckerCount()!=0) {

            Board.Draw(allPoints, bothDie, player_1, player_2);

            System.out.println("Please enter your move");
            String move = in.nextLine();
            if (move.equalsIgnoreCase("Q")) {
                break;
            } else if (move.equalsIgnoreCase("R")) {
                Dice.rollDie(bothDie);
            } else if (move.equalsIgnoreCase("Pip")) {
                if (player_1.getTurnToken()==1) {
                    System.out.println(player_1 + " has " + player_1.getCheckerCount() + " checkers left!");
                } else {
                    System.out.println(player_2 + " has " + player_2.getCheckerCount() + " checkers left!");
                }
            } else if (move.equalsIgnoreCase("hint")) {
                System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
            }
        }

        in.close();

        if (player_1.getCheckerCount()==0)  {
            System.out.println("Game over!" + player_1 + " has won!");
        } else if (player_2.getCheckerCount()==0) {
            System.out.println("Game over!" + player_2 + " has won!");
        } else {
            System.out.println("Game over!");
        }

    }
    
    public static void swapTurn(Player player1, Player player2){
        player1.setTurn(-player1.getTurn());
        player2.setTurn(-player2.getTurn());
    }
    
}
