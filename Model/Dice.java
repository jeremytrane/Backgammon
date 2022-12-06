package Model;

import java.util.ArrayList;
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
        if (bothDie[0].getDots() == bothDie[1].getDots()) {
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

    /**
     * @param bothDie
     * @param spacesToMove
     * @return int[]
     */
    public static int[] removeDieIndex(Dice[] bothDie, int spacesToMove) {
        ArrayList<Integer> dieToRemove = new ArrayList<Integer>();
        boolean oneDie = false;
        for (int i = 0; i < bothDie.length; i++) {
            if (bothDie[i].getDots() == spacesToMove) {
                dieToRemove.add(i);
                oneDie = true;
                break;
            }
        }
        if (!oneDie) {
            if (bothDie.length == 2) {
                dieToRemove.add(0);
                dieToRemove.add(1);
            } else if (bothDie.length > 2) {
                for (int i = 0; i < spacesToMove / bothDie[0].getDots(); i++) {
                    dieToRemove.add(i);
                }
            }
        }

        int[] dieAsArray = new int[dieToRemove.size()];
        for (int i = 0; i < dieToRemove.size(); i++) {
            dieAsArray[i] = dieToRemove.get(i);
        }

        return dieAsArray;
    }

    /**
     * @param bothDie
     * @param indicesToRemove
     * @return Dice[]
     */
    public static Dice[] removeDie(Dice[] bothDie, int[] indicesToRemove) {
        ArrayList<Dice> dieRemoved = new ArrayList<Dice>();

        for (int i = 0; i < bothDie.length; i++) {
            dieRemoved.add(bothDie[i]);
        }
        for (int i : indicesToRemove) {
            bothDie[i].setDots(7);
        }

        if (bothDie.length <= 2) {
            if (indicesToRemove.length == 1) {
                dieRemoved.remove(indicesToRemove[0]);
            } else if (indicesToRemove.length == 2) {
                for (int i = 0; i < dieRemoved.size(); i++) {
                    if (bothDie[i].getDots() == 7) {
                        dieRemoved.remove(i);
                        break;
                    }
                }
                for (int i = 0; i < dieRemoved.size(); i++) {
                    if (bothDie[i].getDots() == 7) {
                        dieRemoved.remove(i);
                        break;
                    }
                }
            }
        } else if (bothDie.length >= 3) {
            for (int i = 0; i < indicesToRemove.length; i++) {
                dieRemoved.remove(0);
            }
        }

        Dice[] dieRemovedArray = new Dice[dieRemoved.size()];
        for (int i = 0; i < dieRemoved.size(); i++) {
            dieRemovedArray[i] = dieRemoved.get(i);
        }
        return dieRemovedArray;
    }

}
