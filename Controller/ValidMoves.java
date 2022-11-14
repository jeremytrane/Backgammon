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

    public static void printPossibleCommands(ArrayList<String> possibleMoves) {
        for (int i = 0; i < possibleMoves.size(); i++) {
            System.out.println("[" + i + "] - Move a checker from point " + possibleMoves.get(i).split(" ")[0] + " to point " + possibleMoves.get(i).split(" ")[1]);
        }
    }
    
}
