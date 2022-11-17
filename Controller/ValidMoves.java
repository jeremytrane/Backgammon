package Controller;

import java.util.ArrayList;
import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;

public class ValidMoves {
    
    public static ArrayList<String> possibleMoves(Dice[] bothDie, Points[] allPoints, Player player_1,
            Player player_2) {
        // Count how many white points there are
        ArrayList<String> possibleMoves = new ArrayList<String>();
        if (player_1.getTurnToken() == 1) {
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0)) == Colour.W) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[i + bothDie[0].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                        }
                    }
                }
            }
        } else {
            // Count how many black points there are
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[23 - i].getCheckerIndex(0)) == Colour.B) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots()].getLength() < 2) {
                        possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() < 2) {
                        possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[0].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[0].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[1].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() > 0  && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                        }
                    }
                }
            }
        }
        return possibleMoves;
    }

    public static ArrayList<String> possibleMovesLastQuarter(Dice[] bothDie, Points[] allPoints, Player player_1,
            Player player_2) {
        // Count how many white points there are
        ArrayList<String> possibleMovesLastQuarter = new ArrayList<String>();
        if (player_1.getTurnToken() == 1) {
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0)) == Colour.W) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[i + bothDie[0].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                        }
                    }
                    // If first die stack-off
                    if ((i + bothDie[0].getDots()) > 23) {
                        possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                    }
                    // If second die stack-off
                    if ((i + bothDie[1].getDots()) > 23) {
                        possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                    }
                }
            }
        } else {
            // Count how many black points there are
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[23 - i].getCheckerIndex(0)) == Colour.B) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                    }
                    // Second dice if point is smaller then 2
                    if ((i + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[1].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                    }
                    // First and second dice if point is smaller then 2
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[0].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[0].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                        }
                    }
                    // Second dice if point is same colour
                    if ((i + bothDie[1].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[1].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                        }
                    }
                    // First and second dice if point is same colour
                    if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() > 0  && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                        }
                    }
                    // If first die stack-off
                    if ((i + bothDie[0].getDots()) > 23) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                    }
                    // If second die stack-off
                    if ((i + bothDie[1].getDots()) > 23) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                    }
                }
            }
        }
        return possibleMovesLastQuarter;
    }

    public static void printPossibleCommands(ArrayList<String> possibleMoves, ArrayList<String> possibleMovesLastQuarter, Points[] allPoints, Player player_1, Player player_2, Dice[] bothDie) {
        char[] listOrder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (!checkFinalQuarter(allPoints, player_1, player_2)) {
            parsePossibleMoves(possibleMoves, bothDie);
            for (int i = 0; i < possibleMoves.size(); i++) {
                System.out.println("[" + listOrder[i] + "]: " + possibleMoves.get(i).split(" ")[0] + "-" + possibleMoves.get(i).split(" ")[1]);
            }
        } else if (checkFinalQuarter(allPoints, player_1, player_2)) {
            parsePossibleMovesLastQuarter(possibleMovesLastQuarter, bothDie);
            for (int i = 0; i < possibleMovesLastQuarter.size(); i++) {
                System.out.println("[" + listOrder[i] + "]: " + possibleMovesLastQuarter.get(i).split(" ")[0] + "-" + possibleMovesLastQuarter.get(i).split(" ")[1]);
            }
        }
    }
    
    public static boolean checkFinalQuarter(Points[] allPoints, Player player_1, Player player_2) {
        if (player_1.getTurnToken() == 1) {
            if (allPoints[18].getHowManyCheckers() + allPoints[19].getHowManyCheckers() + allPoints[20].getHowManyCheckers() + allPoints[21].getHowManyCheckers() + allPoints[22].getHowManyCheckers() + allPoints[23].getHowManyCheckers() + allPoints[26].getHowManyCheckers() == 15) {
                return true;
            } 
        } else if (player_2.getTurnToken() == 1) {
            if (allPoints[0].getHowManyCheckers() + allPoints[1].getHowManyCheckers() + allPoints[2].getHowManyCheckers() + allPoints[3].getHowManyCheckers() + allPoints[4].getHowManyCheckers() + allPoints[5].getHowManyCheckers() + allPoints[27].getHowManyCheckers() == 15) {
                return true;
            }
        }
        return false;
    }

    public static void parsePossibleMoves(ArrayList<String> possibleMoves, Dice[] bothDie) {
        String[] firstPoint = new String[possibleMoves.size()];
        String[] secondPoint = new String[possibleMoves.size()];
        for (int i = 0; i < possibleMoves.size(); i++) {
            firstPoint[i] = possibleMoves.get(i).split(" ")[0];
            secondPoint[i] = possibleMoves.get(i).split(" ")[1];
            //System.out.print(firstPoint[i] + " " + secondPoint[i] + "\n");
        }

        for (int j = 0; j < possibleMoves.size()-1; j++) {
            if (firstPoint[j] == firstPoint[j+1] && Integer.parseInt(secondPoint[j]) - Integer.parseInt(firstPoint[j]) == bothDie[0].getDots() && Integer.parseInt(secondPoint[j+1]) - Integer.parseInt(firstPoint[j+1]) == bothDie[1].getDots()) {
                System.out.print("removed");
                possibleMoves.remove(possibleMoves.get(j));
            }
        }
    }

    public static void parsePossibleMovesLastQuarter(ArrayList<String> possibleMoves, Dice[] bothDie) {
        String[] firstPoint = new String[possibleMoves.size()];
        String[] secondPoint = new String[possibleMoves.size()];
        for (int i = 0; i < possibleMoves.size(); i++) {
        firstPoint[i] = possibleMoves.get(i).split(" ")[0];
        secondPoint[i] = possibleMoves.get(i).split(" ")[1];
        }

        for (int j = 0; j < possibleMoves.size()-1; j++) {
            if (firstPoint[j] == firstPoint[j+1] && Integer.parseInt(firstPoint[j]) == bothDie[0].getDots() && Integer.parseInt(firstPoint[j+1]) == bothDie[1].getDots()) {
                possibleMoves.remove(possibleMoves.get(j));
            }
        }
    }

    public static void makeMove(String userCommand, Dice[] bothDie, Points[] allPoints, Player player_1, Player player_2) {
        ArrayList<String> possibleMoves = possibleMoves(bothDie, allPoints, player_1, player_2);
        ArrayList<String> possibleMovesLastQuarter = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
        ValidMoves.printPossibleCommands(possibleMoves, possibleMovesLastQuarter, allPoints, player_1, player_2, bothDie);
        int moveToMake = 0;
        switch (userCommand.toUpperCase()) {
            case "A":
            moveToMake = 0;
            case "B":
            moveToMake = 1;
            case "C":
            moveToMake = 2;
            case "D":
            moveToMake = 3;
            case "E":
            moveToMake = 4;
            case "F":
            moveToMake = 5;
            case "G":
            moveToMake = 6;
            case "H":
            moveToMake = 7;
            case "I":
            moveToMake = 8;
            case "J":
            moveToMake = 9;
            case "K":
            moveToMake = 10;
            case "L":
            moveToMake = 11;
            case "M":
            moveToMake = 12;
            case "N":
            moveToMake = 13;
            case "O":
            moveToMake = 14;
            case "P":
            moveToMake = 15;
            case "Q":
            moveToMake = 16;
            case "R":
            moveToMake = 17;
            case "S":
            moveToMake = 18;
            case "T":
            moveToMake = 19;
            case "U":
            moveToMake = 20;
            case "V":
            moveToMake = 21;
            case "W":
            moveToMake = 22;
            case "X":
            moveToMake = 23;
            case "Y":
            moveToMake =24;
            case "Z":
            moveToMake = 25;
            default:
            moveToMake = 0;
        }
        if (!checkFinalQuarter(allPoints, player_1, player_2)) {
            System.out.print(possibleMoves.get(moveToMake));
            System.out.print(Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[0])-1);
            System.out.print(Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[1])-1);

            allPoints[0].moveChecker(allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[0])-1], allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[1])-1]);
        } else if (checkFinalQuarter(allPoints, player_1, player_2)) {
            System.out.print(possibleMovesLastQuarter.get(moveToMake));
        }
    }
}
