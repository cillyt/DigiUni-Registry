public class Department{
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

    @Override
    public String toString() {
        return "Код кафедри: " +  departmentCode +", назва кафедри: " + departmentName + ", номер кабінету: " + cabinetNumber;
    }
}
