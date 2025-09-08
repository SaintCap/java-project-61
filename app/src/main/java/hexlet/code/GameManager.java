package hexlet.code;

import hexlet.code.games.*;

import java.util.*;

public class GameManager {
    private final Map<String, GameInterface> games = new LinkedHashMap<>();

    GameManager() {
        addGame("Even", new Even());
        addGame("Calc", new Calc());
        addGame("GCD", new GCD());
    }

    public int numberOfGames() {
        return games.size();
    }

    private void addGame(String name, GameInterface game) {
        games.put(name, game);
    }

    private GameInterface getGame (int indexOfGame) {
        List<String> gameNamesList = new ArrayList<>(games.keySet());
        String key = gameNamesList.get(indexOfGame);

        return games.get(key);
    }

    public void showAllGames(int startNumber) {
        List<String> gameNamesList = new ArrayList<>(games.keySet());
        for (int i = 0; i < gameNamesList.size(); i++) {
            int num = startNumber + i;
            System.out.printf("%d - %s%n", num, gameNamesList.get(i));
        }
    }

    public void playGame(String userName, int indexOfGame) {
        GameInterface game = getGame(indexOfGame);
        game.setUserName(userName);
        game.startGame();
        game.play();
    }
}
