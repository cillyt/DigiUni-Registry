import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class Reports {
    AllObjects allObjects = Main.allObjects;
    Menu menu = Main.menu;
    List<Student> allStudents;
    List<Teacher> allTeachers;

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
                Operations.universities.get(uni).faculties.get(faculty).departments.get(depart).students.sort(Comparator.comparing(Student::getCourseNumber));
                for(Student s : Operations.universities.get(uni).faculties.get(faculty).departments.get(depart).students){
                    System.out.print(s + "\n");
                }
                break;
        }

        menu.mainMenu();
    }

}
