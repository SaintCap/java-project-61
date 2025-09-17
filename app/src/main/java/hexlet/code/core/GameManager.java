package hexlet.code.core;

import hexlet.code.games.Even;
import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;
import hexlet.code.games.Prime;
import hexlet.code.games.GameInterface;

import java.util.ArrayList;
import java.util.List;

public final class GameManager {
    private final List<GameInterface> games = new ArrayList<>();

    public GameManager() {
        addGame(new Even());
        addGame(new Calc());
        addGame(new GCD());
        addGame(new Progression());
        addGame(new Prime());
    }

    public int numberOfGames() {
        return games.size();
    }

    private void addGame(GameInterface game) {
        games.add(game);
    }

    private GameInterface getGame(int indexOfGame) {
        return games.get(indexOfGame);
    }

    public List<GameInterface> getGames() {
        return games;
    }

    public void playGame(String userName, int indexOfGame) {
        GameInterface game = getGame(indexOfGame);
        game.play(userName);
    }
}
