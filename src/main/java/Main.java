import java.io.IOException;

public class Main {
    static Operations operations = new Operations();
    static AllObjects allObjects = new AllObjects();
    static Search search = new Search();
    static Reports reports = new Reports();
    static CheckInput checkInput = new CheckInput();
    static Menu menu = new Menu();

    public static void main(String[] args) throws IOException {
        while(true){  //якщо користувач захоче вернутись в режим авторизації, добавити тут брейк коли буде виходити з програми
            Authorization auth = new Authorization();
            auth.authorizationQuestion();
            Menu menu = new Menu();
            menu.mainMenu();
        }
    }
}