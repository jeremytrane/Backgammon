package Model;
import java.util.Stack;

public class Points {

    protected Stack<Checkers> checkers = new Stack<Checkers>();

    public Points(Stack<Checkers> checkers) {
        this.checkers = checkers;
    }

    public void popChecker() {
        this.checkers.pop();
    }

    public void addChecker(Checkers checker) {
        this.checkers.add(checker);
    }
    
}
