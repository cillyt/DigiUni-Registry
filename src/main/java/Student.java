public class Student extends Person {
    int studentID;
    int courseNumber; //+ перевірка чи в межах 1-6
    int groupNumber;
    int yearOfEntry;
    String studyForm; //ТІЛЬКИ бюджет чи контракт
    String studentStatus; // навчається/ академвідпустка/ відрахований

    Student(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, String personPhone, int studentID, int courseNumber, int groupNumber, int yearOfEntry, String studyForm, String studentStatus) {
        super(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone);
        this.studentID = studentID;
        this.courseNumber = courseNumber;
        this.groupNumber = groupNumber;
        this.yearOfEntry = yearOfEntry;
        this.studyForm = studyForm;
        this.studentStatus = studentStatus;
    }
}

