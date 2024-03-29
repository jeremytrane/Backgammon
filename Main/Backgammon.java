package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import Setup.Setup;
import View.Board;
import Controller.Controller;
import Controller.UserInput;
import Controller.ValidMoves;

public class Backgammon {

    /**
     * @param args
     */
    public static void main(String[] args) {

        Setup.setupMessage();

        Scanner in = new Scanner(System.in);
        UserInput userInput = new UserInput();
        System.out.println("Please enter the game length:");
        int gameLength = Setup.getGameLength(in);
        int player1Wins = 0;
        int player2Wins = 0;
        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer(in);
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer(in);
        player_1.setColour(Colour.W);
        player_2.setColour(Colour.B);

        while (player1Wins != gameLength && player2Wins != gameLength) {

            Dice[] bothDie = Setup.setupDie();
            Points[] allPoints = Setup.defaultBoard();

            Setup.getFirstTurn(bothDie, player_1, player_2);
            boolean moveMade = true;
            int spacesToMove;
            int[] dieToRemove;
            while (allPoints[26].getLength() != 15 && allPoints[27].getLength() != 15) {
                if (moveMade) {
                    bothDie = Setup.setupDie();
                    Dice.rollDie(bothDie);
                }
                bothDie = Dice.checkDouble(bothDie);

                while (bothDie.length > 0) {

                    System.out.print(
                            "===========================================================================================================================================\n");
                    Board.Draw(allPoints, bothDie, player_1, player_2, player1Wins, player2Wins, gameLength);
                    ArrayList<String> possibleMoves = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
                    ArrayList<String> possibleMovesLastQuarter = ValidMoves.possibleMovesLastQuarter(bothDie, allPoints,
                            player_1,
                            player_2);
                    moveMade = Controller.checkSize(possibleMoves, possibleMovesLastQuarter, allPoints, player_1,
                            player_2);
                    if (moveMade) {
                        System.out.println("No valid moves!");
                        Controller.swapTurn(player_1, player_2);
                        bothDie = Setup.setupDie();
                        Dice.rollDie(bothDie);
                    } else {
                        ValidMoves.printPossibleCommands(possibleMoves, possibleMovesLastQuarter, allPoints, player_1,
                                player_2, bothDie);
                        System.out.println("\nEnter your move:");
                        String move = in.nextLine();
                        moveMade = userInput.parseCommand(move, player_1, player_2, bothDie, allPoints);
                        if (moveMade) {
                            spacesToMove = ValidMoves.getMoveSpaces(move, possibleMoves, allPoints, player_1, player_2, bothDie);
                            dieToRemove = Dice.removeDieIndex(bothDie, spacesToMove);
                            bothDie = Dice.removeDie(bothDie, dieToRemove);
                        } else {
                            break;
                        }
                    }
                }
                if (moveMade) {
                    Controller.swapTurn(player_1, player_2);
                }

            }

            if (allPoints[26].getLength() == 15) {
                System.out.println("Game over! " + player_1 + " has won!");
                player1Wins += 1;
            } else if (allPoints[27].getLength() == 15) {
                System.out.println("Game over! " + player_2 + " has won!");
                player2Wins += 1;
            } else {
                System.out.println("Game over!");
            }
        }
        if (player1Wins == gameLength) {
            System.out.println("Match over, player 1 has won!");
        } else if (player2Wins == gameLength) {
            System.out.println("Match over, player 2 has won!");
        }
        in.close();

    }

}
