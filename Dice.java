import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	int dots;
	private int diceOne;
	private int diceTwo;

	public Dices(Dices d) {
		diceOne = d.diceOne;
		diceTwo = d.diceTwo;

	public int getDots() {
		return dots;
	}

	public void setDots(int dots) {
		this.dots = dots;
	}

	public int rollDice(Dice d) {
		int randomNumber = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		d.setDots(randomNumber);
		return randomNumber;
	}

}
