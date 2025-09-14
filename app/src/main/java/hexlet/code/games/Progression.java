package hexlet.code.games;

import java.util.Random;

public final class Progression implements GameInterface {
    private static final String GAME_RULES = "What number is missing in the progression?";
    private static final int MAX_SIZE_PROGRESSION = 10;
    private String exercise;
    private String correctAnswer;

    public void startGame() {
        System.out.println(GAME_RULES);
    }

    public void prepareExercise(Random random) {
        int[] progression = randomProgression(random);
        int randomMissing = random.nextInt(MAX_SIZE_PROGRESSION);
        int missValue = progression[randomMissing];
        exercise = progressionAsStringWithMissVal(progression, randomMissing);
        correctAnswer = Integer.toString(missValue);
    }

    public String getExercise() {
        return exercise;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
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

        return sb.toString().trim();
    }
}
