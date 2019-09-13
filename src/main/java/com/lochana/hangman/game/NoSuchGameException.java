package com.lochana.hangman.game;

public class NoSuchGameException extends RuntimeException {
    public NoSuchGameException() {
        super( "No such game..!");
    }
}
