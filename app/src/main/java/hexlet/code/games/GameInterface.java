package hexlet.code.games;

import java.util.Random;
import hexlet.code.games.utils.GameUtils;

public interface GameInterface {
    int MAX_CORRECT_ANSWERS = 3;
    int MAX_RANDOM_VALUE = 100;

    void startGame();
    void prepareExercise(Random random);
    String getExercise();
    String getCorrectAnswer();

    default void play(String userName) {
        Random random = new Random();

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            prepareExercise(random);
            String exercise = getExercise();
            GameUtils.askQuestion(exercise);
            GameUtils.prepareToAnswer();
            String answer = GameUtils.readString();
            String correctAnswer = getCorrectAnswer();
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
