package Model;

public class Player {
    private String name;
    private int checkerCount;
    private Colour colour;
    private int turnToken = -1;

    public Player(String n1, int checkers) {
        name = n1;
        checkerCount = checkers;
    }

    
    /** 
     * @return int
     */
    public int getTurnToken() {
        return turnToken;
    }

    
    /** 
     * @param turnToken
     */
    public void setTurnToken(int turnToken) {
        this.turnToken = turnToken;
    }

    
    /** 
     * @return int
     */
    public int getCheckerCount() {
        return checkerCount;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @param checkerCount
     */
    public void setCheckerCount(int checkerCount) {
        this.checkerCount = checkerCount;
    }

    
    /** 
     * @return Colour
     */
    public Colour getColour() {
        return colour;
    }

    
    /** 
     * @param colour
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    
    /** 
     * @param turn
     */
    public void setTurn(int turn) {
        turnToken = turn;
    }

    
    /** 
     * @return int
     */
    public int getTurn() {
        return turnToken;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return this.name;
    }
}
