package hexlet.code.games;

import hexlet.code.games.utils.Exercise;

import java.util.Random;

public final class GCD implements GameInterface {
    private static final String GAME_RULES = "Find the greatest common divisor of given numbers.";

    public String getRules() {
        return GAME_RULES;
    }

    public Exercise createExercise(Random random) {
        int num1 = random.nextInt(MAX_RANDOM_VALUE);
        int num2 = random.nextInt(MAX_RANDOM_VALUE);
        int divisor = greatestDivisor(num1, num2);
        String exercise = String.format("%d %d", num1, num2);
        String correctAnswer = Integer.toString(divisor);
        return new Exercise(exercise, correctAnswer);
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
