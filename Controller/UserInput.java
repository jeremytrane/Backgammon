package Controller;

import Model.Dice;
import Model.Player;

public class UserInput {

    String userInput;

    public UserInput() {
    }

    /**
     * @param userCommand
     */
    public void parseCommand(String userCommand, Player player_1, Player player_2, Dice[] bothDie) {

        if (userCommand.equalsIgnoreCase("Q")) {
            System.out.println("Game over!");
            System.exit(0);
        } else if (userCommand.equalsIgnoreCase("R")) {
            Dice.rollDie(bothDie);
        } else if (userCommand.equalsIgnoreCase("Pip")) {
            if (player_1.getTurnToken()==1) {
                System.out.println(player_1 + " has " + player_1.getCheckerCount() + " checkers left!");
            } else {
                System.out.println(player_2 + " has " + player_2.getCheckerCount() + " checkers left!");
            }
        } else if (userCommand.equalsIgnoreCase("hint")) {
            System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
        } else {
            //String listOfPossibleMoves = possibleMoves(bothDie);
        }

    }
    
}
