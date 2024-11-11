package io.project.GachiMetalTrainingBot.service;

import io.project.GachiMetalTrainingBot.config.BotConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    final BotConfig config;

    public TelegramBot(BotConfig config, @Value("${bot.token}") String botToken){
        super(botToken);
        this.config = config;
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }


    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()){
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            switch (messageText){
                case "/start":
                        startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                        break;
                default:
                        sendMessage(chatId, "Мы работаем над реализацией данной функциональности.");

            }
        }

    }

    private void startCommandReceived(long chatId, String name) {

        String answer = name + ", добро пожаловать в бот для записи тренировок!";

        sendMessage(chatId, answer);
    }

    private void sendMessage(long chatId, String textToSend) {

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try{
            execute(message);
        }
        catch (TelegramApiException e){
//            e.printStackTrace();
        }
    }
}
