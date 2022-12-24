package org.example.telegram.helper;

import org.example.telegram.keyboard.button.ButtonId;

public class Helper {
    public static boolean isNumber(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException ex){
            return false;
        }
    }

    public static boolean isButtonId(String button){
        try{
            ButtonId.valueOf(button);
            return true;
        }catch (IllegalArgumentException ex){
            return false;
        }
    }
}
