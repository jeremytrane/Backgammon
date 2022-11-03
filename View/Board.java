package View;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import java.util.Arrays;

public class Board {

    public static void Draw(Points[] allPoints, Dice[] bothDie, Player player_1, Player player_2) {
        int length1 = lengthToPrint1(allPoints);
        int length2 = lengthToPrint2(allPoints);
        Player whatPlayer = whatPlayerTurn(player_1, player_2);
        System.out.println("\n 1  2  3  4  5  6  |7  8  9  10 11 12     It's your turn " + whatPlayer);
        System.out.println("-------------------|-------------------   [" + bothDie[0].getDots() + "] [" + bothDie[1].getDots() + "]");

        for (int i = 0; i < length1; i++) {
            String point1 = whatToPrint1(allPoints[0], i);
            String point2 = whatToPrint1(allPoints[1], i);
            String point3 = whatToPrint1(allPoints[2], i);
            String point4 = whatToPrint1(allPoints[3], i);
            String point5 = whatToPrint1(allPoints[4], i);
            String point6 = whatToPrint1(allPoints[5], i);
            String point7 = whatToPrint1(allPoints[6], i);
            String point8 = whatToPrint1(allPoints[7], i);
            String point9 = whatToPrint1(allPoints[8], i);
            String point10 = whatToPrint1(allPoints[9], i);
            String point11 = whatToPrint1(allPoints[10], i);
            String point12 = whatToPrint1(allPoints[11], i);

            System.out.print("|" + point1 + point2 + point3 + point4 + point5 + point6 + "|" + point7 + point8 + point9 + point10 + point11 + point12 + "|\n");
        }

        System.out.println("-------------------X-------------------");

        for (int i = 0; i < length2; i++) {
            String point13 = whatToPrint2(allPoints[12], i);
            String point14 = whatToPrint2(allPoints[13], i);
            String point15 = whatToPrint2(allPoints[14], i);
            String point16 = whatToPrint2(allPoints[15], i);
            String point17 = whatToPrint2(allPoints[16], i);
            String point18 = whatToPrint2(allPoints[17], i);
            String point19 = whatToPrint2(allPoints[18], i);
            String point20 = whatToPrint2(allPoints[19], i);
            String point21 = whatToPrint2(allPoints[20], i);
            String point22 = whatToPrint2(allPoints[21], i);
            String point23 = whatToPrint2(allPoints[22], i);
            String point24 = whatToPrint2(allPoints[23], i);

            System.out.print("|" + point24 + point23 + point22 + point21 + point20 + point19 + "|" + point18 + point17 + point16 + point15 + point14 + point13 + "|\n");
        }

        System.out.println("-------------------|-------------------");
        System.out.println("24 23 22 21 20 19  |18 17 16 15 14 13");
        
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

    public static String whatToPrint1(Points point, int length) {
        if (point.getHowManyCheckers()>0 ) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers()>length && checkerColour==Colour.B) {
                return "\u001B[31mX  \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour==Colour.W) {
                return "\u001B[37mX  \u001B[0m"; 
            } else 
            return "   ";
        }
        return "   ";
    }

    public static String whatToPrint2(Points point, int length) {
        if (point.getHowManyCheckers()>0) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers()>length && checkerColour==Colour.B) {
                return "\u001B[31mX  \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour==Colour.W) {
                return "\u001B[37mX  \u001B[0m";
            } else 
            return "   ";
        }
        return "   ";
    }

    public static Player whatPlayerTurn (Player player_1, Player player_2) {
        if (player_1.getTurnToken()==1) {
        return player_1;
        } else 
    return player_2;
    }

}
