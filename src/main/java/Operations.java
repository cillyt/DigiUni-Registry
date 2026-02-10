import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import static javax.management.Query.and;

public class Operations {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Menu menu = new Menu();
    static AllObjects allObjects = new AllObjects();

    static List<University> universities = new ArrayList<>();  //масиви об'єктів, які можна додати
    List<Faculty> allFaculties;
    List<Department> allDepartments;
    List<Student> allStudents;
    List<Teacher> allTeachers;
    List<Teacher> allTeachersByFaculty;

    int check;


    public void addingUniversity() throws IOException {
        String fullUniversityName = checkString("Назва університету: ", "Ви не ввели назву університету.");
        String shortUniversityName = checkString("Скорочена назва університету: ", "Ви не ввели скорочену назву університету.");
        String city = checkString("Місто: ", "Ви не ввели місто.");
        String address = checkString("Адреса: ", "Ви не ввели адресу університету.");

        universities.add(new University(fullUniversityName, shortUniversityName, city, address));  //створення об'єкта класу з введеним даними
        for(University u : universities) {
            System.out.print(u + "\n");
        }

        System.out.println("Університет було додано!");
        menu.universityMenu();

    }

   public void addingFaculty() throws IOException {
        int uni = menu.universityQuestion();

         //ввід даних користувачем
        String facultyCode = checkString("Код факультету: ", "Ви не ввели код факультету.");
        String facultyName = checkString("Назва факультету: ", "Ви не ввели назву факультету.");
        String shortFacultyName = checkString("Скорочена назва факультету: ", "Ви не ввели скорочену назву факультету.");
       long facultyPhoneNumber = checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно.");
        String facultyEmail = checkString("Пошта факультету: ", "Ви не ввели пошту факультету.");

       universities.get(uni).faculties.add(new Faculty(facultyCode, facultyName, shortFacultyName, facultyPhoneNumber, facultyEmail));//створення об'єкта класу з введеним даними

       for(Faculty f : (universities.get(uni)).faculties) {
           System.out.print(f + "\n");
       }

        System.out.println("Факультет було додано!");
        menu.facultyMenu();
    }

