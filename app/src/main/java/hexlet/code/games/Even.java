package hexlet.code.games;

import java.util.Random;
import hexlet.code.games.utils.GameUtils;

public final class Even implements GameInterface {
    private String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }

    public void play() {
        Random random = new Random();

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
            String even = isEven(randomNumber) ? "yes" : "no" ;

            GameUtils.askQuestion(randomNumber);
            GameUtils.prepareToAnswer();

            String answer = GameUtils.readString();

            if (GameUtils.isNotRightAnswer(answer, even, userName)) {
                break;
            }
            correctAnswers++;
        }

        if (correctAnswers == MAX_CORRECT_ANSWERS) {
            GameUtils.congratulations(userName);
        }
    }

    private boolean isEven(int num) {
        return (num % 2 == 0);
    }
}
