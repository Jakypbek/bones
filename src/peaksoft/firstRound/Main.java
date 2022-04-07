package peaksoft.firstRound;

import peaksoft.dice;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);;

        System.out.println("---   Start game   ---");
        System.out.println(" ");
        System.out.print("Predict amount of points (2..12): ");
        rollTheDice(scanner.nextInt());







    }
    public static void printDice(int a) {
        if (a == 1) {
            dice.one();
        } else if (a == 2) {
            dice.two();
        } else if (a == 3) {
            dice.three();
        } else if (a == 4) {
            dice.four();
        } else if (a == 5) {
            dice.five();
        } else if (a == 6) {
            dice.six();
        }
    }
    public static void rollTheDice(int input) {
        Random random = new Random();

        if (input < 2 || input > 12) {
            throw new RuntimeException("You can predict number < 12 and > 2");
        }

        System.out.println("User rolls the dices...");

        int a = random.nextInt(1, 7);
        int b = random.nextInt(1, 7);
        int c = a + b;
        int result = c - Math.abs(c - input) * 2;

        printDice(a);
        printDice(b);

        System.out.println("On the dice fell " + c + " points.");
        System.out.println("Result is " + c + " - abs(" + c + " - " + input + ") * 2: " + result + " points");
        if (result > 0) {
            System.out.println("User wins!");
        } else {
            System.out.println("User lose(");
        }
    }
}
