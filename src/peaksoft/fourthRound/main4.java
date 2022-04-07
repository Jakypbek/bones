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
            if (i == 0) {
                user.setPrecent(2);
            } else if (i == 2) {
                user.setPrecent(4);
            } else if (i == 4) {
                user.setPrecent(6);
            }

            if (i == 1) {
                if (random.nextInt(5) == 0) {
                    computer.setCheating(true);
                    computer.setPrecent(2);
                }
            } else if (i == 3 || i == 5) {
                computer.setPrecent(4);

                if (user.getTotalPoints() - computer.getTotalPoints() < 5) {
                    if (random.nextInt(5) == 0) {
                        computer.setCheating(true);
                    }
                } else if (user.getTotalPoints() - computer.getTotalPoints() < 15) {
                    int m = random.nextInt(5);
                    if (m == 0 || m == 1) {
                        computer.setCheating(true);
                    }
                } else {
                    int n = random.nextInt(5);
                    if (n == 0 || n == 1 || n == 2) {
                        computer.setCheating(true);
                    }
                }
            }

            if (i == 5) {
                computer.setPrecent(6);
            }

            if (i % 2 == 0) {
                System.out.print("Predict amount of points (2..12): ");
                user.setPrediction(scanner.nextInt());
                System.out.print("Do you want to cheat? (Y/N): ");
                user.setCheating(scanner.next());


                rollTheDice(user);

                notes.add(user.getPrediction());
                notes.add(user.getDicePoints());
                notes.add(user.getResult());
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

        int resultForUser = notes.get(2) + notes.get(8) + notes.get(14) - user.getPenalty();
        int resultForComputer = notes.get(5) + notes.get(11) + notes.get(17) - computer.getPenalty();

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
                Penalty|             %d|                   %d
                ------+----------------+---------------------
                Total | Points:      %d| Points:           %d
                
                """,notes.get(0),notes.get(3),notes.get(1),
                notes.get(4),notes.get(2),notes.get(5),
                notes.get(6),notes.get(9),notes.get(7),
                notes.get(10),notes.get(8),notes.get(11),
                notes.get(12),notes.get(15),notes.get(13),
                notes.get(16),notes.get(14),notes.get(17),
                user.getPenalty(), computer.getPenalty(),
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

            if (gamer.isCheating() && random.nextInt(gamer.getPrecent()) == 0) {
                gamer.setLuckyCheating(true);
                System.out.println(gamer.getName() + " successfully cheated.");
            } else if (gamer.isCheating()) {
                gamer.setPenalty(10);
            }

            System.out.println(gamer.getName() + " rolls the dices...");

            int a = random.nextInt(1, 7);
            int b = random.nextInt(1, 7);

            if (gamer.isLuckyCheating()) {
                a = gamer.getPrediction() - 1;
                b = 1;
            }

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
