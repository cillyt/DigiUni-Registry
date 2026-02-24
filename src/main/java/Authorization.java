import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*.4 Доступ і ролі
Потрібна авторизація (логін/пароль) і розмежування прав доступу.

Користувач: лише перегляд (пошук і звіти).

Менеджер: повний доступ до CRUD, без керування користувачами.
Адміністратор: повний доступ + створення/редагування/блокування користувачів і ролей.*/

public class Authorization {
    public static int status;           //захистити
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    List<User> allUsers = new ArrayList<>();
    List<Manager> allManagers = new ArrayList<>();
    List<Administrator> allAdministrators = new ArrayList<>();
    static List<Object> allUsersWithRoles = new ArrayList<>();
    private Object consumer;


    public void authorizationQuestion() throws IOException {
        System.out.println("=== Увійдіть у свій обліковий запис ===");
        System.out.println("1. Зареєструватись");
        if (!allUsersWithRoles.isEmpty()) System.out.println("2. Увійти");
        int choice = Integer.parseInt(reader.readLine());
        if(choice == 1|| (choice == 2 && !allUsersWithRoles.isEmpty())){
            switch (choice) {
                case 1:
                    register();
                    authorizationQuestion();
                    break;
                case 2:
                    consumer = findingConsumer();  //перевіряє чи існує запитаний користувач для входу (optional)
                    login();
                    System.out.println("current status: " + status);  //видалити після перевірок
                    break;
            }
        }

        else {
            if(allUsersWithRoles.isEmpty())System.out.println("Для продовження реєстрації введіть лище 1");
            else System.out.println("Введіть лише 1 або 2!");
            authorizationQuestion();
        }
    }







    private void login() throws IOException {
        System.out.println("=== Вкажіть пароль ===");
        String password = reader.readLine();

        if(password!=null && consumer instanceof User){
            String c = ((User) consumer).getPassword();
            if(password.equals(c)){
                status = 1;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
        if(password!=null && consumer instanceof Manager){
            String c = ((Manager) consumer).getPassword();
            if(password.equals(c)){
                status = 2;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
        if(password!=null && consumer instanceof Administrator){
            String c = ((Administrator) consumer).getPassword();
            if(password.equals(c)){
                status = 3;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
    }






    private void register() throws IOException {  //додати перевірку чи вже існує користувач з такою поштою
        String email;

        while (true){
            boolean found=false;
            System.out.println("=== Вкажіть пошту ===");
            email = reader.readLine();
            for(Object o : allUsersWithRoles){
                if((o instanceof User && ((User)o).getEmail().equals(email)) ||
                        (o instanceof Manager && ((Manager)o).getEmail().equals(email)) ||
                        (o instanceof Administrator && ((Administrator)o).getEmail().equals(email))){  //????????????/

                    found = true;
                    break;
                }
            }
            if(found) System.out.println("Обліковий запис з такою електронною поштою вже існує!");
            else break;
        }

        System.out.println("=== Вкажіть пароль ===");
        String password = reader.readLine();
        System.out.println("=== Вкажіть роль ===");
        System.out.println("1. Користувач");
        System.out.println("2. Менеджер");
        System.out.println("3. Адміністратор");
        int role = Integer.parseInt(reader.readLine());

        switch (role) {
            case 1:
                allUsers.add(new User(email, password));
                allUsersWithRoles.add(new User(email, password));
                for(User u : allUsers) {
                    System.out.println(u + "\n");  //потім після тестування видалити
                }
                break;
            case 2:
                allManagers.add(new Manager(email, password));
                allUsersWithRoles.add(new Manager(email, password));
                for(Manager m : allManagers) {
                    System.out.println(m + "\n");
                }
                break;
            case 3:
                allAdministrators.add(new Administrator(email, password));
                allUsersWithRoles.add(new Administrator(email, password));
                for(Administrator a : allAdministrators) {
                    System.out.println(a + "\n");
                }
                break;
        }
    }



    public static Object findingConsumer() throws IOException {
        System.out.println("=== Вкажіть пошту ===");
        String email = reader.readLine();

        Object consumer = getConsumerOrDefault(email);
        if (consumer != null) {
            System.out.println("Знайдено: " + consumer);
                return consumer;
        }
        else return findingConsumer();
    }



    public static Object getConsumerOrDefault(String email) throws IOException {
        return findEmail(email)
                .orElseGet(
                        () -> {System.out.println("не знайдено");
                            return null;
                        });
    }

    public static Optional<Object> findEmail(String email) throws IOException {
        for (Object consumer : allUsersWithRoles) {

            if(consumer instanceof User) {
                String Email= ((User)consumer).getEmail();
                if (consumer != null && email.equals(Email)) {
                    return Optional.of(consumer);
                }
            }
            else if(consumer instanceof Manager) {
                String Email= ((Manager)consumer).getEmail();
                if (consumer != null && email.equals(Email)) {
                    return Optional.of(consumer);
                }
            }
            else if(consumer instanceof Administrator) {
                String Email= ((Administrator)consumer).getEmail();
                if (consumer != null && email.equals(Email)) {
                    return Optional.of(consumer);
                }
            }
        }
        return Optional.empty();
    }
}




