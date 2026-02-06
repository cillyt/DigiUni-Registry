public class Teacher extends Person{
    String teacherPosition;
    String academicDegree;
    String academicTitle;
    int yearOfEntry;
    String rate;

    Teacher(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, long personPhone, String teacherPosition, String academicDegree, String academicTitle, int yearOfEntry, String rate) {
        super(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone);
        this.teacherPosition = teacherPosition;
        this.academicDegree = academicDegree;
        this.academicTitle = academicTitle;
        this.yearOfEntry = yearOfEntry;
        this.rate = rate;
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
    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }


    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + ", прізвище: " + personSurname + ", ім'я: " + personName + ", по-батькові: " + middleName + ", дата народження: " + birthDate + ", електронна пошта: " + personEmail + ", номер телефону: " + personPhone + ", посада: " + teacherPosition + ", науковий ступінь: " + academicDegree + ", вчене звання: " + academicTitle + ", дата прийняття на роботу: " + yearOfEntry + ", ставка: " + rate;
    }

}
