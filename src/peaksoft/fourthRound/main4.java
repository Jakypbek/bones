package peaksoft.fourthRound;

import peaksoft.dice;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class main4 {

    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Random random = new Random();

            Gamer user = new User();
            Gamer computer = new Computer();

            List<Integer> notes = new ArrayList<>();

            System.out.println("---   Start game   ---");
            System.out.println(" ");


            for (int i = 0; i < 6; i++) {
                if (i == 2 || i == 4) {
                    currentScore(user, computer);
                }

                if (i % 2 == 0) {
                    System.out.print("Predict amount of points (2..12): ");
                    user.setPrediction(scanner.nextInt());
                    if (!user.isCheated()) {
                        System.out.print("Do you want to cheat?(Y/N): ");
                        String answer = scanner.nextLine();
                        if (answer.equals("N")) {

                            rollTheDice(user);

                            notes.add(user.getPrediction());
                            notes.add(user.getDicePoints());
                            notes.add(user.getResult());
                        } else if (answer.equals("Y")) {
                            int a = random.nextInt(2);
                            if (a == 1) {
                                System.out.println("User successfully cheated.");
                                hackedRollTheDice(user);
                            }
                        }
                    }
                } else {
                    int a = random.nextInt(2, 13);
                    computer.setPrediction(a);
                    System.out.println("Computer predicted " + a + " points.");
                    rollTheDice(computer);

                    notes.add(computer.getPrediction());
                    notes.add(computer.getDicePoints());
                    notes.add(computer.getResult());
                }
            }

            int resultForUser = notes.get(2) + notes.get(8) + notes.get(14);
            int resultForComputer = notes.get(5) + notes.get(11) + notes.get(17);

            System.out.printf("""
                ---------------- Finish game ----------------
                Round |           User |            Computer
                ------+----------------+---------------------
                      | Predicted:   %d| Predicted:        %d
                - 1 - | Dice:        %d| Dice:             %d
                      | Result:      %d| Result:           %d
                ------+----------------+---------------------
                      | Predicted:   %d| Predicted:        %d
                - 2 - | Dice:        %d| Dice:             %d
                      | Result:      %d| Result:           %d
                ------+----------------+---------------------
                      | Predicted:   %d| Predicted:        %d
                - 3 - | Dice:        %d| Dice:             %d
                      | Result:      %d| Result:           %d
                ------+----------------+---------------------
                Total | Points:      %d| Points:           %d
                
                """,notes.get(0),notes.get(3),notes.get(1),
                    notes.get(4),notes.get(2),notes.get(5),
                    notes.get(6),notes.get(9),notes.get(7),
                    notes.get(10),notes.get(8),notes.get(11),
                    notes.get(12),notes.get(15),notes.get(13),
                    notes.get(16),notes.get(14),notes.get(17),
                    resultForUser, resultForComputer
            );

            if (resultForUser > resultForComputer) {
                int i = resultForUser - resultForComputer;
                System.out.println("User win " + i + " points more. Congratulations!");
            } else if (resultForUser == resultForComputer) {
                System.out.println("It is draw");
            } else {
                System.out.println("User lose(");
            }

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

        public static void rollTheDice(Gamer gamer) {
            Random random = new Random();

            System.out.println(gamer.getName() + " rolls the dices...");

            int a = random.nextInt(1, 7);
            int b = random.nextInt(1, 7);
            int c = a + b;
            int result = c - Math.abs(c - gamer.getPrediction()) * 2;

            printDice(a);
            printDice(b);

            System.out.println("On the dice fell " + c + " points.");
            System.out.println("Result is " + c + " - abs(" + c + " - " + gamer.getPrediction() + ") * 2: " + result + " points");
            System.out.println();

            gamer.setDicePoints(c);
            gamer.setResult(result);
            gamer.setTotalPoints(result);
        }

        public static void hackedRollTheDice(Gamer gamer) {
            Random random = new Random();

            System.out.println(gamer.getName() + " rolls the dices...");

            int a = gamer.getPrediction();
            int b = 0;
            int c = a + b;
            int result = c - Math.abs(c - gamer.getPrediction()) * 2;

            if (gamer.getPrediction() > 3) {
                a --;
                b = 1;
            } else {
                a ++;
                b = -1;
            }

            printDice(a);
            printDice(b);

            System.out.println("On the dice fell " + c + " points.");
            System.out.println("Result is " + c + " - abs(" + c + " - " + gamer.getPrediction() + ") * 2: " + result + " points");
            System.out.println();

            gamer.setDicePoints(c);
            gamer.setResult(result);
            gamer.setTotalPoints(result);
    }

        public static void currentScore(Gamer user, Gamer computer) {
            System.out.println("------- Current score -------");
            System.out.println("User: " + user.getTotalPoints());
            System.out.println("Computer: " + computer.getTotalPoints());
            System.out.println();

            int a = user.getTotalPoints() - computer.getTotalPoints();
            int b = computer.getTotalPoints() - user.getTotalPoints();

            if (a < b) {
                System.out.println("Computer is ahead by " + b + " points!");
                System.out.println("---------------------------------------");
                System.out.println();
            } else if (a == 0) {
                System.out.println("It is draw");
                System.out.println("---------------------------------------");
                System.out.println();
            } else
                System.out.println("User is ahead by " + a + " points!");
            System.out.println("--------------------------------");
            System.out.println();
        }

}
