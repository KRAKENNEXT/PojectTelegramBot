package org.example.telegram.keyboard;

import org.example.api.models.LocationHunt;
import org.example.telegram.keyboard.button.Button;
import org.example.telegram.keyboard.button.ButtonId;
import org.example.telegram.keyboard.button.ButtonRows;
import org.telegram.telegrambots.meta.api.objects.Location;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class BuildKeyboard {
    public static List<List<InlineKeyboardButton>> buildMenu(){
        var rowOne = List.of(new Button("Места для охоты", ButtonId.HUNT));
        var rowTwo = List.of(new Button("Информация с корабля ACE", ButtonId.MORE_INFO));

        return ButtonRows.createKeyboard(rowOne, rowTwo);
    }

    public static List<List<InlineKeyboardButton>> buildAce(){
        var rowOne = List.of(new Button("BZ", ButtonId.BZ), new Button("KP", ButtonId.KP));
        var rowTwo = List.of(new Button("Density", ButtonId.DENSITY), new Button("Speed", ButtonId.SPEED));
        var rowThree = List.of(new Button("В меню", ButtonId.MENU));
        return ButtonRows.createKeyboard(rowOne, rowTwo, rowThree);
    }

    public static List<List<InlineKeyboardButton>> buildInfoFromAce(){
        return ButtonRows.createKeyboard(List.of(new Button("Назад", ButtonId.BACK_ACE)));
    }

    public static List<List<InlineKeyboardButton>> buildLocationHunt(List<LocationHunt> locationHunts){
        List<List<Button>> buttons = new ArrayList<>();
        for (var item: locationHunts){
            buttons.add(List.of(new Button(item.getName(), item.getId())));
        }

       return  ButtonRows.createKeyboardForHunt(buttons);
    }
}
