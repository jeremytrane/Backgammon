package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Checkers;
import Model.Colour;

public class CheckersTest {
    Checkers checker = new Checkers(Colour.W);

    @Test
    // @DisplayName("Checks that ")
    public void testColourSetGet() {
        Colour colourToSet = Colour.B;
        Colour gotColour;
        checker.setCheckerColour(colourToSet);
        gotColour = checker.getCheckerColour();
        assertEquals(colourToSet, gotColour);
    }
}
