import exсeptions.DataLoadException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
@Slf4j

public class Main {
    static List<University> universities;
    static Set<Authorization.Email> emails = new HashSet<>();
    static Set<Integer> IDs = new HashSet<>();
    static AllObjects allObjects = new AllObjects();
    static CheckInput checkInput = new CheckInput();

    static Menu menu = new Menu();
    static Authorization auth = new Authorization();

    public static void main(String[] args) throws Exception {
        try {
            Authorization.baseSet();
            DataLoader.loadData("src/data/data.json");
            while(true){
                Thread autoSaveThread = new Thread(
                        new AutoSaveService(60000, "src/data/data.json")
                );
                autoSaveThread.setDaemon(true); // дозволяє закрити програму без зупинки потоку
                autoSaveThread.start();
                //якщо користувач захоче вернутись в режим авторизації, додати тут брейк коли буде виходити з програми
                auth.authorization();
                menu.mainMenu();
            }
        }catch (DataLoadException dle) {
            log.warn(dle.getMessage());
        }
    }
}