import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void mainMenu() throws IOException {
            System.out.println("=== Оберіть об'єкт з яким хочете працювати ===");
            System.out.println("1. Університет");
            System.out.println("2. Факультет");
            System.out.println("3. Кафедра");
            System.out.println("4. Студент");
            System.out.println("5. Вчитель");

            System.out.println("Введіть номер об'єкта з яким хочете працювати: ");
            int operation = Integer.parseInt(reader.readLine());

            if (operation == 0)
                mainMenu();
            else if (operation == 1)
                universityMenu();
            else if (operation == 2)
                facultyMenu();
            else if (operation == 3)
                departmentMenu();
            else if (operation == 4)
                studentMenu();
            else if (operation == 5)
                teacherMenu();
    }

    public static void universityMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити університет");


        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        if (operation == 0)
            mainMenu();
        else if (operation == 1)
            Operations.addingUniversity();





    }

    public static void facultyMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити факультет");
        System.out.println("2. Редагувати факультет");
        System.out.println("3. Видалити факультет");

        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        if  (operation == 0)
            mainMenu();
        else if (operation == 1)
            Operations.addingFaculty();



    }

    public static void departmentMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити кафедру");
        System.out.println("2. Редагувати кафедру");
        System.out.println("3. Видалити кафедру");

        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        if (operation == 0)
            mainMenu();
        else if (operation == 1)
            Operations.addingDepartment();

    }

    public static void studentMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Додати студента");
        System.out.println("2. Редагувати дані студента");
        System.out.println("3. Вилучити студента");

        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        if (operation == 0)
            mainMenu();
        else if (operation == 1)
            Operations.addingStudent();
    }

    public static void teacherMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Додати вчителя");
        System.out.println("2. Редагувати дані вчителя");
        System.out.println("3. Вилучити вчителя");


        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        if (operation == 0)
            mainMenu();
        else if (operation == 1)
            Operations.addingTeacher();
    }

    public static int universityQuestion() throws IOException {
        System.out.println("Оберіть університет: ");
        int i = 0;
        for (University university : Operations.universities ) {
            i++;
            System.out.println(i + ". " +university.getFullUniversityName());
        }
        System.out.print("Введіть номер університету: ");
        int uni = Integer.parseInt(reader.readLine());
        uni--;
        return uni;

    }

    public static int facultyQuestion(int uni) throws IOException {
        System.out.println("Оберіть факультет: ");
        int i = 0;
        for (Faculty faculty1 : Operations.universities.get(uni).faculties) {
            i++;
            System.out.println(i + ". " + faculty1.getFacultyName());
        }
        System.out.print("Введіть номер факультету: ");
        int faculty = Integer.parseInt(reader.readLine());
        faculty--;
        return faculty;
    }

    public static int departmentQuestion(int uni, int faculty) throws IOException {
        System.out.println("Оберіть кафедру: ");
        int i = 0;
        for (Department department : Operations.universities.get(uni).faculties.get(faculty).departments) {
            i++;
            System.out.println(i + ". " + department.getDepartmentName());
        }
        System.out.print("Введіть номер кафедри: ");
        int departm = Integer.parseInt(reader.readLine());
        departm--;
        return departm;
    }



}
