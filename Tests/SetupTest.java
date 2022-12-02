package Tests;

import Setup.Setup;
import Model.Dice;
import Model.Player;
import Model.Points;

import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.jupiter.api.*;

public class SetupTest {
    @Test
    // @DisplayName("Checks that dice are created.")
    public void testDieCreation() {
        Dice[] bothDie = Setup.setupDie();
        assertNotNull(bothDie[0]);
        assertNotNull(bothDie[1]);
    }

    public void testPlayerCreation(){
        Scanner in = new Scanner(System.in);
        Player player = Setup.setupPlayer(in);
        assertNotNull(player);
    }

    public void testPointCreation(){
        Points[] points = Setup.defaultBoard();

        for(Points p : points){
            assertNotNull(p);
        }

        assertEquals(28, points.length);
    }
}