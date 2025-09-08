package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Calc implements GameInterface {
    public String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("What is the result of the expression?");
    }

    public void play() {
        int correctAnswers = 0;
        char[] operations = allOperations();
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            char oper = randomOperation(operations, random);
            int num1 = random.nextInt(MAX_RANDOM_VALUE);
            int num2 = random.nextInt(MAX_RANDOM_VALUE);
            int result = resultOfOperation(oper, num1, num2);

            System.out.printf("Question: %d %c %d%n", num1, oper, num2);
            System.out.println("Your answer:");

            int answer = input.nextInt();

            if (answer == result) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.%n", answer, result);
                System.out.printf("Let's try again, %s!%n", userName);
            }
        }

        System.out.printf("Congratulations, %s!%n", userName);

    }

    private char[] allOperations() {
        return new char[]{'+','-','*'};
    }

    private char randomOperation(char[] operations, Random random) {
        int randNum = random.nextInt(operations.length);
        return operations[randNum];
    }

    private int resultOfOperation(char oper, int num1, int num2) {
        int result = 0;
        if (oper == '+') {
            result = num1 + num2;
        } else if (oper == '-') {
            result = num1 - num2;
        } else if (oper == '*') {
            result = num1 * num2;
        }
        return result;
    }
}
