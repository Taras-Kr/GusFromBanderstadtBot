package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class GusFromBanderstadtBot extends TelegramLongPollingBot {
    
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi api = new TelegramBotsApi(DefaultBotSession.class);
        api.registerBot(new GusFromBanderstadtBot());
    }

    @Override
    public void onUpdateReceived(Update update) {
        long chatId = getChatId(update);
        SendMessage message = createMessage("Hello, *Taras*");
        message.setChatId(chatId);
        sendApiMethodAsync(message);
    }

    @Override
    public String getBotUsername() {
        return "GusFromBanderstadtBot";
    }

    //@Override
    public String getBotToken() {
        return "6069648040:AAFKVunqBzZsPtsPxpoGMYg3eVGisNX6lpI";
    }

    public Long getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId();
        }
        if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }

    public SendMessage createMessage(String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setParseMode("markdown");
        return message;
    }
}