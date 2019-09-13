package com.lochana.hangman.UI;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CmdUserInputsOutputs implements UserInputsOutputs
{
    public char readUserInput()
    {
        Scanner input = new Scanner(System.in);
        System.err.println("Enter a guess: ");
        return input.next().charAt(0);
    }

    final static Logger logger = Logger.getLogger(CmdUserInputsOutputs.class.getName());

    @Override
    public void welcomeMsg() {
        logger.info("Welcome to Hangman..!");
    }

    @Override
    public void showIncompleteWord(char[] arr) {
        for(int i=0; i <arr.length;i++){
            if(arr[i]== 0){
                arr[i] = '*';
            }
        }
        logger.info("Guess the word: " + String.valueOf(arr));
    }

    @Override
    public void showLevel(int level) {
        logger.info("Current Level: " + level);
    }

    @Override
    public void showAttempts(int attempts) {
        logger.info(attempts + " remaining...");
    }

    @Override
    public void showWinMsg() {
        logger.info("You WIN.!");
    }

    @Override
    public void showGameOver() {
        logger.info("Game Over");
    }

    @Override
    public void showNextLevel() {
        logger.info("Go to next level..");
    }

    @Override
    public void showFailedAttemptMsg(int attempts)
    {
        logger.info("Your Guess is incorrect!");
        showAttempts(attempts);
    }
}
