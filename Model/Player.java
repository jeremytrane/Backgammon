package Model;

public class Player {
    private String name1;
    private int checkerCount;

    public Player(String n1, int checkers){ 
        name1 = n1;
        checkerCount = checkers;
    }

    public String getPlayerName(){
        return name1;
    } 
    public int getCheckerCount(){
        return checkerCount;
    }

}
