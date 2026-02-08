import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Operations {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static List<University> universities = new ArrayList<>();  //масиви об'єктів, які можна додати
    static Menu menu = new Menu();


    public void addingUniversity() throws IOException {
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
        menu.universityMenu();

    }

   public void addingFaculty() throws IOException {
        int uni = menu.universityQuestion();

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

       for(Faculty f : (universities.get(uni)).faculties) {
           System.out.print(f + "\n");
       }

        System.out.println("Факультет було додано!");
        menu.facultyMenu();
    }

    public void addingDepartment() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);

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
        menu.departmentMenu();
    }

    public void addingTeacher() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);

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
        menu.teacherMenu();
    }

    public void addingStudent() throws IOException {
        int uni = menu.universityQuestion();
        int faculty = menu.facultyQuestion(uni);
        int depart = menu.departmentQuestion(uni, faculty);

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
        String studyForm = reader.readLine();
        System.out.print("Статус: ");
        String studentStatus = reader.readLine();

        universities.get(uni).faculties.get(faculty).departments.get(depart).students.add(new Student(studentID, personSurname, personName, middleName, birthDate, personEmail, personPhone, courseNumber, groupNumber, yearOfEntry, studyForm, studentStatus));  //створення об'єкту класу з введеним даними

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
                    System.out.print("Введіть нове повне ім'я університету: ");
                    String newUniFullName = reader.readLine();
                    universities.get(uni).setFullUniversityName(newUniFullName);
                    break;
                case 2:
                    System.out.print("Введіть нове скорочене ім'я університету: ");
                    String newUniShortName = reader.readLine();
                    universities.get(uni).setShortUniversityName(newUniShortName);
                    break;
                case 3:
                    System.out.print("Введіть нове місто: ");
                    String newUniCity = reader.readLine();
                    universities.get(uni).setCity(newUniCity);
                    break;
                case 4:
                    System.out.print("Введіть нову адресу університету: ");
                    String newUniAddress = reader.readLine();
                    universities.get(uni).setAddress(newUniAddress);


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
                    System.out.print("Введіть новий код факультету: ");
                    String newFacultyCode = reader.readLine();
                    Operations.universities.get(uni).faculties.get(faculty).setFacultyCode(newFacultyCode);
                    break;
                case 2:
                    System.out.print("Введіть нове повне ім'я факультету: ");
                    String newFacultyName = reader.readLine();
                    Operations.universities.get(uni).faculties.get(faculty).setFacultyName(newFacultyName);
                    break;
                case 3:
                    System.out.print("Введіть нове скорочене ім'я факультету: ");
                    String newFacultyShortName = reader.readLine();
                    Operations.universities.get(uni).faculties.get(faculty).setShortFacultyName(newFacultyShortName);
                    break;
                case 4:
                    System.out.print("Введіть новий номер телефону факультету: ");
                    long newFacultyNumber = Long.parseLong(reader.readLine());
                    Operations.universities.get(uni).faculties.get(faculty).setFacultyPhoneNumber(newFacultyNumber);
                    break;
                case 5:
                    System.out.print("Введіть нову пошту факультету: ");
                    String newFacultyEmail = reader.readLine();
                    Operations.universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);

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
                    System.out.print("Введіть новий код кафедри: ");
                    String newDepartmentCode = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentCode(newDepartmentCode);
                    break;
                case 2:
                    System.out.print("Введіть нове ім'я кафедри: ");
                    String newDepartmentName = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentName(newDepartmentName);
                    break;
                case 3:
                    System.out.print("Введіть новий кабінет кафедри: ");
                    int newCabinetNumber = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).setCabinetNumber(newCabinetNumber);

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
                    System.out.print("Введіть новий унікальний ідентифікатор: ");
                    int newPersonID = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonID(newPersonID);
                    break;
                case 2:
                    System.out.print("Введіть нове прізвище: ");
                    String newPersonSurname = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    System.out.print("Введіть нове ім'я: ");
                    String newPersonName = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonName(newPersonName);
                    break;
                case 4:
                    System.out.print("Введіть нове по-батькові: ");
                    String newMiddleName = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMiddleName(newMiddleName);
                    break;
                case 5:
                    System.out.print("Введіть новий день народження: ");
                    String newBirthDate = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setBirthDate(newBirthDate);
                    break;
                case 6:
                    System.out.print("Введіть нову електронну пошту: ");
                    String newPersonEmail = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    System.out.print("Введіть новий номер телефону: ");
                    long newPersonPhone = Long.parseLong(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonPhone(newPersonPhone);
                    break;

                case 8:
                    System.out.print("Введіть новий курс: ");
                    int newCourseNumber = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setCourseNumber(newCourseNumber);
                    break;
                case 9:
                    System.out.print("Введіть новий номер групи: ");
                    int newGroupNumber = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setGroupNumber(newGroupNumber);
                    break;
                case 10:
                    System.out.print("Введіть новий рік вступу: ");
                    int newYearOfEntry = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfEntry(newYearOfEntry);
                    break;
                case 11:
                    System.out.print("Введіть нову форму навчання: ");
                    String newStudyForm = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudyForm(newStudyForm);
                    break;
                case 12:
                    System.out.print("Введіть новий статус студента: ");
                    String newStudentStatus = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudentStatus(newStudentStatus);

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
                    System.out.print("Введіть новий унікальний ідентифікатор: ");
                    int newPersonID = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonID(newPersonID);
                    break;
                case 2:
                    System.out.print("Введіть нове прізвище: ");
                    String newPersonSurname = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    System.out.print("Введіть нове ім'я: ");
                    String newPersonName = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonName(newPersonName);
                    break;
                case 4:
                    System.out.print("Введіть нове по-батькові: ");
                    String newMiddleName = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMiddleName(newMiddleName);
                    break;
                case 5:
                    System.out.print("Введіть новий день народження: ");
                    String newBirthDate = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setBirthDate(newBirthDate);
                    break;
                case 6:
                    System.out.print("Введіть нову електронну пошту: ");
                    String newPersonEmail = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    System.out.print("Введіть новий номер телефону: ");
                    long newPersonPhone = Long.parseLong(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonPhone(newPersonPhone);
                    break;
                case 8:
                    System.out.print("Введіть нову посаду: ");
                    String newTeacherPosition = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setTeacherPosition(newTeacherPosition);
                    break;
                case 9:
                    System.out.print("Введіть новий науковий ступінь: ");
                    String newAcademicDegree = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicDegree(newAcademicDegree);
                    break;
                case 10:
                    System.out.print("Введіть нове вчене звання: ");
                    String newAcademicTitle = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicTitle(newAcademicTitle);
                    break;
                case 11:
                    System.out.print("Введіть новий рік прийняття на роботу: ");
                    int newYearOfEntry = Integer.parseInt(reader.readLine());
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfEntry(newYearOfEntry);
                    break;
                case 12:
                    System.out.print("Введіть нову ставку: ");
                    String newRate = reader.readLine();
                    universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setRate(newRate);

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
                System.out.println("Введіть ПІБ для пошуку: ");
                String findBySNM = reader.readLine();

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
                System.out.println("Введіть курс для пошуку: ");
                int findByYear = Integer.parseInt(reader.readLine());

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
                System.out.println("Введіть групу для пошуку: ");
                int findByGroup = Integer.parseInt(reader.readLine());
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
                String findBySNMt = reader.readLine();

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





    public List<Teacher> findBySNMt(String snm) throws IOException {
        List<Teacher> allTeachers = allTeachers();
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



    public List<Student> findBySNM(String snm) throws IOException {
        List<Student> allStudents = allStudents();
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

    public List<Student> findByYear(int year) throws IOException {
        List<Student> allStudents = allStudents();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allStudents) {
            if (student != null && year == student.getCourseNumber() ) {
                    foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public List<Student> findByGroup(int group) throws IOException {
        List<Student> allStudents = allStudents();
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allStudents) {
            if (student != null && group == student.getGroupNumber() ) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }





    public List<Student> allStudents(){
        ArrayList<Student> allStudents = new ArrayList<>();
        for(University u : universities){
            for(Faculty f : u.faculties){
                for(Department d : f.departments){
                    for(Student s : d.students){
                        allStudents.add(s);
                    }
                }
            }
        }
        return allStudents;
    }

    public List<Teacher> allTeachers(){
        ArrayList<Teacher> allTeachers = new ArrayList<>();
        for(University u : universities){
            for(Faculty f : u.faculties){
                for(Department d : f.departments){
                    for(Teacher t : d.teachers){
                        allTeachers.add(t);
                    }
                }
            }
        }
        return allTeachers;
    }
}