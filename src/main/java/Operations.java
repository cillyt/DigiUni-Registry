import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

//import static javax.management.Query.and;

public class Operations {

    AllObjects allObjects = Main.allObjects;
    CheckInput checkInput = Main.checkInput;

    public Menu getMenu() {
        return Main.menu;
    }
    
    List<University> universities = Main.universities;  //масиви об'єктів, які можна додати


    int check;


    public void addingUniversity() throws IOException {
        University uni = new University();

        uni.setFullUniversityName(checkInput.checkString("Назва університету: ", "Ви не ввели назву університету."));
        uni.setShortUniversityName(checkInput.checkString("Скорочена назва університету: ", "Ви не ввели скорочену назву університету."));
        uni.setCity(checkInput.checkString("Місто: ", "Ви не ввели місто."));
        uni.setAddress(checkInput.checkString("Адреса: ", "Ви не ввели адресу університету."));

        Main.universities.add(uni);
        for(University u : Main.universities) {
            System.out.print(u + "\n");
        }

        System.out.println("Університет було додано!");
        getMenu().universityMenu();

    }

   public void addingFaculty() throws IOException {
        int uni = getMenu().universityQuestionNoFaculty();

        Faculty faculty = new Faculty();

        faculty.setFacultyCode(checkInput.checkString("Код факультету: ", "Ви не ввели код факультету."));
        faculty.setFacultyName(checkInput.checkString("Назва факультету: ", "Ви не ввели назву факультету."));
        faculty.setShortFacultyName(checkInput.checkString("Скорочена назва факультету: ", "Ви не ввели скорочену назву факультету."));
        faculty.setFacultyPhoneNumber(checkInput.checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно."));
        faculty.setFacultyEmail(checkInput.checkString("Пошта факультету: ", "Ви не ввели пошту факультету."));



       universities.get(uni).faculties.add(faculty);

       for(Faculty f : (universities.get(uni)).faculties) {
           System.out.print(f + "\n");
       }

        System.out.println("Факультет було додано!");
        getMenu().facultyMenu();
    }

    public void addingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionNoDepartment(uni);
        Department depart = new Department();

        depart.setDepartmentCode(checkInput.checkString("Код кафедри: ", "Ви не ввели код кафедри."));
        depart.setDepartmentName(checkInput.checkString("Назва кафедри: ", "Ви не ввели назву кафедри."));
        depart.setCabinetNumber(checkInput.checkInt("Номер кабінету: ", "Ви ввели номер кабінету неправильно."));

        universities.get(uni).faculties.get(faculty).departments.add(depart);

        for(Department d : universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }

        System.out.println("Кафедру було додано!");
        getMenu().departmentMenu();
    }

