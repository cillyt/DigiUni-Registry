public class Person{
    int personID;
    String personSurname;
    String personName;
    String middleName;
    String birthDate;
    String personEmail;
    long personPhone;

    Person(int personID, String personSurname, String personName, String middleName, String birthDate, String personEmail, long personPhone) {
        this.personID = personID;
        this.personSurname = personSurname;
        this.personName = personName;
        this.middleName = middleName;
        this.birthDate = birthDate;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
    }

    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + ", прізвище: " + personSurname + ", ім'я: " + personName + ", по-батькові: " + middleName + ", дата народження: " + birthDate + ", електронна пошта: " + personEmail + ", номер телефону: " + personPhone;
    }

}
