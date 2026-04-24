import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Teacher t;
    private Student s;
    private Authorization.User a;
    private Authorization.User a1;
    Authorization au = new Authorization();

    @BeforeEach
    void setUp() {
        Authorization.Email e1 = new Authorization.Email("@1");
        Authorization.Email e2 = new Authorization.Email("@2");
        t = new Teacher(1, "1", "1", "1", 1, 1, 1, e1, 1, "1", "1", "1", "1", "1", "1", 1, 1, 1, "1", false, false);
        s = new Student(2, "1", "1", "1", 1, 1, 1, e2, 1, "1", "1", "1", 1, 1, 1, "Бюджет", "Навчається");
        Main.IDs.add(1);
        Main.IDs.add(2);
        Main.emails.add(e1);
        Main.emails.add(e2);
        Authorization.Email email = new Authorization.Email("@");
        a = new Authorization.User(email, "1");
        a1 = new Authorization.User(email, "1");
    }

    @Test
    public void testAddingTeacher() {
        int month = t.getMonthOfEntry();
        assertEquals(1, month);
    }
    @Test
    public void testTeacherExperience(){
        String experience = t.getWorkExperience();
        assertEquals("2025 років, 3 місяців та 23 днів", experience);
    }
    @Test
    public void personAge(){
        int ageTea = t.getPersonAge();
        assertEquals(2025, ageTea);
        int ageStu = s.getPersonAge();
        assertEquals(2025, ageStu);
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


}