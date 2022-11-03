package Model;

public class Player {
    private String name;
    private int checkerCount;
    private Colour colour;
    private int turnToken = -1;

    public Player(String n1, int checkers){ 
        name = n1;
        checkerCount = checkers;
    }

    public int getTurnToken() {
        return turnToken;
    }

    public void setTurnToken(int turnToken) {
        this.turnToken = turnToken;
    }

    public int getCheckerCount(){
        return checkerCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckerCount(int checkerCount) {
        this.checkerCount = checkerCount;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }    

    public void setTurn(int turn){
        turnToken = turn;
    }

    public int getTurn(){
        return turnToken;
    }

    public String toString(){
        return this.name;
    }
}
