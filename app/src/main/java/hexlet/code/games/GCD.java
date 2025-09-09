package hexlet.code.games;

import hexlet.code.games.utils.GameUtils;

import java.util.Random;

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

        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int num1 = random.nextInt(MAX_RANDOM_VALUE);
            int num2 = random.nextInt(MAX_RANDOM_VALUE);

            int divisor = greatestDivisor(num1, num2);

            GameUtils.askQuestion(num1, num2);
            GameUtils.prepareToAnswer();

            int answer = GameUtils.readInt();

            correctAnswers = GameUtils.checkAnswer(answer, divisor, userName, correctAnswers);
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
