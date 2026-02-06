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
        System.out.print("Назва університету: ");  //ввід даних користувачем
        String fullUniversityName = reader.readLine();
        System.out.print("Скорочена: ");
        String shortUniversityName = reader.readLine();
        System.out.print("Місто: ");
        String city = reader.readLine();
        System.out.print("Адреса: ");
        String address = reader.readLine();

        universities.add(new University(fullUniversityName, shortUniversityName, city, address));  //створення об'єкту класу з введеним даними
        for(University u : universities) {
            System.out.print(u + "\n");
        }

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

       for(Faculty f : Operations.universities.get(uni).faculties) {
           System.out.print(f + "\n");
       }

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

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }

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

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }

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

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }

        System.out.println("Студент був успішно доданий!");
        Menu.mainMenu();
    }


    public static void deletingUniversity() throws IOException {
        int uni = Menu.universityQuestion();
        universities.remove(uni);

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно видалений!");
        Menu.mainMenu();
    }

    public static void deletingFaculty() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        Operations.universities.get(uni).faculties.remove(faculty);

        for(Faculty f : Operations.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно видалений!");
        Menu.mainMenu();

    }

    public static void deletingDepartment() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        universities.get(uni).faculties.get(faculty).departments.remove(depart);

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }
        System.out.println("Кафедра була успішно видалена!");
        Menu.mainMenu();

    }

    public static void deletingStudent() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        int stud = Menu.studentQuestion(uni, faculty, depart);
        universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }
        System.out.println("Студент був успішно вилучений!");
        Menu.mainMenu();

    }

    public static void deletingTeacher() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        int teach = Menu.teacherQuestion(uni, faculty, depart);
        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }
        System.out.println("Викладач був успішно вилучений!");
        Menu.mainMenu();

    }


    /*public static void editingUniversity() throws IOException {
        int uni = Menu.universityQuestion();
        switch (editingUniversityQuestion){
            case 1:
                universities.get(uni).setFullUniversityName(newUniFullName);
            case 2:
                universities.get(uni).setShortUniversityName(newUniShortName);
            case 3:
                universities.get(uni).setCity(newUniCity);
            case 4:
                universities.get(uni).setAddress(newUniAddress);
        }

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно змінений!");
        Menu.mainMenu();
    }

    public static void editingFaculty() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        switch (editingFacultyQuestion){
            case 1:
                Operations.universities.get(uni).faculties.get(faculty).setFacultyCode(newFacultyCode);
            case 2:
                Operations.universities.get(uni).faculties.get(faculty).setFacultyName(newFacultyName);
            case 3:
                Operations.universities.get(uni).faculties.get(faculty).setShortFacultyName(newFacultyShortName);
            //case 4:
              //  Operations.universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);
            case 5:
                Operations.universities.get(uni).faculties.get(faculty).setFacultyPhoneNumber(newFacultyNumber);
            case 6:
                Operations.universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);

        }

        for(Faculty f : Operations.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно змінений!");
        Menu.mainMenu();
    }

    public static void editingDepartment() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        switch (editingDepartQuestion){
            case 1:
                universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentCode(newDepartmentCode);
            case 2:
                universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentName(newDepartmentName);
            //case 3:
              //  universities.get(uni).faculties.get(faculty).departments.get(depart).s(newFacultyShortName);
           // case 4:
             //   universities.get(uni).faculties.get(faculty).departments.get(depart).setFacultyPhoneNumber(newFacultyNumber);
            case 5:
                universities.get(uni).faculties.get(faculty).departments.get(depart).setCabinetNumber(newCabinetNumber);

        }

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }
        System.out.println("Кафедра була успішно змінена!");
        Menu.mainMenu();
    }

    public static void editingStudent() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        int stud = Menu.studentQuestion(uni, faculty, depart);

        switch (editingStudentQuestion){
            case 1:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonID(meni lenki sori);
            case 2:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonSurname();
            case 3:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonName();
            case 4:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMiddleName();
            case 5:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setBirthDate();
            case 6:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonEmail();
            case 7:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonPhone();

            case 8:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setCourseNumber();
            case 9:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setGroupNumber();
            case 10:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfEntry();
            case 11:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudyForm();
            case 12:
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudentStatus();

        }

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }
        System.out.println("Студент був успішно змінений!");
        Menu.mainMenu();
    }


    public static void editingTeacher() throws IOException {
        int uni = Menu.universityQuestion();
        int faculty = Menu.facultyQuestion(uni);
        int depart = Menu.departmentQuestion(uni, faculty);
        int teach = Menu.teacherQuestion(uni, faculty, depart);

        switch (editingTeacherQuestion){
            case 1:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonID(meni lenki sori);
            case 2:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonSurname();
            case 3:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonName();
            case 4:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMiddleName();
            case 5:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setBirthDate();
            case 6:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonEmail();
            case 7:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonPhone();

            case 8:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setTeacherPosition();
            case 9:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicDegree();
            case 10:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicTitle();
            case 11:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfEntry();
            case 12:
                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setRate();

        }

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }
        System.out.println("Викладач був успішно змінений!");
        Menu.mainMenu();
    }*/

}