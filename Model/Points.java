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

    public void moveChecker(Points pointToMoveFrom, Points pointToMoveTo, Points whiteBar, Points blackBar) {
        boolean bothNotEmpty = false;
        if(pointToMoveFrom.howManyCheckers>0 && pointToMoveTo.howManyCheckers>0){
            bothNotEmpty = true;
        }

        pointToMoveFrom.howManyCheckers -= 1;
        pointToMoveTo.howManyCheckers += 1;

        if(bothNotEmpty){
            if((pointToMoveFrom.getCheckerIndex(0).getCheckerColour() != pointToMoveTo.getCheckerIndex(0).getCheckerColour())){
                if(pointToMoveTo.getCheckerIndex(0).getCheckerColour() == Colour.B){
                    pointToMoveTo.howManyCheckers -= 1;
                    blackBar.howManyCheckers += 1;
                    blackBar.checkers.add(pointToMoveTo.getCheckerIndex(0));
                    pointToMoveTo.checkers.remove(pointToMoveTo.getCheckerIndex(0));
                }
                else if(pointToMoveTo.getCheckerIndex(0).getCheckerColour() == Colour.W){
                    pointToMoveTo.howManyCheckers -= 1;
                    whiteBar.howManyCheckers += 1;
                    whiteBar.checkers.add(pointToMoveTo.getCheckerIndex(0));
                    pointToMoveTo.checkers.remove(pointToMoveTo.getCheckerIndex(0));
                }
            }
        }
        
        pointToMoveTo.checkers.add(pointToMoveFrom.getCheckerIndex(0));
        pointToMoveFrom.checkers.remove(pointToMoveFrom.getCheckerIndex(0));   
    }

}
