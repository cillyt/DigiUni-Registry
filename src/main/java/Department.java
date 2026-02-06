import java.util.ArrayList;
import java.util.List;

public class Department{
    static List<Student> students = new ArrayList<>();
    static List<Teacher> teachers = new ArrayList<>();
    String departmentCode;
    String departmentName;
    //+ факультет посилання
    //+ завідувач посилання на викладача
    int cabinetNumber;

    Department(String departmentCode, String departmentName, int cabinetNumber) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.cabinetNumber = cabinetNumber;
    }
    public String getDepartmentCode() {
        return departmentCode;
    }
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public int getCabinetNumber() {
        return cabinetNumber;
    }
    public void setCabinetNumber(int cabinetNumber) {
        this.cabinetNumber = cabinetNumber;
    }



    @Override
    public String toString() {
        return "Код кафедри: " +  departmentCode +", назва кафедри: " + departmentName + ", номер кабінету: " + cabinetNumber;
    }
}
