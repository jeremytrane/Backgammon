package Model;
import java.util.Stack;

public class Points {

    protected Stack<Checkers> checkers = new Stack<Checkers>();

    public Points(Colour colour, int howManyCheckers) {
        Stack<Checkers> checkers;
        for (int i = 0; i < howManyCheckers; i++) {
            checkers.add(colour);
        }
    }

    public void popChecker() {
        this.checkers.pop();
    }

    public void addChecker(Checkers checker) {
        this.checkers.add(checker);
    }
    
}