    public void addingDepartment() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);

          //ввід даних користувачем
        String departmentCode = checkString("Код кафедри: ", "Ви не ввели код кафедри.");
        String departmentName = checkString("Назва кафедри: ", "Ви не ввели назву кафедри.");
        int cabinetNumber = checkInt("Номер кабінету: ", "Ви ввели номер кабінету неправильно.");

        universities.get(uni).faculties.get(faculty).departments.add(new Department(departmentCode, departmentName, cabinetNumber));  //створення об'єкта класу з введеним даними

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }

        System.out.println("Кафедру було додано!");
        menu.departmentMenu();
    }

    public void addingTeacher() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);

        int personID = checkInt("Унікальний ідентифікатор: ","Ви ввели унікальний ідентифікатор неправильно.");
        String personSurname = checkString("Прізвище: ","Ви не ввели прізвище викладача.");
        String personName = checkString("Ім'я: ", "Ви не ввели ім'я викладача.");
        String middleName = checkString("По-батькові: ", "Ви не ввели по-батькові викладача.");
        String birthDate = checkString("Дата народження: ", "Ви не ввели дату народження викладача.");
        String personEmail = checkString("Електронна пошта: ","Ви не ввели електронну пошту викладача.");
        long personPhone = checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно.");

        String teacherPosition = checkString("Посада: ","Ви не ввели посаду викладача.");
        String academicDegree = checkString("Науковий ступінь: ","Ви не ввели науковий ступінь викладача.");
        String academicTitle = checkString("Вчене звання: ","Ви не ввели вчене звання викладача.");
        int yearOfEntry = checkInt("Рік прийняття на роботу: ","Ви ввели рік прийняття на роботу неправильно.");
        String rate = checkString("Ставка: ","Ви не ввели ставку викладача.");

        Boolean newDecan = false;
        if (universities.get(uni).faculties.get(faculty).facultyDecan == null)
            newDecan = menu.decanQuestion();

        Boolean newHeadOfDepart = false;
        if (universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart == null)
            newHeadOfDepart = menu.headOfDepartmentQuestion();


        Teacher newTeacher =  new Teacher(personID, personSurname, personName, middleName, birthDate,personEmail,personPhone,teacherPosition,academicDegree,academicTitle,yearOfEntry,rate, newDecan, newHeadOfDepart);
        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.add(newTeacher);  //створення об'єкта класу з введеним даними

        if (newDecan)
            universities.get(uni).faculties.get(faculty).facultyDecan = newTeacher;
        if (newHeadOfDepart)
            universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = newTeacher;

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }

        System.out.println("Вчитель був успішно доданий!");
        menu.teacherMenu();
    }

    public void addingStudent() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);

        int studentID = checkInt("Унікальний ідентифікатор: ","Ви ввели унікальний ідентифікатор неправильно.");
        String personSurname = checkString("Прізвище: ","Ви не ввели прізвище студента.");
        String personName = checkString("Ім'я: ", "Ви не ввели ім'я студента.");
        String middleName = checkString("По-батькові: ", "Ви не ввели по-батькові студента.");
        String birthDate = checkString("Дата народження: ", "Ви не ввели дату народження студента.");
        String personEmail = checkString("Електронна пошта: ","Ви не ввели електронну пошту студента.");
        long personPhone = checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно.");

        check = 0;

        int courseNumber = menu.checkOperations(1,6,"Курс: ","Ви ввели курс неправильно.","Ви ввели курс неправильно.");
        int groupNumber = checkInt("Група: ","Ви ввели групу неправильно.");
        int yearOfEntry = checkInt("Рік вступу: ","Ви ввели рік вступу неправильно: ");

        check = 0;
        String studyForm = " ";
        while(check == 0){
            studyForm = checkString("Форма навчання(Бюджет/Контракт): ", "Ви не ввели форму навчання.");
            if (studyForm.equals("Бюджет") || studyForm.equals("Контракт"))
                check = 1;
            else {
                System.out.println("Ви ввели форму навчання неправильно.");
                check = 0;
            }
        }

        check = 0;
        String studentStatus = " ";
        while(check == 0){
            studentStatus = checkString("Статус(Навчається/Відрахований/Академвідпустка): ", "Ви не ввели статус.");
            if (studentStatus.equals("Навчається") || studentStatus.equals("Відрахований") || studentStatus.equals("Академвідпустка"))
                check = 1;
            else{
                System.out.println("Ви ввели статус неправильно.");
                check = 0;
            }
        }


        universities.get(uni).faculties.get(faculty).departments.get(depart).students.add(new Student(studentID, personSurname, personName, middleName, birthDate, personEmail, personPhone, courseNumber, groupNumber, yearOfEntry, studyForm, studentStatus));  //створення об'єкта класу з введеним даними

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }

        System.out.println("Студент був успішно доданий!");
        menu.studentMenu();
    }


    public void deletingUniversity() throws IOException {
        int uni = menu.universityQuestion();
        universities.remove(uni);

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно видалений!");
        menu.universityMenu();
    }

    public void deletingFaculty() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        Operations.universities.get(uni).faculties.remove(faculty);

        for(Faculty f : Operations.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно видалений!");
        menu.facultyMenu();

    }

    public void deletingDepartment() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);

        allTeachersByFaculty = allObjects.allTeachersByFaculty(universities.get(uni).faculties.get(faculty));
        for(Teacher t : allTeachersByFaculty) {
            if (t.decan)
                universities.get(uni).faculties.get(faculty).facultyDecan = null;
        }

        universities.get(uni).faculties.get(faculty).departments.remove(depart);

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }
        System.out.println("Кафедра була успішно видалена!");
        menu.departmentMenu();

    }

    public void deletingStudent() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);
        int stud = menu.studentQuestion(uni, faculty, depart);
        universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }
        System.out.println("Студент був успішно вилучений!");
        menu.studentMenu();

    }

    public void deletingTeacher() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);
        int teach = menu.teacherQuestion(uni, faculty, depart);

        if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).decan)
            universities.get(uni).faculties.get(faculty).facultyDecan = null;

        if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).headOfDepartment)
            universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = null;

        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }
        System.out.println("Викладач був успішно вилучений!");
        menu.teacherMenu();

    }


    public void editingUniversity() throws IOException {
        int uni = menu.universityQuestion();
        boolean changed = false;

        while(!changed) {
            int changingParameter = menu.universityParameterQuestion();

            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    String newUniFullName = checkString("Введіть нову повну назву університету: ", "Ви не ввели нову повну назву університету.");
                    universities.get(uni).setFullUniversityName(newUniFullName);
                    break;
                case 2:
                    String newUniShortName = checkString("Введіть нову скорочену назву університету: ", "Ви не ввели нову скорочену назву університету.");
                    universities.get(uni).setShortUniversityName(newUniShortName);
                    break;
                case 3:
                    String newUniCity = checkString("Введіть нове місто: ", "Ви не ввели нове місто.");
                    universities.get(uni).setCity(newUniCity);
                    break;
                case 4:
                    String newUniAddress = checkString("Введіть нову адресу університету: ", "Ви не ввели нову адресу університету.");
                    universities.get(uni).setAddress(newUniAddress);
                    break;
            }
        }

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно змінений!");
        menu.universityMenu();
    }



    public void editingFaculty() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);

        boolean changed = false;

        while (!changed) {
            int changingParameter = menu.facultyParameterQuestion();
            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    String newFacultyCode = checkString("Введіть новий код факультету: ", "Ви не ввели новий код факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyCode(newFacultyCode);
                    break;
                case 2:
                    String newFacultyName = checkString("Введіть нову повну назву факультету: ", "Ви не ввели нову повну назву факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyName(newFacultyName);
                    break;
                case 3:
                    String newFacultyShortName = checkString("Введіть нову скорочену назву факультету: ", "Ви не ввели нову скорочену назву факультету.");
                    universities.get(uni).faculties.get(faculty).setShortFacultyName(newFacultyShortName);
                    break;
                case 4:
                    allTeachersByFaculty = allObjects.allTeachersByFaculty(universities.get(uni).faculties.get(faculty));
                    if (allTeachersByFaculty.size() > 0) {//можливо потрібно додати умову що масив з одного викладача і той декан
                        Teacher newFacultyDecan = menu.decanEditingQuestion(allTeachersByFaculty);
                        universities.get(uni).faculties.get(faculty).setFacultyDecan(newFacultyDecan);
                        for (Department d : universities.get(uni).faculties.get(faculty).departments)
                            for (Teacher t : d.teachers) {
                                if (t.personID == newFacultyDecan.personID)
                                    t.decan = true;
                                else
                                    t.decan = false;
                            }
                    }
                    else System.out.println("На обраному факультеті немає вчителів.");
                    break;
                case 5:
                    long newFacultyNumber = checkLong("Введіть новий номер телефону факультету: ","Ви ввели новий номер телефону неправильно.");
                    universities.get(uni).faculties.get(faculty).setFacultyPhoneNumber(newFacultyNumber);
                    break;
                case 6:
                    String newFacultyEmail = checkString("Введіть нову пошту факультету: ", "Ви не ввели нову пошту факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);
                    break;

            }
        }

        for(Faculty f : Operations.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно змінений!");
        menu.facultyMenu();
    }

    public void editingDepartment() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);
        boolean changed = false;
        while(!changed) {
            int changingParameter = menu.departmentParameterQuestion();
            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    String newDepartmentCode = checkString("Введіть новий код кафедри: ", "Ви не ввели новий код кафедри.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentCode(newDepartmentCode);
                    break;
                case 2:
                    String newDepartmentName = checkString("Введіть нову повну назву кафедри: ", "Ви не ввели нову повну назву кафедри.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentName(newDepartmentName);
                    break;
                case 3:
                    if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.size() > 0) {//можливо потрібно додати умову що масив з одного викладача і той декан
                        Teacher newHeadOfDepartment = menu.headOfDepartmentEditingQuestion(universities.get(uni).faculties.get(faculty).departments.get(depart).teachers);
                        universities.get(uni).faculties.get(faculty).departments.get(depart).setHeadOfDepart(newHeadOfDepartment);
                        for (Department d : universities.get(uni).faculties.get(faculty).departments)
                            for (Teacher t : d.teachers) {
                                if (t.personID == newHeadOfDepartment.personID)
                                    t.decan = true;
                                else
                                    t.decan = false;
                            }
                    }
                    else System.out.println("На обраній кафедрі немає вчителів.");
                    break;

                case 4:
                    System.out.print("Введіть новий кабінет кафедри: ");
                    int newCabinetNumber = checkInt("Введіть новий кабінет кафедри: ","Ви ввели новий кабінет кафедри неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setCabinetNumber(newCabinetNumber);
                    break;
            }
        }

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }
        System.out.println("Кафедра була успішно змінена!");
        menu.departmentMenu();
    }

    public  void editingStudent() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);
        int stud = menu.studentQuestion(uni, faculty, depart);

        boolean changed = false;

        while(!changed) {

            int changingParameter = menu.studentParameterQuestion();

            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    int newPersonID = checkInt("Введіть новий унікальний ідентифікатор: ","Ви ввели новий унікальний ідентифікатор неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonID(newPersonID);
                    break;
                case 2:
                    String newPersonSurname = checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    String newPersonName =checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonName(newPersonName);
                    break;
                case 4:
                    String newMiddleName = checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMiddleName(newMiddleName);
                    break;
                case 5:
                    String newBirthDate = checkString("Введіть нову дату дня народження: ", "Ви не ввели нову дату дня народження.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setBirthDate(newBirthDate);
                    break;
                case 6:
                    String newPersonEmail = checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    long newPersonPhone = checkLong("Введіть новий номер телефону: ","Ви ввели новий номер телефону неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonPhone(newPersonPhone);
                    break;

                case 8:
                    int newCourseNumber = checkInt("Введіть новий курс: ","Ви ввели новий курс неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setCourseNumber(newCourseNumber);
                    break;
                case 9:
                    int newGroupNumber = checkInt("Введіть новий номер групи: ","Ви ввели новий номер групи неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setGroupNumber(newGroupNumber);
                    break;
                case 10:
                    int newYearOfEntry = checkInt("Введіть новий рік вступу: ","Ви ввели новий рік вступу неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfEntry(newYearOfEntry);
                    break;
                case 11:
                    check = 0;
                    String newStudyForm = " ";
                    while(check == 0){
                        newStudyForm = checkString("Форма навчання: ", "Ви не ввели форму навчання.");
                        if (newStudyForm.equals("Бюджет") || newStudyForm.equals("Контракт"))
                            check = 1;
                        else {
                            System.out.println("Ви ввели форму навчання неправильно.");
                            check = 0;
                        }
                    }
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudyForm(newStudyForm);
                    break;
                case 12:
                    check = 0;
                    String newStudentStatus = " ";
                    while(check == 0){
                        newStudentStatus = checkString("Статус: ", "Ви не ввели статус.");
                        if (newStudentStatus.equals("Навчається") || newStudentStatus.equals("Відрахований") || newStudentStatus.equals("Академвідпустка"))
                            check = 1;
                        else {
                            System.out.println("Ви ввели статус неправильно.");
                            check = 0;
                        }
                    }
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudentStatus(newStudentStatus);
                    break;

            }


        }

        for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
            System.out.print(s + "\n");
        }
        System.out.println("Студент був успішно змінений!");
        menu.studentMenu();
    }


    public void editingTeacher() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);
        int teach = menu.teacherQuestion(uni, faculty, depart);

        boolean changed = false;

        while(!changed) {

            int changingParameter = menu.teacherParameterQuestion();

            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    int newPersonID = checkInt("Введіть новий унікальний ідентифікатор: ","Ви ввели новий унікальний ідентифікатор неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonID(newPersonID);
                    break;
                case 2:
                    String newPersonSurname = checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    String newPersonName =checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonName(newPersonName);
                    break;
                case 4:
                    String newMiddleName = checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMiddleName(newMiddleName);
                    break;
                case 5:
                    String newBirthDate = checkString("Введіть нову дату дня народження: ", "Ви не ввели нову дату дня народження.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setBirthDate(newBirthDate);
                    break;
                case 6:
                    String newPersonEmail = checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    long newPersonPhone = checkLong("Введіть новий номер телефону: ","Ви ввели новий номер телефону неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonPhone(newPersonPhone);
                    break;
                case 8:
                    String newTeacherPosition = checkString("Введіть нову посаду: ", "Ви не ввели нову посаду.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setTeacherPosition(newTeacherPosition);
                    break;
                case 9:
                    String newAcademicDegree = checkString("Введіть новий науковий ступінь: ", "Ви не ввели новий науковий ступінь.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicDegree(newAcademicDegree);
                    break;
                case 10:
                    String newAcademicTitle = checkString("Введіть нове вчене звання: ", "Ви не ввели нове вчене звання.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicTitle(newAcademicTitle);
                    break;
                case 11:
                    int newYearOfEntry = checkInt("Введіть новий рік прийняття на роботу: ","Ви ввели новий рік прийняття на роботу неправильно.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfEntry(newYearOfEntry);
                    break;
                case 12:
                    String newRate = checkString("Введіть нову ставку: ", "Ви не ввели нову ставку.");
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setRate(newRate);
                    break;

            }
        }

        for(Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
            System.out.print(t + "\n");
        }
        System.out.println("Викладач був успішно змінений!");
        menu.teacherMenu();
    }









    public void findingStudent() throws IOException {
        int studentFindingQuestion = menu.studentFindingQuestion();
        switch(studentFindingQuestion){
            case 0:
                menu.mainMenu();
            case 1:
                String findBySNM = checkString("Введіть ПІБ для пошуку: ", "Ви не ввели ПІБ для пошуку.");
                List<Student> results = findBySNM(findBySNM);
                if (results.isEmpty()) {
                    System.out.println("Студентів з таким ПІБ не знайдено");
                }
                else {
                    System.out.println("Знайдено студентів: " + results.size());
                    for (Student s : results) {
                        System.out.println("- " + s);
                    }
                }
                menu.studentMenu();
                break;
            case 2:
                int findByYear = checkInt("Введіть курс для пошуку: ","Ви ввели курс неправильно.");

                List<Student> results1 = findByYear(findByYear);
                if (results1.isEmpty()) {
                    System.out.println("Студентів такого курсу не знайдено");
                }
                else {
                    System.out.println("Знайдено студентів: " + results1.size());
                    for (Student s : results1) {
                        System.out.println("- " + s);
                    }
                }
                menu.studentMenu();
                break;
            case 3:
                int findByGroup = checkInt("Введіть групу для пошуку: ","Ви ввели групу неправильно.");
                List<Student> results2 = findByGroup(findByGroup);
                if (results2.isEmpty()) {
                    System.out.println("Студентів такої групи не знайдено");
                }
                else {
                    System.out.println("Знайдено студентів: " + results2.size());
                    for (Student s : results2) {
                        System.out.println("- " + s);
                    }
                }
                menu.studentMenu();
                break;
        }
    }


    public void findingTeacher() throws IOException {
        int teacherFindingQuestion = menu.teacherFindingQuestion();
        switch(teacherFindingQuestion){
            case 0:
                menu.mainMenu();
            case 1:
                System.out.println("Введіть ПІБ для пошуку: ");
                String findBySNMt = checkString("Введіть ПІБ для пошуку: ", "Ви не ввели ПІБ для пошуку.");

                List<Teacher> results = findBySNMt(findBySNMt);
                if (results.isEmpty()) {
                    System.out.println("Викладачів з таким ПІБ не знайдено");
                }
                else {
                    System.out.println("Знайдено викладачів: " + results.size());
                    for (Teacher t : results) {
                        System.out.println("- " + t);
                    }
                }
                menu.teacherMenu();
                break;

        }
    }





    public List<Teacher> findBySNMt(String snm) {
        allTeachers = allObjects.allTeachers();
        List<Teacher> foundTeachers = new ArrayList<>();
        if (snm == null || snm.isEmpty()) return foundTeachers;

        for (Teacher teacher :allTeachers) {
            if (teacher != null) {
                String SNM = teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName();
                if (snm.equalsIgnoreCase(SNM)) {
                    foundTeachers.add(teacher);
                }
            }
        }
        return foundTeachers;
    }



    public List<Student> findBySNM(String snm) {
        allStudents = allObjects.allStudents();
        List<Student> foundStudents = new ArrayList<>();
        if (snm == null || snm.isEmpty()) return foundStudents;

        for (Student student :allStudents) {
            if (student != null) {
                String SNM = student.getPersonSurname() + " " + student.getPersonName() + " " + student.getMiddleName();
                if (snm.equalsIgnoreCase(SNM)) {
                    foundStudents.add(student);
                }
            }
        }
        return foundStudents;
    }

    public List<Student> findByYear(int year) {
        allStudents = allObjects.allStudents();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allStudents) {
            if (student != null && year == student.getCourseNumber() ) {
                    foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public List<Student> findByGroup(int group) {
        allStudents = allObjects.allStudents();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allStudents) {
            if (student != null && group == student.getGroupNumber() ) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }






    public void reports() throws IOException {
        int rep = menu.reportQuestion();
        switch(rep){
            case 0:
                menu.mainMenu();
                break;
            case 1:
                allStudents = allObjects.allStudents();
                allStudents.sort(Comparator.comparing(Student::getCourseNumber));
                for(Student s : allStudents){
                    System.out.print(s + "\n");
                }
                break;
            case 2:
                int uni = menu.universityQuestion();
                int faculty = menu.facultyQuestion(uni);
                int depart = menu.departmentQuestion(uni, faculty);
                universities.get(uni).faculties.get(faculty).departments.get(depart).students.sort(Comparator.comparing(Student::getCourseNumber));
                for(Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students){
                    System.out.print(s + "\n");
                }
                break;
        }

        menu.mainMenu();
    }




    public String checkString(String s, String s1) throws IOException {
        check = 0;
        String parameter = "";
        while(check == 0) {
            System.out.println(s);
            parameter = reader.readLine();
            if (parameter.equals(""))
                System.out.println(s1);
            else{
                for (int i = 0; i < parameter.length(); i++) {
                    if (parameter.charAt(i) != ' ') {
                        check = 1;
                    }
                }
                if (check!=1) {
                    System.out.println(s1);
                }
            }
        }

        return parameter;

    }

    public int  checkInt(String s, String s1) throws IOException {
        check = 0;
        int parameter = 0;
        while(check == 0) {
            try{
                System.out.println(s);
                parameter = Integer.parseInt(reader.readLine());
                check = 1;
            }
            catch(NumberFormatException e){
                System.out.println(s1);
                check = 0;
            }
        }
        return parameter;
    }

    public long checkLong(String s, String s1) throws IOException {
        check = 0;
        long parameter = 0;
        while(check == 0) {
            try{
                System.out.println(s);
                parameter = Long.parseLong(reader.readLine());
                check = 1;
            }
            catch(NumberFormatException e){
                System.out.println(s1);
                check = 0;
            }
        }
        return parameter;
    }









}