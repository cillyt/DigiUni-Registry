public class Teacher extends Person{
    String teacherPosition;
    String academicDegree;
    String academicTitle;
    int yearOfEntry;
    String rate;

    Teacher(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, String personPhone, String teacherPosition, String academicDegree, String academicTitle, int yearOfEntry, String rate) {
        super(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone);
        this.teacherPosition = teacherPosition;
        this.academicDegree = academicDegree;
        this.academicTitle = academicTitle;
        this.yearOfEntry = yearOfEntry;
        this.rate = rate;
    }
}
