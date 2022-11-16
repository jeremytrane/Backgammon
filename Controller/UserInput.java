package Controller;

import java.util.ArrayList;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;

public class UserInput {

    String userInput;

    public UserInput() {
    }

    /**
     * @param userCommand
     * @param allPoints
     */
    public void parseCommand(String userCommand, Player player_1, Player player_2, Dice[] bothDie, Points[] allPoints) {

        if (userCommand.equalsIgnoreCase("Q")) {
            System.out.println("Game over!");
            System.exit(0);
        } else if (userCommand.equalsIgnoreCase("R")) {
            Dice.rollDie(bothDie);
        } else if (userCommand.equalsIgnoreCase("Pip")) {
            pipCount(player_1, player_2, allPoints);
        } else if (userCommand.equalsIgnoreCase("hint")) {
            ArrayList<String> possibleMoves = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
            ArrayList<String> possibleMovesLastQuarter = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
            System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
            ValidMoves.printPossibleCommands(possibleMoves, possibleMovesLastQuarter, allPoints, player_1, player_2);
        } else {
            System.out.println("Invalid command!");
        }
    }

    public void pipCount(Player player_1, Player player_2, Points[] allPoints) { 
        int whitePips = 0;
        int blackPips = 0;
        for (Points p:allPoints) {
            if (p.getLength()>0 && p.getCheckerColour(p.getCheckerIndex(0))==Colour.W)  {
                whitePips += p.getHowManyCheckers()*p.getPointNumber();
            } else if (p.getLength()>0 && p.getCheckerColour(p.getCheckerIndex(0))==Colour.B) {
                blackPips += p.getHowManyCheckers()*(25-p.getPointNumber());
            }
        }
        System.out.println(player_1 + " pip count: " + whitePips);
        System.out.println(player_2 + " pip count: " + blackPips);
    }
}
