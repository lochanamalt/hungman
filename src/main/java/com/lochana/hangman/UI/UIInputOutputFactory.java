package com.lochana.hangman.UI;

public class UIInputOutputFactory{

    private UIInputOutputFactory() {
    }

    public static UserInputsOutputs UserInterface(UIType ui) {


        if(ui == UIType.CLI){
            return new CmdUserInputsOutputs();
        }
        return null;
    }
}
