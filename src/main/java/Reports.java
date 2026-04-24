import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Reports {
    AllObjects allObjects = Main.allObjects;
    public Menu getMenu() {
        return Main.menu;
    }
    List<Student> allStudents;
    List<Teacher> allTeachers;

    //додати перевірку, коли будуть звіти з викладачами
    public void reports() throws Exception {
        int rep =getMenu().reportQuestion();
        int uni;
        int faculty;
        int depart;
        int studOrTeach;
        switch(rep){
            case 0:
               getMenu().mainMenu();
                break;
            case 1://студенти впорядковані за курсами
                allStudents = allObjects.allStudents();
                allStudents.sort(Comparator.comparing(Student::getCourseNumber));

                writeReportStudent(allStudents);
                break;

            case 2://всі студенти кафедри впорядковані за курсом
                uni =getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
                faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 3);
                depart =getMenu().departmentQuestionWithStudents(uni, faculty);
                Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.sort(Comparator.comparing(Student::getCourseNumber));

                writeReportStudent(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students);
                break;

            case 3://всі студенти/викладачі факультету, впорядковані за алфавітом.
                studOrTeach = getMenu().studentsOrTeachersReportQuestion();
                switch(studOrTeach){
                    case 1:
                        uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
                        faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 3);

                        List<Student> alphabetSFaculty = allObjects.allStudentsByFaculty(Main.universities.get(uni).faculties.get(faculty));
                        alphabetSFaculty.sort(Comparator.comparing(Student::getPersonName));
                        writeReportStudent(alphabetSFaculty);
                        break;

                    case 2:
                        uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(4);
                        faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 4);

                        List<Teacher> alphabetTFaculty = allObjects.allTeachersByFaculty(Main.universities.get(uni).faculties.get(faculty));
                        alphabetTFaculty.sort(Comparator.comparing(Teacher::getPersonName));
                        writeReportTeacher(alphabetTFaculty);
                        break;
                }
                break;
            case 4://всіх студентів/викладачів кафедри, впорядкованих за алфавітом.
                studOrTeach = getMenu().studentsOrTeachersReportQuestion();
                switch(studOrTeach){
                    case 1:
                        uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
                        faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 3);
                        depart = getMenu().departmentQuestionWithStudents(uni,faculty);

                        List<Student> alphabetSDepartment = Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students;
                        alphabetSDepartment.sort(Comparator.comparing(Student::getPersonName));
                        writeReportStudent(alphabetSDepartment);
                        break;

                    case 2:
                        uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(4);
                        faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 4);
                        depart = getMenu().departmentQuestionWithTeachers(uni,faculty);


                        List<Teacher> alphabetTDepartment = Main.universities.get(uni).faculties.get(faculty).departments.get(depart).teachers;
                        alphabetTDepartment.sort(Comparator.comparing(Teacher::getPersonName));
                        writeReportTeacher(alphabetTDepartment);
                        break;
                }
                break;
            case 5:
                uni = getMenu().universityQuestionWithFacultyDepartmentsOrStudents(3);
                faculty = getMenu().facultyQuestionWithDepartmentStudentsOrTeachers(uni, 3);
                depart = getMenu().departmentQuestionWithStudents(uni,faculty);
                int course = getMenu().courseQuestion();
                List<Student> studentsByCourse = new ArrayList<Student>(Main.universities.get(uni).faculties.get(faculty).departments.get(depart).students.stream()
                        .filter(s -> s.getCourseNumber() == course)
                        .toList()
                );

                System.out.println("Звичайний список:");
                writeReportStudent(studentsByCourse);

                System.out.println("За алфавітом:");
                studentsByCourse.sort(Comparator.comparing(Student::getPersonName));
                writeReportStudent(studentsByCourse);

        }

       getMenu().reportsAndSearchMenu();
    }

    private void writeReportStudent(List<Student> students){
        int i = 1;
        for(Student s : students){
            System.out.print(i + ". " + s + "\n");
            System.out.print("-------------------------------------------------------\n");
            i++;
        }

    }

    private void writeReportTeacher(List<Teacher> teachers){
        int i = 1;
        for(Teacher t : teachers){
            System.out.print(i + ". " + t + "\n");
            System.out.print("-------------------------------------------------------\n");
            i++;
        }

    }


}
