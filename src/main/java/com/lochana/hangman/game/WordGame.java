package com.lochana.hangman.game;

import com.lochana.hangman.UI.*;
import com.lochana.hangman.repository.DataSource;
import com.lochana.hangman.repository.DataSourceFactory;
import com.lochana.hangman.repository.DataSourceType;
import com.lochana.hangman.word.Word;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WordGame implements Game {
    private int numberOfLevels = 5;
    private boolean isLevelSuccessful=false,gameWon= false;
    UserInputsOutputs gameInputOutputs = UIInputOutputFactory.UserInterface(UIType.CLI);
    @Override
    public void run() {
        DataSource datasource = DataSourceFactory.create(DataSourceType.TEXT,"C:\\Users\\INSIGHT\\Documents\\NetBeansProjects\\assignment\\src\\test\\java\\com\\assignment\\assignment\\test.txt");

        Logger logger = Logger.getAnonymousLogger();
        try
        {
            List<String> lines = datasource.readLines();

            gameInputOutputs.welcomeMsg();
            for (int i = 0; i < numberOfLevels; i++)
            {

                Random rand = SecureRandom.getInstanceStrong();
                int attemptsPerLevel = rand.nextInt(10);
                Word word = new Word(lines.get(i),attemptsPerLevel);
                isLevelSuccessful = this.runLevel(word, i + 1);
                if (!isLevelSuccessful)
                {
                    gameInputOutputs.showGameOver();
                    break;
                }else{
                    gameInputOutputs.showNextLevel();
                }
            }

            if (gameWon)
            {
                gameInputOutputs.showWinMsg();
            }

        } catch (IOException e)
        {
            logger.log(Level.SEVERE,"File on the path not found");

        } catch (NoSuchAlgorithmException e) {
            logger.log(Level.SEVERE,"No such algorithm");
        }


    }

    private boolean runLevel(Word word, int currentLevel)
    {

        gameInputOutputs.showLevel(currentLevel);
        gameInputOutputs.showAttempts(word.getRemainingAttempts());
        gameInputOutputs.showIncompleteWord(word.get());

        while (word.getRemainingAttempts() > 0 && !word.isWordGuessed())
        {
            char userInput = gameInputOutputs.readUserInput();
            if (word.fill(userInput))
            {
                gameInputOutputs.showAttempts(word.getRemainingAttempts());
                gameInputOutputs.showIncompleteWord(word.get());
            } else
            {
                gameInputOutputs.showFailedAttemptMsg(word.getRemainingAttempts());
            }

            gameInputOutputs.showIncompleteWord(word.get());

        }
        return word.isWordGuessed();
    }

}

