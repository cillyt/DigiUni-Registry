import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        while(true){  //якщо користувач захоче вернутись в режим авторизації, добавити тут брейк коли буде виходити з програми
            Authorization auth = new Authorization();
            auth.authorizationQuestion();
            Menu menu = new Menu();
            menu.mainMenu();
        }
    }
}