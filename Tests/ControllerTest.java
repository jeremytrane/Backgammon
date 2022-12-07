package Tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Controller.Controller;
import Model.Player;
import Model.Points;
import Setup.Setup;

public class ControllerTest {
    
    @Test
    // Checks swapTurn functionality
    public void testSwapTurn() {
        Player player1 = new Player("P1",15);
        Player player2 = new Player("P2",15);
        player2.setTurnToken(1);

        Controller.swapTurn(player1,player2);

        assertEquals(player1.getTurnToken(), 1);
        assertEquals(player2.getTurnToken(), -1);
    }

    @Test
    // Checks checkSize functionality
    public void testCheckSize() {
        Player player1 = new Player("P1",15);
        Player player2 = new Player("P2",15);
        player1.setTurnToken(1);

        ArrayList<String> possibleMoves = new ArrayList<String>();
        possibleMoves.add("1 7");
        possibleMoves.add("12 17");
        possibleMoves.add("12 18");
        possibleMoves.add("12 23");
        possibleMoves.add("17 22");
        possibleMoves.add("17 23");

        ArrayList<String> possibleMovesLQ = new ArrayList<String>();

        Points[] allPoints = Setup.defaultBoard();

        boolean empty;
        empty = Controller.checkSize(possibleMoves,possibleMovesLQ,allPoints,player1,player2);
        assertEquals(empty, false);
    }
}
