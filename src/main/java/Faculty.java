import java.util.ArrayList;
import java.util.List;

public class Faculty{
    static List<Department> departments = new ArrayList<>();
    String facultyCode;
    String facultyName;
    String shortFacultyName;
    //+ декан (посилання на викладача)
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

    @Override
    public String toString() {
        return "Код факультету: " +  facultyCode + ", назва факультету: " + facultyName + ", скорочена назва факультету: " + shortFacultyName + ", номер телефону факультету: " + facultyPhoneNumber + ", електронна пошта факультету: " + facultyEmail;
    }

}
