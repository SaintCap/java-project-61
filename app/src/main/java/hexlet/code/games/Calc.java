package hexlet.code.games;

import hexlet.code.games.utils.GameUtils;

import java.util.Random;

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

        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            char oper = randomOperation(operations, random);
            int num1 = random.nextInt(MAX_RANDOM_VALUE);
            int num2 = random.nextInt(MAX_RANDOM_VALUE);
            int result = resultOfOperation(oper, num1, num2);

            GameUtils.askQuestion(num1, num2, oper);
            GameUtils.prepareToAnswer();

            int answer = GameUtils.readInt();

            correctAnswers = GameUtils.checkAnswer(answer, result, userName, correctAnswers);
        }

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
