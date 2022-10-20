import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	int dots;
	private int diceOne;
	private int diceTwo;

	public Dice() {
	}

	public int getDiceOne() {
		return diceOne;
	}

	public void setDiceOne(int diceOne) {
		this.diceOne = diceOne;
	}

	public int getDiceTwo() {
		return diceTwo;
	}

	public void setDiceTwo(int diceTwo) {
		this.diceTwo = diceTwo;
	}

	public int[] rollDie(Dice diceOne, Dice diceTwo) {
		int[] randomNumber = new int[1];
		randomNumber[0] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		randomNumber[1] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		diceOne.setDiceOne(randomNumber[0]);
		diceTwo.setDiceTwo(randomNumber[1]);
		return randomNumber;
	}

}
