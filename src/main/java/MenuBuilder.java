import java.lang.reflect.Method;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class MenuBuilder {
    private final Object target;

    public MenuBuilder(Object target) {
        this.target = target;
    }

    /*Показує меню для вказаного розділу і викликає обраний метод.
     * @param section  розділ: "student", "teacher", "university", "faculty", "department", "user"
     * @param title    заголовок меню
     * @param backLabel назва пункту "назад" (0)*/
    public void show(String section, String title, String backLabel) throws Exception {
        // 1. Збираємо всі методи з @MenuOption для цього розділу і доступної ролі
        List<Method> available = getAvailableMethods(section);

        if (available.isEmpty()) {
            log.warn("Немає доступних дій у цьому розділі.");
            return;
        }

        // 2. Виводимо меню
        System.out.println("=== " + title + " ===");
        System.out.println("0. " + backLabel);

        int i = 1;
        for (Method m : available) {
            MenuOption opt = m.getAnnotation(MenuOption.class);
            System.out.println(i + ". " + opt.label());
            i++;

        }

        // 3. Зчитуємо вибір
        int choice = Main.checkInput.checkOperations(0, available.size(), "Введіть номер дії: " ,"Номер дії введений неправильно.", "Дії під таким номером не існує.");

        if (choice == 0) return;

        // 4. Викликаємо обраний метод
        Method chosen = available.get(choice - 1);
        chosen.invoke(target);

    }

    /* Повертає список методів із @MenuOption, доступних для поточного користувача,
     * відсортованих за полем order.*/
    private List<Method> getAvailableMethods(String section) {
        List<Method> result = new ArrayList<>();

        for (Method m : target.getClass().getDeclaredMethods()) {
            MenuOption opt = m.getAnnotation(MenuOption.class);
            if ((m.isAnnotationPresent(MenuOption.class)) && (opt.section().equals(section)) && (Authorization.status >= opt.minRole()))
                result.add(m);

        }

        // сортуємо за order
        result.sort(Comparator.comparingInt(m -> m.getAnnotation(MenuOption.class).order()));

        return result;
    }
}
