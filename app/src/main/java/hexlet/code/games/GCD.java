package hexlet.code.games;

import java.util.Random;

public final class GCD implements GameInterface {
    private static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    private String exercise;
    private String correctAnswer;

    public void startGame() {
        System.out.println(GAME_RULES);
    }

    public void prepareExercise(Random random) {
        int num1 = random.nextInt(MAX_RANDOM_VALUE);
        int num2 = random.nextInt(MAX_RANDOM_VALUE);
        int divisor = greatestDivisor(num1, num2);
        exercise = String.format("%d %d", num1, num2);
        correctAnswer = Integer.toString(divisor);
    }

    public String getExercise() {
        return exercise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
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
