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
            System.out.println("5. Викладач");

            System.out.println("Введіть номер об'єкта з яким хочете працювати: ");
            int operation = Integer.parseInt(reader.readLine());

            switch(operation) {
                case 0:
                    mainMenu();
                    break;
                case 1:
                    universityMenu();
                    break;
                case 2:
                    facultyMenu();
                    break;
                case 3:
                    departmentMenu();
                    break;
                case 4:
                    studentMenu();
                    break;
                case 5:
                    teacherMenu();
                    break;

            }
    }

    public static void universityMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити університет");
        System.out.println("2. Редагувати університет");
        System.out.println("3. Видалити університет");


        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingUniversity();
                break;
            //case 2:
              //  Operations.editingUniversity();
                //break;
            case 3:
                Operations.deletingUniversity();

        }
    }

    public static void facultyMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити факультет");
        System.out.println("2. Редагувати факультет");
        System.out.println("3. Видалити факультет");

        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingFaculty();
                break;
            //case 2:
              //  Operations.editingUniversity();
                //break;
            case 3:
                Operations.deletingFaculty();

        }

    }

    public static void departmentMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити кафедру");
        System.out.println("2. Редагувати кафедру");
        System.out.println("3. Видалити кафедру");

        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingDepartment();
                break;
            //case 2:
              //  Operations.editingUniversity();
                //break;
            case 3:
                Operations.deletingDepartment();

        }

    }

    public static void studentMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Додати студента");
        System.out.println("2. Редагувати дані студента");
        System.out.println("3. Вилучити студента");
        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingStudent();
                break;
            //case 2:
              //  Operations.editingUniversity();
                //break;
            case 3:
                Operations.deletingStudent();

        }
    }

    public static void teacherMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Додати викладача");
        System.out.println("2. Редагувати дані викладача");
        System.out.println("3. Вилучити викладача");


        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingTeacher();
                break;
            //case 2:
              //  Operations.editingUniversity();
                //break;
            case 3:
                Operations.deletingTeacher();

        }
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

    public static int studentQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть студента: ");
        int i = 0;
        for (Student student : Operations.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
            i++;
            System.out.println(i + ". " + student.getPersonSurname() + " " + student.getPersonName() + " " + student.getMiddleName());
        }
        System.out.print("Введіть номер студента: ");
        int stud = Integer.parseInt(reader.readLine());
        stud--;
        return stud;
    }

    public static int teacherQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть викладача: ");
        int i = 0;
        for (Teacher teacher : Operations.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
            i++;
            System.out.println(i + ". " + teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName());
        }
        System.out.print("Введіть номер викладача: ");
        int teach = Integer.parseInt(reader.readLine());
        teach--;
        return teach;
    }

}
