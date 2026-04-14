import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
                    if (results.isEmpty())
                        System.out.println("Студентів з таким ПІБ не знайдено");
                    else {
                        System.out.println("Знайдено студентів: " + results.size());
                        int i = 1;
                        for (Student s : results) {
                            System.out.println(i + ". " + s);
                            System.out.print("-------------------------------------------------------\n");
                            i++;
                        }
                    }
                    getMenu().studentMenu();
                    break;
                case 2:
                    int findByYear = checkInput.checkInt("Введіть курс для пошуку: ", "Ви ввели курс неправильно.");
                    List<Student> results1 = findByYear(findByYear);

                    if (results1.isEmpty())
                        System.out.println("Студентів такого курсу не знайдено");
                    else {
                        System.out.println("Знайдено студентів: " + results1.size());
                        int i = 1;
                        for (Student s : results1) {
                            System.out.println(i + ". " + s);
                            System.out.print("-------------------------------------------------------\n");
                            i++;
                        }
                    }
                    getMenu().studentMenu();
                    break;
                case 3:
                    int findByGroup = checkInput.checkInt("Введіть групу для пошуку: ", "Ви ввели групу неправильно.");
                    List <Student> results2 = findByGroup(findByGroup);

                    if (results2.isEmpty()) {
                        System.out.println("Студентів такої групи не знайдено");
                    } else {
                        System.out.println("Знайдено студентів: " + results2.size());
                        int i = 1;
                        for (Student s : results2) {
                            System.out.println(i + ". " + s);
                            System.out.print("-------------------------------------------------------\n");
                            i++;
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
                String findBySNMt = checkInput.checkString("Введіть ПІБ для пошуку: ", "Ви не ввели ПІБ для пошуку.");
                List<Teacher> results = findBySNMt(findBySNMt);

                if (results.isEmpty())
                    System.out.println("Викладачів з таким ПІБ не знайдено");
                else {
                    System.out.println("Знайдено викладачів: " + results.size());
                    int i = 1;
                    for (Teacher t : results) {
                        System.out.println(i + ". " + t);
                        System.out.print("-------------------------------------------------------\n");
                        i++;
                    }
                }
                getMenu().teacherMenu();
                break;

        }
    }

    public List<Teacher> findBySNMt(String snm) {
        String regex = "(?i).*" + Pattern.quote(snm) + ".*";
        Pattern pattern = Pattern.compile(regex);

        return allObjects.allTeachers().stream().filter(teacher -> {
                    String fullSNM = teacher.getPersonSurname() + " " + teacher.getPersonName() + " " + teacher.getMiddleName();
                    return pattern.matcher(fullSNM).find();
        } )
        .toList();
    }

    public List<Student> findBySNM(String snm) {
        String regex = "(?i).*" + Pattern.quote(snm) + ".*";
        Pattern pattern = Pattern.compile(regex);

        return allObjects.allStudents().stream().filter(student -> {
                    String SNM = student.getPersonSurname() + " " + student.getPersonName() + " " + student.getMiddleName();
                    return pattern.matcher(SNM).find();
        })
        .toList();
    }

    public List<Student> findByYear(int year) {
        return allObjects.allStudents().stream().filter(student -> student.courseNumber == year)
        .toList();
    }

    public List<Student> findByGroup(int group) {
        return allObjects.allStudents().stream().filter(student -> student.groupNumber == group)
        .toList();
    }




}
