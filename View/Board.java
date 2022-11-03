package View;

import Model.Colour;
import Model.Dice;
import Model.Points;
import java.util.Arrays;

public class Board {

    public Board() {

    }

    public static void Draw(Points[] allPoints, Dice[] bothDie) {
        int length1 = lengthToPrint1(allPoints);
        int length2 = lengthToPrint2(allPoints);
        System.out.println(" 1  2  3  4  5  6  7  8  9  10 11 12");
        System.out.println("-------------------------------------");

        for (int i = 0; i < length1; i++) {
            String point1 = whatToPrint(allPoints[i], i);
            String point2 = whatToPrint(allPoints[i], i);
            String point3 = whatToPrint(allPoints[i], i);
            String point4 = whatToPrint(allPoints[i], i);
            String point5 = whatToPrint(allPoints[i], i);
            String point6 = whatToPrint(allPoints[i], i);
            String point7 = whatToPrint(allPoints[i], i);
            String point8 = whatToPrint(allPoints[i], i);
            String point9 = whatToPrint(allPoints[i], i);
            String point10 = whatToPrint(allPoints[i], i);
            String point11 = whatToPrint(allPoints[i], i);
            String point12 = whatToPrint(allPoints[i], i);

            System.out.println("|" + point1 + point2 + point3 + point4 + point5 + point6 + point7 + point8 + point9 + point10 + point11 + point12 + "|");
        }

        System.out.println("|                                   |");

        for (int i = 0; i < length2; i++) {
            String point13 = whatToPrint(allPoints[i], i);
            String point14 = whatToPrint(allPoints[i], i);
            String point15 = whatToPrint(allPoints[i], i);
            String point16 = whatToPrint(allPoints[i], i);
            String point17 = whatToPrint(allPoints[i], i);
            String point18 = whatToPrint(allPoints[i], i);
            String point19 = whatToPrint(allPoints[i], i);
            String point20 = whatToPrint(allPoints[i], i);
            String point21 = whatToPrint(allPoints[i], i);
            String point22 = whatToPrint(allPoints[i], i);
            String point23 = whatToPrint(allPoints[i], i);
            String point24 = whatToPrint(allPoints[i], i);

            System.out.println("|" + point13 + point14 + point15 + point16 + point17 + point18 + point19 + point20 + point21 + point22 + point23 + point24 + "|");
             System.out.println("|                                    |");
        }

        System.out.println("-------------------------------------");
        System.out.println(" 24 23 22 21 20 19 18 17 16 15 14 13");
        
    }

    public static int lengthToPrint1(Points[] allPoints) {
        int maxLength1 = 0;
        Points[] firstHalf = Arrays.copyOfRange(allPoints, 0, allPoints.length/2);
        for (Points p: firstHalf) {
            if (p.getHowManyCheckers() > maxLength1) {
                maxLength1 = p.getHowManyCheckers();
            }
        }
        return maxLength1;
    }

    public static int lengthToPrint2(Points[] allPoints) {
        int maxLength2 = 0;
        Points[] secondHalf = Arrays.copyOfRange(allPoints, allPoints.length/2, allPoints.length);
        for (Points p: secondHalf) {
            if (p.getHowManyCheckers() > maxLength2) {
                maxLength2 = p.getHowManyCheckers();
            }
        }
        return maxLength2;
    }

    public static String whatToPrint(Points point, int length) {
        Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
        if (point.getHowManyCheckers()>=length && checkerColour==Colour.B) {
            return "\u001B[31mX \u001B[0m";
        } else if (point.getHowManyCheckers() >= length && checkerColour==Colour.W) {
            return "\u001B[32mO \u001B[0m"; 
        } else 
        return "  ";
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
