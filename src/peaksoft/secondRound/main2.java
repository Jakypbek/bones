package peaksoft.secondRound;

import peaksoft.dice;

import java.util.Random;
import java.util.Scanner;

public class main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        System.out.println();
        int q = random.nextInt(2, 13);
        System.out.println("Computer predicted " + q + " points.");
        System.out.println("Computer rolls the dices...");

        int d = random.nextInt(1, 7);
        int e = random.nextInt(1, 7);
        int f = d + e;
        int resultOfComputer = f - Math.abs(f - input) * 2;

        printDice(d);
        printDice(e);

        System.out.println("On the dice fell " + f + " points.");
        System.out.println("Result is " + f + " - abs(" + f + " - " + q + ") * 2: " + resultOfComputer + " points");

        System.out.println();

        if (result > resultOfComputer) {
            int someInt = result - resultOfComputer;
            System.out.println("User win " + someInt + " more.");
            System.out.println("Congratulations");
        } else if (result == resultOfComputer)  {
            System.out.println("It is draw");
        } else {
            System.out.println("User lose(");
        }
    }
}