public class Student extends Person {
    int studentID;
    int courseNumber; //+ перевірка чи в межах 1-6
    int groupNumber;
    int yearOfEntry;
    boolean studyForm; //ТІЛЬКИ бюджет чи контракт
    String studentStatus; // навчається/ академвідпустка/ відрахований

    Student(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, long personPhone, int courseNumber, int groupNumber, int yearOfEntry, boolean studyForm, String studentStatus) {
        super(personID, personSurname, personName, middleName, birthDate, personEmail, personPhone);
        this.studentID = personID;
        this.courseNumber = courseNumber;
        this.groupNumber = groupNumber;
        this.yearOfEntry = yearOfEntry;
        this.studyForm = studyForm;
        this.studentStatus = studentStatus;
    }

    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + ", прізвище: " + personSurname + ", ім'я: " + personName + ", по-батькові: " + middleName + ", дата народження: " + birthDate + ", електронна пошта: " + personEmail + ", номер телефону: " + personPhone + ", курс: " + courseNumber + ", група: " + groupNumber + ", рік вступу: " + yearOfEntry + ", форма навчання: " + studyForm + ", статус: " + studentStatus;
    }

}

