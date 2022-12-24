package org.example.telegram.helper;

import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageMedia;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.media.InputMediaPhoto;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import java.io.InputStream;

public class BuildMessageMedia {

    public static StreamFile buildEditMessageMedia(String chatId, InlineKeyboardMarkup keyboardMarkup, int messageId,
                                                   InputStream readFile, String fileName, String text){

        InputMediaPhoto photo = new InputMediaPhoto();
        photo.setMedia(readFile, fileName);
        photo.setCaption(text);

        EditMessageMedia editMessageMedia  = new EditMessageMedia();
        editMessageMedia.setChatId(chatId);
        editMessageMedia.setReplyMarkup(keyboardMarkup);
        editMessageMedia.setMessageId(messageId);
        editMessageMedia.setMedia(photo);

        return new StreamFile(editMessageMedia, readFile);
    }

    public static StreamFile buildMessageMedia(String chatId, InlineKeyboardMarkup keyboardMarkup, InputStream readFile,
                                               String fileName, String text){

        SendPhoto sendPhoto = new SendPhoto();

        sendPhoto.setChatId(chatId);
        sendPhoto.setReplyMarkup(keyboardMarkup);
        sendPhoto.setCaption(text);
        sendPhoto.setPhoto(new InputFile().setMedia(readFile, fileName));

        return new StreamFile(sendPhoto, readFile);
    }
}