    public void addingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 1);
        if(faculty != -1) {
                int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);

                Teacher teacher = new Teacher();

                teacher.setPersonID(checkInput.checkInt("Унікальний ідентифікатор: ", "Ви ввели унікальний ідентифікатор неправильно."));
                teacher.setPersonSurname(checkInput.checkString("Прізвище: ", "Ви не ввели прізвище викладача."));
                teacher.setPersonName(checkInput.checkString("Ім'я: ", "Ви не ввели ім'я викладача."));
                teacher.setMiddleName(checkInput.checkString("По-батькові: ", "Ви не ввели по-батькові викладача."));

                teacher.setYearOfBirth(checkInput.checkInt("Рік народження: ", "Ви не ввели рік народження"));
                teacher.setMonthOfBirth(checkInput.checkInt("Місяць народження: ", "Ви не ввели місяць народження"));
                teacher.setDayOfBirth(checkInput.checkInt("День народження: ", "Ви не ввели день народження"));
                teacher.setPersonEmail(checkInput.checkString("Електронна пошта: ", "Ви не ввели електронну пошту викладача."));
                teacher.setPersonPhone(checkInput.checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно."));

                teacher.setUni(universities.get(uni).fullUniversityName);
                teacher.setFaculty(universities.get(uni).faculties.get(faculty).facultyName);
                teacher.setDepartment(universities.get(uni).faculties.get(faculty).departments.get(depart).departmentName);

                teacher.setTeacherPosition(checkInput.checkString("Посада: ", "Ви не ввели посаду викладача."));
                teacher.setAcademicDegree(checkInput.checkString("Науковий ступінь: ", "Ви не ввели науковий ступінь викладача."));
                teacher.setAcademicTitle(checkInput.checkString("Вчене звання: ", "Ви не ввели вчене звання викладача."));
                teacher.setYearOfEntry(checkInput.checkInt("Рік прийняття на роботу: ", "Ви ввели рік прийняття на роботу неправильно."));
                teacher.setMonthOfEntry(checkInput.checkInt("Місяць прийняття на роботу (у числовому форматі): ", "Ви ввели місяць прийняття на роботу неправильно."));
                teacher.setDayOfEntry(checkInput.checkInt("День прийняття на роботу (у числовому форматі): ", "Ви ввели день прийняття на роботу неправильно."));
                teacher.setRate(checkInput.checkString("Ставка: ", "Ви не ввели ставку викладача."));

                teacher.setDecanStatus(false);
                if (universities.get(uni).faculties.get(faculty).facultyDecan == null)
                     teacher.setDecanStatus(getMenu().decanQuestion());

                teacher.setHeadOfDepartmentStatus(false);
                if (universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart == null)
                    teacher.setHeadOfDepartmentStatus(getMenu().headOfDepartmentQuestion());

                universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.add(teacher);

                if (teacher.decan)
                    universities.get(uni).faculties.get(faculty).facultyDecan = teacher;
                if (teacher.headOfDepartment)
                    universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = teacher;

                for (Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
                    System.out.print(t + "\n");
                }

                System.out.println("Вчитель був успішно доданий!");


        }

        getMenu().teacherMenu();


    }

    public void addingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,1);

        if(faculty != -1) {
            int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);

            Student stud = new Student();
            stud.setPersonID(checkInput.checkInt("Унікальний ідентифікатор: ", "Ви ввели унікальний ідентифікатор неправильно."));
            stud.setPersonSurname(checkInput.checkString("Прізвище: ", "Ви не ввели прізвище студента."));
            stud.setPersonName(checkInput.checkString("Ім'я: ", "Ви не ввели ім'я студента."));
            stud.setMiddleName(checkInput.checkString("По-батькові: ", "Ви не ввели по-батькові студента."));

            stud.setYearOfBirth(checkInput.checkInt("Рік народження: ", "Ви не ввели рік народження"));
            stud.setMonthOfBirth( checkInput.checkInt("Місяць народження: ", "Ви не ввели місяць народження"));
            stud.setDayOfBirth(checkInput.checkInt("День народження: ", "Ви не ввели день народження"));

            stud.setPersonEmail(checkInput.checkString("Електронна пошта: ", "Ви не ввели електронну пошту студента."));
            stud.setPersonPhone(checkInput.checkLong("Номер телефону: ", "Ви ввели номер телефону неправильно."));

            stud.setUni(universities.get(uni).fullUniversityName);
            stud.setFaculty(universities.get(uni).faculties.get(faculty).facultyName);
            stud.setDepartment(universities.get(uni).faculties.get(faculty).departments.get(depart).departmentName);

            check = 0;

            stud.setCourseNumber(getMenu().checkOperations(1, 6, "Курс: ", "Ви ввели курс неправильно.", "Ви ввели курс неправильно."));
            stud.setGroupNumber(checkInput.checkInt("Група: ", "Ви ввели групу неправильно."));
            stud.setYearOfEntry(checkInput.checkInt("Рік вступу: ", "Ви ввели рік вступу неправильно: "));

            stud.setStudyForm(getMenu().studyFormQuestion());
            stud.setStudentStatus(getMenu().studentStatusQuestion());

            universities.get(uni).faculties.get(faculty).departments.get(depart).students.add(stud);

            for (Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
                System.out.print(s + "\n");
            }

            System.out.println("Студент був успішно доданий!");

        }

        getMenu().studentMenu();

    }


    public void deletingUniversity() throws IOException {
        int uni = getMenu().universityQuestionNoFaculty();
        universities.remove(uni);

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно видалений!");
        getMenu().universityMenu();
    }

    public void deletingFaculty() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionNoDepartment(uni);
        universities.get(uni).faculties.remove(faculty);

        for(Faculty f : universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно видалений!");
        getMenu().facultyMenu();

    }

    public void deletingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 1);
        if (faculty != -1) {
            int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);

            for (Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
                if (t.decan)
                    universities.get(uni).faculties.get(faculty).facultyDecan = null;
            }

            universities.get(uni).faculties.get(faculty).departments.remove(depart);

            for (Department d : universities.get(uni).faculties.get(faculty).departments) {
                System.out.print(d + "\n");
            }
            System.out.println("Кафедра була успішно видалена!");
        }

        getMenu().departmentMenu();


    }

    public void deletingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,2);
        if(faculty != -1) {
            int depart = getMenu().departmentQuestionWithStudents(uni, faculty);
            int stud = getMenu().studentQuestion(uni, faculty, depart);
            universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);

            for (Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
                System.out.print(s + "\n");
            }
            System.out.println("Студент був успішно вилучений!");
        }
        getMenu().studentMenu();

    }

    public void deletingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,3);
        if(faculty != -1) {
            int depart = getMenu().departmentQuestionWithTeachers(uni, faculty);
            int teach = getMenu().teacherQuestion(uni, faculty, depart);

            if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).decan)
                universities.get(uni).faculties.get(faculty).facultyDecan = null;

            if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).headOfDepartment)
                universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = null;

            universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);

            for (Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
                System.out.print(t + "\n");
            }
            System.out.println("Викладач був успішно вилучений!");
        }
        getMenu().teacherMenu();

    }


    public void editingUniversity() throws IOException {
        int uni = getMenu().universityQuestionNoFaculty();
        boolean changed = false;

        while(!changed) {
            int changingParameter = getMenu().universityParameterQuestion();

            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    universities.get(uni).setFullUniversityName(checkInput.checkString("Введіть нову повну назву університету: ", "Ви не ввели нову повну назву університету."));
                    break;
                case 2:
                    String newUniShortName = checkInput.checkString("Введіть нову скорочену назву університету: ", "Ви не ввели нову скорочену назву університету.");
                    universities.get(uni).setShortUniversityName(newUniShortName);
                    break;
                case 3:
                    String newUniCity = checkInput.checkString("Введіть нове місто: ", "Ви не ввели нове місто.");
                    universities.get(uni).setCity(newUniCity);
                    break;
                case 4:
                    String newUniAddress = checkInput.checkString("Введіть нову адресу університету: ", "Ви не ввели нову адресу університету.");
                    universities.get(uni).setAddress(newUniAddress);
                    break;
            }
        }

        for(University u : universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно змінений!");
        getMenu().universityMenu();
    }



    public void editingFaculty() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionNoDepartment(uni);

        boolean changed = false;

        while (!changed) {
            int changingParameter = getMenu().facultyParameterQuestion();
            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    String newFacultyCode = checkInput.checkString("Введіть новий код факультету: ", "Ви не ввели новий код факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyCode(newFacultyCode);
                    break;
                case 2:
                    String newFacultyName = checkInput.checkString("Введіть нову повну назву факультету: ", "Ви не ввели нову повну назву факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyName(newFacultyName);
                    break;
                case 3:
                    String newFacultyShortName = checkInput.checkString("Введіть нову скорочену назву факультету: ", "Ви не ввели нову скорочену назву факультету.");
                    universities.get(uni).faculties.get(faculty).setShortFacultyName(newFacultyShortName);
                    break;
                case 4:
                    if (!allObjects.allTeachersByFaculty(universities.get(uni).faculties.get(faculty)).isEmpty()) {//можливо потрібно додати умову що масив з одного викладача і той декан
                        Teacher newFacultyDecan = getMenu().decanEditingQuestion(allObjects.allTeachersByFaculty(universities.get(uni).faculties.get(faculty)));
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
                    long newFacultyNumber = checkInput.checkLong("Введіть новий номер телефону факультету: ","Ви ввели новий номер телефону неправильно.");
                    universities.get(uni).faculties.get(faculty).setFacultyPhoneNumber(newFacultyNumber);
                    break;
                case 6:
                    String newFacultyEmail = checkInput.checkString("Введіть нову пошту факультету: ", "Ви не ввели нову пошту факультету.");
                    universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);
                    break;

            }
        }

        for(Faculty f : universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно змінений!");
        getMenu().facultyMenu();
    }

    public void editingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 1);
        if (faculty != -1) {
            int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);
            boolean changed = false;
            while (!changed) {
                int changingParameter = getMenu().departmentParameterQuestion();
                switch (changingParameter) {
                    case 0:
                        changed = true;
                        break;
                    case 1:
                        String newDepartmentCode = checkInput.checkString("Введіть новий код кафедри: ", "Ви не ввели новий код кафедри.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentCode(newDepartmentCode);
                        break;
                    case 2:
                        String newDepartmentName = checkInput.checkString("Введіть нову повну назву кафедри: ", "Ви не ввели нову повну назву кафедри.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentName(newDepartmentName);
                        break;
                    case 3:
                        if (universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.size() > 0) {//можливо потрібно додати умову що масив з одного викладача і той декан
                            Teacher newHeadOfDepartment = getMenu().headOfDepartmentEditingQuestion(universities.get(uni).faculties.get(faculty).departments.get(depart).teachers);
                            universities.get(uni).faculties.get(faculty).departments.get(depart).setHeadOfDepart(newHeadOfDepartment);
                            for (Department d : universities.get(uni).faculties.get(faculty).departments)
                                for (Teacher t : d.teachers) {
                                    if (t.personID == newHeadOfDepartment.personID)
                                        t.decan = true;
                                    else
                                        t.decan = false;
                                }
                        } else System.out.println("На обраній кафедрі немає вчителів.");
                        break;

                    case 4:
                        System.out.print("Введіть новий кабінет кафедри: ");
                        int newCabinetNumber = checkInput.checkInt("Введіть новий кабінет кафедри: ", "Ви ввели новий кабінет кафедри неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).setCabinetNumber(newCabinetNumber);
                        break;
                }
            }

            for (Department d : universities.get(uni).faculties.get(faculty).departments) {
                System.out.print(d + "\n");
            }
            System.out.println("Кафедра була успішно змінена!");
        }
        getMenu().departmentMenu();
    }

    public  void editingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 2);
        if(faculty != -1) {
            int depart = getMenu().departmentQuestionWithStudents(uni, faculty);
            int stud = getMenu().studentQuestion(uni, faculty, depart);

            boolean changed = false;

            while (!changed) {

                int changingParameter = getMenu().studentParameterQuestion();

                switch (changingParameter) {
                    case 0:
                        changed = true;
                        break;
                    case 1:
                        int newPersonID = checkInput.checkInt("Введіть новий унікальний ідентифікатор: ", "Ви ввели новий унікальний ідентифікатор неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonID(newPersonID);
                        break;
                    case 2:
                        String newPersonSurname = checkInput.checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonSurname(newPersonSurname);
                        break;
                    case 3:
                        String newPersonName = checkInput.checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonName(newPersonName);
                        break;
                    case 4:
                        String newMiddleName = checkInput.checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMiddleName(newMiddleName);
                        break;
                    case 5:
                        int newBirthYear = checkInput.checkInt("Введіть новий рік народження: ", "Ви не ввели новий рік народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfBirth(newBirthYear);

                        int newBirthMonth = checkInput.checkInt("Введіть новий місяць народження: ", "Ви не ввели новий місяць народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMonthOfBirth(newBirthMonth);

                        int newBirthDay = checkInput.checkInt("Введіть новий день народження: ", "Ви не ввели новий день народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setDayOfBirth(newBirthDay);
                        break;
                    case 6:
                        String newPersonEmail = checkInput.checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonEmail(newPersonEmail);
                        break;
                    case 7:
                        long newPersonPhone = checkInput.checkLong("Введіть новий номер телефону: ", "Ви ввели новий номер телефону неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonPhone(newPersonPhone);
                        break;
                    case 8:
                        int newuni = getMenu().universityQuestionWithFaculty();
                        int newfaculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,1);
                        int newdepartment = getMenu().departmentQuestionNoStudentsAndTeachers(newuni, newfaculty);

                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setUni(universities.get(newuni).fullUniversityName);
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setFaculty(universities.get(newuni).faculties.get(newfaculty).facultyName);
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setDepartment(universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).departmentName);

                        universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).students.add(universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud));
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);
                        break;

                    case 9:
                        int newCourseNumber = checkInput.checkInt("Введіть новий курс: ", "Ви ввели новий курс неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setCourseNumber(newCourseNumber);
                        break;
                    case 10:
                        int newGroupNumber = checkInput.checkInt("Введіть новий номер групи: ", "Ви ввели новий номер групи неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setGroupNumber(newGroupNumber);
                        break;
                    case 11:
                        int newYearOfEntry = checkInput.checkInt("Введіть новий рік вступу: ", "Ви ввели новий рік вступу неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfEntry(newYearOfEntry);
                        break;
                    case 12:
                        check = 0;
                        String newStudyForm = getMenu().studyFormQuestion();
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudyForm(newStudyForm);
                        break;
                    case 13:
                        check = 0;
                        String newStudentStatus = getMenu().studentStatusQuestion();
                        universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudentStatus(newStudentStatus);
                        break;

                }


            }

            for (Student s : universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
                System.out.print(s + "\n");
            }
            System.out.println("Студент був успішно змінений!");
        }
        getMenu().studentMenu();
    }


    public void editingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFaculty();
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,3);
        if (faculty != -1) {
            int depart = getMenu().departmentQuestionWithTeachers(uni, faculty);
            int teach = getMenu().teacherQuestion(uni, faculty, depart);

            boolean changed = false;

            while (!changed) {

                int changingParameter = getMenu().teacherParameterQuestion();

                switch (changingParameter) {
                    case 0:
                        changed = true;
                        break;
                    case 1:
                        int newPersonID = checkInput.checkInt("Введіть новий унікальний ідентифікатор: ", "Ви ввели новий унікальний ідентифікатор неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonID(newPersonID);
                        break;
                    case 2:
                        String newPersonSurname = checkInput.checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonSurname(newPersonSurname);
                        break;
                    case 3:
                        String newPersonName = checkInput.checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonName(newPersonName);
                        break;
                    case 4:
                        String newMiddleName = checkInput.checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMiddleName(newMiddleName);
                        break;
                    case 5:
                        int newBirthYear = checkInput.checkInt("Введіть новий рік народження: ", "Ви не ввели новий рік народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfBirth(newBirthYear);

                        int newBirthMonth = checkInput.checkInt("Введіть новий місяць народження: ", "Ви не ввели новий місяць народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMonthOfBirth(newBirthMonth);

                        int newBirthDay = checkInput.checkInt("Введіть новий день народження: ", "Ви не ввели новий день народження.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setDayOfBirth(newBirthDay);
                        break;
                    case 6:
                        String newPersonEmail = checkInput.checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonEmail(newPersonEmail);
                        break;
                    case 7:
                        long newPersonPhone = checkInput.checkLong("Введіть новий номер телефону: ", "Ви ввели новий номер телефону неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonPhone(newPersonPhone);
                        break;
                    case 8:
                        int newuni = getMenu().universityQuestionWithFaculty();
                        int newfaculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,1);
                        int newdepartment = getMenu().departmentQuestionNoStudentsAndTeachers(newuni, newfaculty);

                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setUni(universities.get(newuni).fullUniversityName);
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setFaculty(universities.get(newuni).faculties.get(newfaculty).facultyName);
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setDepartment(universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).departmentName);

                        universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).teachers.add(universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach));
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);
                        break;
                    case 9:
                        String newTeacherPosition = checkInput.checkString("Введіть нову посаду: ", "Ви не ввели нову посаду.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setTeacherPosition(newTeacherPosition);
                        break;
                    case 10:
                        String newAcademicDegree = checkInput.checkString("Введіть новий науковий ступінь: ", "Ви не ввели новий науковий ступінь.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicDegree(newAcademicDegree);
                        break;
                    case 11:
                        String newAcademicTitle = checkInput.checkString("Введіть нове вчене звання: ", "Ви не ввели нове вчене звання.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicTitle(newAcademicTitle);
                        break;
                    case 12:
                        int newYearOfEntry = checkInput.checkInt("Введіть новий рік прийняття на роботу: ", "Ви ввели новий рік прийняття на роботу неправильно.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfEntry(newYearOfEntry);
                        break;
                    case 13:
                        String newRate = checkInput.checkString("Введіть нову ставку: ", "Ви не ввели нову ставку.");
                        universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setRate(newRate);
                        break;

                }
            }

            for (Teacher t : universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
                System.out.print(t + "\n");
            }
            System.out.println("Викладач був успішно змінений!");
        }
        getMenu().teacherMenu();
    }


}