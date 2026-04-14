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
    Authorization.Email facultyEmail;

    Faculty (String facultyCode, String facultyName, String shortFacultyName, long facultyPhoneNumber, Authorization.Email facultyEmail){
        this.facultyCode = facultyCode;
        this.facultyName = facultyName;
        this.shortFacultyName = shortFacultyName;

        this.facultyPhoneNumber = facultyPhoneNumber;
        this.facultyEmail = facultyEmail;
    }

    Faculty(){}


    @Override
    public String toString() {
        String facultyDecanPIB = "; декан факультету: немає";
        if (this.facultyDecan != null) {
            facultyDecanPIB = "; декан факультету: " + this.facultyDecan.personSurname + " " + this.facultyDecan.personName + " " + this.facultyDecan.middleName;
        }
        return "Код факультету: " +  facultyCode + "; назва факультету: " + facultyName + "; скорочена назва факультету: " + shortFacultyName + facultyDecanPIB + "\nномер телефону факультету: " + facultyPhoneNumber + "; електронна пошта факультету: " + facultyEmail;
    }

}
