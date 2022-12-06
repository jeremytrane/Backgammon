package Model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

	int dots;

	public Dice(int dots) {
		this.dots = dots;
	}

	
	/** 
	 * @return int
	 */
	public int getDots() {
		return dots;
	}

	
	/** 
	 * @param dots
	 */
	public void setDots(int dots) {
		this.dots = dots;
	}

	
	/** 
	 * @param die
	 */
	public static void rollDie(Dice[] die) {
		int[] randomNumber = new int[2];
		randomNumber[0] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		randomNumber[1] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
		die[0].setDots(randomNumber[0]);
		die[1].setDots(randomNumber[1]);
	}

	
	/** 
	 * @param die
	 * @param die_1
	 * @param die_2
	 */
	public static void setDie(Dice[] die, int die_1, int die_2) {
		die[0].setDots(die_1);
		die[1].setDots(die_2);
	}

    
	/** 
	 * @param bothDie
	 * @return Dice[]
	 */
	public static Dice[] checkDouble(Dice[] bothDie) {
		if (bothDie[0].getDots()==bothDie[1].getDots()) {
			Dice[] fourDie = new Dice[4];
			fourDie[0] = new Dice(bothDie[1].getDots());
			fourDie[1] = new Dice(bothDie[1].getDots());
			fourDie[2] = new Dice(bothDie[1].getDots());
			fourDie[3] = new Dice(bothDie[1].getDots());

			return fourDie;
		}
			Dice[] twoDie = new Dice[2];
			twoDie[0] = new Dice(bothDie[0].getDots());
			twoDie[1] = new Dice(bothDie[1].getDots());
		
		return twoDie;
    }

}
