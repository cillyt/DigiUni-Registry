import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AutoSaveService implements Runnable {

    private final List<University> universities;
    private final long intervalMs;
    private final String filePath;
    private final Gson gson;

    public AutoSaveService(List<University> universities, long intervalMs, String filePath) {
        this.universities = universities;
        this.intervalMs = intervalMs;
        this.filePath = filePath;
        this.gson = new GsonBuilder().setPrettyPrinting().create(); // гарний JSON
    }

    @Override
    public void run() {
        while (true) {
            try {
                saveToFile();
                System.out.println("Дані збережено: " + java.time.LocalTime.now());
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                System.out.println("Автозбереження зупинено");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(universities, writer);
        }
    }
}