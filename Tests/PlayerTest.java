package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Colour;
import Model.Player;

public class PlayerTest {
    Player player = new Player("Player 1", 15);

    @Test
    // Checks getTurn/setTurn functionality
    public void testTurnSetGet() {
        int tokenToSet = 1;
        int gotToken;
        player.setTurnToken(tokenToSet);
        gotToken = player.getTurnToken();
        assertEquals(tokenToSet, gotToken);
    }
    @Test
    // Checks getName/setName functionality
    public void testNameSetGet() {
        String nameToSet = "Test";
        String gotName;
        player.setName(nameToSet);
        gotName = player.getName();
        assertEquals(nameToSet, gotName);
    }
    @Test
    // Checks getChecker/setChecker functionality
    public void testCheckerSetGet() {
        int checkerToSet = 1;
        int gotChecker;
        player.setCheckerCount(checkerToSet);
        gotChecker = player.getCheckerCount();
        assertEquals(checkerToSet, gotChecker);
    }
    @Test
    // Checks getColour/setColour functionality
    public void testColourSetGet() {
        Colour colourToSet = Colour.B;
        Colour gotColour;
        player.setColour(colourToSet);
        gotColour = player.getColour();
        assertEquals(colourToSet, gotColour);
    }
}
