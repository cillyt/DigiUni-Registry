import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static List<University> universities = new ArrayList<>();  //масиви об'єктів, які можна додати
    //static List<Faculty> faculties = new ArrayList<>();
    //static List<Department> departments = new ArrayList<>();
    //static List<Student> students = new ArrayList<>();
    //static List<Teacher> teachers = new ArrayList<>();

    public static void addingUniversity() throws IOException {
        System.out.print("Ім'я університету: ");  //ввід даних користувачем
        String fullUniversityName = reader.readLine();
        System.out.print("Скорочене: ");
        String shortUniversityName = reader.readLine();
        System.out.print("Місто: ");
        String city = reader.readLine();
        System.out.print("Адреса: ");
        String address = reader.readLine();

        universities.add(new University(fullUniversityName, shortUniversityName, city, address));  //створення об'єкту класу з введеним даними
        System.out.println(universities);  //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
        System.out.println("Університет було додано!");
        Menu.mainMenu();
    }

   public static void addingFaculty() throws IOException {
        int uni = Menu.universityQuestion();

        System.out.print("Код факультету: ");  //ввід даних користувачем
        String facultyCode = reader.readLine();
        System.out.print("Назва факультету: ");
        String facultyName = reader.readLine();
        System.out.print("Скорочена назва факультету: ");
        String shortFacultyName = reader.readLine();
        System.out.print("Номер телефону: ");
        long facultyPhoneNumber = Long.parseLong(reader.readLine());
        System.out.print("Пошта факультету: ");
        String facultyEmail = reader.readLine();


        universities.get(uni).faculties.add(new Faculty(facultyCode, facultyName, shortFacultyName, facultyPhoneNumber, facultyEmail));//створення об'єкту класу з введеним даними

        System.out.println(Operations.universities.get(0).faculties.get(0)); //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
        System.out.println("Факультет було додано!");
        Menu.mainMenu();
    }

    public static void addingDepartment() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);

        System.out.print("Код кафедри: ");  //ввід даних користувачем
        String departmentCode = reader.readLine();
        System.out.print("Назва кафедри: ");
        String departmentName = reader.readLine();
        System.out.print("Номер кабінету: ");
        int cabinetNumber = Integer.parseInt(reader.readLine());

        universities.get(uni).faculties.get(faculty).departments.add(new Department(departmentCode, departmentName, cabinetNumber));  //створення об'єкту класу з введеним даними
        System.out.print(universities.get(uni).faculties.get(faculty).departments); //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
        System.out.println("Кафедру було додано!");
        Menu.mainMenu();
    }

    public static void addingTeacher() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);

        System.out.print("Унікальний ідентифікатор: ");
        int personID = Integer.parseInt(reader.readLine());
        System.out.print("Прізвище: ");
        String personSurname = reader.readLine();
        System.out.print("Ім'я: ");
        String personName = reader.readLine();
        System.out.print("По-батькові: ");
        String middleName = reader.readLine();
        System.out.print("Дата народження: ");
        String birthDate = reader.readLine();
        System.out.print("Електронна пошта: ");
        String personEmail = reader.readLine();
        System.out.print("Номер телефону: ");
        long personPhone = Long.parseLong(reader.readLine());

        System.out.print("Посада: ");
        String teacherPosition = reader.readLine();
        System.out.print("Науковий ступінь: ");
        String academicDegree = reader.readLine();
        System.out.print("Вчене звання: ");
        String academicTitle = reader.readLine();
        System.out.print("Рік прийняття на роботу: ");
        int yearOfEntry = Integer.parseInt(reader.readLine());
        System.out.print("Ставка: ");
        String rate = reader.readLine();

        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.add(new Teacher(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone, teacherPosition, academicDegree, academicTitle, yearOfEntry, rate));  //створення об'єкту класу з введеним даними
        System.out.print(universities.get(uni).faculties.get(faculty).departments.get(depart).teachers);  //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
        System.out.println("Вчитель був успішно доданий!");
        Menu.mainMenu();
    }

    public static void addingStudent() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);

        System.out.print("Унікальний ідентифікатор: ");
        int studentID = Integer.parseInt(reader.readLine());
        System.out.print("Прізвище: ");
        String personSurname = reader.readLine();
        System.out.print("Ім'я: ");
        String personName = reader.readLine();
        System.out.print("По-батькові: ");
        String middleName = reader.readLine();
        System.out.print("Дата народження: ");
        String birthDate = reader.readLine();
        System.out.print("Електронна пошта: ");
        String personEmail = reader.readLine();
        System.out.print("Номер телефону: ");
        long personPhone = Long.parseLong(reader.readLine());

        System.out.print("Курс: ");
        int courseNumber = Integer.parseInt(reader.readLine());
        System.out.print("Група: ");
        int groupNumber = Integer.parseInt(reader.readLine());
        System.out.print("Рік вступу: ");
        int yearOfEntry = Integer.parseInt(reader.readLine());
        System.out.print("Форма навчання: ");
        boolean studyForm = Boolean.parseBoolean(reader.readLine());
        System.out.print("Статус: ");
        String studentStatus = reader.readLine();

        universities.get(uni).faculties.get(faculty).departments.get(depart).students.add(new Student(studentID, personSurname, personName, middleName, birthDate, personEmail, personPhone, courseNumber, groupNumber, yearOfEntry, studyForm, studentStatus));  //створення об'єкту класу з введеним даними
        System.out.print(universities.get(uni).faculties.get(faculty).departments.get(depart).students); //завдяки перевизначеному toString можемо тут викликати список всіх доданих об'єктів
        System.out.println("Студент був успішно доданий!");
        Menu.mainMenu();
    }

}


