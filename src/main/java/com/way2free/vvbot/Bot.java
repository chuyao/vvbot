package com.way2free.vvbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    enum Command {
        ECHO,
        CHAT,
    }

    void sendText(Long id, String text) {
        SendMessage msg = SendMessage.builder()
                .chatId(id.toString())
                .text(text).build();
        try {
            execute(msg);
        } catch (TelegramApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void echoMessage(Long id, Integer msgId) {
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(id.toString())
                .chatId(id.toString())
                .messageId(msgId)
                .build();
        try {
            execute(cm);
        } catch (TelegramApiException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onUpdateReceived(Update arg0) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'onUpdateReceived'");
        // System.out.println(arg0);
        var msg = arg0.getMessage();
        var user = msg.getFrom();
        System.out.println(user.getFirstName() + "wrote " + msg.getText());
        var id = user.getId();
        //sendText(id, msg.getText());
        echoMessage(id, msg.getMessageId());
    }

    @Override
    public String getBotToken() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getBotToken'");
        return BotApplication.getBotToken();
    }

    @Override
    public String getBotUsername() {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method
        // 'getBotUsername'");
        return "AllenToyBot";
    }

}
