package Model;
import java.util.Stack;

public class Points {

    protected Stack<Checkers> checkers = new Stack<Checkers>();

    public Points(Colour colour, int howManyCheckers) {
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

    public Colour getLowestCheckerColour(Checkers checker) {
        return checker.getCheckerColour();
    }
    
}
