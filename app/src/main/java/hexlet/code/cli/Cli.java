package hexlet.code.cli;

import hexlet.code.core.GameManager;

import java.util.Scanner;

public final class Cli {
    private final int startGamesNumber;
    private final GameManager games;
    private String userName;

    public Cli() {
        games = new GameManager();
        userName = "Unknown";
        startGamesNumber = 2;
    }

    /**
     * Method shows options to the user
     */
    public void menu() {

        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        games.showAllGames(startGamesNumber);
        System.out.println("0 - Exit");
        System.out.println("Your choice: ");

    }

    /**
     * Method returns the user's selection
     */
    public int userSelection() {
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice < 0 || choice > (games.numberOfGames() + startGamesNumber)) {
            System.out.println("There is no such option!");
            return userSelection();
        }
        return choice;
    }

    /**
     * Method handles user selection
     */
    public void processUserSelection(int choice) {
        if (choice == 0) {
            return;
        }

        greeting();

        if (choice == 1) {
            return;
        }

        int indexOfGame = choice - startGamesNumber;
        games.playGame(userName, indexOfGame);

    }

    /**
     * Method greeting with user
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
}
