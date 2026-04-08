import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter

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

    String uni;
    String faculty;
    String department;

    Person(int personID, String personSurname, String personName, String middleName, int yearOfBirth, int monthOfBirth, int dayOfBirth, String personEmail, long personPhone, String uni, String faculty, String department) {
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

    Person(){}

    public void setPersonID(int personID) throws IOException {
            if(this.personID != personID) {
                while (Main.IDs.contains(personID)) {
                    System.out.println("Цей ідентифікаційний код вже зайнято іншою особою!!");
                    personID = Main.checkInput.checkInt("Унікальний ідентифікатор: ", "Ви ввели унікальний ідентифікатор неправильно.");
                }
            }
            this.personID = personID;
            Main.IDs.add(personID);
    }

    public void setPersonEmail(String personEmail) throws IOException {
        if(this.personEmail != personEmail) {
            while (Main.emails.contains(personEmail)) {
                System.out.println("Ця пошта вже зайнята іншою особою!!");
                personEmail = Main.checkInput.checkString("Електронна пошта: ", "Ви не ввели електронну пошту викладача.");
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
