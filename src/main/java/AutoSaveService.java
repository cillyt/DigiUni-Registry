import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.crypto.Data;
import java.io.FileWriter;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AutoSaveService implements Runnable {


    private final DataWrapper data;
    private final long intervalMs;
    private final String filePath;
    private final Gson gson;

    public AutoSaveService( long intervalMs, String filePath) {
        this.data = new DataWrapper();
        this.data.universities = Main.universities;
        this.data.users = Authorization.allUsers;
        this.data.managers = Authorization.allManagers;
        this.data.admins = Authorization.allAdministrators;

        this.intervalMs = intervalMs;
        this.filePath = filePath;
        this.gson = new GsonBuilder().setPrettyPrinting().create(); // гарний JSON
    }

    @Override
    public void run() {
        while (true) {
            try {
                saveToFile();
                log.debug("Дані збережено: {}", java.time.LocalTime.now());
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                log.debug("Автозбереження зупинено");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(data, writer);
        }
    }
}