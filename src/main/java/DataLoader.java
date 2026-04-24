import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import exсeptions.DataLoadException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Set;

public class DataLoader {

    public static void loadData(String filePath) throws Exception {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filePath)) {
            DataWrapper data = gson.fromJson(reader, DataWrapper.class);
            Main.universities = data.universities;
            Authorization.allUsers = data.users;
            Authorization.allManagers = data.managers;
            Authorization.allAdministrators = data.admins;

            Authorization.setAllUsersWithRoles();
            for(Student s: Main.allObjects.allStudents()){
                Main.emails.add(s.personEmail);
                Main.IDs.add(s.personID);
            }

            for(Teacher t: Main.allObjects.allTeachers()){
                Main.emails.add(t.personEmail);
                Main.IDs.add(t.personID);
            }

        }catch (FileNotFoundException e) {
            throw new DataLoadException("Файл даних не знайдено: " + filePath);
        } catch (JsonSyntaxException e) {
            throw new DataLoadException("Помилка формату JSON у файлі: " + filePath + ". " + e.getMessage());
        } catch (IOException e) {
            throw new DataLoadException("Помилка читання файлу: " + filePath + ". " + e.getMessage());
        }
    }
}