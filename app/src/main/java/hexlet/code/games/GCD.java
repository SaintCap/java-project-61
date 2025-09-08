package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class GCD implements GameInterface {
    public String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public void play() {
        int correctAnswers = 0;
        Random random = new Random();
        Scanner input = new Scanner(System.in);


        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int num1 = random.nextInt(MAX_RANDOM_VALUE);
            int num2 = random.nextInt(MAX_RANDOM_VALUE);

            int divisor = greatestDivisor(num1, num2);

            System.out.printf("Question: %d %d%n", num1, num2);
            System.out.println("Your answer:");

            int answer = input.nextInt();

            if (answer == divisor) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.%n", answer, divisor);
                System.out.printf("Let's try again, %s!%n", userName);
            }
        }
    }

    public int greatestDivisor(int num1, int num2) {
        int resDiv = Math.max(num1, num2);
        int numTemp1 = num1;
        int numTemp2 = num2;

        if (num1 == 0 || num2 == 0) {
            return resDiv;
        }

        while (numTemp2 != 0) {
            int temp = numTemp2;
            numTemp2 = numTemp1 % numTemp2;
            numTemp1 = temp;
        }

        return  numTemp1;

    }
}
