import java.util.Scanner;

public class Game {
    public static void main(String[] args) { 

        Scanner in = new Scanner(System.in);
        String name1, name2;
        final int INITIAL_CHECKERS=15;

        System.out.println("Please enter name of player 1:");
        name1 = in.nextLine();
        System.out.println("Please enter name of player 2");
        name2 = in.nextLine();

        Player player_1 = new Player(name1,INITIAL_CHECKERS);
        Player player_2 = new Player(name2,INITIAL_CHECKERS);


        in.close();
    }

}
