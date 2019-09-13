package com.lochana.hangman.game;

public class GameFactory {

    private GameFactory() {
    }

    public static Game play(GameType type){


        if(type == GameType.WORDGAME){
            return new WordGame();
        }
        else{
            throw new NoSuchGameException();
        }

    }
}
