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
            case 2:
                Operations.editingUniversity();
                break;
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
            case 2:
                Operations.editingFaculty();
                break;
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
            case 2:
                Operations.editingDepartment();
                break;
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
        System.out.println("4. Знайти студента");
        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingStudent();
                break;
            case 2:
                Operations.editingStudent();
                break;
            case 3:
                Operations.deletingStudent();
                break;
            case 4:
                Operations.findingStudent();
                break;

        }
    }

    public static void teacherMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Додати викладача");
        System.out.println("2. Редагувати дані викладача");
        System.out.println("3. Вилучити викладача");
        System.out.println("4. Знайти викладача");


        System.out.println("Введіть номер дії: ");
        int operation = Integer.parseInt(reader.readLine());

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                Operations.addingTeacher();
                break;
            case 2:
                Operations.editingTeacher();
                break;
            case 3:
                Operations.deletingTeacher();
                break;
            case 4:
                Operations.findingTeacher();
                break;

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


    public static int universityParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Назва університету");
        System.out.println("2. Скорочена назва університету");
        System.out.println("3. Місто");
        System.out.println("4. Адреса");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;
    }

    public static int facultyParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Код факультету");
        System.out.println("2. Назва факультету");
        System.out.println("3. Скорочена назва факультету");
        System.out.println("4. Номер телефону");
        System.out.println("5. Пошта факультету");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;
    }

    public static int departmentParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Код кафедри");
        System.out.println("2. Назва кафедри");
        System.out.println("3. Кабінет");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;
    }

    public static int studentParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Унікальний ідентифікатор");
        System.out.println("2. Прізвище");
        System.out.println("3. Ім'я");
        System.out.println("4. По-батькові");
        System.out.println("5. Дата народження");
        System.out.println("6. Електронна пошта");
        System.out.println("7. Номер телефону");
        System.out.println("8. Курс");
        System.out.println("9. Група");
        System.out.println("10. Рік вступу");
        System.out.println("11. Форма навчання");
        System.out.println("12. Статус");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;


    }

    public static int teacherParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Унікальний ідентифікатор");
        System.out.println("2. Прізвище");
        System.out.println("3. Ім'я");
        System.out.println("4. По-батькові");
        System.out.println("5. Дата народження");
        System.out.println("6. Електронна пошта");
        System.out.println("7. Номер телефону");
        System.out.println("8. Посада");
        System.out.println("9. Науковий ступінь");
        System.out.println("10. Вчене звання");
        System.out.println("11. Рік прийняття на роботу");
        System.out.println("12. Ставка");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;


    }


    public static int studentFindingQuestion() throws IOException {
        System.out.println("Оберіть за чим ви хочете знайти студента: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. ПІБ");
        System.out.println("2. Курс");
        System.out.println("3. Група");

        System.out.print("Введіть номер параметра: ");
        int parameterf = Integer.parseInt(reader.readLine());

        return parameterf;


    }

    public static int teacherFindingQuestion() throws IOException {
        System.out.println("Оберіть за чим ви хочете знайти викладача: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. ПІБ");

        System.out.print("Введіть номер параметра: ");
        int parametert = Integer.parseInt(reader.readLine());

        return parametert;
    }

}
