import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AutoSaveService implements Runnable {

    private final List<University> universities;
    private final long intervalMs;
    private final String filePath;

    public AutoSaveService(List<University> universities, long intervalMs, String filePath) {
        this.universities = universities;
        this.intervalMs = intervalMs;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        while (true) {
            try {
                saveToFile();
                System.out.println("Дані збережено: " + java.time.LocalTime.now());
                Thread.sleep(intervalMs);
            } catch (InterruptedException e) {
                System.out.println("Автозбереження зупинено");
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void saveToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            if(!universities.isEmpty()){
                writer.write("==Університети==");
                writer.write("\n");
            }
            for (University uni : universities) {
                writer.write(uni.toString());
                if(!uni.faculties.isEmpty()){
                    writer.write("\n");
                    writer.write("==Факультети==");
                    writer.write("\n");
                }
                for (Faculty faculty : uni.faculties) {
                    writer.write(faculty.toString());

                    if (!faculty.departments.isEmpty()) {
                        writer.write("\n");
                        writer.write("==Кафедри==");
                        writer.write("\n");
                    }
                    for (Department dept : faculty.departments) {
                        writer.write(dept.toString());

                        if(!dept.students.isEmpty()){
                            writer.write("\n");
                            writer.write("==Студенти==");
                            writer.write("\n");
                        }
                        for (Student student : dept.students) {
                            writer.write(student.toString());
                        }

                        if(!dept.teachers.isEmpty()) {
                            writer.write("\n");
                            writer.write("==Викладачі==");
                            writer.write("\n");
                        }
                        for (Teacher teacher : dept.teachers) {
                            writer.write(teacher.toString());
                        }
                        writer.write("\n");
                    }
                    writer.write("\n");
                }
                writer.write("\n\n");
            }
        }
    }
}
