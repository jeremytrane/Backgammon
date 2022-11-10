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
            if (player_1.getTurnToken() == 1) {
                System.out.println(player_1 + " has " + player_1.getCheckerCount() + " checkers left!");
            } else {
                System.out.println(player_2 + " has " + player_2.getCheckerCount() + " checkers left!");
            }
        } else if (userCommand.equalsIgnoreCase("hint")) {
            ArrayList<String> possibleMoves = possibleMoves(bothDie, allPoints, player_1, player_2);
            System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
            printPossibleCommands(possibleMoves);
        } else {
            System.out.println("Invalid command!");
        }
    }

    public void printPossibleCommands(ArrayList<String> possibleMoves) {
        for (int i = 0; i < possibleMoves.size(); i++) {
            System.out.println("[" + i + "] - Move a checker from point " + possibleMoves.get(i).split(" ")[0]
                    + " to point " + possibleMoves.get(i).split(" ")[1]);
        }
    }

    public static ArrayList<String> possibleMoves(Dice[] bothDie, Points[] allPoints, Player player_1,
            Player player_2) {
        // Count how many white points there are
        ArrayList<String> possibleMoves = new ArrayList<String>();
        if (player_1.getTurnToken() == 1) {
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0
                        && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0)) == Colour.W) {
                    System.out.print(i + 1 + "NUMBER\n");
                    System.out.println("1-");
                    System.out.println(i + bothDie[0].getDots());
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[i + bothDie[0].getDots()].getLength() < 2) {
                        System.out.println("11-");
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    System.out.println("2-");
                    System.out.println(i + bothDie[1].getDots());
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                        System.out.println("22-");
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    System.out.println("3-");
                    System.out.println(i + bothDie[0].getDots() + bothDie[1].getDots());
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23
                            && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                        System.out.println("33-");
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    System.out.println("4-");
                    System.out.println(i);
                    System.out.println(bothDie[0].getDots());
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()]
                                .getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.W) {
                            System.out.println("44-");
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    System.out.println("5-");
                    System.out.println(i + bothDie[1].getDots());
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[1].getDots()]
                                .getCheckerColour(allPoints[i + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                            System.out.println("55-");
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    System.out.println("6-");
                    System.out.println(i + bothDie[0].getDots() + bothDie[1].getDots());
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() > 0
                                && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()]
                                        .getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()]
                                                .getCheckerIndex(0)) == Colour.W) {
                            System.out.println("66-");
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                        }
                    }
                }
            }
        } else {
            // Count how many black points there are
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0
                        && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0)) == Colour.B) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[i + bothDie[0].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23
                            && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()]
                                .getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[1].getDots()]
                                .getCheckerColour(allPoints[i + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() > 0
                                && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()]
                                        .getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()]
                                                .getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

}
