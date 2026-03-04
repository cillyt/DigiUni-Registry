public class Student extends Person {
    int courseNumber; //+ перевірка чи в межах 1-6
    int groupNumber;
    int yearOfEntry;
    String studyForm; //ТІЛЬКИ бюджет чи контракт
    String studentStatus; // навчається/ академвідпустка/ відрахований

    Student(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, String personEmail, long personPhone, int courseNumber, int groupNumber, int yearOfEntry, String studyForm, String studentStatus) {
        super(personID, personSurname, personName, middleName, yearOfBirth, monthOfBirth, dayOfBirth, personEmail, personPhone);
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
        return "Унікальний ідентифікатор: " +  personID + "\nПрізвище: " + personSurname + "\nІм'я: " + personName + "\nПо-батькові: " + middleName + "\nДата народження: " + getDateOfBirth() +"\nВік: " + getPersonAge() + "\nЕлектронна пошта: " + personEmail + "\nНомер телефону: " + personPhone + "\nКурс: " + courseNumber + "\nГрупа: " + groupNumber + "\nРік вступу: " + yearOfEntry + "\nФорма навчання: " + studyForm + "\nСтатус: " + studentStatus;
    }

}

