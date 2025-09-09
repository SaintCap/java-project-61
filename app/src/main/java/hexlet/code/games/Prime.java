package hexlet.code.games;

import hexlet.code.games.utils.GameUtils;

import java.util.Random;

public final class Prime implements GameInterface{
    private String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public void play() {
        Random random = new Random();

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            int randomNumber = random.nextInt(MAX_RANDOM_VALUE);
            String prime = isPrime(randomNumber) ? "yes" : "no" ;

            GameUtils.askQuestion(randomNumber);
            GameUtils.prepareToAnswer();

            String answer = GameUtils.readString();

            if (GameUtils.isNotRightAnswer(answer, prime, userName)) {
                break;
            }
            correctAnswers++;
        }

        if (correctAnswers == MAX_CORRECT_ANSWERS) {
            GameUtils.congratulations(userName);
        }
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

        for (int i = 3; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;

    }
}
