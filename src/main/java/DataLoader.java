import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class DataLoader {

    public static void loadData(String filePath) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            DataWrapper data = gson.fromJson(reader, DataWrapper.class);
            Main.universities = data.universities;
            Authorization.allUsers = data.users;
            Authorization.allManagers = data.managers;
            Authorization.allAdministrators = data.admins;
        }
    }
}