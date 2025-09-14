package hexlet.code.games;

import java.util.Random;
import hexlet.code.games.utils.Exercise;

public final class Calc implements GameInterface {
    private static final String GAME_RULES = "What is the result of the expression?";
    private static final char[] OPERATIONS = new char[]{'+', '-', '*'};

    public String getRules() {
        return GAME_RULES;
    }

    public Exercise createExercise(Random random) {
        char oper = randomOperation(random);
        int num1 = random.nextInt(MAX_RANDOM_VALUE);
        int num2 = random.nextInt(MAX_RANDOM_VALUE);
        int result = resultOfOperation(oper, num1, num2);
        String exercise = String.format("%d %c %d", num1, oper, num2);
        String correctAnswer = Integer.toString(result);
        return new Exercise(exercise, correctAnswer);
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
