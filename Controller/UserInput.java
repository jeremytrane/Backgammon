package Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import Main.Backgammon;
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
    public boolean parseCommand(String userCommand, Player player_1, Player player_2, Dice[] bothDie, Points[] allPoints) {
        boolean moveMade = false;
        String[] levalMovesList = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        String[] validDieMoves = {"1", "2", "3", "4", "5", "6"};
        boolean contains = Arrays.stream(levalMovesList).anyMatch(userCommand::equals);
        String[] userCommandSplit = userCommand.split(" ");
        if (userCommand.equalsIgnoreCase("quit")) {
            System.out.println("Game over!");
            System.exit(0);
        } else if (userCommand.equalsIgnoreCase("roll")) {
            Dice.rollDie(bothDie);
        } else if (userCommand.equalsIgnoreCase("swap")) {
            Backgammon.swapTurn(player_1, player_2);    
        } else if (Arrays.stream(validDieMoves).anyMatch((userCommandSplit[1])::equals) && Arrays.stream(validDieMoves).anyMatch((userCommandSplit[2])::equals) && userCommandSplit[0].equalsIgnoreCase("dice") && userCommandSplit.length == 3 && (Integer.parseInt(userCommandSplit[1])>0 && Integer.parseInt(userCommandSplit[1])<7) && (Integer.parseInt(userCommandSplit[2])>0 && Integer.parseInt(userCommandSplit[2])<7)) {
            Dice.setDie(bothDie, Integer.parseInt(userCommandSplit[1]), Integer.parseInt(userCommandSplit[2]));
        } else if (userCommand.equalsIgnoreCase("Pip")) {
            pipCount(player_1, player_2, allPoints);
        } else if (userCommand.equalsIgnoreCase("hint")) {
            System.out.println("\u001B[1mEnter pip to see player's pip count, roll to roll the die, quit to exit the game, Or enter a letter from the moves listed below:");
        } else if (userCommand.equalsIgnoreCase("test")) {
            try {
                testFromTxtFile(player_1, player_2, bothDie, allPoints);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (contains) {
            ValidMoves.makeMove(userCommand, bothDie, allPoints, player_1, player_2);
            moveMade = true;
        } else {
            System.out.println("Invalid command!");
        }
        return moveMade;
    }

    public void pipCount(Player player_1, Player player_2, Points[] allPoints) { 
        int whitePips = 0;
        int blackPips = 0;
        for (Points p:allPoints) {
            if (p.getLength()>0 && p.getCheckerColour(p.getCheckerIndex(0))==Colour.W)  {
                whitePips += p.getHowManyCheckers()*(25-p.getPointNumber());
            } else if (p.getLength()>0 && p.getCheckerColour(p.getCheckerIndex(0))==Colour.B) {
                blackPips += p.getHowManyCheckers()*p.getPointNumber();
            }
        }
        System.out.println(player_1 + " pip count: " + whitePips);
        System.out.println(player_2 + " pip count: " + blackPips);
    }

    public void testFromTxtFile(Player player_1, Player player_2, Dice[] bothDie, Points[] allPoints) throws FileNotFoundException{
        File file = new File("Controller/test.txt");
        Scanner sc = new Scanner(file);
        String command;
        int i = 1;

        while (sc.hasNextLine()){
            command = sc.nextLine();
            System.out.println("\nCommand "+ i + ":  " + command);
            parseCommand(command, player_1, player_2, bothDie, allPoints);
            i++;
        }
        sc.close();
    }
}
