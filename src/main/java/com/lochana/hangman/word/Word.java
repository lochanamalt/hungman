package com.lochana.hangman.word;

public class Word {

    private final String fullWord;
    private char[] currentWord;
    private int remainingAttempts;

    public Word(String word, int attempts) {
        this.fullWord= word.toUpperCase();
        this.remainingAttempts= attempts;
        currentWord = new char[fullWord.length()];
        this.currentWord[0]=fullWord.charAt(0);
    }

    public char[] get() {
        return currentWord;
    }

    public boolean fill(Character newChar){

        boolean flag = false;
        Character uppercaseChar = Character.toUpperCase(newChar);

        for(int i = 0; i < fullWord.length(); i++)
        {
            if(uppercaseChar == fullWord.charAt(i))
            {
                currentWord[i]= uppercaseChar;
                flag=true;
            }
        }
        if(flag == false){
            remainingAttempts--;
        }
        return flag;
    }

    public int getRemainingAttempts(){
        return remainingAttempts;
    }

    public boolean isWordGuessed()
    {
        return fullWord.equals(String.valueOf(currentWord));
    }
}

