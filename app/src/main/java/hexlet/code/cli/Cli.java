package hexlet.code.cli;

import hexlet.code.core.GameManager;

import java.util.Scanner;

public final class Cli {
    private static final int START_GAMES_NUMBER = 2;
    private final GameManager games;
    private String userName;

    public Cli() {
        games = new GameManager();
        userName = "Unknown";
    }

    /**
     * Method shows options to the user.
     */
    public void menu() {

        String[] namesOfGames = games.getNamesOfAllGames();
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        showAllGames(namesOfGames);
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");

    }

    /**
     * Returns the user's selection from available menu options.
     * Validates the input to ensure it's within the valid range of choices.
     *
     * @return the validated user selection as integer
     */
    public int userSelection() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            choice = input.nextInt();
            if (choice < 0 || choice > (games.numberOfGames() + START_GAMES_NUMBER)) {
                System.out.println("There is no such option! Please try again.");
            }
        } while (choice < 0 || choice > (games.numberOfGames() + START_GAMES_NUMBER));

        return choice;
    }

    /**
     * Method handles user selection.
     *
     * @param choice the user's input choice to validate
     */
    public void processUserSelection(int choice) {
        if (choice == 0) {
            return;
        }

        greeting();

        if (choice == 1) {
            return;
        }

        int indexOfGame = choice - START_GAMES_NUMBER;
        games.playGame(userName, indexOfGame);

    }

    /**
     * Method greeting with user.
     */
    private void greeting() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String name = input.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("You have not entered a name");
            return;
        }
        this.userName = name;
        System.out.printf("Hello, %s!%n", name);
    }

    /**
     * Method shows names of games with counting
     * which starts from the starting value START_GAMES_NUMBER.
     */
    private void showAllGames(String[] namesOfGames) {
        int count = START_GAMES_NUMBER;
        for (String name : namesOfGames) {
            System.out.printf("%d - %s%n", count, name);
            count++;
        }
    }
}
