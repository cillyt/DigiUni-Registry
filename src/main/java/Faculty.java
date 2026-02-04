public class Faculty{
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

}
