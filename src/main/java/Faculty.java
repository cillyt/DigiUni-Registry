import java.util.ArrayList;
import java.util.List;

public class Faculty{
    List<Department> departments = new ArrayList<>();
    String facultyCode;
    String facultyName;
    String shortFacultyName;
    Teacher facultyDecan;
    long facultyPhoneNumber;
    String facultyEmail;

    Faculty (String facultyCode, String facultyName, String shortFacultyName, long facultyPhoneNumber, String facultyEmail){
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
        this.shortFacultyName = shortFacultyName;

        this.facultyPhoneNumber = facultyPhoneNumber;
        this.facultyEmail = facultyEmail;
    }

    public String getFacultyCode() {
        return facultyCode;
    }
    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }
    public String getFacultyName() {
        return facultyName;
    }
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
    public String getShortFacultyName() {
        return shortFacultyName;
    }
    public void setShortFacultyName(String shortFacultyName) {
        this.shortFacultyName = shortFacultyName;
    }
    public long getFacultyPhoneNumber() {
        return facultyPhoneNumber;
    }
    public void setFacultyPhoneNumber(long facultyPhoneNumber) {
        this.facultyPhoneNumber = facultyPhoneNumber;
    }
    public String getFacultyEmail() {
        return facultyEmail;
    }
    public void setFacultyEmail(String facultyEmail) {
        this.facultyEmail = facultyEmail;
    }

    public Teacher getFacultyDecan() {
        return facultyDecan;
    }
    public void setFacultyDecan(Teacher facultyDecan) {
        this.facultyDecan = facultyDecan;
    }

    @Override
    public String toString() {
        String facultyDecanPIB = "\nДекан факультету: немає";
        if (this.facultyDecan != null) {
            facultyDecanPIB = "\nДекан факультету: " + this.facultyDecan.personSurname + " " + this.facultyDecan.personName + " " + this.facultyDecan.middleName;
        }
        return "Код факультету: " +  facultyCode + "\nНазва факультету: " + facultyName + "\nСкорочена назва факультету: " + shortFacultyName + facultyDecanPIB + "\nНомер телефону факультету: " + facultyPhoneNumber + "\nЕлектронна пошта факультету: " + facultyEmail;
    }

}
