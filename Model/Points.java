package Model;

import java.util.ArrayList;

public class Points {

    protected ArrayList<Checkers> checkers = new ArrayList<Checkers>();
    int howManyCheckers;
    int pointNumber;

    public Points(Colour colour, int howManyCheckers, int pointNumber) {
        this.howManyCheckers = howManyCheckers;
        this.pointNumber = pointNumber;
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

    public int getPointNumber() {
        return pointNumber;
    }

}
