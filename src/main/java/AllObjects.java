import java.util.ArrayList;
import java.util.List;

public class AllObjects {
    public List<Teacher> allTeachers(){
        ArrayList<Teacher> allTeachers = new ArrayList<>();
        for(University u : Main.universities){
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
        for(University u : Main.universities){
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
        for(University u : Main.universities){
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
        for(University u : Main.universities){
            for(Faculty f : u.faculties){
                allFaculties.add(f);
            }
        }
        return allFaculties;
    }


    public List<Teacher> allTeachersByUni(University uni){
        List<Teacher> allTeachersByUni = new ArrayList<>();

        for (Faculty f : uni.faculties)
            for(Department d : f.departments)
                for(Teacher t : d.teachers)
                    allTeachersByUni.add(t);


        return allTeachersByUni;
    }


    public List<Teacher> allTeachersByFaculty(Faculty f){
        List<Teacher> allTeachersByFaculty = new ArrayList<>();
            for(Department d : f.departments)
                for(Teacher t : d.teachers)
                    allTeachersByFaculty.add(t);


        return allTeachersByFaculty;
    }

    public List<Student> allStudentsByUni(University uni){
        List<Student> allStudentsByUni = new ArrayList<>();

        for (Faculty f : uni.faculties)
            for(Department d : f.departments)
                for(Student s : d.students)
                    allStudentsByUni.add(s);


        return allStudentsByUni;
    }



    public List<Student> allStudentsByFaculty(Faculty f){
        List<Student> allStudentsByFaculty = new ArrayList<>();
        for(Department d : f.departments)
            for(Student s : d.students)
                allStudentsByFaculty.add(s);


        return allStudentsByFaculty;
    }

    public List<Department> allDepartmentsByUni(University uni){
        List<Department> allDepartmentsByUni = new ArrayList<>();
        for(Faculty f : uni.faculties)
            for(Department d : f.departments)
                allDepartmentsByUni.add(d);


        return allDepartmentsByUni;
    }









}
