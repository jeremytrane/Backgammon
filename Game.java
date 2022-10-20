import java.util.Scanner;

public class Game {
    public static void main(String[] args) { 
        Scanner in = new Scanner(System.in);
        String player1;
        String player2;

        System.out.println("Please enter name of player 1:");
        player1 = in.nextLine();
        System.out.println("Please enter name of player 2");
        player2 = in.nextLine();

        Player players = new Player(player1,player2);

        Dice firstDice = new Dice();
        firstDice.rollDice(firstDice);
        System.out.println(firstDice.getDots());

        in.close();
    }

}
