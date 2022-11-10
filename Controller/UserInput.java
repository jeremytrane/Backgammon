package Controller;

import java.util.ArrayList;
import java.util.Arrays;

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
            if (player_1.getTurnToken()==1) {
                System.out.println(player_1 + " has " + player_1.getCheckerCount() + " checkers left!");
            } else {
                System.out.println(player_2 + " has " + player_2.getCheckerCount() + " checkers left!");
            }
        } else if (userCommand.equalsIgnoreCase("hint")) {
            ArrayList<String> possibleMoves = possibleMoves(bothDie, allPoints, player_1, player_2);
            System.out.println("Enter pip to see player pip. Or enter a number from the moves listed below:\n");
            System.out.println(possibleMoves);
        } else {
            System.out.println("Invalid command!");
        }
    }

    
    public static ArrayList<String> possibleMoves(Dice[] bothDie, Points[] allPoints, Player player_1, Player player_2) {
        //Count how many white points there are
        ArrayList<String> possibleMoves = new ArrayList<String>();
        if (player_1.getTurnToken()==1)  {
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength()>0){
                    if (allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                        //First dice if point is smaller then 2
                        if ((i+bothDie[0].getDots()) >= 24 && allPoints[i+bothDie[0].getDots()].getLength()<2) {
                            System.out.print("11" + i + " ");
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[0].getDots()));
                        //Second dice if point is smaller then 2
                        } else if ((i+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[1].getDots()].getLength()<2) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()));
                        //First and second dice if point is smaller then 2
                        } else if ((i+bothDie[0].getDots()+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getLength()<2) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()+bothDie[0].getDots()));
                        //First dice if point is same colour
                        } else if ((i+bothDie[0].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()].getCheckerColour(allPoints[i+bothDie[0].getDots()].getCheckerIndex(0))==Colour.W) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[0].getDots()));
                        //Second dice if point is same colour
                        }else if ((i+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[1].getDots()].getCheckerColour(allPoints[i+bothDie[1].getDots()].getCheckerIndex(0))==Colour.W) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()));
                        //First and second dice if point is same colour
                        }else if ((i+bothDie[0].getDots()+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getCheckerColour(allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getCheckerIndex(0))==Colour.W) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()+bothDie[0].getDots()));
                        }
                    }
                }
            }
        } else {
            //Count how many black points there are
            for (int i = 0; i < 24; i++) {
                if (allPoints[i].getLength()>0){
                    if (allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                        //First dice if point is smaller then 2
                        if ((i+bothDie[0].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()].getLength()<2) {
                            System.out.print("12" + i + " ");
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[0].getDots()));
                        //Second dice if point is smaller then 2
                        } else if ((i+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[1].getDots()].getLength()<2) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()));
                        //First and second dice if point is smaller then 2
                        } else if ((i+bothDie[0].getDots()+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getLength()<2) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()+bothDie[0].getDots()));
                        //First dice if point is same colour
                        } else if ((i+bothDie[0].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()].getCheckerColour(allPoints[i+bothDie[0].getDots()].getCheckerIndex(0))==Colour.B) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[0].getDots()));
                         //Second dice if point is same colour
                        }else if ((i+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[1].getDots()].getCheckerColour(allPoints[i+bothDie[1].getDots()].getCheckerIndex(0))==Colour.B) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()));
                        //First and second dice if point is same colour
                        }else if ((i+bothDie[0].getDots()+bothDie[1].getDots()) <= 24 && allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getCheckerColour(allPoints[i+bothDie[0].getDots()+bothDie[1].getDots()].getCheckerIndex(0))==Colour.B) {
                            possibleMoves.add((i+1) + " " + ((i+1)+bothDie[1].getDots()+bothDie[0].getDots()));
                        }
                    }
                }
            }
        }
            return possibleMoves;
    }
    
}
