import java.util.Random;
import java.util.Scanner;

class RockPaperScissor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = {"Rock", "Paper", "Scissor"};

        while (true) {
            System.out.println("Enter the number of rounds you want to play: ");
            int totalRounds;
            try {
                totalRounds = sc.nextInt();
                if (totalRounds <= 0) {
                    System.out.println("Please enter a positive number.");
                    continue;
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.next();
                continue;
            }

            int userWins = 0;
            int computerWins = 0;
            int ties = 0;

            for (int round = 1; round <= totalRounds; round++) {
                System.out.println("\nRound " + round + ": Enter your choice:\n1. Rock\n2. Paper\n3. Scissor\n0. Exit");
                int uChoice;
                try {
                    uChoice = sc.nextInt();

                    if (uChoice == 0) {
                        System.out.println("\nThank you for playing!");
                        displayFinalScores(userWins, computerWins, ties);
                        return;
                    }

                    if (uChoice < 1 || uChoice > 3) {
                        System.out.println("\nInvalid choice! Please enter 1, 2, or 3.");
                        round--; 
                        continue;
                    }

                    String userChoice = choices[uChoice - 1];
                    String computerChoice = choices[rand.nextInt(choices.length)];

                    System.out.println("\nYou chose: " + userChoice);
                    System.out.println("Computer is making a choice...");
                    Thread.sleep(1000); 
                    System.out.println("Computer chose: " + computerChoice);

                    if (userChoice.equals(computerChoice)) {
                        System.out.println("It's a tie!");
                        ties++;
                    } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissor")) ||
                               (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                               (userChoice.equals("Scissor") && computerChoice.equals("Paper"))) {
                        System.out.println("You won this round!");
                        userWins++;
                    } else {
                        System.out.println("Computer won this round!");
                        computerWins++;
                    }

                    System.out.println("\nCurrent Scores:");
                    System.out.println("You: " + userWins);
                    System.out.println("Computer: " + computerWins);
                    System.out.println("Ties: " + ties);
                } catch (Exception e) {
                    System.out.println("\nInvalid input! Please enter a number 1, 2, or 3.");
                    sc.next();
                    round--;
                }
            }

            System.out.println("\nGame Over! Here are the final scores:");
            displayFinalScores(userWins, computerWins, ties);

            System.out.println("\nWould you like to play again? (yes/no)");
            String playAgain = sc.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        sc.close();
    }

    private static void displayFinalScores(int userWins, int computerWins, int ties) {
        System.out.println("Final Scores:");
        System.out.println("You won: " + userWins + " times");
        System.out.println("Computer won: " + computerWins + " times");
        System.out.println("Ties: " + ties);

        if (userWins > computerWins) {
            System.out.println("\nCongratulations! You are the overall winner!");
        } else if (computerWins > userWins) {
            System.out.println("\nComputer is the overall winner. Better luck next time!");
        } else {
            System.out.println("\nIt's a tie overall!");
        }
    }
}
