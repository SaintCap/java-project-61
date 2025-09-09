package hexlet.code.games;

import hexlet.code.games.utils.GameUtils;

import java.util.Random;

public final class Progression implements GameInterface {
    private static final int MAX_SIZE_PROGRESSION = 10;
    private String userName;

    public void setUserName(String name) {
        userName = name;
    }

    public void startGame() {
        System.out.println("What number is missing in the progression?");
    }

    public void play() {
        int correctAnswers = 0;
        Random random = new Random();

        while (correctAnswers < MAX_CORRECT_ANSWERS) {

            int[] progression = randomProgression(random);
            int randomMissing = random.nextInt(MAX_SIZE_PROGRESSION);
            int missValue = progression[randomMissing];

            String progressionStr = progressionAsStringWithMissVal(progression, randomMissing);
            GameUtils.askQuestion(progressionStr);
            GameUtils.prepareToAnswer();

            int answer = GameUtils.readInt();

            if (GameUtils.isNotRightAnswer(answer, missValue, userName)) {
                break;
            }
            correctAnswers++;
        }

        if (correctAnswers == MAX_CORRECT_ANSWERS) {
            GameUtils.congratulations(userName);
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

        return sb.toString().trim();
    }
}
