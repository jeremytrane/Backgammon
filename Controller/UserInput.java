package Controller;

import java.util.ArrayList;
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
            System.out.println(player_1 + " has " + player_1.getCheckerCount() + " checkers left!");
            System.out.println(player_2 + " has " + player_2.getCheckerCount() + " checkers left!");
        } else if (userCommand.equalsIgnoreCase("hint")) {
            ArrayList<String> possibleMoves = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
            System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
            printPossibleCommands(possibleMoves);
        } else {
            System.out.println("Invalid command!");
        }
    }

    public void printPossibleCommands(ArrayList<String> possibleMoves) {
        for (int i = 0; i < possibleMoves.size(); i++) {
            System.out.println("[" + i + "] - Move a checker from point " + possibleMoves.get(i).split(" ")[0] + " to point " + possibleMoves.get(i).split(" ")[1]);
        }
    }

}
