package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

import hexlet.code.games.utils.Exercise;

public interface GameInterface {
    int MAX_CORRECT_ANSWERS = 3;
    int MAX_RANDOM_VALUE = 100;
    String PROMPT_INPUT = "Your answer: ";
    String USER_CONGRATULATIONS_TEMPLATE = "Congratulations, %s!%n";

    String getName();
    String getRules();
    Exercise createExercise(Random random);
    default void play(String userName) {
        String rules = getRules();
        System.out.println(rules);

        Random random = new Random();

        int correctAnswers = 0;
        while (correctAnswers < MAX_CORRECT_ANSWERS) {
            Exercise exercise = createExercise(random);
            String correctAnswer = exercise.correctAnswer();

            System.out.printf("Question: %s%n", exercise.exercise());
            System.out.print(PROMPT_INPUT);
            String answer = readString();

            if (isNotRightAnswer(answer, correctAnswer, userName)) {
                break;
            }
            correctAnswers++;
        }
        if (correctAnswers == MAX_CORRECT_ANSWERS) {
            System.out.printf(USER_CONGRATULATIONS_TEMPLATE, userName);
        }
    }

    private boolean isNotRightAnswer(String userAnswer, String correctAnswer, String userName) {

        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return false;
        } else {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'%n",
                    userAnswer, correctAnswer);
            System.out.printf("Let's try again, %s!%n", userName);
            return true;
        }
    }

    private static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
}
