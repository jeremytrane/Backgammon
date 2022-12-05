package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import Setup.Setup;
import View.Board;
import Controller.UserInput;
import Controller.ValidMoves;

public class Backgammon {

    public static void main(String[] args) {

        Setup.setupMessage();

        Scanner in = new Scanner(System.in);
        UserInput userInput = new UserInput();

        Dice[] bothDie = Setup.setupDie();
        Points[] allPoints = Setup.defaultBoard();

        System.out.println("Please enter name of player 1:");
        Player player_1 = Setup.setupPlayer(in);
        System.out.println("Please enter name of player 2:");
        Player player_2 = Setup.setupPlayer(in);
        player_1.setColour(Colour.W);
        player_2.setColour(Colour.B);

        Setup.getFirstTurn(bothDie, player_1, player_2);
        boolean moveMade = false;
        int spacesToMove;
        int[] dieToRemove;
        while (player_1.getCheckerCount() != 0 || player_2.getCheckerCount() != 0) {

            bothDie = Setup.setupDie();
            Dice.rollDie(bothDie);
            while(bothDie.length > 0){
                bothDie = Dice.checkDouble(bothDie);
                System.out.print("===========================================================================================================================================\n");
                Board.Draw(allPoints, bothDie, player_1, player_2);
                ArrayList<String> possibleMoves = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
                ArrayList<String> possibleMovesLastQuarter = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
                
                ValidMoves.printPossibleCommands(possibleMoves, possibleMovesLastQuarter, allPoints, player_1, player_2, bothDie);
                System.out.println("\nEnter your move:");
                String move = in.nextLine();
                moveMade = userInput.parseCommand(move, player_1, player_2, bothDie, allPoints);
                if(moveMade) {
                    spacesToMove = ValidMoves.getMoveSpaces(move,possibleMoves);
                    dieToRemove = removeDieIndex(bothDie,spacesToMove);
                    bothDie = removeDie(bothDie, dieToRemove);
                }
                
            }
            swapTurn(player_1, player_2);
        }

        in.close();

        if (player_1.getCheckerCount() == 0) {
            System.out.println("Game over!" + player_1 + " has won!");
        } else if (player_2.getCheckerCount() == 0) {
            System.out.println("Game over!" + player_2 + " has won!");
        } else {
            System.out.println("Game over!");
        }

    }



    public static void swapTurn(Player player1, Player player2) {
        player1.setTurn(-player1.getTurn());
        player2.setTurn(-player2.getTurn());
    }

    public static int[] removeDieIndex(Dice[] bothDie, int spacesToMove) {
        ArrayList<Integer> dieToRemove = new ArrayList<Integer>();
        boolean oneDie = false;
        for(int i=0; i<bothDie.length; i++){
            if(bothDie[i].getDots() == spacesToMove){
                dieToRemove.add(i);
                oneDie = true;
                break;
            }
        }
        if(!oneDie){
            if(bothDie.length == 2){
                dieToRemove.add(0);
                dieToRemove.add(1);
            }
            else if(bothDie.length > 2){
                for(int i=0;i<spacesToMove/bothDie[0].getDots();i++){
                    dieToRemove.add(i);
                }
            }
        }

        int[] dieAsArray = new int[dieToRemove.size()];
        for(int i=0;i<dieToRemove.size();i++){
            dieAsArray[i] = dieToRemove.get(i);
        }
        
        return dieAsArray;
    }

    public static Dice[] removeDie(Dice[] bothDie, int[] indicesToRemove) {
        ArrayList<Dice> dieRemoved = new ArrayList<Dice>();//Arrays.asList(bothDie);
        for(int i=0; i<bothDie.length; i++){
            dieRemoved.add(bothDie[i]);
        }
        for(int i : indicesToRemove){
            bothDie[i].setDots(7);
        }

        if(bothDie.length <= 2){
            if(indicesToRemove.length == 1){
                dieRemoved.remove(indicesToRemove[0]);
            }
            else if(indicesToRemove.length == 2){
                for(int i=0; i<dieRemoved.size();i++){
                    if(bothDie[i].getDots() == 7){
                        dieRemoved.remove(i);
                        break;
                    }
                }
                for(int i=0; i<dieRemoved.size();i++){
                    if(bothDie[i].getDots() == 7){
                        dieRemoved.remove(i);
                        break;
                    }
                }
            }
        }
        else if(bothDie.length >= 3){
            for(int i=0; i<indicesToRemove.length;i++){
                dieRemoved.remove(0);
            }
        }

        Dice[] dieRemovedArray = new Dice[dieRemoved.size()];
        for(int i=0; i<dieRemoved.size(); i++){
            dieRemovedArray[i] = dieRemoved.get(i);
        }
        return dieRemovedArray;
    }
}
