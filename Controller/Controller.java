package Controller;

import java.util.ArrayList;

import Main.Backgammon;
import Model.Player;
import Model.Points;

public class Controller {

    public static void reset() {
        Backgammon.main(null);
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
     * @param possibleMoves
     * @param possibleMovesLastQuarter
     * @param allPoints
     * @param player_1
     * @param player_2
     * @return boolean
     */
    public static boolean checkSize(ArrayList<String> possibleMoves, ArrayList<String> possibleMovesLastQuarter,
            Points[] allPoints, Player player_1, Player player_2) {
        if (ValidMoves.checkFinalQuarter(allPoints, player_1, player_2) && possibleMovesLastQuarter.size() == 0) {
            return true;
        } else if (!ValidMoves.checkFinalQuarter(allPoints, player_1, player_2) && possibleMoves.size() == 0) {
            return true;
        }
        return false;
    }

}
