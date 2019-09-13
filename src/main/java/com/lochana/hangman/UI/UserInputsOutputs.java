package com.lochana.hangman.UI;

public interface UserInputsOutputs
{
    char readUserInput();
    void welcomeMsg();
    void showIncompleteWord(char[] word);
    void showLevel(int level);
    void showFailedAttemptMsg(int attempts);
    void showAttempts(int attempts);
    void showWinMsg();
    void showGameOver();
    void showNextLevel();
}
