package hexlet.code.games;

import java.util.Random;

public final class Prime implements GameInterface {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int DIVISOR = 3;
    public String exercise;
    public String correctAnswer;

    public void startGame() {
        System.out.println(GAME_RULES);
    }

    public String getExercise() {
        return exercise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void prepareExercise(Random random) {
        int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
        exercise = Integer.toString(randomNumber);
        correctAnswer = isPrime(randomNumber) ? "yes" : "no";
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
