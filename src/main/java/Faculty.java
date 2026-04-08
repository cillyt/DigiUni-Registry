import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
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

    Faculty(){}


    @Override
    public String toString() {
        String facultyDecanPIB = "\nДекан факультету: немає";
        if (this.facultyDecan != null) {
            facultyDecanPIB = "\nДекан факультету: " + this.facultyDecan.personSurname + " " + this.facultyDecan.personName + " " + this.facultyDecan.middleName;
        }
        return "Код факультету: " +  facultyCode + "\nНазва факультету: " + facultyName + "\nСкорочена назва факультету: " + shortFacultyName + facultyDecanPIB + "\nНомер телефону факультету: " + facultyPhoneNumber + "\nЕлектронна пошта факультету: " + facultyEmail;
    }

}
