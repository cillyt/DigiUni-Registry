import java.util.ArrayList;
import java.util.List;

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
    public Teacher getHeadOfDepart() {
        return headOfDepart;
    }
    public void setHeadOfDepart(Teacher headOfDepart) {
        this.headOfDepart = headOfDepart;
    }



    @Override
    public String toString() {
        return "Код кафедри: " +  departmentCode +", назва кафедри: " + departmentName + ", номер кабінету: " + cabinetNumber;
    }
}
