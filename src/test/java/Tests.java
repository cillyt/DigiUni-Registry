import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    private Teacher t;
    private Student s;

    @BeforeEach
    void setUp() {
        t = new Teacher(1, "1", "1", "1", 1, 1, 1, "1", 1, "1", "1", "1", 1, 1, 1, "1", false, false);
        s = new Student(1, "1", "1", "1", 1, 1, 1, "1", 1, 1, 1, 1, "Бюджет", "Навчається");
    }

    @Test
    public void testAddingTeacher() {
        int month = t.getMonthOfEntry();
        assertEquals(1, month);
    }
    @Test
    public void testTeacherExperience(){
        String experience = t.getWorkExperience();
        assertEquals("2025 років, 2 місяців та 3 днів", experience);
    }
    @Test
    public void personAge(){
        int ageTea = t.getPersonAge();
        assertEquals(2025, ageTea);
        int ageStu = s.getPersonAge();
        assertEquals(2025, ageStu);
    }
}