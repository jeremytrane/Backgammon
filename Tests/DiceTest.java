package Tests;

import static org.junit.Assert.*;
import org.junit.Test;

import Model.Dice;

public class DiceTest {

    Dice die1 = new Dice(0);
    Dice die2 = new Dice(0);

    @Test
    // Checks dice creation functionality
    public void testDiceCreation() {
        Dice die = new Dice(2);
        assertNotNull(die);
    }

    @Test
    // Checks setDots/getDots functionality
    public void testDotsSetGet() {
        die1.setDots(1);
        int gotDots = die1.getDots();
        assertEquals(gotDots,1);
    }

    @Test 
    // Checks rollDie functionality
    public void testRollDie() {
        Dice[] bothDie = new Dice[2];
        bothDie[0] = die1;
        bothDie[1] = die2;
        Dice.rollDie(bothDie);
        assertTrue(bothDie[0].getDots()<7 && bothDie[0].getDots()>0);
        assertTrue(bothDie[1].getDots()<7 && bothDie[1].getDots()>0);
    }

    @Test
    // Checks checkDouble functionality
    public void testCheckDouble() {
        die1.setDots(1);
        die2.setDots(1);
        Dice[] doubleDie = new Dice[2];
        doubleDie[0] = die1;
        doubleDie[1] = die2;
        Dice newDie1 = new Dice(2);
        Dice newDie2 = new Dice(3);
        Dice[] notDoubleDie = new Dice[2];
        notDoubleDie[0] = newDie1;
        notDoubleDie[1] = newDie2;

        doubleDie = Dice.checkDouble(doubleDie);
        notDoubleDie = Dice.checkDouble(notDoubleDie);

        assertEquals(doubleDie.length, 4);
        assertEquals(notDoubleDie.length, 2);
    }

    @Test
    // Checks removeDieIndex functionality
    public void testRemoveDieIndex() {
        int die1Value = 2;
        int die2Value = 5;
        int spacesToMove = die2Value;
        die1.setDots(die1Value);
        die2.setDots(die2Value);
        Dice[] bothDie = new Dice[2];
        bothDie[0] = die1;
        bothDie[1] = die2;

        // Should remove die matching spaces to move, if one die was used
        int[] indicesToRemove = Dice.removeDieIndex(bothDie,spacesToMove);
        int[] check1 = new int[1];
        check1[0] = 1; // index of die2
        assertArrayEquals(indicesToRemove, check1);

        // Should remove both die if both used
        spacesToMove = die1Value + die2Value;
        indicesToRemove = Dice.removeDieIndex(bothDie,spacesToMove);
        int[] check2 = new int[2];
        check2[1] = 0; // index of die1
        check2[1] = 1; // index of die2
        assertArrayEquals(indicesToRemove, check2);

        // If double(all match), should remove first die
        Dice[] fourDice = new Dice[4];
        fourDice[0] = die1;
        fourDice[1] = die1;
        fourDice[2] = die1;
        fourDice[3] = die1;

        check1[0] = 0;
        indicesToRemove = Dice.removeDieIndex(fourDice,die1Value);
        assertArrayEquals(indicesToRemove, check1);
    }

    @Test 
    // Checks removeDie functionality
    public void testRemoveDie() {
        Dice[] bothDie = new Dice[2];
        bothDie[0] = die1;
        bothDie[1] = die2;
        
        // Check die 2 was removed if method is run
        int[] indicesToRemove = new int[1];
        indicesToRemove[0] = 1;

        bothDie = Dice.removeDie(bothDie, indicesToRemove);
        assertEquals(bothDie.length, 1);
        assertEquals(bothDie[0], die1);
    }
}
