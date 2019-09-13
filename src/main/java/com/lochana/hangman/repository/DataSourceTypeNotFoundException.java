package com.lochana.hangman.repository;

public class DataSourceTypeNotFoundException extends RuntimeException {
    public DataSourceTypeNotFoundException() {
        super("Data source type not found.");
    }
}
