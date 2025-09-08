package hexlet.code;

public class App {
    public static void main(String[] args) {
        Cli cli = new Cli();

        cli.menu();
        int choice = cli.userSelection();
        cli.processUserSelection(choice);

    }
}
