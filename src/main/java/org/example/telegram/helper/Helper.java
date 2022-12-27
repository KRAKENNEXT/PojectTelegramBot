package org.example.telegram.helper;

import org.example.telegram.keyboard.button.ButtonId;

public class Helper {
    public static boolean isButtonId(String button){
        try{
            ButtonId.valueOf(button);
            return true;
        }catch (IllegalArgumentException ex){
            return false;
        }
    }
}
