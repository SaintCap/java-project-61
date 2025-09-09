package hexlet.code.games.utils;
import java.util.Scanner;

public class GameUtils {
    public static final String PROMPT_INPUT = "Your answer: ";
    public static final String USER_CONGRATULATIONS_TEMPLATE = "Congratulations, %s!%n";

    public static void askQuestion(int num) {
        System.out.printf("Question: %d%n", num);
    }

    public static void askQuestion(int num1, int num2, char ch) {
        System.out.printf("Question: %d %c %d%n", num1, ch, num2);
    }

    public static void askQuestion(int num1, int num2) {
        System.out.printf("Question: %d %d%n", num1, num2);
    }

    public static void askQuestion(String str) {
        System.out.printf("Question: %s%n", str);
    }

    public static void prepareToAnswer() {
        System.out.print(PROMPT_INPUT);
    }

    public static String readString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
            }
        }
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

    public static boolean isNotRightAnswer(int userAnswer, int correctAnswer,
                                  String userName) {

        if (userAnswer == correctAnswer) {
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
