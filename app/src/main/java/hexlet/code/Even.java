package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even implements GameInterface {
    public String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public void play() {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
            String even = isEven(randomNumber) ? "yes" : "no" ;

            System.out.printf("Question: %d%n", randomNumber);
            System.out.println("Your answer: ");

            String answer = input.nextLine().trim();

            if (answer.equals(even)) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("%s is wrong answer ;(. Correct answer was %s%n", answer, even);
                System.out.printf("Let's try again, %s%n!", userName);
            }
        }

        System.out.printf("Congratulations, %s!%n", userName);
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}
