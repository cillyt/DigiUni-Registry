import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Teacher t;
    private Student s;
    private User a;
    private User a1;
    Authorization au = new Authorization();

    @BeforeEach
    void setUp() {
        t = new Teacher(1, "1", "1", "1", 1, 1, 1, "1", 1, "1", "1", "1", 1, 1, 1, "1", false, false);
        s = new Student(1, "1", "1", "1", 1, 1, 1, "1", 1, 1, 1, 1, "Бюджет", "Навчається");
        a = new User("a", "1");
        a1 = new User("a", "1");
    }

    @Test
    public void testAddingTeacher() {
        int month = t.getMonthOfEntry();
        assertEquals(1, month);
    }
    @Test
    public void testTeacherExperience(){
        String experience = t.getWorkExperience();
        assertEquals("2025 років, 2 місяців та 9 днів", experience);
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
}