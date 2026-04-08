import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;
@Setter
@Getter
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


    Teacher(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth,
            String personEmail, long personPhone, String uni, String faculty, String department, String teacherPosition, String academicDegree,
            String academicTitle, int yearOfEntry, int monthOfEntry, int dayOfEntry, String rate, boolean decan, boolean headOfDepartment) {
        super(personID, personSurname, personName, middleName, yearOfBirth, monthOfBirth, dayOfBirth, personEmail, personPhone, uni, faculty, department);
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

    Teacher(){
        super();
    }

    public boolean getDecanStatus(){return decan;}
    public void setDecanStatus(boolean decan){this.decan = decan;}
    public boolean getHeadOfDepartmentStatus(){return headOfDepartment;}
    public void setHeadOfDepartmentStatus(boolean headOfDepartment){this.headOfDepartment = headOfDepartment;}

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
        return "Унікальний ідентифікатор: " +  personID + "\nПрізвище: " + personSurname + "\nІм'я: " + personName + "\nПо-батькові: " + middleName + "\nДата народження: " + getDateOfBirth() +"\nВік: " + getPersonAge() + "\nЕлектронна пошта: " + personEmail + "\nНомер телефону: " + personPhone +"\nВикладає: " + uni + ", " + faculty + ", " + department + "\nПосада: " + teacherPosition + "\nНауковий ступінь: " + academicDegree + "\nВчене звання: " + academicTitle + "\nДата прийняття на роботу: " + getDateOfEntry() + "\nСтавка: " + rate + "\nСтаж: " + getWorkExperience();
    }

}
