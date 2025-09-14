package hexlet.code.games;

import hexlet.code.games.utils.Exercise;

import java.util.Random;

public final class Prime implements GameInterface {
    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int DIVISOR = 3;

    public String getRules() {
        return GAME_RULES;
    }

    public Exercise createExercise(Random random) {
        int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
        String exercise = Integer.toString(randomNumber);
        String correctAnswer = isPrime(randomNumber) ? "yes" : "no";
        return new Exercise(exercise, correctAnswer);
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        if (num % 2 == 0) {
            return false;
        }

        for (int i = DIVISOR; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
