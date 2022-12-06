package View;

import Model.Colour;
import Model.Dice;
import Model.Player;
import Model.Points;
import java.util.Arrays;

public class Board {

    
    /** 
     * @param allPoints
     * @param bothDie
     * @param player_1
     * @param player_2
     * @param player1Wins
     * @param player2Wins
     * @param gameLength
     */
    public static void Draw(Points[] allPoints, Dice[] bothDie, Player player_1, Player player_2, int player1Wins, int player2Wins, int gameLength) {
        int lengthTop = lengthToPrintTop(allPoints);
        int lengthBottom = lengthToPrintBottom(allPoints);
        Player whatPlayer = whatPlayerTurn(player_1, player_2);
        pipDisplayTop(whatPlayer, allPoints);
        System.out.println("\n 12    11    10    9     8     7     \u001B[32m|   |\u001B[0m6     5     4     3     2     1      \u001B[31mRED\u001B[0m        ");
        System.out.println("\u001B[32m=====================================|===|=========================================\u001B[0m     Score (in games): " + player_1 + ": " + player1Wins + " " + player_2 + ": " + player2Wins + " (First to " + gameLength + "!)");

        for (int i = 0; i < lengthTop; i++) {
            String point1 = whatToPrintTop(allPoints[0], i);
            String point2 = whatToPrintTop(allPoints[1], i);
            String point3 = whatToPrintTop(allPoints[2], i);
            String point4 = whatToPrintTop(allPoints[3], i);
            String point5 = whatToPrintTop(allPoints[4], i);
            String point6 = whatToPrintTop(allPoints[5], i);
            String point7 = whatToPrintTop(allPoints[6], i);
            String point8 = whatToPrintTop(allPoints[7], i);
            String point9 = whatToPrintTop(allPoints[8], i);
            String point10 = whatToPrintTop(allPoints[9], i);
            String point11 = whatToPrintTop(allPoints[10], i);
            String point12 = whatToPrintTop(allPoints[11], i);
            String whiteStackOdd = whatIsBar(allPoints[27] ,i);
            String point24 = whatIsBar(allPoints[24], i);

            System.out.print("\u001B[32m|\u001B[0m" + point12 + point11 + point10 + point9 + point8 + point7 + "\u001B[32m|" + point24 + "|\u001B[0m" + point6 + point5 + point4
                    + point3 + point2 + point1 + "\u001B[32m|" + whiteStackOdd + "\u001B[32m|\u001B[0m\n");
        }
        System.out.println("\u001B[32m=====================================|BAR|=========================================\u001B[0m");

        for (int i = lengthBottom; i > -1; i--) {
            String point13 = whatToPrintBottom(allPoints[12], i);
            String point14 = whatToPrintBottom(allPoints[13], i);
            String point15 = whatToPrintBottom(allPoints[14], i);
            String point16 = whatToPrintBottom(allPoints[15], i);
            String point17 = whatToPrintBottom(allPoints[16], i);
            String point18 = whatToPrintBottom(allPoints[17], i);
            String point19 = whatToPrintBottom(allPoints[18], i);
            String point20 = whatToPrintBottom(allPoints[19], i);
            String point21 = whatToPrintBottom(allPoints[20], i);
            String point22 = whatToPrintBottom(allPoints[21], i);
            String point23 = whatToPrintBottom(allPoints[22], i);
            String point24 = whatToPrintBottom(allPoints[23], i);
            String point25 = whatIsBar(allPoints[25], i);
            String blackStackOdd = whatIsBar(allPoints[26] ,i);


            System.out.print("\u001B[32m|\u001B[0m" + point13 + point14 + point15 + point16 + point17 + point18 + "\u001B[32m|" + point25 + "|\u001B[0m" + point19 + point20
                    + point21 + point22 + point23 + point24 + "\u001B[32m|"+ blackStackOdd +"\u001B[32m|\u001B[0m\n");

        }
        System.out.println("\u001B[32m=====================================|===|=========================================\u001B[0m");
        System.out.println("13    14    15    16    17    18     \u001B[32m|   |\u001B[0m19    20    21    22    23    24    WHITE");
        pipDisplayBottom(whatPlayer, allPoints);
        System.out.print("\nIt's your turn " + whatPlayer + "\n");
        System.out.print("Dice roll: ");
        for(int i=0;i<bothDie.length;i++){
            System.out.print(bothDie[i].getDots() + " ");
        }
        System.out.print("\n");
    }

    
    /** 
     * @param whatPlayer
     * @param allPoints
     */
    private static void pipDisplayBottom(Player whatPlayer, Points[] allPoints) {
        for (int i = 12; i < 24; i++) {
            if (i == 18){
                System.out.print("      ");
            }
            if (whatPlayer.getColour()==Colour.W) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                    pipCount(allPoints[i]);
                } else {
                    System.out.print("      ");
                }
            } else if (whatPlayer.getColour()==Colour.B) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                    pipCount(allPoints[i]);
                } else {
                    System.out.print("      ");
                } 
            }
        }
    }

    
    /** 
     * @param whatPlayer
     * @param allPoints
     */
    private static void pipDisplayTop(Player whatPlayer, Points[] allPoints) {
        System.out.print(" ");
        for (int i = 11; i > -1; i--) {
            if (i == 5){
                System.out.print("     ");
            }
            if (whatPlayer.getColour()==Colour.W) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.W) {
                    pipCount(allPoints[i]);
                } else {
                    System.out.print("      ");
                }
            } else if (whatPlayer.getColour()==Colour.B) {
                if (allPoints[i].getLength()>0 && allPoints[i].getCheckerColour(allPoints[i].getCheckerIndex(0))==Colour.B) {
                    pipCount(allPoints[i]);
                } else {
                    System.out.print("      ");
                } 
            }
        }
    }

    
    /** 
     * @param currentPoint
     */
    public static void pipCount(Points currentPoint) {
        if (currentPoint.getLength() > 0 && currentPoint.getCheckerColour(currentPoint.getCheckerIndex(0))==Colour.W) {
            if (currentPoint.getPointNumber()*currentPoint.getHowManyCheckers() > 100) {
                System.out.print((25-currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "   ");
            } else if (currentPoint.getPointNumber()*currentPoint.getHowManyCheckers() < 100 && currentPoint.getPointNumber()*currentPoint.getHowManyCheckers() > 9) {
                System.out.print((25-currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "    ");
            }  else {
            System.out.print((25-currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "     ");
            }   
        } else if (currentPoint.getLength() > 0 && currentPoint.getCheckerColour(currentPoint.getCheckerIndex(0))==Colour.B) {
            if ((currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() > 100) {
                System.out.print("\u001B[31m" + (currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "   \u001B[0m");
            } else if ((currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() < 100 && (25-currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() > 9) {
                System.out.print("\u001B[31m" + (currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "    \u001B[0m");
            }  else {
            System.out.print("\u001B[31m" + (currentPoint.getPointNumber())*currentPoint.getHowManyCheckers() + "     \u001B[0m");
            }
        }
    } 

    
    /** 
     * @param allPoints
     * @return int
     */
    public static int lengthToPrintTop(Points[] allPoints) {
        int maxLengthTop = 0;
        Points[] firstHalf = Arrays.copyOfRange(allPoints, 0, allPoints.length / 2);
        for (Points p : firstHalf) {
            if (p.getHowManyCheckers() > maxLengthTop) {
                maxLengthTop = p.getHowManyCheckers();
            }
        }
        if (allPoints[24].getLength() > maxLengthTop) {
            maxLengthTop = allPoints[24].getLength();
        }
        if (allPoints[26].getLength() > maxLengthTop) {
            maxLengthTop = allPoints[26].getLength();
        }
        return maxLengthTop;
    }

    
    /** 
     * @param allPoints
     * @return int
     */
    public static int lengthToPrintBottom(Points[] allPoints) {
        int maxLengthBottom = 0;
        Points[] secondHalf = Arrays.copyOfRange(allPoints, allPoints.length / 2, allPoints.length);
        for (Points p : secondHalf) {
            if (p.getHowManyCheckers() > maxLengthBottom) {
                maxLengthBottom = p.getHowManyCheckers();
            }
        }
        if (allPoints[25].getLength() > maxLengthBottom) {
            maxLengthBottom = allPoints[25].getLength();
        }
        if (allPoints[27].getLength() > maxLengthBottom) {
            maxLengthBottom = allPoints[27].getLength();
        }
        return maxLengthBottom;
    }

    
    /** 
     * @param point
     * @param length
     * @return String
     */
    public static String whatIsBar(Points point, int length) {
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

    
    /** 
     * @param point
     * @param length
     * @return String
     */
    public static String whatToPrintTop(Points point, int length) {
        if (point.getHowManyCheckers() > 0) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers() > length && checkerColour == Colour.B) {
                return "\u001B[31mX     \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour == Colour.W) {
                return "\u001B[37mX     \u001B[0m";
            } else
                return "      ";
        }
        return "      ";
    }

    
    /** 
     * @param point
     * @param length
     * @return String
     */
    public static String whatToPrintBottom(Points point, int length) {
        if (point.getHowManyCheckers() > 0) {
            Colour checkerColour = point.getCheckerColour(point.getCheckerIndex(0));
            if (point.getHowManyCheckers() > length && checkerColour == Colour.B) {
                return "\u001B[31mX     \u001B[0m";
            } else if (point.getHowManyCheckers() > length && checkerColour == Colour.W) {
                return "\u001B[37mX     \u001B[0m";
            } else
                return "      ";
        }
        return "      ";
    }

    
    /** 
     * @param player_1
     * @param player_2
     * @return Player
     */
    public static Player whatPlayerTurn(Player player_1, Player player_2) {
        if (player_1.getTurnToken() == 1) {
            return player_1;
        } else
            return player_2;
    }

}
