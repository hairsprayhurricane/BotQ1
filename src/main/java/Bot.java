import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "@custttttbot";
    }

    @Override
    public String getBotToken() {
        return "7103102612:AAFNmi3DXCXCbwQJSGxLR0POFUnDqVd9I1c";
    }

    Integer correctAnswers = 0;
    Integer answeredQuestions = 0;

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            handleMessage(update.getMessage());
        } else if (update.hasCallbackQuery()) {
            handleCallbackQuery(update.getCallbackQuery());
        }
    }

    private void handleMessage(Message message) {
        String chatId = message.getChatId().toString();
        String response = "";

        if (message.getText().equals("/start_test")) {
            response = "Start?";
            sendInlineKeyboard(chatId, response, "Start", "start");
        } else {
            response = "You selected: " + message.getText();
            sendMessage(chatId, response);
        }
    }

    private void handleCallbackQuery(CallbackQuery callbackQuery) {
        String callbackData = callbackQuery.getData();
        String chatId = callbackQuery.getMessage().getChatId().toString();
        String response = "";

        if (callbackData.equals("start")){
            firstQuestion(chatId);
        } else if (callbackData.contains("q") && answeredQuestions == 0){
            answeredQuestions++;
            if (callbackData.equals("q1")){
                correctAnswers++;
            }
            secondQuestion(chatId);
        }else if (callbackData.contains("w") && answeredQuestions == 1){
            answeredQuestions++;
            if (callbackData.equals("w2")){
                correctAnswers++;
            }
            thirdQuestion(chatId);
        }else if (callbackData.contains("e") && answeredQuestions == 2){
            answeredQuestions++;
            if (callbackData.equals("e3")){
                correctAnswers++;
            }
            fourthQuestion(chatId);
        }else if (callbackData.contains("r") && answeredQuestions == 3){
            answeredQuestions++;
            if (callbackData.equals("r4")){
                correctAnswers++;
            }
            response = "Вы ответили верно на: " + correctAnswers.toString() + " вопроса.";
            sendMessage(chatId, response);
            answeredQuestions = correctAnswers = 0;
            response = "Еще раз?";
            sendInlineKeyboard(chatId, response, "Start", "start");
        }
    }

    private void sendInlineKeyboard(String chatId, String text, String buttonText, String callbackData) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText(buttonText);
        button1.setCallbackData(callbackData);
        row1.add(button1);

        keyboard.add(row1);
        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void sendMessage(String chatId, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(text);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void firstQuestion(String chatId){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        String response = "Какая разница string stringbuilder?";

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button1.setText("Нет разницы");
        button1.setCallbackData("q1");
        button2.setText("Разница в типе даных");
        button2.setCallbackData("q2");
        button3.setText("Разница в копиях");
        button3.setCallbackData("q3");
        button4.setText("Класс и примитив");
        button4.setCallbackData("q4");
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        row1.add(button4);

        keyboard.add(row1);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void secondQuestion(String chatId){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        String response = "Выберите примитивы";

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button1.setText("int double");
        button1.setCallbackData("w1");
        button2.setText("bool integer");
        button2.setCallbackData("w2");
        button3.setText("short byte");
        button3.setCallbackData("w3");
        button4.setText("boolean float");
        button4.setCallbackData("w4");
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        row1.add(button4);

        keyboard.add(row1);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void thirdQuestion(String chatId){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        String response = "Чем локалы лучше деты?";

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button1.setText("Удобны");
        button1.setCallbackData("e1");
        button2.setText("Точны");
        button2.setCallbackData("e2");
        button3.setText("Преобразовывают норм");
        button3.setCallbackData("e3");

        row1.add(button1);
        row1.add(button2);
        row1.add(button3);


        keyboard.add(row1);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void fourthQuestion(String chatId){
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();

        String response = "Как слово класс ключевое объевлять?";

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        InlineKeyboardButton button1 = new InlineKeyboardButton();
        InlineKeyboardButton button2 = new InlineKeyboardButton();
        InlineKeyboardButton button3 = new InlineKeyboardButton();
        InlineKeyboardButton button4 = new InlineKeyboardButton();
        button1.setText("Expand");
        button1.setCallbackData("r1");
        button2.setText("Extend");
        button2.setCallbackData("r2");
        button3.setText("Extended");
        button3.setCallbackData("r3");
        button4.setText("Extends");
        button4.setCallbackData("r4");
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        row1.add(button4);

        keyboard.add(row1);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(response);
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            execute(sendMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
