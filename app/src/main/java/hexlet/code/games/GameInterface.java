package hexlet.code.games;

import java.util.Random;
import hexlet.code.games.utils.GameUtils;
import hexlet.code.games.utils.Exercise;

public interface GameInterface {
    int MAX_CORRECT_ANSWERS = 3;
    int MAX_RANDOM_VALUE = 100;

    String getRules();
    Exercise createExercise(Random random);
    default void startGame() {
        String rules = getRules();
        System.out.println(rules);
    }

    default void play(String userName) {
        Random random = new Random();

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            Exercise exercise = createExercise(random);
            String correctAnswer = exercise.correctAnswer();
            GameUtils.askQuestion(exercise.exercise());
            GameUtils.prepareToAnswer();
            String answer = GameUtils.readString();
            if (GameUtils.isNotRightAnswer(answer, correctAnswer, userName)) {
                break;
            }
            correctAnswers++;
        }
        if (correctAnswers == MAX_CORRECT_ANSWERS) {
            GameUtils.congratulations(userName);
        }
    }
}
