import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Search {
    AllObjects allObjects = Main.allObjects;
    CheckInput checkInput = Main.checkInput;

    public Menu getMenu() {
        return Main.menu;
    }



    public void findingStudent() throws IOException {
            int studentFindingQuestion = getMenu().studentFindingQuestion();
            switch (studentFindingQuestion) {
                case 0:
                    getMenu().mainMenu();
                case 1:
                    String findBySNM = checkInput.checkString("Введіть ПІБ для пошуку: ", "Ви не ввели ПІБ для пошуку.");
                    List<Student> results = findBySNM(findBySNM);
                    if (results.isEmpty()) {
                        System.out.println("Студентів з таким ПІБ не знайдено");
                    } else {
                        System.out.println("Знайдено студентів: " + results.size());
                        for (Student s : results) {
                            System.out.println("- " + s);
                        }
                    }
                    getMenu().studentMenu();
                    break;
                case 2:
                    int findByYear = checkInput.checkInt("Введіть курс для пошуку: ", "Ви ввели курс неправильно.");

                    List<Student> results1 = findByYear(findByYear);
                    if (results1.isEmpty()) {
                        System.out.println("Студентів такого курсу не знайдено");
                    } else {
                        System.out.println("Знайдено студентів: " + results1.size());
                        for (Student s : results1) {
                            System.out.println("- " + s);
                        }
                    }
                    getMenu().studentMenu();
                    break;
                case 3:
                    int findByGroup = checkInput.checkInt("Введіть групу для пошуку: ", "Ви ввели групу неправильно.");
                    List<Student> results2 = findByGroup(findByGroup);
                    if (results2.isEmpty()) {
                        System.out.println("Студентів такої групи не знайдено");
                    } else {
                        System.out.println("Знайдено студентів: " + results2.size());
                        for (Student s : results2) {
                            System.out.println("- " + s);
                        }
                    }
                    getMenu().studentMenu();
                    break;
            }
    }

    public void findingTeacher() throws IOException {
        int teacherFindingQuestion = getMenu().teacherFindingQuestion();
        switch(teacherFindingQuestion){
            case 0:
                getMenu().mainMenu();
            case 1:
                System.out.println("Введіть ПІБ для пошуку: ");
                String findBySNMt = checkInput.checkString("Введіть ПІБ для пошуку: ", "Ви не ввели ПІБ для пошуку.");

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
                getMenu().teacherMenu();
                break;

        }
    }

    public List<Teacher> findBySNMt(String snm) {
        List<Teacher> foundTeachers = new ArrayList<>();
        if (snm == null || snm.isEmpty()) return foundTeachers;

        for (Teacher teacher :allObjects.allTeachers()) {
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
        List<Student> foundStudents = new ArrayList<>();
        if (snm == null || snm.isEmpty()) return foundStudents;

        for (Student student :allObjects.allStudents()) {
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
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allObjects.allStudents()) {
            if (student != null && year == student.getCourseNumber() ) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }

    public List<Student> findByGroup(int group) {
        List<Student> foundStudents = new ArrayList<>();

        for (Student student :allObjects.allStudents()) {
            if (student != null && group == student.getGroupNumber() ) {
                foundStudents.add(student);
            }
        }
        return foundStudents;
    }




}
