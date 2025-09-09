package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Prime implements GameInterface{
    public String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public void play() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
            String prime = isPrime(randomNumber) ? "yes" : "no" ;

            System.out.printf("Question: %d%n", randomNumber);
            System.out.println("Your answer: ");

            String answer = input.nextLine().trim();

            if (answer.equals(prime)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s%n", answer, prime);
                System.out.printf("Let's try again, %s%n!", userName);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) { return false; }
        if (num == 2) { return true; }
        if (num % 2 == 0) { return false; }

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
