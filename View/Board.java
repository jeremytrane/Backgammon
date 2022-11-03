package View;

import Model.Dice;
import Model.Points;

public class Board {

    public Board() {

    }

    public static void Draw(Points[] allPoints, Dice[] bothDie) {
        int length = lengthToPrint(allPoints);
        System.out.println(" 1  2  3  4  5  6  7  8  9  10 11 12");
        System.out.println("-------------------------------------");

        for (int i = 0; i < length; i++) {
            String point1 = whatToPrint(allPoints[i], i);
            System.out.println("|                                    |");
            System.out.println("|                                    |");

        }
        System.out.println("-------------------------------------");
        System.out.println(" 24 23 22 21 20 19 18 17 16 15 14 13");
        
    }

    public static int lengthToPrint(Points[] allPoints) {
        int maxLength = 0;
        for (Points p: allPoints) {
            if (p.getHowManyCheckers() > maxLength) {
                maxLength = p.getHowManyCheckers();
            }
        }
        return maxLength;
    }

    public static String whatToPrint(Points point, int length) {
        if (point.getHowManyCheckers()>length&&) {
            return "\u001B[31mX\u001B[0m";
        } else if (point.getHowManyCheckers()>length&&) {
            return "\u001B[32mO\u001B[0m"; 
        } else 
        return "";
    }

    public static void Draw1(Points[] allPoints, Dice[] bothDie){

        System.out.println("||   1      2      3      4      5      6       7      8      9      10     11     12");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("||\\  "+allPoints[0].getHowManyCheckers()+" / \\  "+allPoints[1].getHowManyCheckers()+" / \\  "+allPoints[2].getHowManyCheckers()+" / \\  "+allPoints[3].getHowManyCheckers()+" / \\  "+allPoints[4].getHowManyCheckers()+" / \\  "+allPoints[5].getHowManyCheckers()+" /|||\\  "+allPoints[6].getHowManyCheckers()+" / \\  "+allPoints[7].getHowManyCheckers()+" / \\  "+allPoints[8].getHowManyCheckers()+" / \\  "+allPoints[9].getHowManyCheckers()+" / \\  "+allPoints[10].getHowManyCheckers()+" / \\  "+allPoints[11].getHowManyCheckers()+" /||");
        System.out.println("|| \\  /   \\  /   \\  /   \\  /   \\  /   \\  / ||| \\  /   \\  /   \\  /   \\  /   \\  /   \\  / ||");
        System.out.println("||  \\/     \\/     \\/     \\/     \\/     \\/  |||  \\/     \\/     \\/     \\/     \\/     \\/  ||");
        System.out.println("||                                         |||                                         ||   ["+bothDie[0].getDots() +"]");
        System.out.println("||                                         |||                                         ||   ["+bothDie[1].getDots() +"]");
        System.out.println("||  /\\     /\\     /\\     /\\     /\\     /\\  |||  /\\     /\\     /\\     /\\     /\\     /\\  ||");
        System.out.println("|| /  \\   /  \\   /  \\   /  \\   /  \\   /  \\ ||| /  \\   /  \\   /  \\   /  \\   /  \\   /  \\ ||");
        System.out.println("||/  "+allPoints[23].getHowManyCheckers()+" \\ /  "+allPoints[22].getHowManyCheckers()+" \\ /  "+allPoints[21].getHowManyCheckers()+" \\ /  "+allPoints[20].getHowManyCheckers()+" \\ /  "+allPoints[19].getHowManyCheckers()+" \\ /  "+allPoints[18].getHowManyCheckers()+" \\|||/  "+allPoints[17].getHowManyCheckers()+" \\ /  "+allPoints[16].getHowManyCheckers()+" \\ /  "+allPoints[15].getHowManyCheckers()+" \\ /  "+allPoints[14].getHowManyCheckers()+" \\ /  "+allPoints[13].getHowManyCheckers()+" \\ /  "+allPoints[12].getHowManyCheckers()+" \\||");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("||  24     23     22     21     20     19       18     17     16     15     14     13");
        
    }

}
