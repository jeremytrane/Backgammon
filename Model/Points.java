package Model;
import java.util.Stack;

public class Points {

    protected Stack<Checkers> checkers = new Stack<Checkers>();
    int howManyCheckers;

    public Points(Colour colour, int howManyCheckers) {
        this.howManyCheckers = howManyCheckers;
        Stack<Checkers> checkers = new Stack<Checkers>();
        for (int i = 0; i < howManyCheckers; i++) {
            Checkers e = new Checkers(colour);
            checkers.add(e);
        }
    }

    public void popChecker() {
        this.checkers.pop();
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
