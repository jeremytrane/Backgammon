package Tests;

import Setup.Setup;
import Model.Dice;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.jupiter.api.*;

public class SetupTest{
    @Test
    //@DisplayName("Checks that dice are created.")
    public void testDie(){
        Dice[] bothDie = Setup.setupDie();
        assertNotNull(bothDie[0]);
        assertNotNull(bothDie[1]);
    }
}