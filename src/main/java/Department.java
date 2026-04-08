import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Department{
    List<Student> students = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    String departmentCode;
    String departmentName;
    Teacher headOfDepart;
    int cabinetNumber;

    Department(String departmentCode, String departmentName, int cabinetNumber) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.cabinetNumber = cabinetNumber;
    }

    Department() {}


    @Override
    public String toString() {
        return "Код кафедри: " +  departmentCode +"\nНазва кафедри: " + departmentName + "\nНомер кабінету: " + cabinetNumber;
    }
}
