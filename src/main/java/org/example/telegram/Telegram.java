package org.example.telegram;

import org.example.api.Auroras;
import org.example.api.exceptions.ClientException;
import org.example.api.exceptions.ProcessingDataException;
import org.example.api.exceptions.ServiceNotAvailableException;
import org.example.api.models.LocationHunt;
import org.example.telegram.helper.Helper;
import org.example.telegram.helper.StreamFile;
import org.example.telegram.keyboard.Keyboard;
import org.example.telegram.keyboard.button.ButtonId;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Telegram extends TelegramLongPollingBot {

    private final Keyboard keyboard = new Keyboard();
    private final Auroras api = new Auroras();

    @Override
    public String getBotUsername() {
        //Заменить!
        return "TestMyProject";
    }

    @Override
    public String getBotToken() {
        //Заменить!
        return "5835000914:AAGzXhhAbWoWsG14AsYgF6Ic7cxU9DkMayY";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()&&update.getMessage().getText().startsWith("/"))
            processingCommand(update);
        else if (update.hasCallbackQuery())
            defineClickButton(update.getCallbackQuery());
    }

    private void processingCommand(Update update){
        String chatId = update.getMessage().getChatId().toString();
        String command = update.getMessage().getText();
        if (command.equals("/start") || command.equals("/menu"))
            sendPhotoMessage(keyboard.drawMenu(chatId));
    }

    private void defineClickButton(CallbackQuery callbackQuery){
        String buttonClick = callbackQuery.getData();
        if (Helper.isButtonId(buttonClick))
            processingClickButtonId(callbackQuery, buttonClick);

        else processingClickButton(callbackQuery, buttonClick);
    }

    private void processingClickButtonId(CallbackQuery callbackQuery, String button){
        String chatId = callbackQuery.getMessage().getChatId().toString();
        int messageId = callbackQuery.getMessage().getMessageId();
        ButtonId buttonId = ButtonId.valueOf(button);

        switch (buttonId){
            case MENU:
                sendEditPhotoMessage(keyboard.drawMenu(chatId, messageId));
                break;

            case BACK_ACE:
            case MORE_INFO:
                sendEditPhotoMessage(keyboard.drawFullInfo(chatId, messageId));
                break;

            case BZ:
                sendBZ(chatId, messageId);
                break;

            case KP:
                sendKP(chatId, messageId);
                break;

            case SPEED:
                sendSpeed(chatId, messageId);
                break;

            case DENSITY:
                sendDensity(chatId, messageId);
                break;

            case HUNT:
                sendLocationHunt(chatId, messageId);
                break;
        }
    }

    private void processingClickButton(CallbackQuery callbackQuery, String button) {
        String chatId = callbackQuery.getMessage().getChatId().toString();
        int messageId = callbackQuery.getMessage().getMessageId();

        try{
            sendEditPhotoMessage(keyboard.drawInfoLocation(chatId, messageId, api.getSearchLocation(button).toString()));
        }catch ( ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }

    private void sendPhotoMessage(StreamFile message){
        try{
            execute(message.getSendPhoto());
            message.closeStream();
        }catch (TelegramApiException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void sendEditPhotoMessage(StreamFile message){
        try{
            execute(message.getEditMessageMedia());
            message.closeStream();
        }catch (TelegramApiException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void sendText(String message, String chatId){
        SendMessage sendMessage = new SendMessage(chatId, message);
        try{
            execute(sendMessage);
        }catch (TelegramApiException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void sendBZ(String chatId, int messageId){
        try{
            sendEditPhotoMessage(keyboard.drawInfoAce(chatId, messageId, api.getAceBz().toString()));
        }catch (ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }

    private void sendKP(String chatId, int messageId){
        try{
            sendEditPhotoMessage(keyboard.drawInfoAce(chatId, messageId, api.getAceKp().toString()));
        }catch (ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }

    private void sendSpeed(String chatId, int messageId){
        try{
            sendEditPhotoMessage(keyboard.drawInfoAce(chatId, messageId, api.getAceSpeed().toString()));
        }catch (ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }

    private void sendDensity(String chatId, int messageId){
        try{
            sendEditPhotoMessage(keyboard.drawInfoAce(chatId, messageId, api.getAceDensity().toString()));
        }catch (ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }

    private void sendLocationHunt(String chatId, int messageId){
        try{
            sendEditPhotoMessage(keyboard.drawHunt(chatId, messageId, api.getLocationsForHunt()));
        }catch (ServiceNotAvailableException | ProcessingDataException | ClientException ex){
            sendText(ex.getMessage(), chatId);
        }
    }
}
