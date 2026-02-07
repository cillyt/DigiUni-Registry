public class Student extends Person {
    int courseNumber; //+ перевірка чи в межах 1-6
    int groupNumber;
    int yearOfEntry;
    String studyForm; //ТІЛЬКИ бюджет чи контракт
    String studentStatus; // навчається/ академвідпустка/ відрахований

    Student(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, long personPhone, int courseNumber, int groupNumber, int yearOfEntry, String studyForm, String studentStatus) {
        super(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone);
        this.courseNumber = courseNumber;
        this.groupNumber = groupNumber;
        this.yearOfEntry = yearOfEntry;
        this.studyForm = studyForm;
        this.studentStatus = studentStatus;
    }

    public int getCourseNumber() {
        return courseNumber;
    }
    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }
    public int getGroupNumber() {
        return groupNumber;
    }
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
    public int getYearOfEntry() {
        return yearOfEntry;
    }
    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }
    public String isStudyForm() {
        return studyForm;
    }
    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }
    public String getStudentStatus() {
        return studentStatus;
    }
    public void setStudentStatus(String studentStatus) {
        this.studentStatus = studentStatus;
    }





    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + ", прізвище: " + personSurname + ", ім'я: " + personName + ", по-батькові: " + middleName + ", дата народження: " + birthDate + ", електронна пошта: " + personEmail + ", номер телефону: " + personPhone + ", курс: " + courseNumber + ", група: " + groupNumber + ", рік вступу: " + yearOfEntry + ", форма навчання: " + studyForm + ", статус: " + studentStatus;
    }

}

