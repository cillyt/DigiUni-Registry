import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    static List<University> universities;
    static Set<String> emails = new HashSet<>();
    static Set<Integer> IDs = new HashSet<>();
    static AllObjects allObjects = new AllObjects();
    static CheckInput checkInput = new CheckInput();

    static Menu menu = new Menu();
    static Authorization auth = new Authorization();


    public static void main(String[] args) throws IOException {
        universities = DataLoader.loadUniversities("src/data.json");
        Authorization.baseSet();
        while(true){
            Thread autoSaveThread = new Thread(
                    new AutoSaveService(universities, 60000, "src/data.json")
            );
            autoSaveThread.setDaemon(true); // дозволяє закрити програму без зупинки потоку
            autoSaveThread.start();
            //якщо користувач захоче вернутись в режим авторизації, додати тут брейк коли буде виходити з програми
            auth.authorization();
            menu.mainMenu();
        }
    }
}