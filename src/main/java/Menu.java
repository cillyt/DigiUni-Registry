import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    Operations operations = new Operations();

    public void mainMenu() throws IOException {
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

    public void universityMenu() throws IOException {
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
                operations.addingUniversity();
                break;
            case 2:
                operations.editingUniversity();
                break;
            case 3:
                operations.deletingUniversity();

        }
    }

    public void facultyMenu() throws IOException {
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
                operations.addingFaculty();
                break;
            case 2:
                operations.editingFaculty();
                break;
            case 3:
                operations.deletingFaculty();

        }

    }

    public void departmentMenu() throws IOException {
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
                operations.addingDepartment();
                break;
            case 2:
                operations.editingDepartment();
                break;
            case 3:
                operations.deletingDepartment();

        }

    }

    public void studentMenu() throws IOException {
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
                operations.addingStudent();
                break;
            case 2:
                operations.editingStudent();
                break;
            case 3:
                operations.deletingStudent();
                break;
            case 4:
                operations.findingStudent();
                break;

        }
    }

    public void teacherMenu() throws IOException {
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
                operations.addingTeacher();
                break;
            case 2:
                operations.editingTeacher();
                break;
            case 3:
                operations.deletingTeacher();
                break;
            case 4:
                operations.findingTeacher();
                break;

        }
    }

    public int universityQuestion() throws IOException {
        System.out.println("Оберіть університет: ");
        int i = 0;
        for (University university : operations.universities ) {
            i++;
            System.out.println(i + ". " +university.getFullUniversityName());
        }
        System.out.print("Введіть номер університету: ");
        int uni = Integer.parseInt(reader.readLine());
        uni--;
        return uni;

    }

    public int facultyQuestion(int uni) throws IOException {
        System.out.println("Оберіть факультет: ");
        int i = 0;
        for (Faculty faculty1 : operations.universities.get(uni).faculties) {
            i++;
            System.out.println(i + ". " + faculty1.getFacultyName());
        }
        System.out.print("Введіть номер факультету: ");
        int faculty = Integer.parseInt(reader.readLine());
        faculty--;
        return faculty;
    }

    public int departmentQuestion(int uni, int faculty) throws IOException {
        System.out.println("Оберіть кафедру: ");
        int i = 0;
        for (Department department : operations.universities.get(uni).faculties.get(faculty).departments) {
            i++;
            System.out.println(i + ". " + department.getDepartmentName());
        }
        System.out.print("Введіть номер кафедри: ");
        int departm = Integer.parseInt(reader.readLine());
        departm--;
        return departm;
    }

    public int studentQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть студента: ");
        int i = 0;
        for (Student student : operations.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
            i++;
            System.out.println(i + ". " + student.getPersonSurname() + " " + student.getPersonName() + " " + student.getMiddleName());
        }
        System.out.print("Введіть номер студента: ");
        int stud = Integer.parseInt(reader.readLine());
        stud--;
        return stud;
    }

    public int teacherQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть викладача: ");
        int i = 0;
        for (Teacher teacher : operations.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
            i++;
            System.out.println(i + ". " + teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName());
        }
        System.out.print("Введіть номер викладача: ");
        int teach = Integer.parseInt(reader.readLine());
        teach--;
        return teach;
    }


    public int universityParameterQuestion() throws IOException {
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

    public int facultyParameterQuestion() throws IOException {
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

    public int departmentParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Код кафедри");
        System.out.println("2. Назва кафедри");
        System.out.println("3. Кабінет");

        System.out.print("Введіть номер параметра: ");
        int parameter = Integer.parseInt(reader.readLine());

        return parameter;
    }

    public int studentParameterQuestion() throws IOException {
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

    public int teacherParameterQuestion() throws IOException {
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


    public int studentFindingQuestion() throws IOException {
        System.out.println("Оберіть параметр за яким ви хочете знайти студента: ");
        System.out.println("0. Завершити пошук");
        System.out.println("1. ПІБ");
        System.out.println("2. Курс");
        System.out.println("3. Група");

        System.out.print("Введіть номер параметра: ");
        int parameterf = Integer.parseInt(reader.readLine());

        return parameterf;


    }

    public int teacherFindingQuestion() throws IOException {
        System.out.println("Оберіть параметр за яким ви хочете знайти викладача: ");
        System.out.println("0. Завершити пошук");
        System.out.println("1. ПІБ");

        System.out.print("Введіть номер параметра: ");
        int parametert = Integer.parseInt(reader.readLine());

        return parametert;
    }

}
