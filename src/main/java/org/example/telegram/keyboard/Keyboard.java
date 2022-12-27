package org.example.telegram.keyboard;

import org.example.api.models.LocationHunt;
import org.example.telegram.helper.BuildMessageMedia;
import org.example.telegram.helper.StreamFile;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.InputStream;
import java.util.List;

public class Keyboard {
    private static final String MENU = "/photo/menu.jpg";
    private static final String HUNT = "/photo/hunt.jpg";
    private static final String MORE_INFO = "/photo/more_info.jpg";

    public StreamFile drawMenu(String chatId){
        var markup = new InlineKeyboardMarkup(BuildKeyboard.buildMenu());
        InputStream photo = this.getClass().getResourceAsStream(MENU);
        String message = "Главное меню";

        return BuildMessageMedia.buildMessageMedia(chatId, markup, photo, MENU, message);
    }

    public StreamFile drawMenu(String chatId, int messageId){
        var markup = new InlineKeyboardMarkup(BuildKeyboard.buildMenu());
        InputStream photo = this.getClass().getResourceAsStream(MENU);
        String message = "Главное меню";

        return BuildMessageMedia.buildEditMessageMedia(chatId, markup, messageId, photo, MENU, message);
    }

    public StreamFile drawFullInfo(String chatId, int messageId){
        var markup = new InlineKeyboardMarkup(BuildKeyboard.buildAce());
        InputStream photo  = this.getClass().getResourceAsStream(MORE_INFO);
        String message = "Данные с коробля ACE";
        return BuildMessageMedia.buildEditMessageMedia(chatId, markup, messageId, photo, MORE_INFO, message);
    }

    public StreamFile drawInfoAce(String chatId, int messageId, String message){
        var markup = new InlineKeyboardMarkup(BuildKeyboard.buildInfoFromAce());
        InputStream photo = this.getClass().getResourceAsStream(MORE_INFO);

        return BuildMessageMedia.buildEditMessageMedia(chatId, markup, messageId, photo, MORE_INFO, message);
    }

    public StreamFile drawHunt(String chatId, int messageId, List<LocationHunt> locationHunts){
        var markup = new InlineKeyboardMarkup(BuildKeyboard.buildLocationHunt(locationHunts));
        InputStream photo = this.getClass().getResourceAsStream(HUNT);
        String message = "Места для охоты";

        return BuildMessageMedia.buildEditMessageMedia(chatId, markup, messageId, photo, HUNT, message);
    }

    public StreamFile drawInfoLocation(String chatId, int messageId, String message){
        var markup  = new InlineKeyboardMarkup((BuildKeyboard.buildLocation()));
        InputStream photo = this.getClass().getResourceAsStream(HUNT);

        return BuildMessageMedia.buildEditMessageMedia(chatId, markup, messageId, photo, HUNT, message);
    }
}
