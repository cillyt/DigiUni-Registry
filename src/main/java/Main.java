import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Operations operations = new Operations();
    static AllObjects allObjects = new AllObjects();
    static Search search = new Search();
    static Reports reports = new Reports();
    static CheckInput checkInput = new CheckInput();
    static Menu menu = new Menu();
    static Authorization auth = new Authorization();
    static List<University> universities = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        while(true){  //якщо користувач захоче вернутись в режим авторизації, додати тут брейк коли буде виходити з програми
            auth.authorization();
            menu.mainMenu();
        }
    }
}