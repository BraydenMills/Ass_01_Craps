import java.util.Random;
import java.util.Scanner;

public class CrapsGame {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner input = new Scanner(System.in);
        String playAgain;

        do {
            System.out.println("\n--- Craps Game ---");
            int die1 = rnd.nextInt(6) + 1;
            int die2 = rnd.nextInt(6) + 1;
            int sum = die1 + die2;
            System.out.println("Die 1: " + die1 + " | Die 2: " + die2 + " | Sum: " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You crapped out and lost.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You won!");
            } else {
                int point = sum;
                System.out.println("The point is now " + point + ".");
                boolean gameOver = false;
                while (!gameOver) {
                    die1 = rnd.nextInt(6) + 1;
                    die2 = rnd.nextInt(6) + 1;
                    sum = die1 + die2;
                    System.out.println("Die 1: " + die1 + " | Die 2: " + die2 + " | Sum: " + sum);
                    if (sum == point) {
                        System.out.println("Made the point! You won!");
                        gameOver = true;
                    } else if (sum == 7) {
                        System.out.println("Got a seven! You lost.");
                        gameOver = true;
                    } else {
                        System.out.println("Trying for point " + point + "...");
                    }
                }
            }

            System.out.print("Play again? (Y/N): ");
            playAgain = input.nextLine().trim();
        } while (playAgain.equalsIgnoreCase("Y"));

        System.out.println("Thanks for playing!");
        input.close();
    }
}
