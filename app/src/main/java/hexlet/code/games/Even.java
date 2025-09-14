package hexlet.code.games;

import java.util.Random;

public final class Even implements GameInterface {
    private static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private String exercise;
    private String correctAnswer;

    public void startGame() {
        System.out.println(GAME_RULES);
    }

    public void prepareExercise(Random random) {
        int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
        exercise = Integer.toString(randomNumber);
        correctAnswer = isEven(randomNumber) ? "yes" : "no";
    }

    public String getExercise() {
        return exercise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}
