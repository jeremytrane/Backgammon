package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Colour;
import Model.Points;

public class PointsTest {
    Points point = new Points(Colour.B, 5, 1);

    @Test
    // @DisplayName("Checks that ")
    public void testPointLength() {
        int pointLength = 5;
        int gotLength = point.getLength();
        assertEquals(pointLength, gotLength);
    }

    @Test
    // @DisplayName("Checks that ")
    public void testGetIndex() {
        int numCheckers = 5;
        int gotCheckers = point.getHowManyCheckers();
        assertEquals(numCheckers, gotCheckers);
    }

    @Test
    // @DisplayName("Checks that ")
    public void testAddPoint() {
        int gotLength = point.getLength();
        point.addChecker(null);
        int newLength = point.getLength();
        assertEquals(newLength, gotLength+1);
    }

    @Test
    // @DisplayName("Checks that ")
    public void testColour() {
        Colour checkerColour = point.getCheckerIndex(0).getCheckerColour();
        Colour pointCheckerColour = point.getCheckerColour(point.getCheckerIndex(0));
        assertEquals(checkerColour,pointCheckerColour);
    }

    @Test
    // @DisplayName("Checks that ")
    public void testPointNumber() {
        int pointNumber = 1;
        int gotNumber = point.getPointNumber();
        assertEquals(pointNumber, gotNumber);
    }

    @Test
    // @DisplayName("Checks that ")
    public void testMoveChecker() {
        Points point1 = new Points(Colour.B, 5, 1);
        Points point2 = new Points(Colour.B, 5, 1);

        int length1 = 4;
        int length2 = 6;

        point.moveChecker(point1, point2, null, null);

        int newLength1 = point1.getHowManyCheckers();
        int newLength2 = point2.getHowManyCheckers();
        
        assertEquals(newLength1, length1);
        assertEquals(newLength2, length2);
    }
}
