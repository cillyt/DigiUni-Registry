import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Menu {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int check;
    Operations operations = Main.operations;
    AllObjects allObjects = Main.allObjects;
    Search search = Main.search;
    Reports reports = Main.reports;
    CheckInput checkInput = Main.checkInput;


    public void mainMenu() throws IOException {
            int counter = 1;
            System.out.println("=== Оберіть об'єкт з яким хочете працювати ===");
            System.out.println("0. Вийти на сторінку входу");
            System.out.println("1. Звіти та пошук");



            if(Authorization.status == 2 || Authorization.status == 3) {
                System.out.println("2. Університет");
                counter++;

                if (!Main.universities.isEmpty()) {
                    System.out.println("3. Факультет");
                    counter++;
                }

                if (!allObjects.allFaculties().isEmpty()) {
                    System.out.println("4. Кафедра");
                    counter++;
                }

                if (!allObjects.allDepartments().isEmpty()) {
                    System.out.println("5. Студент");
                    System.out.println("6. Викладач");
                    counter += 2;
                }
            }


            int operation = checkOperations(0, counter,"Введіть номер об'єкта з яким хочете працювати: ", "Номер об'єкта був введений неправильно.","Не існує об'єкта під таким номером.");



        switch (operation) {
            case 0:
                return;
            case 1:
                reportsAndSearchMenu();
                break;
            case 2:
                universityMenu();
                break;
            case 3:
                facultyMenu();
                break;
            case 4:
                departmentMenu();
                break;
            case 5:
                studentMenu();
                break;
            case 6:
                teacherMenu();
                break;
        }
    }

    public void reportsAndSearchMenu() throws IOException {
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню.");
        System.out.println("1. Звіти");
        System.out.println("2. Пошук");

        int operation = checkOperations(0, 2,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");

        switch (operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                if(allObjects.allStudents().isEmpty() /*&& allObjects.allTeachers().isEmpty()*/){ //треба додати перевірку в репорти (коли додамо викладачів)
                    System.out.println("Немає викладачів та студентів, звіт не може бути складений.");
                    reportsAndSearchMenu();
                }
                else{
                    reports.reports();
                }
                break;
            case 2:
                check = 0;
                int who = searchQuestion();
                switch (who) {
                    case 0:
                        reportsAndSearchMenu();
                        break;
                    case 1:
                        if (allObjects.allStudents().isEmpty()){
                            System.out.println("Немає студентів для пошуку.");
                            reportsAndSearchMenu();
                        }
                        else
                            search.findingStudent();
                        break;
                    case 2:
                        if (allObjects.allTeachers().isEmpty()){
                            System.out.println("Немає вчителів для пошуку.");
                            reportsAndSearchMenu();
                        }
                        else
                            search.findingTeacher();
                        break;
                }
                break;

        }




    }

    public void universityMenu() throws IOException {
        int counter = 1;
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити університет");
        if (!Main.universities.isEmpty()){
            System.out.println("2. Редагувати університет");
            System.out.println("3. Видалити університет");
            counter+=2;
        }

        int operation = checkOperations(0, counter,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");


            switch (operation) {
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
        int counter = 1;
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити факультет");
        if (!allObjects.allFaculties().isEmpty()) {
            System.out.println("2. Редагувати факультет");
            System.out.println("3. Видалити факультет");
            counter+=2;
        }

        int operation = checkOperations(0, counter,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");


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
        int counter = 1;
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Створити кафедру");
        if (!allObjects.allDepartments().isEmpty()) {
            System.out.println("2. Редагувати кафедру");
            System.out.println("3. Видалити кафедру");
            counter+=2;
        }

        check = 0;
        int operation = checkOperations(0, counter,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");


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
        int counter = 1;
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");

        System.out.println("1. Знайти студента");

        if (Authorization.status == 3) {
            System.out.println("2. Додати студента");
            counter++;

            if (!allObjects.allStudents().isEmpty()) {
                System.out.println("3. Редагувати дані студента");
                System.out.println("4. Вилучити студента");
                counter += 2;
            }
        }


        int operation = checkOperations(0, counter,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");

        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                if (allObjects.allStudents().isEmpty()){
                    System.out.println("Немає студентів для пошуку.");
                    studentMenu();
                }
                else search.findingStudent();

                break;
            case 2:
                operations.addingStudent();
                break;
            case 3:
                operations.editingStudent();
                break;
            case 4:
                operations.deletingStudent();
                break;


        }
    }

    public void teacherMenu() throws IOException {
        int counter = 1;
        System.out.println("=== Оберіть дію ===");
        System.out.println("0. Повернутись до головного меню");
        System.out.println("1. Знайти викладача");

        if (Authorization.status == 3) {
            System.out.println("2. Додати викладача");
            counter++;

            if (!allObjects.allTeachers().isEmpty()) {
                System.out.println("3. Редагувати дані викладача");
                System.out.println("4. Вилучити викладача");
                counter += 2;
            }
        }


        int operation = checkOperations(0, counter,"Введіть номер дії: ","Номер дії був введений неправильно.", "Дії під таким номером не існує.");


        switch(operation) {
            case 0:
                mainMenu();
                break;
            case 1:
                if (allObjects.allTeachers().isEmpty()){
                    System.out.println("Немає вчителів для пошуку.");
                    teacherMenu();
                }
                else search.findingTeacher();
                break;
            case 2:
                operations.addingTeacher();
                break;
            case 3:
                operations.editingTeacher();
                break;
            case 4:
                operations.deletingTeacher();
                break;


        }
    }


    public int universityQuestion() throws IOException {
        System.out.println("Оберіть університет: ");
        int i = 0;
        for (University university : Main.universities ) {
            i++;
            System.out.println(i + ". " +university.getFullUniversityName());
        }

        int uni= checkOperations(1, Main.universities.size(),"Введіть номер університету: ","Номер університету був введений неправильно.", "Університету під таким номером не існує.");

        uni--;
        return uni;

    }

    public int facultyQuestion(int uni) throws IOException {
        System.out.println("Оберіть факультет: ");
        int i = 0;
        for (Faculty faculty1 : Main.universities.get(uni).faculties) {
            i++;
            System.out.println(i + ". " + faculty1.getFacultyName());
        }

        int faculty= checkOperations(1, Main.universities.get(uni).faculties.size(),"Введіть номер факультету: ","Номер факультету був введений неправильно.", "Факультету під таким номером не існує.");


        faculty--;
        return faculty;
    }

    public int departmentQuestion(int uni, int faculty) throws IOException {
        System.out.println("Оберіть кафедру: ");
        int i = 0;
        for (Department department : Main.universities.get(uni).faculties.get(faculty).departments) {
            i++;
            System.out.println(i + ". " + department.getDepartmentName());
        }

        int departm = checkOperations(1, Main.universities.get(uni).faculties.get(faculty).departments.size(),"Введіть номер кафедри: ","Номер кафедри був введений неправильно.", "Кафедри під таким номером не існує.");

        departm--;
        return departm;
    }

    public int studentQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть студента: ");
        int i = 0;
        for (Student student : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
            i++;
            System.out.println(i + ". " + student.getPersonSurname() + " " + student.getPersonName() + " " + student.getMiddleName());
        }


        int stud = checkOperations(1, Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.size(),"Введіть номер студента: ","Номер студента був введений неправильно.", "Студента під таким номером не існує.");



        stud--;
        return stud;
    }

    public int teacherQuestion(int uni, int faculty, int depart) throws IOException {
        System.out.println("Оберіть викладача: ");
        int i = 0;
        for (Teacher teacher : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
            i++;
            System.out.println(i + ". " + teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName());
        }

        int teach = checkOperations(1, Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.size(),"Введіть номер викладача: ","Номер викладача був введений неправильно.", "Викладача під таким номером не існує.");

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

        int parameter = checkOperations(0, 4,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");

        return parameter;
    }

    public int facultyParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Код факультету");
        System.out.println("2. Назва факультету");
        System.out.println("3. Скорочена назва факультету");
        System.out.println("4. Декан");
        System.out.println("5. Номер телефону");
        System.out.println("6. Пошта факультету");


        int parameter = checkOperations(0, 6,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");


        return parameter;
    }

    public int departmentParameterQuestion() throws IOException {
        System.out.println("Оберіть параметр, який ви хочете змінити: ");
        System.out.println("0. Завершити зміни");
        System.out.println("1. Код кафедри");
        System.out.println("2. Назва кафедри");
        System.out.println("3. Завідувач кафедри");
        System.out.println("4. Кабінет");


        int parameter = checkOperations(0, 4,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");

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


        int parameter = checkOperations(0, 12,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");


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

        int parameter = checkOperations(0, 4,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");

        return parameter;


    }

    public int searchQuestion() throws IOException {
        System.out.println("Кого ви хочете знайти?");
        System.out.println("0. Завершити пошук");
        System.out.println("1. Студент");
        System.out.println("2. Викладач");

        int person = checkOperations(0, 2,"Введіть номер особи: ","Номер особи був введений неправильно.", "Особи під таким номером не існує.");

        return person;

    }


    public int studentFindingQuestion() throws IOException {
        System.out.println("Оберіть параметр за яким ви хочете знайти студента: ");
        System.out.println("0. Завершити пошук");
        System.out.println("1. ПІБ");
        System.out.println("2. Курс");
        System.out.println("3. Група");

        int parameterf = checkOperations(0, 3,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");

        return parameterf;


    }

    public int teacherFindingQuestion() throws IOException {
        System.out.println("Оберіть параметр за яким ви хочете знайти викладача: ");
        System.out.println("0. Завершити пошук");
        System.out.println("1. ПІБ");

        int parametert = checkOperations(0, 1,"Введіть номер параметра: ","Номер параметра був введений неправильно.", "Параметра під таким номером не існує.");

        return parametert;
    }

    public int reportQuestion() throws IOException {
        System.out.println("Оберіть звіт який ви б хотіли переглянути");
        System.out.println("0. Завершити перегляд звітів");
        System.out.println("1. Студенти впорядковані за курсами");
        System.out.println("2. Всі студенти кафедри впорядковані за курсом");


        check = 0;
        int report = checkOperations(0, 2,"Введіть номер звіту: ","Номер звіту був введений неправильно.", "Звіту під таким номером не існує.");

        return report;

    }

    public boolean decanQuestion() throws IOException {
        check=0;
        while (check == 0) {
            System.out.println("Чи назначити цього викладача деканом факультету?(Так/Ні)");
            String answer = reader.readLine();
            if (answer.equals("Так")){
                check = 1;
                return true;
            }
            if (answer.equals("Ні")){
                check = 1;
                return false;
            }
            else System.out.println("Ви ввели неправильну відповідь.");
        }

        return true;

    }

    public boolean headOfDepartmentQuestion() throws IOException {
        check=0;
        while (check == 0) {
            System.out.println("Назначити цього викладача завідувачем кафедри?(Так/Ні)");
            String answer = reader.readLine();
            if (answer.equals("Так")){
                check = 1;
                return true;
            }
            if (answer.equals("Ні")){
                check = 1;
                return false;
            }
            else System.out.println("Ви ввели неправильну відповідь.");
        }

        return true;
    }

    public Teacher decanEditingQuestion(List<Teacher> allTeachersByFaculty) throws IOException {
        System.out.println("Оберіть викладача: ");
        int i = 0;
        for (Teacher teacher : allTeachersByFaculty) {
            i++;
            System.out.println(i + ". " + teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName());
        }

        int teach = checkOperations(1, allTeachersByFaculty.size(),"Введіть номер викладача: ","Номер викладача був введений неправильно.", "Викладача під таким номером не існує.");
        teach--;

        return allTeachersByFaculty.get(teach);
    }

    public Teacher headOfDepartmentEditingQuestion(List<Teacher> teachers) throws IOException {
        System.out.println("Оберіть викладача: ");
        int i = 0;
        for (Teacher teacher : teachers) {
            i++;
            System.out.println(i + ". " + teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName());
        }

        int teach = checkOperations(1, teachers.size(),"Введіть номер викладача: ","Номер викладача був введений неправильно.", "Викладача під таким номером не існує.");
        teach--;

        return teachers.get(teach);
    }

    public int authorizationQuestion(boolean haventUsersWithRoles) throws IOException {
        int a = 1;
        System.out.println("=== Увійдіть у свій обліковий запис ===");
        System.out.println("1. Зареєструватись");
        if (!haventUsersWithRoles){
            System.out.println("2. Увійти");
            a = 2;
        }

        int operation = checkOperations(1, a,"Введіть номер дії: ", "Номер був введений неправильно.", "Немає дії під таким номером.");
        return operation;

    }

    public int roleAuthorizationQuestion() throws IOException {
        System.out.println("=== Вкажіть роль ===");
        System.out.println("1. Користувач");
        System.out.println("2. Менеджер");
        System.out.println("3. Адміністратор");

        int role = checkOperations(1, 3,"Введіть номер ролі: ", "Номер був введений неправильно.", "Немає ролі під таким номером.");
        return role;

    }


    public int checkOperations(int a, int b, String s, String s1, String s2) throws IOException {
        check = 0;
        int operation = -1;
        while (check == 0) {
            operation = checkInput.checkInt(s,s1);

            if (operation <= b && operation >= a)
                check = 1;
            else
                System.out.println(s2);
        }

        return operation;
    }

}
