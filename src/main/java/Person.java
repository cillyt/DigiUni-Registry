import java.time.LocalDate;
import java.time.Period;

public class Person{
    int personID;
    String personSurname;
    String personName;
    String middleName;

    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;

    //String birthDate;
    String personEmail;
    long personPhone;

    Person(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, String personEmail, long personPhone) {
        this.personID = personID;
        this.personSurname = personSurname;
        this.personName = personName;
        this.middleName = middleName;

        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;

        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }

    public int getPersonID() {
        return personID;
    }
    public void setPersonID(int personID) {
        this.personID = personID;
    }
    public String getPersonSurname() {
        return personSurname;
    }
    public void setPersonSurname(String personSurname) {
        this.personSurname = personSurname;
    }
    public String getPersonName() {
        return personName;
    }
    public void setPersonName(String personName) {
        this.personName = personName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public int getYearOfBirth() {return yearOfBirth;}
    public void setYearOfBirth(int yearOfBirth) {this.yearOfBirth = yearOfBirth;}
    public int getMonthOfBirth() {return monthOfBirth;}
    public void setMonthOfBirth(int monthOfBirth) {this.monthOfBirth = monthOfBirth;}
    public int getDayOfBirth() {return dayOfBirth;}
    public void setDayOfBirth(int dayOfBirth) {this.dayOfBirth = dayOfBirth;}

    public String getPersonEmail() {
        return personEmail;
    }
    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }
    public long getPersonPhone() {
        return personPhone;
    }
    public void setPersonPhone(long personPhone) {
        this.personPhone = personPhone;
    }


    public LocalDate getDateOfBirth() {
        return LocalDate.of(this.yearOfBirth, this.monthOfBirth, this.dayOfBirth);
    }

    public int getPersonAge(){
        getDateOfBirth();
        Period personAge = Period.between(getDateOfBirth(), LocalDate.now());
        return personAge.getYears();
    }

    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + "\nПрізвище: " + personSurname + "\nІм'я: " + personName + "\nПо-батькові: " + middleName + "\nДата народження: " + getDateOfBirth() +"\nВік: " + getPersonAge() + "\nЕлектронна пошта: " + personEmail + "\nНомер телефону: " + personPhone;
    }

}
