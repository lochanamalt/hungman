package com.lochana.hangman.repository;
import com.lochana.hangman.word.Word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextDataSource implements DataSource{

    private String textsource;

    public TextDataSource(String path)  {
        textsource = path;
    }

    @Override
    public List<String> readLines() throws IOException {
        List<String> lines;
        lines = Files.readAllLines(Paths.
                get(textsource));

        return lines;
    }
}
