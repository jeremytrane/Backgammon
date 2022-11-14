package View;

import Model.Checkers;
import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import java.util.Arrays;

public class Board {

    public static void Draw(Points[] allPoints, Dice[] bothDie, Player player_1, Player player_2) {
        int lengthTop = lengthToPrintTop(allPoints);
        int lengthBottom = lengthToPrintBottom(allPoints);
        Checkers bar = new Checkers(null);
        Player whatPlayer = whatPlayerTurn(player_1, player_2);
        pipDisplayTop(whatPlayer, allPoints);
        System.out.println("\n 12 11 10 9  8  7  |6  5  4  3  2  1      It's your turn " + whatPlayer);
        System.out.println("-------------------|-------------------   [" + bothDie[0].getDots() + "] ["
                + bothDie[1].getDots() + "]");

        for (int i = 0; i < lengthTop; i++) {
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

            System.out.print("|" + point12 + point11 + point10 + point9 + point8 + point7 + "|" + point6 + point5 + point4
                    + point3 + point2 + point1 + "|\n");
        }
        String barToPrint = whatIsBar(bar);
        System.out.println("-------------------" + barToPrint + "-------------------");

        for (int i = lengthBottom; i > -1; i--) {
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

            System.out.print("|" + point13 + point14 + point15 + point16 + point17 + point18 + "|" + point19 + point20
                    + point21 + point22 + point23 + point24 + "|\n");

        }
        System.out.println("-------------------|-------------------");
        System.out.println("13 14 15 16 17 18  |19 20 21 22 23 24");
        pipDisplayBottom(whatPlayer, allPoints);

    }

    private static void pipDisplayBottom(Player whatPlayer, Points[] allPoints) {
        System.out.print(" ");
        for (int i = 12; i < 24; i++) {
            if (i == 18){
                System.out.print(" ");
            }
            if (whatPlayer.getColour()==Colour.W) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                    System.out.print(allPoints[i].getHowManyCheckers() + "  ");
                } else {
                    System.out.print("   ");
                }
            } else if (whatPlayer.getColour()==Colour.B) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                    System.out.print(allPoints[i].getHowManyCheckers() + "  ");
                } else {
                    System.out.print("   ");
                } 
            }
        }
    }

    private static void pipDisplayTop(Player whatPlayer, Points[] allPoints) {
        System.out.print(" ");
        for (int i = 11; i > -1; i--) {
            if (i == 7){
                System.out.print(" ");
            }
            if (whatPlayer.getColour()==Colour.W) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                    System.out.print(allPoints[i].getHowManyCheckers() + "  ");
                } else {
                    System.out.print("   ");
                }
            } else if (whatPlayer.getColour()==Colour.B) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                    System.out.print(allPoints[i].getHowManyCheckers() + "  ");
                } else {
                    System.out.print("   ");
                } 
            }
        }
    }

    public static String whatIsBar(Checkers bar) {
        if (bar.getCheckerColour() == Colour.B)
            return "\u001B[31mX\u001B[0m";
        else if (bar.getCheckerColour() == Colour.W) {
            return "\u001B[37mX\u001B[0m";
        } else
            return "O";
    }

    public static int lengthToPrintTop(Points[] allPoints) {
        int maxLengthTop = 0;
        Points[] firstHalf = Arrays.copyOfRange(allPoints, 0, allPoints.length / 2);
        for (Points p : firstHalf) {
            if (p.getHowManyCheckers() > maxLengthTop) {
                maxLengthTop = p.getHowManyCheckers();
            }
        }
        return maxLengthTop;
    }

    public static int lengthToPrintBottom(Points[] allPoints) {
        int maxLengthBottom = 0;
        Points[] secondHalf = Arrays.copyOfRange(allPoints, allPoints.length / 2, allPoints.length);
        for (Points p : secondHalf) {
            if (p.getHowManyCheckers() > maxLengthBottom) {
                maxLengthBottom = p.getHowManyCheckers();
            }
        }
        return maxLengthBottom;
    }

    public static String whatToPrint1(Points point, int length) {
        if (point.getHowManyCheckers() > 0) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers() > length && checkerColour == Colour.B) {
                return "\u001B[31mX  \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour == Colour.W) {
                return "\u001B[37mX  \u001B[0m";
            } else
                return "   ";
        }
        return "   ";
    }

    public static String whatToPrint2(Points point, int length) {
        if (point.getHowManyCheckers() > 0) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers() > length && checkerColour == Colour.B) {
                return "\u001B[31mX  \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour == Colour.W) {
                return "\u001B[37mX  \u001B[0m";
            } else
                return "   ";
        }
        return "   ";
    }

    public static Player whatPlayerTurn(Player player_1, Player player_2) {
        if (player_1.getTurnToken() == 1) {
            return player_1;
        } else
            return player_2;
    }

}
