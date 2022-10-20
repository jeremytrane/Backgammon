import java.util.Stack;

public class Point {

    protected Stack<Checkers> checkers = new Stack<Checkers>();

    public Point(Stack<Checkers> checkers) {
        this.checkers = checkers;
    }

    public void popChecker() {
        this.checkers.pop();
    }

    public void addChecker(Checkers checker) {
        this.checkers.add(checker);
    }
    
}
