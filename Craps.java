import java.util.Scanner;
import java.util.Random;
public class Craps
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // initial roll
        Random rnd = new Random();
        int dice1;
        int dice2;
        int diceSum;
        dice1 = rnd.nextInt(6) + 1;
        dice2 = rnd.nextInt(6) + 1;
        diceSum = dice1 + dice2;
        boolean playing = false;
        Scanner console = new Scanner(System.in);
        do{


            if (diceSum == 2 || diceSum == 3 || diceSum == 12)
            {
                System.out.println("Dice 1 roll is: " + dice1 + " || Dice 2 roll is: " + dice2);
                System.out.println("Immediate loss with craps: " + diceSum);
                playing = SafeInput.getYNConfirm(console, "Do you want to play again?");
                break;
            }
            else if (diceSum == 7 || diceSum == 11)
            {
                System.out.println("Dice 1 roll is: " + dice1 + " || Dice 2 roll is: " + dice2);
                System.out.println("Immediate win with natural: " + diceSum);
                playing = SafeInput.getYNConfirm(console, "Do you want to play again?");
                break;
            }
            else
            {
                int point = diceSum; // point: 4, 5, 6, 8, 9, or 10
                System.out.println("Point: " + point);
                while (true) // keep rolling
                {
                    dice1 = rnd.nextInt(6) + 1;
                    dice2 = rnd.nextInt(6) + 1;
                    diceSum = dice1 + dice2;
                    System.out.println("Dice 1 roll is: " + dice1 + " || Dice 2 roll is: " + dice2);
                    System.out.println("\nNew roll: " + diceSum);
                    System.out.println("Point is: " + diceSum);
                    if (diceSum == point) {
                        System.out.println("Made point, won");
                        playing = SafeInput.getYNConfirm(console, "Do you want to play again?");
                        break;  // break out of loop, a win
                    }
                    if (diceSum == 7) {
                        System.out.println("Lost with 7");
                        playing = SafeInput.getYNConfirm(console, "Do you want to play again?");
                        break;  // break out of loop, a loss
                    }
                    else System.out.println("No win, Re-Rolling");
                }
            }
        }while (playing);

    }
}