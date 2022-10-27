package View;

import Model.Dice;
import Model.Points;

public class Board {

    public Board() {

    }

    public static void Draw(Points[] allPoints, Dice[] bothDie){

        System.out.println("||   1      2      3      4      5      6       7      8      9      10     11     12");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("||\u001B[31m\\    /\u001B[0m \\    / \u001B[31m\\    /\u001B[0m \\    / \u001B[31m\\    /\u001B[0m \\    /|||\u001B[31m\\    /\u001B[0m \\    / \u001B[31m\\    /\u001B[0m \\    / \u001B[31m\\    /\u001B[0m \\    /||");
        System.out.println("|| \u001B[31m\\  /\u001B[0m   \\  /   \u001B[31m\\  /\u001B[0m   \\  /   \u001B[31m\\  /\u001B[0m   \\  / ||| \u001B[31m\\  /\u001B[0m   \\  /   \u001B[31m\\  /\u001B[0m   \\  /   \u001B[31m\\  /\u001B[0m   \\  / ||");
        System.out.println("||  \u001B[31m\\/\u001B[0m     \\/     \u001B[31m\\/\u001B[0m     \\/     \u001B[31m\\/\u001B[0m     \\/  |||  \u001B[31m\\/\u001B[0m     \\/     \u001B[31m\\/\u001B[0m     \\/     \u001B[31m\\/\u001B[0m     \\/  ||");
        System.out.println("||\u001B[0m                                         |||                                         ||   ["+bothDie[0].getDots() +"]");
        System.out.println("||\u001B[0m                                         |||                                         ||   ["+bothDie[1].getDots() +"]");
        System.out.println("||  /\\     \u001B[31m/\\\u001B[0m     /\\     \u001B[31m/\\\u001B[0m     /\\     \u001B[31m/\\\u001B[0m  |||  /\\     \u001B[31m/\\\u001B[0m     /\\     \u001B[31m/\\\u001B[0m     /\\     \u001B[31m/\\\u001B[0m  ||");
        System.out.println("|| /  \\   \u001B[31m/  \\\u001B[0m   /  \\   \u001B[31m/  \\\u001B[0m   /  \\   \u001B[31m/  \\\u001B[0m ||| /  \\   \u001B[31m/  \\\u001B[0m   /  \\   \u001B[31m/  \\\u001B[0m   /  \\   \u001B[31m/  \\\u001B[0m ||");
        System.out.println("||/    \\ \u001B[31m/    \\\u001B[0m /    \\ \u001B[31m/    \\\u001B[0m /    \\ \u001B[31m/    \\\u001B[0m|||/    \\ \u001B[31m/    \\\u001B[0m /    \\ \u001B[31m/    \\\u001B[0m /    \\ \u001B[31m/    \\\u001B[0m||");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("||  24     23     22     21     20     19       18     17     16     15     14     13");
        
    }

}
