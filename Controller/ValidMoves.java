package Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;

public class ValidMoves {
    
    public static ArrayList<String> possibleMoves(Dice[] bothDie, Points[] allPoints, Player player_1,
            Player player_2) {
        // Count how many white points there are
        ArrayList<String> possibleMoves = new ArrayList<String>();
        int checkOneDiePlayable1 = 0;
        int checkOneDiePlayable2 = 0;
        if(allPoints[24].getHowManyCheckers()>0 && player_1.getTurnToken() == 1){
            possibleMoves = possibleMovesWhiteBar(bothDie, allPoints);
        }
        else if(allPoints[25].getHowManyCheckers()>0 && player_2.getTurnToken() == 1){
            possibleMoves = possibleMovesBlackBar(bothDie, allPoints);
        }
        else{
            if (player_1.getTurnToken() == 1) {
                for (int i = 0; i < 24; i++) {
                    if (allPoints[i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0)) == Colour.W) {
                        // First dice if point is smaller then 2
                        if ((i + bothDie[0].getDots()) <= 23 && allPoints[i + bothDie[0].getDots()].getLength() < 2) {
                            possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                            checkOneDiePlayable1 += 1;
                        }
                        if(bothDie.length > 1){
                            // Second dice if point is smaller then 2
                            if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                                possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                                checkOneDiePlayable1 += 1;
                            }
                            // First and second dice if point is smaller then 2
                            if (checkOneDiePlayable1 != 0 &&(i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                                possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                            }
                        }
                        if (bothDie.length > 3) {
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots()].getLength() < 2) {
                                possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()+ bothDie[2].getDots()));
                            }
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() <= 23) {
                                if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()+ bothDie[2].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()+ bothDie[2].getDots()].getCheckerIndex(0)) == Colour.W) {
                                    possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots() + bothDie[2].getDots()));
                                }
                            }
                        } 
                        if (bothDie.length == 4) {
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots() <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots()].getLength() < 2) {
                                possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()+ bothDie[2].getDots() + bothDie[3].getDots()));
                            }
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots() <= 23) {
                                if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()+ bothDie[2].getDots() + bothDie[3].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()+ bothDie[2].getDots() + bothDie[3].getDots()].getCheckerIndex(0)) == Colour.W) {
                                    possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots() + bothDie[2].getDots() + bothDie[3].getDots()));
                                }
                            }
                        }
                        // First dice if point is same colour
                        if ((i + bothDie[0].getDots()) <= 23) {
                            if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.W) {
                                possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                                checkOneDiePlayable2 += 1;
                            }
                        }
                        if(bothDie.length > 1){
                            // Second dice if point is same colour
                            if ((i + bothDie[1].getDots()) <= 23) {
                                if (allPoints[i + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                                    possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                                    checkOneDiePlayable2 += 1;
                                }
                            }
                            // First and second dice if point is same colour
                            if (checkOneDiePlayable2 != 0 && (i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                                if (allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getCheckerIndex(0)) == Colour.W) {
                                    possibleMoves.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                                }
                            }
                        }
                    }
                }

            } else {
                // Count how many black points there are
                for (int i = 0; i < 24; i++) {
                    if (allPoints[23-i].getLength() > 0 && allPoints[23-i].getCheckerColour(allPoints[23 - i].getCheckerIndex(0)) == Colour.B) {
                        // First dice if point is smaller then 2
                        if ((i + bothDie[0].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots()].getLength() < 2) {
                            possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                            checkOneDiePlayable1 += 1;
                        }
                        if(bothDie.length > 1){
                            // Second dice if point is smaller then 2
                            if ((i + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[1].getDots()].getLength() < 2) {
                                possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                                checkOneDiePlayable1 += 1;
                            }
                            // First and second dice if point is smaller then 2
                            if (checkOneDiePlayable1 != 0 && (i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() < 2) {
                                possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                            }
                        } 
                        if (bothDie.length > 3) {
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots()  <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots()].getLength() < 2) {
                                possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots()));
                            }
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots()<= 23) {
                                if (allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots()].getLength() > 0  && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots()].getCheckerIndex(0)) == Colour.B) {
                                    possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots() - bothDie[2].getDots()));
                                }
                            }
                        } 
                        if (bothDie.length == 4) {
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots() <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots() - bothDie[3].getDots()].getLength() < 2) {
                                possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots() - bothDie[2].getDots() - bothDie[3].getDots()));
                            }
                            if (i + bothDie[0].getDots() + bothDie[1].getDots() + bothDie[2].getDots() + bothDie[3].getDots()<= 23) {
                                if (allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots() - bothDie[3].getDots()].getLength() > 0  && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots() - bothDie[3].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots() - bothDie[3].getDots()].getCheckerIndex(0)) == Colour.B) {
                                    possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots() - bothDie[1].getDots() - bothDie[2].getDots() - bothDie[3].getDots()));
                                }
                            }
                        } 
                        // First dice if point is same colour
                        if ((i + bothDie[0].getDots()) <= 23) {
                            if (allPoints[23 - i - bothDie[0].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[0].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots()].getCheckerIndex(0)) == Colour.B) {
                                possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                                checkOneDiePlayable2 += 1;
                            }
                        }
                        if(bothDie.length > 1){
                            // Second dice if point is same colour
                            if ((i + bothDie[1].getDots()) <= 23) {
                                if (allPoints[23 - i - bothDie[1].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                                    possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                                    checkOneDiePlayable2 += 1;
                                }
                            }
                            // First and second dice if point is same colour
                            if (checkOneDiePlayable2 != 0 && (i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23) {
                                if (allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() > 0  && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getCheckerIndex(0)) == Colour.B) {
                                    possibleMoves.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                                }
                            }
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
                    if(bothDie.length > 1){
                        // Second dice if point is smaller then 2
                        if ((i + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[1].getDots()].getLength() < 2) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots()));
                        }
                        // First and second dice if point is smaller then 2
                        if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[i + bothDie[0].getDots() + bothDie[1].getDots()].getLength() < 2) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[1].getDots() + bothDie[0].getDots()));
                        }
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[i + bothDie[0].getDots()].getLength() > 0 && allPoints[i + bothDie[0].getDots()].getCheckerColour(allPoints[i + bothDie[0].getDots()].getCheckerIndex(0)) == Colour.W) {
                            possibleMovesLastQuarter.add((i + 1) + " " + ((i + 1) + bothDie[0].getDots()));
                        }
                    }
                    if(bothDie.length > 1){
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
                    }
                    // If first die stack-off
                    if ((i + bothDie[0].getDots()) > 23) {
                        possibleMovesLastQuarter.add((i + 1) + " " + 27);
                    }
                    if(bothDie.length > 1){
                        // If second die stack-off
                        if ((i + bothDie[1].getDots()) > 23) {
                            possibleMovesLastQuarter.add((i + 1) + " " + 27);
                        }
                        //If both die stack-off
                        if (i+bothDie[0].getDots() + bothDie[1].getDots() > 23) {
                            possibleMovesLastQuarter.add((i + 1) + " " + 27);
                        }
                    }
                }
            }
        } else {
            // Count how many black points there are
            for (int i = 0; i < 24; i++) {
                if (allPoints[23-i].getLength() > 0 && allPoints[i].getCheckerColour(allPoints[23 - i].getCheckerIndex(0)) == Colour.B) {
                    // First dice if point is smaller then 2
                    if ((i + bothDie[0].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots()].getLength() < 2) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                    }
                    if(bothDie.length > 1){
                        // Second dice if point is smaller then 2
                        if ((i + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[1].getDots()].getLength() < 2) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots()));
                        }
                        // First and second dice if point is smaller then 2
                        if ((i + bothDie[0].getDots() + bothDie[1].getDots()) <= 23 && allPoints[23 - i - bothDie[0].getDots() - bothDie[1].getDots()].getLength() < 2) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[1].getDots() - bothDie[0].getDots()));
                        }
                    }
                    // First dice if point is same colour
                    if ((i + bothDie[0].getDots()) <= 23) {
                        if (allPoints[23 - i - bothDie[0].getDots()].getLength() > 0 && allPoints[23 - i - bothDie[0].getDots()].getCheckerColour(allPoints[23 - i - bothDie[0].getDots()].getCheckerIndex(0)) == Colour.B) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + (24 - (i ) - bothDie[0].getDots()));
                        }
                    }
                    if(bothDie.length > 1){
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
                    }
                    // If first die stack-off
                    if ((i + bothDie[0].getDots()) > 23) {
                        possibleMovesLastQuarter.add(24 - (i ) + " " + 28);
                    }
                    if(bothDie.length > 1){
                        // If second die stack-off
                        if ((i + bothDie[1].getDots()) > 23) {
                            possibleMovesLastQuarter.add(24 - (i ) + " " + 28);
                        }
                        //If both die stack-off
                        if (i+bothDie[0].getDots() + bothDie[1].getDots() > 23) {
                            possibleMovesLastQuarter.add(24 - i + " " + 28);
                        }
                    }
                }
            }
        }
        return possibleMovesLastQuarter;
    }

    public static ArrayList<String> possibleMovesWhiteBar(Dice[] bothDie, Points[] allPoints){
        ArrayList<String> possibleMoves = new ArrayList<String>();

        for(Dice die : bothDie){
            if(allPoints[die.getDots()-1].getHowManyCheckers()<=1){
                possibleMoves.add(25 + " " + die.getDots());
            }
            else if(allPoints[die.getDots()-1].getCheckerIndex(0).getCheckerColour()==Colour.W){
                possibleMoves.add(25 + " " + die.getDots());
            }
        } 

        return possibleMoves;
    }
    public static ArrayList<String> possibleMovesBlackBar(Dice[] bothDie, Points[] allPoints){
        ArrayList<String> possibleMoves = new ArrayList<String>();

        for(Dice die : bothDie){
            if(allPoints[24-die.getDots()].getHowManyCheckers()<=1){
                possibleMoves.add(26 + " " + (25-die.getDots()));
            }
            else if(allPoints[24-die.getDots()].getCheckerIndex(0).getCheckerColour()==Colour.B){
                possibleMoves.add(26 + " " + (25-die.getDots()));
            }
        } 

        return possibleMoves;
    }

    public static void printPossibleCommands(ArrayList<String> possibleMoves, ArrayList<String> possibleMovesLastQuarter, Points[] allPoints, Player player_1, Player player_2, Dice[] bothDie) {
        char[] listOrder = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        if (!checkFinalQuarter(allPoints, player_1, player_2)) {
            removeDoubleMoves(possibleMoves);
            Collections.sort(possibleMoves);
            System.out.println("Not in");
            for (int i = 0; i < possibleMoves.size(); i++) {
                System.out.println("[" + listOrder[i] + "]: " + possibleMoves.get(i).split(" ")[0] + "-" + possibleMoves.get(i).split(" ")[1]);            }
        } else if (checkFinalQuarter(allPoints, player_1, player_2)) {
            removeDoubleMoves(possibleMovesLastQuarter);
            Collections.sort(possibleMovesLastQuarter);
            System.out.println("We're in");
            for (int i = 0; i < possibleMovesLastQuarter.size(); i++) {
                System.out.println("[" + listOrder[i] + "]: " + possibleMovesLastQuarter.get(i).split(" ")[0] + "-" + possibleMovesLastQuarter.get(i).split(" ")[1]);
            }
        }
    }
    
    private static void removeDoubleMoves(ArrayList<String> possibleMoves) {
        Set<String> set = new HashSet<>(possibleMoves);
        possibleMoves.clear();
        possibleMoves.addAll(set);
    }

    public static boolean checkFinalQuarter(Points[] allPoints, Player player_1, Player player_2) {
        int sum = 0;
        if (player_1.getTurnToken() == 1) {
            if (allPoints[18].getLength() > 0 && allPoints[18].getCheckerColour(allPoints[18].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[18].getHowManyCheckers();
            }
            if (allPoints[19].getLength() > 0 && allPoints[19].getCheckerColour(allPoints[19].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[19].getHowManyCheckers();
            }
            if (allPoints[20].getLength() > 0 && allPoints[20].getCheckerColour(allPoints[20].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[20].getHowManyCheckers();
            }
            if (allPoints[21].getLength() > 0 && allPoints[21].getCheckerColour(allPoints[21].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[21].getHowManyCheckers();
            }
            if (allPoints[22].getLength() > 0 && allPoints[22].getCheckerColour(allPoints[22].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[22].getHowManyCheckers();
            }
            if (allPoints[23].getLength() > 0 && allPoints[23].getCheckerColour(allPoints[23].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[23].getHowManyCheckers();
            }
            if (allPoints[26].getLength() > 0 && allPoints[26].getCheckerColour(allPoints[26].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[26].getHowManyCheckers();
            }
            if (sum == 15) {
                return true;
            } 

        } else if (player_2.getTurnToken() == 1) {
            if (allPoints[0].getLength() > 0 && allPoints[0].getCheckerColour(allPoints[0].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[0].getHowManyCheckers();
            }
            if (allPoints[1].getLength() > 0 &&allPoints[1].getCheckerColour(allPoints[1].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[1].getHowManyCheckers();
            }
            if (allPoints[2].getLength() > 0 &&allPoints[2].getCheckerColour(allPoints[3].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[2].getHowManyCheckers();
            }
            if (allPoints[3].getLength() > 0 &&allPoints[3].getCheckerColour(allPoints[3].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[3].getHowManyCheckers();
            }
            if (allPoints[4].getLength() > 0 &&allPoints[4].getCheckerColour(allPoints[4].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[4].getHowManyCheckers();
            }
            if (allPoints[5].getLength() > 0 &&allPoints[5].getCheckerColour(allPoints[5].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[5].getHowManyCheckers();
            }
            if (allPoints[27].getLength() > 0 &&allPoints[27].getCheckerColour(allPoints[27].getCheckerIndex(0))==Colour.W) {
                sum += allPoints[27].getHowManyCheckers();
            }
            if (sum == 15) {
                return true;
            } 
        }
        return false;
    }

    public static void makeMove(String userCommand, Dice[] bothDie, Points[] allPoints, Player player_1, Player player_2) {
        ArrayList<String> possibleMoves;
        if (checkFinalQuarter(allPoints, player_1, player_2)) {
            possibleMoves = possibleMovesLastQuarter(bothDie, allPoints, player_1, player_2);
        } else {
            System.out.println(allPoints[18].getHowManyCheckers() + allPoints[19].getHowManyCheckers() + allPoints[20].getHowManyCheckers() + allPoints[21].getHowManyCheckers() + allPoints[22].getHowManyCheckers() + allPoints[23].getHowManyCheckers() + allPoints[26].getHowManyCheckers());
            possibleMoves = possibleMoves(bothDie, allPoints, player_1, player_2);
        }
        removeDoubleMoves(possibleMoves);
        Collections.sort(possibleMoves);

        if(possibleMoves.size()==0) {
            System.out.println("No valid moves!");
        } else {
            int moveToMake = 0;
            String[] legalMoves = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            moveToMake = Arrays.asList(legalMoves).indexOf(userCommand.toUpperCase());
            if (moveToMake>=possibleMoves.size()) {
                System.out.println("Please enter a valid move!");
            } else {
                if (!checkFinalQuarter(allPoints, player_1, player_2)) {
                    allPoints[0].moveChecker(allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[0])-1], allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[1])-1], allPoints[24],allPoints[25]);
                } 
                else if (checkFinalQuarter(allPoints, player_1, player_2)) {
                    //Add to move out of final quarter
                    allPoints[0].moveChecker(allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[0])-1], allPoints[Integer.parseInt(possibleMoves.get(moveToMake).split(" ")[1])-1], allPoints[24],allPoints[25]);
                }
            }
        }
        
    }

    public static int getMoveSpaces(String userCommand, ArrayList<String> possibleMoves) { 
        int moveToMake;
        int spacesToMove = 0;
        String[] legalMoves = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        moveToMake = Arrays.asList(legalMoves).indexOf(userCommand.toUpperCase());
        
        if (moveToMake<possibleMoves.size()) {
            String[] moveStrings = possibleMoves.get(moveToMake).split(" ");
            spacesToMove = Math.abs(Integer.parseInt(moveStrings[1]) - Integer.parseInt(moveStrings[0]));
        }

        return spacesToMove;
    }
}
