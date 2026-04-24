import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Teacher t;
    private Student s;
    private Authorization.User a;
    private Authorization.User a1;
    Authorization au = new Authorization();

    private Authorization.Email teacherEmail;
    private Authorization.Email studentEmail;

    @BeforeEach
    void setUp() {
        Main.IDs.clear();
        Main.emails.clear();
        Authorization.allUsers.clear();
        Authorization.allManagers.clear();
        Authorization.allAdministrators.clear();
        Authorization.allUsersWithRoles.clear();

        teacherEmail = new Authorization.Email("teacher@ukma.ua");
        studentEmail = new Authorization.Email("student@ukma.ua");

        t = new Teacher(
                1, "Іваненко", "Іван", "Іванович",
                1990, 1, 10,
                teacherEmail, 1111111111L,
                "NaUKMA", "ФІ", "Інформатика",
                "Доцент", "PhD", "Доцент",
                2020, 9, 1,
                "1.0", false, true
        );

        s = new Student(
                2, "Петренко", "Марія", "Олександрівна",
                2004, 5, 20,
                studentEmail, 2222222222L,
                "NaUKMA", "ФІ", "Інформатика",
                2, 3, 2022,
                "Бюджет", "Навчається"
        );

        a = new Authorization.User(new Authorization.Email("lol@gmail.com"), "111");
        a1 = a;
    }

    @Test
    public void testAddingTeacher() {
        int month = t.getMonthOfEntry();
        assertEquals(9, month);
    }
    @Test
    public void testTeacherExperience(){
        String experience = t.getWorkExperience();
        assertEquals("5 років, 7 місяців та 23 днів", experience);
    }
    @Test
    public void personAge(){
        int ageTea = t.getPersonAge();
        assertEquals(36, ageTea);
        int ageStu = s.getPersonAge();
        assertEquals(21, ageStu);
    }

    @Test
    public void SameUsers(){
        boolean isAdded1 = au.allUsers.add(a);
        boolean isAdded2 = au.allUsers.add(a1);
        assertTrue(isAdded1);   //first added successfully
        assertFalse(isAdded2);  //second dont
    }
    
    @Test
    public void setID() throws Exception {
        t.setPersonID(1);
        assertEquals(1, t.personID);
    }

    @Test
    void studentCourseShouldBeCorrect() {
        assertEquals(2, s.getCourseNumber());
    }

    @Test
    void studentGroupShouldBeCorrect() {
        assertEquals(3, s.getGroupNumber());
    }

    @Test
    void personAgeShouldBePositive() {
        assertTrue(s.getPersonAge() > 0);
    }

    @Test
    void dateOfBirthShouldBeCorrect() {
        assertEquals(LocalDate.of(2004, 5, 20), s.getDateOfBirth());
    }

    @Test
    void setUniquePersonIdShouldWork() throws Exception {
        s.setPersonID(10);
        assertEquals(10, s.getPersonID());
    }

    @Test
    void setUniqueEmailShouldWork() throws Exception {
        Authorization.Email newEmail = new Authorization.Email("new@ukma.ua");
        s.setPersonEmail(newEmail);
        assertEquals(newEmail, s.getPersonEmail());
    }

    @Test
    void duplicateEmailShouldThrowException() {
        Main.emails.add(teacherEmail);
        assertThrows(Exception.class, () -> s.setPersonEmail(teacherEmail));
    }

    @Test
    void sameUsersShouldNotBeDuplicatedInSet() {
        Authorization.User u1 = new Authorization.User(new Authorization.Email("same@ukma.ua"), "123");
        Authorization.User u2 = new Authorization.User(new Authorization.Email("same@ukma.ua"), "456");

        boolean firstAdd = Authorization.allUsers.add(u1);
        boolean secondAdd = Authorization.allUsers.add(u2);

        assertTrue(firstAdd);
        assertFalse(secondAdd);
    }

    @Test
    void findExistingUserShouldReturnOptional() {
        Authorization.User user = new Authorization.User(new Authorization.Email("user@ukma.ua"), "111");
        Authorization.allUsersWithRoles.add(user);

        Optional<Authorization.BaseUser> result =
                Authorization.findEmail(new Authorization.Email("user@ukma.ua"));

        assertTrue(result.isPresent());
    }

    @Test
    void findMissingUserShouldReturnEmptyOptional() {
        Optional<Authorization.BaseUser> result =
                Authorization.findEmail(new Authorization.Email("missing@ukma.ua"));

        assertTrue(result.isEmpty());
    }

    @Test
    void teacherDeanStatusShouldChangeCorrectly() {
        t.setDecanStatus(true);
        assertTrue(t.getDecanStatus());
    }

    @ParameterizedTest
    @ValueSource(strings = {"valid1@ukma.ua", "student.test@naukma.edu", "admin123@gmail.com"})
    void validEmailsShouldBeAccepted(String email) {
        assertDoesNotThrow(() -> new Authorization.Email(email));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void validStudentCoursesShouldBeAccepted(int course) {
        s.setCourseNumber(course);
        assertEquals(course, s.getCourseNumber());
    }

    @ParameterizedTest
    @CsvSource({
            "2020, true",
            "2021, true",
            "2022, true"
    })
    void admissionYearShouldBeValid(int year, boolean expected) {
        s.setYearOfEntry(year);
        assertEquals(expected, s.getYearOfEntry() == year);
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "5, true",
            "10, true"
    })
    void groupNumbersShouldBeStoredCorrectly(int group, boolean expected) {
        s.setGroupNumber(group);
        assertEquals(expected, s.getGroupNumber() == group);
    }


}