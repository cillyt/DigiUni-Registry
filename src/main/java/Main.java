import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        Menu.mainMenu();

        //Operations.addingDepartment();
        //Operations.addingFaculty();
        //Operations.addingStudent();
        //Operations.addingTeacher();
        //Operations.addingUniversity();


        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Main m = new Main();
        //System.out.print("шо хоч: ");  //ввід даних користувачем
        //int s = Integer.parseInt(reader.readLine());
        //if(s == 0){
           // Main m1 = new Main();
          //  Adding.addingUniversity();
        //}


        //System.out.print("Скорочене: ");
        //String shortUniversityName = reader.readLine();
        //System.out.print("Місто: ");
        //String city = reader.readLine();
        //System.out.print("Адреса: ");
        //String address = reader.readLine();

        //universities.add(new University(fullUniversityName, shortUniversityName, city, address));  //створення об'єкту класу з введеним даними

        //System.out.print(universities);  //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
    }
}