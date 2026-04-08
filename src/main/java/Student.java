import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Person {
    int courseNumber; //+ перевірка чи в межах 1-6
    int groupNumber;
    int yearOfEntry;
    String studyForm; //ТІЛЬКИ бюджет чи контракт
    String studentStatus; // навчається/ академвідпустка/ відрахований

    Student(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, String personEmail, long personPhone,String uni, String faculty, String department, int courseNumber, int groupNumber, int yearOfEntry, String studyForm, String studentStatus) {
        super(personID, personSurname, personName, middleName, yearOfBirth, monthOfBirth, dayOfBirth, personEmail, personPhone, uni, faculty, department);
        this.courseNumber = courseNumber;
        this.groupNumber = groupNumber;
        this.yearOfEntry = yearOfEntry;
        this.studyForm = studyForm;
        this.studentStatus = studentStatus;
    }

    Student(){
        super();
    }

    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + "\nПрізвище: " + personSurname + "\nІм'я: " + personName + "\nПо-батькові: " + middleName + "\nДата народження: " + getDateOfBirth() +"\nВік: " + getPersonAge() + "\nЕлектронна пошта: " + personEmail + "\nНомер телефону: " + personPhone +"\nНавчається: " + uni + ", " + faculty + ", " + department+ "\nКурс: " + courseNumber + "\nГрупа: " + groupNumber + "\nРік вступу: " + yearOfEntry + "\nФорма навчання: " + studyForm + "\nСтатус: " + studentStatus;
    }

}

