package hexlet.code;

public interface GameInterface {
    int MAX_CORRECT_ANSWERS = 3;
    int MAX_RANDOM_VALUE = 100;

    void setUserName(String userName);
    void startGame();
    void play();
}
