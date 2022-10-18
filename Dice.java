import java.util.Random;

public class Dice {

    private int diceOne;
	private int diceTwo;

    public Dice(Dice d) {
        diceOne = d.diceOne;
		diceTwo = d.diceTwo;
        int[] possibleDiceRolls = {1, 2, 3, 4, 5, 6};
	}
	
	public int getDiceOne(){
		return diceOne;
	}
	
	public int getDiceTwo(){
		return diceTwo;
	}

}
