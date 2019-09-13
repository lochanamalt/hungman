package com.lochana.hangman.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class NumberDataSource implements DataSource {

    public NumberDataSource(String path) {
    }

    @Override
    public List readLines() throws IOException {
        return null;
    }
}
