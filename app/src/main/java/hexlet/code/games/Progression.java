package hexlet.code.games;

import java.util.Random;
import java.util.Scanner;

public class Progression implements GameInterface {
    public static final int MAX_SIZE_PROGRESSION = 10;
    public String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("What number is missing in the progression?");
    }

    public void play() {
        int correctAnswers = 0;
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        while (correctAnswers < MAX_CORRECT_ANSWERS) {

            int[] progression = randomProgression(random);
            int randomMissing = random.nextInt(MAX_SIZE_PROGRESSION);
            int missValue = progression[randomMissing];

            String question = progressionAsStringWithMissVal(progression, randomMissing);
            System.out.printf("Question: %s%n", question);
            System.out.println("Your answer:");

            int answer = input.nextInt();

            if (answer == missValue) {
                System.out.println("Correct!");
                correctAnswers++;
            } else {
                System.out.printf("'%d' is wrong answer ;(. Correct answer was '%d'.%n", answer, missValue);
                System.out.printf("Let's try again, %s!%n", userName);
            }
        }
    }

    public int[] randomProgression(Random random) {

        int[] progression = new int[MAX_SIZE_PROGRESSION];
        int startProgression = random.nextInt(MAX_RANDOM_VALUE);
        int step = random.nextInt(MAX_RANDOM_VALUE);

        for (int i = 0; i < MAX_SIZE_PROGRESSION; i++) {
            progression[i] = currentElementOfProgression(startProgression, i, step);
        }

        return  progression;
    }

    private int currentElementOfProgression(int start, int index, int step) {
        return start + (index * step);
    }

    private String progressionAsStringWithMissVal(int[] progression, int missIndex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < progression.length; i++) {
            sb.append(" ");
            if (i != missIndex) {
                sb.append(progression[i]);
            } else {
                sb.append("..");
            }
        }

        return sb.toString();
    }
}
