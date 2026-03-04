import java.time.LocalDate;
import java.time.Period;

public class Teacher extends Person{
    String teacherPosition;
    String academicDegree;
    String academicTitle;
    int yearOfEntry;
    int monthOfEntry;
    int dayOfEntry;
    String rate;
    boolean decan;
    boolean headOfDepartment;


    Teacher(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, String personEmail, long personPhone, String teacherPosition, String academicDegree, String academicTitle, int yearOfEntry, int monthOfEntry, int dayOfEntry, String rate, boolean decan, boolean headOfDepartment) {
        super(personID, personSurname, personName, middleName, yearOfBirth, monthOfBirth, dayOfBirth, personEmail, personPhone);
        this.teacherPosition = teacherPosition;
        this.academicDegree = academicDegree;
        this.academicTitle = academicTitle;
        this.yearOfEntry = yearOfEntry;
        this.monthOfEntry = monthOfEntry;
        this.dayOfEntry = dayOfEntry;
        this.rate = rate;
        this.decan = decan;
        this.headOfDepartment = headOfDepartment;
    }

    public String getTeacherPosition() {return teacherPosition;}
    public void setTeacherPosition(String teacherPosition) {this.teacherPosition = teacherPosition;}
    public String getAcademicDegree() {
        return academicDegree;
    }
    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }
    public String getAcademicTitle() {
        return academicTitle;
    }
    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }
    public int getYearOfEntry() {
        return yearOfEntry;
    }
    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }
    public int getMonthOfEntry() {
        return yearOfEntry;
    }
    public void setMonthOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }
    public int getDayOfEntry() {
        return yearOfEntry;
    }
    public void setDayOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }

    public LocalDate getDateOfEntry(){
        LocalDate dateOfEntry = LocalDate.of(yearOfEntry, monthOfEntry, dayOfEntry);
        return dateOfEntry;
    }

    public String getWorkExperience(){
        LocalDate dateOfEntry = getDateOfEntry();
        Period workExperience = Period.between(dateOfEntry, LocalDate.now());
        return  String.format("%d років, %d місяців та %d днів", workExperience.getYears(), workExperience.getMonths(), workExperience.getDays());
    }

    @Override
    public String toString() {
        getWorkExperience();
        return "Унікальний ідентифікатор: " +  personID + "\nПрізвище: " + personSurname + "\nІм'я: " + personName + "\nПо-батькові: " + middleName + "\nДата народження: " + getDateOfBirth() +"\nВік: " + getPersonAge() + "\nЕлектронна пошта: " + personEmail + "\nНомер телефону: " + personPhone + "\nПосада: " + teacherPosition + "\nНауковий ступінь: " + academicDegree + "\nВчене звання: " + academicTitle + "\nДата прийняття на роботу: " + getDateOfEntry() + "\nСтавка: " + rate + "\nСтаж: " + getWorkExperience();
    }

}
