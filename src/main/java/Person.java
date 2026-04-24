import exсeptions.DuplicateObjectException;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class Person{
    int personID;
    String personSurname;
    String personName;
    String middleName;

    int yearOfBirth;
    int monthOfBirth;
    int dayOfBirth;

    //String birthDate;
    Authorization.Email personEmail;
    long personPhone;

    String uni;
    String faculty;
    String department;

    Person(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, Authorization.Email personEmail, long personPhone, String uni, String faculty, String department) {
        this.personID = personID;
        this.personSurname = personSurname;
        this.personName = personName;
        this.middleName = middleName;

        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.dayOfBirth = dayOfBirth;

        this.personEmail = personEmail;
        this.personPhone = personPhone;

        this.uni = uni;
        this.faculty = faculty;
        this.department = department;
    }

    Person(){}

    public void setPersonID(int personID) throws Exception {
            if(this.personID != personID) {
                while (Main.IDs.contains(personID)) {
                    log.warn("Цей ідентифікаційний код вже зайнятий іншою особою!");
                    throw new DuplicateObjectException("");
                }
            }
            this.personID = personID;
            Main.IDs.add(personID);
    }

    public void setPersonEmail(Authorization.Email personEmail) throws Exception {
        if(this.personEmail != null && !this.personEmail.equals(personEmail)) {
            while (Main.emails.contains(personEmail)) {
                log.warn("Ця пошта вже зайнята іншою особою!!");
                throw new DuplicateObjectException("");

                //System.out.println("Ця пошта вже зайнята іншою особою!!");
                //personEmail = Main.checkInput.checkEmail("Електронна пошта: ", "Ви не ввели електронну пошту викладача.");
            }
        }
        Main.emails.add(personEmail);
        this.personEmail = personEmail;
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
