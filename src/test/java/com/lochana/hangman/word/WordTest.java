package com.lochana.hangman.word;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class WordTest {
    @Test
    public void shouldReturnFirstPositionFilledArray_when_word_is_given(){
        Word word= new Word("APPLE",10);
        char[] expected = new char[]{'A',' ',' ',' ',' ',' '};
        assertThat(expected,is(word.get()));
    }

    @Test
    public void shouldApplyTheCharacterToTheWord_when_aValidCharacterIsGiven(){
        Word word= new Word("APPLE",10);
        char[] expected = new char[]{'A','P','P',' ',' '};
        char newChar = 'p';
        assertThat(word.fill(newChar), is(true));
        assertThat(expected,is(word.get()));
    }

    @Test
    public void shouldReduceAttemptsBy1_when_anInvalidCharacterIsGiven(){
        Word word= new Word("APPLE",10);
        char[] expected = new char[]{'A',' ',' ',' ',' '};
        char newChar = 'c';
        assertThat(word.fill(newChar), is(false));
        assertThat(expected,is(word.get()));
        assertThat(word.getRemainingAttempts(), is(9));
    }
}
