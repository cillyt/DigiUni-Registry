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



       Main.universities.get(uni).faculties.add(faculty);

       for(Faculty f : (Main.universities.get(uni)).faculties) {
           System.out.print(f + "\n");
       }

        System.out.println("Факультет було додано!");
        getMenu().facultyMenu();
    }

    public void addingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(1);
        int faculty = getMenu().facultyQuestionNoDepartment(uni);
        Department depart = new Department();

        depart.setDepartmentCode(checkInput.checkString("Код кафедри: ", "Ви не ввели код кафедри."));
        depart.setDepartmentName(checkInput.checkString("Назва кафедри: ", "Ви не ввели назву кафедри."));
        depart.setCabinetNumber(checkInput.checkInt("Номер кабінету: ", "Ви ввели номер кабінету неправильно."));

        Main.universities.get(uni).faculties.get(faculty).departments.add(depart);

        for(Department d : Main.universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }

        System.out.println("Кафедру було додано!");
        getMenu().departmentMenu();
    }

    public void addingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 2);

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

                teacher.setUni(Main.universities.get(uni).fullUniversityName);
                teacher.setFaculty(Main.universities.get(uni).faculties.get(faculty).facultyName);
                teacher.setDepartment(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).departmentName);

                teacher.setTeacherPosition(checkInput.checkString("Посада: ", "Ви не ввели посаду викладача."));
                teacher.setAcademicDegree(checkInput.checkString("Науковий ступінь: ", "Ви не ввели науковий ступінь викладача."));
                teacher.setAcademicTitle(checkInput.checkString("Вчене звання: ", "Ви не ввели вчене звання викладача."));
                teacher.setYearOfEntry(checkInput.checkInt("Рік прийняття на роботу: ", "Ви ввели рік прийняття на роботу неправильно."));
                teacher.setMonthOfEntry(checkInput.checkInt("Місяць прийняття на роботу (у числовому форматі): ", "Ви ввели місяць прийняття на роботу неправильно."));
                teacher.setDayOfEntry(checkInput.checkInt("День прийняття на роботу (у числовому форматі): ", "Ви ввели день прийняття на роботу неправильно."));
                teacher.setRate(checkInput.checkString("Ставка: ", "Ви не ввели ставку викладача."));

                teacher.setDecanStatus(false);
                if (Main.universities.get(uni).faculties.get(faculty).facultyDecan == null)
                     teacher.setDecanStatus(getMenu().decanQuestion());

                teacher.setHeadOfDepartmentStatus(false);
                if (Main.universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart == null)
                    teacher.setHeadOfDepartmentStatus(getMenu().headOfDepartmentQuestion());

                Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.add(teacher);

                if (teacher.decan)
                    Main.universities.get(uni).faculties.get(faculty).facultyDecan = teacher;
                if (teacher.headOfDepartment)
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = teacher;

                for (Teacher t : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
                    System.out.print(t + "\n");
                }

                System.out.println("Вчитель був успішно доданий!");




        getMenu().teacherMenu();


    }

    public void addingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,2);


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

            stud.setUni(Main.universities.get(uni).fullUniversityName);
            stud.setFaculty(Main.universities.get(uni).faculties.get(faculty).facultyName);
            stud.setDepartment(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).departmentName);

            check = 0;

            stud.setCourseNumber(getMenu().checkOperations(1, 6, "Курс: ", "Ви ввели курс неправильно.", "Ви ввели курс неправильно."));
            stud.setGroupNumber(checkInput.checkInt("Група: ", "Ви ввели групу неправильно."));
            stud.setYearOfEntry(checkInput.checkInt("Рік вступу: ", "Ви ввели рік вступу неправильно: "));

            stud.setStudyForm(getMenu().studyFormQuestion());
            stud.setStudentStatus(getMenu().studentStatusQuestion());

            Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.add(stud);

            for (Student s : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
                System.out.print(s + "\n");
            }

            System.out.println("Студент був успішно доданий!");



        getMenu().studentMenu();

    }


    public void deletingUniversity() throws IOException {
        int uni = getMenu().universityQuestionNoFaculty();
        Main.universities.remove(uni);

        for(University u : Main.universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно видалений!");
        getMenu().universityMenu();
    }

    public void deletingFaculty() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(1);
        int faculty = getMenu().facultyQuestionNoDepartment(uni);
        Main.universities.get(uni).faculties.remove(faculty);

        for(Faculty f : Main.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно видалений!");
        getMenu().facultyMenu();

    }

    public void deletingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 2);

        int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);

            for (Teacher t : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers){
                if (t.decan)
                    Main.universities.get(uni).faculties.get(faculty).facultyDecan = null;
            }

            Main.universities.get(uni).faculties.get(faculty).departments.remove(depart);

            for (Department d : Main.universities.get(uni).faculties.get(faculty).departments) {
                System.out.print(d + "\n");
            }
            System.out.println("Кафедра була успішно видалена!");

        getMenu().departmentMenu();


    }

    public void deletingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,3);
        int depart = getMenu().departmentQuestionWithStudents(uni, faculty);
        int stud = getMenu().studentQuestion(uni, faculty, depart);

        Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);

            for (Student s : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
                System.out.print(s + "\n");
            }
            System.out.println("Студент був успішно вилучений!");

        getMenu().studentMenu();

    }

    public void deletingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(4);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,4);
        int depart = getMenu().departmentQuestionWithTeachers(uni, faculty);
        int teach = getMenu().teacherQuestion(uni, faculty, depart);

            if (Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).decan)
                Main.universities.get(uni).faculties.get(faculty).facultyDecan = null;

            if (Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).headOfDepartment)
                Main.universities.get(uni).faculties.get(faculty).departments.get(depart).headOfDepart = null;

            Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);

            for (Teacher t : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
                System.out.print(t + "\n");
            }
            System.out.println("Викладач був успішно вилучений!");

        getMenu().teacherMenu();

    }



    public void deleteUser() throws IOException {

        boolean changed = false;

        while (!changed) {
            int i = 0;
            List<Authorization.BaseUser> tempUserList = new ArrayList<>(Authorization.allUsersWithRoles);

            for(Authorization.BaseUser b : tempUserList){
                i++;
                System.out.println(i + ". " + b);
            }

            int chooseUser = checkInput.checkInt("Введіть якого користувача ви хочете призначити: ", "Користувача з таким номером не існує");

            Authorization.BaseUser us = tempUserList.get(chooseUser - 1);

            Authorization.allUsersWithRoles.remove(us);         //delete user with previous role
            if(us instanceof Authorization.User){
                Authorization.allUsers.remove(us);
            }
            else if(us instanceof Authorization.Manager){
                Authorization.allManagers.remove(us);
            }
            else if(us instanceof Authorization.Administrator){
                Authorization.allAdministrators.remove(us);
            }


            changed = true;
            System.out.println("Користувач успішно видалений!");

            //   Authorization.BaseUser us = Authorization.allUsersWithRoles(chooseUser);




        }

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
                    System.out.println("Поточна назва університету: " + Main.universities.get(uni).getFullUniversityName());
                    Main.universities.get(uni).setFullUniversityName(checkInput.checkString("Введіть нову повну назву університету: ", "Ви не ввели нову повну назву університету."));
                    break;
                case 2:
                    System.out.println("Поточна скорочена назва університету: " + Main.universities.get(uni).getShortUniversityName());
                    String newUniShortName = checkInput.checkString("Введіть нову скорочену назву університету: ", "Ви не ввели нову скорочену назву університету.");
                    Main.universities.get(uni).setShortUniversityName(newUniShortName);
                    break;
                case 3:
                    System.out.println("Поточне місто : " + Main.universities.get(uni).getCity());
                    String newUniCity = checkInput.checkString("Введіть нове місто: ", "Ви не ввели нове місто.");
                    Main.universities.get(uni).setCity(newUniCity);
                    break;
                case 4:
                    System.out.println("Поточна адреса університету: " + Main.universities.get(uni).getAddress());
                    String newUniAddress = checkInput.checkString("Введіть нову адресу університету: ", "Ви не ввели нову адресу університету.");
                    Main.universities.get(uni).setAddress(newUniAddress);
                    break;
            }
        }

        for(University u : Main.universities) {
            System.out.print(u + "\n");
        }
        System.out.println("Університет був успішно змінений!");
        getMenu().universityMenu();
    }



    public void editingFaculty() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(1);
        int faculty = getMenu().facultyQuestionNoDepartment(uni);

        boolean changed = false;

        while (!changed) {
            int changingParameter = getMenu().facultyParameterQuestion();
            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    System.out.println("Поточний код факультету: " + Main.universities.get(uni).faculties.get(faculty).getFacultyCode());
                    String newFacultyCode = checkInput.checkString("Введіть новий код факультету: ", "Ви не ввели новий код факультету.");
                    Main.universities.get(uni).faculties.get(faculty).setFacultyCode(newFacultyCode);
                    break;
                case 2:
                    System.out.println("Поточна повна назва факультету: " + Main.universities.get(uni).faculties.get(faculty).getFacultyName());
                    String newFacultyName = checkInput.checkString("Введіть нову повну назву факультету: ", "Ви не ввели нову повну назву факультету.");
                    Main.universities.get(uni).faculties.get(faculty).setFacultyName(newFacultyName);
                    break;
                case 3:
                    System.out.println("Поточна скорочена назва факультету: " + Main.universities.get(uni).faculties.get(faculty).getShortFacultyName());
                    String newFacultyShortName = checkInput.checkString("Введіть нову скорочену назву факультету: ", "Ви не ввели нову скорочену назву факультету.");
                    Main.universities.get(uni).faculties.get(faculty).setShortFacultyName(newFacultyShortName);
                    break;
                case 4:
                    if (!allObjects.allTeachersByFaculty(Main.universities.get(uni).faculties.get(faculty)).isEmpty()) {
                        System.out.println("Поточний декан факультету: " + Main.universities.get(uni).faculties.get(faculty).getFacultyDecan());
                        Teacher newFacultyDecan = getMenu().decanEditingQuestion(allObjects.allTeachersByFaculty(Main.universities.get(uni).faculties.get(faculty)));
                        Main.universities.get(uni).faculties.get(faculty).setFacultyDecan(newFacultyDecan);
                        for (Department d : Main.universities.get(uni).faculties.get(faculty).departments)
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
                    System.out.println("Поточний номер телефону факультету: " + Main.universities.get(uni).faculties.get(faculty).getFacultyPhoneNumber());
                    long newFacultyNumber = checkInput.checkLong("Введіть новий номер телефону факультету: ","Ви ввели новий номер телефону неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).setFacultyPhoneNumber(newFacultyNumber);
                    break;
                case 6:
                    System.out.println("Поточна пошта факультету: " + Main.universities.get(uni).faculties.get(faculty).getFacultyEmail());
                    String newFacultyEmail = checkInput.checkString("Введіть нову пошту факультету: ", "Ви не ввели нову пошту факультету.");
                    Main.universities.get(uni).faculties.get(faculty).setFacultyEmail(newFacultyEmail);
                    break;

            }
        }

        for(Faculty f : Main.universities.get(uni).faculties) {
            System.out.print(f + "\n");
        }
        System.out.println("Факультет був успішно змінений!");
        getMenu().facultyMenu();
    }

    public void editingDepartment() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 2);

        int depart = getMenu().departmentQuestionNoStudentsAndTeachers(uni, faculty);
        boolean changed = false;
        while (!changed) {
            int changingParameter = getMenu().departmentParameterQuestion();
            switch (changingParameter) {
                case 0:
                    changed = true;
                    break;
                case 1:
                    System.out.println("Поточний код кафедри: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).getDepartmentCode());
                    String newDepartmentCode = checkInput.checkString("Введіть новий код кафедри: ", "Ви не ввели новий код кафедри.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentCode(newDepartmentCode);
                    break;
                case 2:
                    System.out.println("Поточна повна назва кафедри: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).getDepartmentName());
                    String newDepartmentName = checkInput.checkString("Введіть нову повну назву кафедри: ", "Ви не ввели нову повну назву кафедри.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).setDepartmentName(newDepartmentName);
                    break;
                case 3:
                    if (Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.size() > 0) {
                        System.out.println("Поточний завідувач кафедри: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).getHeadOfDepart());
                        Teacher newHeadOfDepartment = getMenu().headOfDepartmentEditingQuestion(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers);
                        Main.universities.get(uni).faculties.get(faculty).departments.get(depart).setHeadOfDepart(newHeadOfDepartment);
                        for (Department d : Main.universities.get(uni).faculties.get(faculty).departments)
                            for (Teacher t : d.teachers) {
                                if (t.personID == newHeadOfDepartment.personID)
                                    t.decan = true;
                                else
                                    t.decan = false;
                            }
                    } else System.out.println("На обраній кафедрі немає вчителів.");
                    break;

                case 4:
                    System.out.println("Поточний кабінет кафедри: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).getCabinetNumber());
                    int newCabinetNumber = checkInput.checkInt("Введіть новий кабінет кафедри: ", "Ви ввели новий кабінет кафедри неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).setCabinetNumber(newCabinetNumber);
                    break;
            }
        }

        for (Department d : Main.universities.get(uni).faculties.get(faculty).departments) {
            System.out.print(d + "\n");
        }
        System.out.println("Кафедра була успішно змінена!");

        getMenu().departmentMenu();
    }

    public  void editingStudent() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 3);

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
                    System.out.println("Поточний унікальний ідентифікатор: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getPersonID());
                    int newPersonID = checkInput.checkInt("Введіть новий унікальний ідентифікатор: ", "Ви ввели новий унікальний ідентифікатор неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonID(newPersonID);
                    break;
                case 2:
                    System.out.println("Поточне прізвище: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getPersonSurname());
                    String newPersonSurname = checkInput.checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    System.out.println("Поточне ім'я: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getPersonName());
                    String newPersonName = checkInput.checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonName(newPersonName);
                    break;
                case 4:
                    System.out.println("Поточне по-батькові: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getMiddleName());
                    String newMiddleName = checkInput.checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMiddleName(newMiddleName);
                    break;
                case 5:
                    System.out.println("Поточна дата народження: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getYearOfBirth() + "." + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getMonthOfBirth() + "." + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getDayOfBirth());
                    int newBirthYear = checkInput.checkInt("Введіть новий рік народження: ", "Ви не ввели новий рік народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfBirth(newBirthYear);

                    int newBirthMonth = checkInput.checkInt("Введіть новий місяць народження: ", "Ви не ввели новий місяць народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setMonthOfBirth(newBirthMonth);

                    int newBirthDay = checkInput.checkInt("Введіть новий день народження: ", "Ви не ввели новий день народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setDayOfBirth(newBirthDay);
                    break;
                case 6:
                    System.out.println("Поточна електронна пошта: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getPersonEmail());
                    String newPersonEmail = checkInput.checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    System.out.println("Поточний номер телефону: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getPersonPhone());
                    long newPersonPhone = checkInput.checkLong("Введіть новий номер телефону: ", "Ви ввели новий номер телефону неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setPersonPhone(newPersonPhone);
                    break;
                case 8:
                    System.out.println("Поточний університет: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getUni());
                    System.out.println("Поточний факультет: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getFaculty());
                    System.out.println("Поточна кафедра: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getDepartment());
                    int newuni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
                    int newfaculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(newuni,2);
                    int newdepartment = getMenu().departmentQuestionNoStudentsAndTeachers(newuni, newfaculty);

                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setUni(Main.universities.get(newuni).fullUniversityName);
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setFaculty(Main.universities.get(newuni).faculties.get(newfaculty).facultyName);
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setDepartment(Main.universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).departmentName);

                    Main.universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).students.add(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud));
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.remove(stud);

                    uni = newuni;
                    faculty = newfaculty;
                    depart = newdepartment;
                    stud = Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.size() - 1;
                    break;

                case 9:
                    System.out.println("Поточний курс: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getCourseNumber());
                    int newCourseNumber = checkInput.checkInt("Введіть новий курс: ", "Ви ввели новий курс неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setCourseNumber(newCourseNumber);
                    break;
                case 10:
                    System.out.println("Поточний номер групи: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getGroupNumber());
                    int newGroupNumber = checkInput.checkInt("Введіть новий номер групи: ", "Ви ввели новий номер групи неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setGroupNumber(newGroupNumber);
                    break;
                case 11:
                    System.out.println("Поточний рік вступу: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getYearOfEntry());
                    int newYearOfEntry = checkInput.checkInt("Введіть новий рік вступу: ", "Ви ввели новий рік вступу неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setYearOfEntry(newYearOfEntry);
                    break;
                case 12:
                    check = 0;
                    System.out.println("Поточна форма навчання: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getStudyForm());
                    String newStudyForm = getMenu().studyFormQuestion();
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudyForm(newStudyForm);
                    break;
                case 13:
                    check = 0;
                    System.out.println("Поточний статус студента: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).getStudentStatus());
                    String newStudentStatus = getMenu().studentStatusQuestion();
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.get(stud).setStudentStatus(newStudentStatus);
                    break;

            }


        }

        for (Student s : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students) {
            System.out.print(s + "\n");
        }
        System.out.println("Студент був успішно змінений!");
        getMenu().studentMenu();
    }


    public void editingTeacher() throws IOException {
        int uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(4);
        int faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni,4);
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
                    System.out.println("Поточний унікальний ідентифікатор: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getPersonID());
                    int newPersonID = checkInput.checkInt("Введіть новий унікальний ідентифікатор: ", "Ви ввели новий унікальний ідентифікатор неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonID(newPersonID);
                    break;
                case 2:
                    System.out.println("Поточне прізвище: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getPersonSurname());
                    String newPersonSurname = checkInput.checkString("Введіть нове прізвище: ", "Ви не ввели нове прізвище.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonSurname(newPersonSurname);
                    break;
                case 3:
                    System.out.println("Поточне ім'я: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getPersonName());
                    String newPersonName = checkInput.checkString("Введіть нове ім'я: ", "Ви не ввели нове ім'я.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonName(newPersonName);
                    break;
                case 4:
                    System.out.println("Поточне по-батькові: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getMiddleName());
                    String newMiddleName = checkInput.checkString("Введіть нове по-батькові: ", "Ви не ввели нове по-батькові.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMiddleName(newMiddleName);
                    break;
                case 5:
                    System.out.println("Поточна дата народження: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getYearOfBirth() + "." + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getMonthOfBirth() + "." + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getDayOfBirth());
                    int newBirthYear = checkInput.checkInt("Введіть новий рік народження: ", "Ви не ввели новий рік народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfBirth(newBirthYear);

                    int newBirthMonth = checkInput.checkInt("Введіть новий місяць народження: ", "Ви не ввели новий місяць народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setMonthOfBirth(newBirthMonth);

                    int newBirthDay = checkInput.checkInt("Введіть новий день народження: ", "Ви не ввели новий день народження.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setDayOfBirth(newBirthDay);
                    break;
                case 6:
                    System.out.println("Поточна електронна пошта: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getPersonEmail());
                    String newPersonEmail = checkInput.checkString("Введіть нову електронну пошту: ", "Ви не ввели нову електронну пошту.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonEmail(newPersonEmail);
                    break;
                case 7:
                    System.out.println("Поточний номер телефону: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getPersonPhone());
                    long newPersonPhone = checkInput.checkLong("Введіть новий номер телефону: ", "Ви ввели новий номер телефону неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setPersonPhone(newPersonPhone);
                    break;
                case 8:
                    System.out.println("Поточний університет: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getUni());
                    System.out.println("Поточний факультет: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getFaculty());
                    System.out.println("Поточна кафедра: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getDepartment());
                    int newuni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(2);
                    int newfaculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(newuni,2);
                    int newdepartment = getMenu().departmentQuestionNoStudentsAndTeachers(newuni, newfaculty);

                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setUni(Main.universities.get(newuni).fullUniversityName);
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setFaculty(Main.universities.get(newuni).faculties.get(newfaculty).facultyName);
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setDepartment(Main.universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).departmentName);

                    Main.universities.get(newuni).faculties.get(newfaculty).departments.get(newdepartment).teachers.add(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach));
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.remove(teach);

                    uni = newuni;
                    faculty = newfaculty;
                    depart = newdepartment;
                    teach = Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.size() - 1;

                    break;
                case 9:
                    System.out.println("Поточна посада: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getTeacherPosition());
                    String newTeacherPosition = checkInput.checkString("Введіть нову посаду: ", "Ви не ввели нову посаду.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setTeacherPosition(newTeacherPosition);
                    break;
                case 10:
                    System.out.println("Поточний науковий ступінь: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getAcademicDegree());
                    String newAcademicDegree = checkInput.checkString("Введіть новий науковий ступінь: ", "Ви не ввели новий науковий ступінь.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicDegree(newAcademicDegree);
                    break;
                case 11:
                    System.out.println("Поточне вчене звання: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getAcademicTitle());
                    String newAcademicTitle = checkInput.checkString("Введіть нове вчене звання: ", "Ви не ввели нове вчене звання.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setAcademicTitle(newAcademicTitle);
                    break;
                case 12:
                    System.out.println("Поточний рік прийняття на роботу: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getYearOfEntry());
                    int newYearOfEntry = checkInput.checkInt("Введіть новий рік прийняття на роботу: ", "Ви ввели новий рік прийняття на роботу неправильно.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setYearOfEntry(newYearOfEntry);
                    break;
                case 13:
                    System.out.println("Поточна ставка: " + Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).getRate());
                    String newRate = checkInput.checkString("Введіть нову ставку: ", "Ви не ввели нову ставку.");
                    Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers.get(teach).setRate(newRate);
                    break;

            }
        }

        for (Teacher t : Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers) {
            System.out.print(t + "\n");
        }
        System.out.println("Викладач був успішно змінений!");

        getMenu().teacherMenu();
    }


    public void editingUser() throws IOException {

        boolean changed = false;

        while (!changed) {
            int i = 0;
            List<Authorization.BaseUser> tempUserList = new ArrayList<>(Authorization.allUsersWithRoles);

            for(Authorization.BaseUser b : tempUserList){
                i++;
                System.out.println(i + ". " + b);
            }

            int chooseUser = checkInput.checkInt("Введіть якого користувача ви хочете призначити: ", "Користувача з таким номером не існує");

            Authorization.BaseUser us = tempUserList.get(chooseUser - 1);

            int newUserStatus = checkInput.checkInt("Введіть нову роль (1 - Користувач, 2 - Менеджер, 3 - Адміністратор): ", "Ви ввели нову роль неправильно.");
            switch (newUserStatus) {
                case 1:
                    Authorization.Email e = us.email();
                    String pass = us.password();

                    Authorization.allUsersWithRoles.remove(us);         //delete user with previous role
                    if(us instanceof Authorization.User){
                        Authorization.allUsers.remove(us);
                    }
                    else if(us instanceof Authorization.Manager){
                        Authorization.allManagers.remove(us);
                    }
                    else if(us instanceof Authorization.Administrator){
                        Authorization.allAdministrators.remove(us);
                    }

                    Authorization.User user = new Authorization.User(e, pass);      //add user with different role
                    Authorization.allUsersWithRoles.add(user);
                    Authorization.allUsers.add(user);
                    changed = true;
                    System.out.println("Користувач успішно призначений користувачем!");
                    break;

                case 2:
                    Authorization.Email e1 = us.email();
                    String pass1 = us.password();

                    Authorization.allUsersWithRoles.remove(us);         //delete user with previous role
                    if(us instanceof Authorization.User){
                        Authorization.allUsers.remove(us);
                    }
                    else if(us instanceof Authorization.Manager){
                        Authorization.allManagers.remove(us);
                    }
                    else if(us instanceof Authorization.Administrator){
                        Authorization.allAdministrators.remove(us);
                    }

                    Authorization.Manager user1 = new Authorization.Manager(e1, pass1);      //add user with different role
                    Authorization.allUsersWithRoles.add(user1);
                    Authorization.allManagers.add(user1);
                    changed = true;
                    System.out.println("Користувач успішно призначений менеджером!");
                    break;

                case 3:
                    Authorization.Email e2 = us.email();
                    String pass2 = us.password();

                    Authorization.allUsersWithRoles.remove(us);         //delete user with previous role
                    if(us instanceof Authorization.User){
                        Authorization.allUsers.remove(us);
                    }
                    else if(us instanceof Authorization.Manager){
                        Authorization.allManagers.remove(us);
                    }
                    else if(us instanceof Authorization.Administrator){
                        Authorization.allAdministrators.remove(us);
                    }

                    Authorization.Manager user2 = new Authorization.Manager(e2, pass2);      //add user with different role
                    Authorization.allUsersWithRoles.add(user2);
                    Authorization.allManagers.add(user2);
                    changed = true;
                    System.out.println("Користувач успішно призначений адміністратором!");
                    break;

            }
            }

        }


}