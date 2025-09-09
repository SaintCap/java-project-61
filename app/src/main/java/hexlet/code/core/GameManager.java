package hexlet.code.core;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import hexlet.code.games.GameInterface;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

public final class GameManager {
    private final Map<String, GameInterface> games = new LinkedHashMap<>();

    public GameManager() {
        addGame("Even", new Even());
        addGame("Calc", new Calc());
        addGame("GCD", new GCD());
        addGame("Progression", new Progression());
        addGame("Prime", new Prime());
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
