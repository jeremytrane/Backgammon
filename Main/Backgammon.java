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

        while (player1Wins != gameLength || player2Wins != gameLength) {

            Dice[] bothDie = Setup.setupDie();
            Points[] allPoints = Setup.defaultBoard();

            System.out.println("Please enter name of player 1:");
            Player player_1 = Setup.setupPlayer(in);
            System.out.println("Please enter name of player 2:");
            Player player_2 = Setup.setupPlayer(in);
            player_1.setColour(Colour.W);
            player_2.setColour(Colour.B);

            Setup.getFirstTurn(bothDie, player_1, player_2);
            boolean moveMade = true;
            int spacesToMove;
            int[] dieToRemove;
            while (player_1.getCheckerCount() != 0 || player_2.getCheckerCount() != 0) {

                if(moveMade){
                    bothDie = Setup.setupDie();
                    Dice.rollDie(bothDie);
                }
                bothDie = Dice.checkDouble(bothDie);

                while(bothDie.length > 0){
                    
                    System.out.print("===========================================================================================================================================\n");
                    Board.Draw(allPoints, bothDie, player_1, player_2, player1Wins, player2Wins, gameLength);
                    ArrayList<String> possibleMoves = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
                    ArrayList<String> possibleMovesLastQuarter = ValidMoves.possibleMoves(bothDie, allPoints, player_1, player_2);
                    moveMade = checkSize(possibleMoves, possibleMovesLastQuarter, allPoints, player_1, player_2);
                    if (moveMade){
                        System.out.println("No valid moves!");
                        swapTurn(player_1, player_2);
                    }else {
                    ValidMoves.printPossibleCommands(possibleMoves, possibleMovesLastQuarter, allPoints, player_1, player_2, bothDie);
                    System.out.println("\nEnter your move:");
                    String move = in.nextLine();
                    moveMade = userInput.parseCommand(move, player_1, player_2, bothDie, allPoints);
                    if(moveMade) {
                        spacesToMove = ValidMoves.getMoveSpaces(move,possibleMoves);
                        dieToRemove = removeDieIndex(bothDie,spacesToMove);
                        bothDie = removeDie(bothDie, dieToRemove);
                    }
                    else{
                        break;
                    }
                }
                }
                if(moveMade){
                    swapTurn(player_1, player_2);
                }
                
            }

            in.close();

            if (player_1.getCheckerCount() == 0) {
                System.out.println("Game over!" + player_1 + " has won!");
                player1Wins += 1;
            } else if (player_2.getCheckerCount() == 0) {
                System.out.println("Game over!" + player_2 + " has won!");
                player2Wins += 1;
            } else {
                System.out.println("Game over!");
            }
        }
    }



    
    /** 
     * @param possibleMoves
     * @param possibleMovesLastQuarter
     * @param allPoints
     * @param player_1
     * @param player_2
     * @return boolean
     */
    private static boolean checkSize(ArrayList<String> possibleMoves, ArrayList<String> possibleMovesLastQuarter, Points[] allPoints, Player player_1, Player player_2) {
        if (ValidMoves.checkFinalQuarter(allPoints, player_1, player_2) && possibleMovesLastQuarter.size()==0) {
            return true;
        } else if (!ValidMoves.checkFinalQuarter(allPoints, player_1, player_2) && possibleMoves.size()==0) {
            return true;
        }
        return false;
    }

    
    /** 
     * @param player1
     * @param player2
     */
    public static void swapTurn(Player player1, Player player2) {
        player1.setTurn(-player1.getTurn());
        player2.setTurn(-player2.getTurn());
    }

    
    /** 
     * @param bothDie
     * @param spacesToMove
     * @return int[]
     */
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

    
    /** 
     * @param bothDie
     * @param indicesToRemove
     * @return Dice[]
     */
    public static Dice[] removeDie(Dice[] bothDie, int[] indicesToRemove) {
        ArrayList<Dice> dieRemoved = new ArrayList<Dice>();

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



    public static void reset() {
        main(null);
    }
}
