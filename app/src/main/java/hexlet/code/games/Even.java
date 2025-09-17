package hexlet.code.games;

import hexlet.code.games.utils.Exercise;

import java.util.Random;

public final class Even implements GameInterface {
    private static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final String GAME_NAME  = "Even";

    public String getName() {
        return GAME_NAME;
    }

    public String getRules() {
        return GAME_RULES;
    }

    public Exercise createExercise(Random random) {
        int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
        String exercise = Integer.toString(randomNumber);
        String correctAnswer = isEven(randomNumber) ? "yes" : "no";
        return new Exercise(exercise, correctAnswer);
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}
