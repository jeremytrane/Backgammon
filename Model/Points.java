package Model;

import java.util.ArrayList;

public class Points {

    protected ArrayList<Checkers> checkers = new ArrayList<Checkers>();
    int howManyCheckers;

    public Points(Colour colour, int howManyCheckers) {
        this.howManyCheckers = howManyCheckers;
        checkers = new ArrayList<Checkers>();
        for (int i = 0; i < howManyCheckers; i++) {
            checkers.add(new Checkers(colour));
        }
    }

    public int getLength() {
        return checkers.size();
    }

    public void addChecker(Checkers checker) {
        this.checkers.add(checker);
    }

    public Colour getCheckerColour(Checkers checker) {
        return checker.getCheckerColour();
    }

    public int getHowManyCheckers() {
        return howManyCheckers;
    }

    public Checkers getCheckerIndex(int i) {
        return checkers.get(i);
    }
    
}
