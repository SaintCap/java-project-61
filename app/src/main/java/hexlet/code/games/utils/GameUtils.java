package hexlet.code.games.utils;
import java.util.Scanner;

public final class GameUtils {
    public static final String PROMPT_INPUT = "Your answer: ";
    public static final String USER_CONGRATULATIONS_TEMPLATE = "Congratulations, %s!%n";

    public static void askQuestion(String exercise) {
        System.out.printf("Question: %s%n", exercise);
    }

    public static void prepareToAnswer() {
        System.out.print(PROMPT_INPUT);
    }

    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static boolean isNotRightAnswer(String userAnswer, String correctAnswer,
                                        String userName) {

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

    public static void congratulations(String userName) {
        System.out.printf(USER_CONGRATULATIONS_TEMPLATE, userName);
    }

}
