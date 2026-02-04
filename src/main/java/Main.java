import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<University> universities = new ArrayList<>();  //масиви об'єктів, які можна додати
        List<Faculty> faculties = new ArrayList<>();
        List<Department> departments = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        System.out.print("Ім'я університету: ");  //ввід даних користувачем
        String fullUniversityName = reader.readLine();
        System.out.print("Скорочене: ");
        String shortUniversityName = reader.readLine();
        System.out.print("Місто: ");
        String city = reader.readLine();
        System.out.print("Адреса: ");
        String address = reader.readLine();

        universities.add(new University(fullUniversityName, shortUniversityName, city, address));  //створення об'єкту класу з введеним даними

        System.out.print(universities);  //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
    }
}