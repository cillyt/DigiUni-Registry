import java.util.ArrayList;
import java.util.List;

public class AllObjects {
    Operations operations = new Operations();

    public List<Teacher> allTeachers(){
        ArrayList<Teacher> allTeachers = new ArrayList<>();
        for(University u : operations.universities){
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

    public List<Student> allStudents(){
        ArrayList<Student> allStudents = new ArrayList<>();
        for(University u : operations.universities){
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

    public List<Department> allDepartments(){
        ArrayList<Department> allDepartments = new ArrayList<>();
        for(University u : operations.universities){
            for(Faculty f : u.faculties){
                for(Department d : f.departments){
                    allDepartments.add(d);
                }
            }
        }
        return allDepartments;
    }

    public List<Faculty> allFaculties(){
        ArrayList<Faculty> allFaculties = new ArrayList<>();
        for(University u : operations.universities){
            for(Faculty f : u.faculties){
                allFaculties.add(f);
            }
        }
        return allFaculties;
    }

    public List<Teacher> allTeachersByFaculty(Faculty faculty){
        List<Teacher> allTeachersByFaculty = new ArrayList<>();
            for(Department d : faculty.departments)
                for(Teacher t : d.teachers)
                    allTeachersByFaculty.add(t);


        return allTeachersByFaculty;
    }


}
