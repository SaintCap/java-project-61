package hexlet.code.games;

import java.util.Random;

public final class Calc implements GameInterface {
    public static final String GAME_RULES = "What is the result of the expression?";
    public static final char[] OPERATIONS = new char[]{'+', '-', '*'};
    public String exercise;
    public String correctAnswer;

    public void startGame() {
        System.out.println(GAME_RULES);
    }

    public void prepareExercise(Random random) {
        char oper = randomOperation(random);
        int num1 = random.nextInt(MAX_RANDOM_VALUE);
        int num2 = random.nextInt(MAX_RANDOM_VALUE);
        int result = resultOfOperation(oper, num1, num2);
        exercise = String.format("%d %c %d",num1, oper, num2);
        correctAnswer = Integer.toString(result);
    }

    public String getExercise() {
        return exercise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    private char randomOperation(Random random) {
        int randNum = random.nextInt(OPERATIONS.length);
        return OPERATIONS[randNum];
    }

    private int resultOfOperation(char oper, int num1, int num2) throws IllegalArgumentException {
        return switch (oper) {
            case ('+') -> num1 + num2;
            case ('-') -> num1 - num2;
            case ('*') -> num1 * num2;
            default -> throw new IllegalArgumentException("Недопустимая операция: " + oper);
        };
    }
}
