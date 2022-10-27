package Model;
import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	int dots;

	public Dice(int dots) {
		this.dots = dots;
	}

	public int getDots() {
		return dots;
	}

	public void setDots(int dots) {
		this.dots = dots;
	}

	public static int[] rollDie(Dice[] die) {
		int[] randomNumber = new int[2];
		randomNumber[0] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		randomNumber[1] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		die[0].setDots(randomNumber[0]);
		die[1].setDots(randomNumber[1]);
		return randomNumber;
	}

}
