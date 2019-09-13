package com.lochana.hangman.repository;
import com.lochana.hangman.word.Word;

import java.io.IOException;
import java.util.List;

public interface DataSource<T> {
    List<T> readLines() throws IOException;
}
