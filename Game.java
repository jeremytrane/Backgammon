
public class Game {

    public static void main(String[] args) { 
        Dice firstDice = new Dice();
        firstDice.rollDice(firstDice);
        System.out.println(firstDice.getDots());
    }

}
