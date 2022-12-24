package org.example;

import org.example.api.Auroras;
import org.example.api.exceptions.ClientException;
import org.example.api.exceptions.ProcessingDataException;
import org.example.api.exceptions.ServiceNotAvailableException;
import org.example.telegram.Telegram;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        Telegram telegramBot = new Telegram();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(telegramBot);
    }
}