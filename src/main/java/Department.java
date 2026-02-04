public class Department{
    String departmentCode;
    String departmentName;
    //+ факультет посилання
    //+ завідувач посилання на викладача
    String cabinetNumber;

    Department(String departmentCode, String departmentName, String cabinetNumber) {
        this.departmentCode = departmentCode;
        this.departmentName = departmentName;
        this.cabinetNumber = cabinetNumber;
    }
}
