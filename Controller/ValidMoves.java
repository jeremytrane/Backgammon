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

    public static void printPossibleCommands(ArrayList<String> possibleMoves, ArrayList<String> possibleMovesLastQuarter, Points[] allPoints, Player player_1, Player player_2) {
        char[] listOrder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (!checkFinalQuarter(allPoints, player_1, player_2)) {
            parsePossibleMoves(possibleMoves);
            for (int i = 0; i < possibleMoves.size(); i++) {
                System.out.println("[" + listOrder[i] + "]: " + possibleMoves.get(i).split(" ")[0] + "-" + possibleMoves.get(i).split(" ")[1]);
            }
        } else if (checkFinalQuarter(allPoints, player_1, player_2)) {
            parsePossibleMovesLastQuarter(possibleMovesLastQuarter);
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

    public static void parsePossibleMoves(ArrayList<String> possibleMoves) {
        //Add the stupid rules he wants
        for (String moves:possibleMoves) {
            System.out.println(moves);
        }
    }

    public static void parsePossibleMovesLastQuarter(ArrayList<String> possibleMoves) {
        //Add the stupid rules he wants
        for (String moves:possibleMoves) {
            System.out.println(moves);
        }
    }
}

