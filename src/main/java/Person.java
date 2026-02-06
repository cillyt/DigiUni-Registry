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
    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
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

    @Override
    public String toString() {
        return "Унікальний ідентифікатор: " +  personID + ", прізвище: " + personSurname + ", ім'я: " + personName + ", по-батькові: " + middleName + ", дата народження: " + birthDate + ", електронна пошта: " + personEmail + ", номер телефону: " + personPhone;
    }

}
