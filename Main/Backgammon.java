package Main;

import java.util.Scanner;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import Setup.Setup;
import View.Board;
import Controller.UserInput;

public class Backgammon {

    public static void main(String[] args) { 

        Setup.setupMessage();

        Scanner in = new Scanner(System.in);
        UserInput userInput = new UserInput();

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
            System.out.println("If you wish to enter a move please enter it in the order: point_number number_of_points_to_move.");
            String move = in.nextLine();
            //String possibleMoves = possibleMoves(bothDie, allPoints, player_1, player_2);
            userInput.parseCommand(move,player_1,player_2,bothDie);
            
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
    
    public static String possibleMoves(Dice[] bothDie, Points[] allPoints, Player player_1, Player player_2) {
        //Count how many white points there are
        if (player_1.getTurnToken()==1)  {
            int howManyWhitePoints = 0;
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                    howManyWhitePoints += 1;
                }
            }
            Points[] pointsOfColourToMove = new Points[howManyWhitePoints];
            for (int j = 0; j < 24; j++) {
                if (allPoints[j].getCheckerColour(allPoints[j].getCheckerIndex(0))==Colour.W) {
                    pointsOfColourToMove[j] = allPoints[j];
                }
            }
        } else {
            //Count how many black points there are
            int howManyBlackPoints = 0;
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                    howManyBlackPoints += 1;
                }
            }
            Points[] pointsOfColourToMove = new Points[howManyBlackPoints];
            for (int j = 0; j < 24; j++) {
                if (allPoints[j].getCheckerColour(allPoints[j].getCheckerIndex(0))==Colour.B) {
                    pointsOfColourToMove[j] = allPoints[j];
                }
            }
        }
        String[] possibleMoves;
        //Add for loop to calculate moves possible (checking if colour landing on is the same if the length is geater then 1), temp return statement
        return "";
    }
    
}
