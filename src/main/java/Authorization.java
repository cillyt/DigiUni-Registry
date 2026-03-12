import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Authorization {
    Menu menu = new Menu();
    CheckInput checkInput = Main.checkInput;


    public static int status;           //захистити
    public final Set<User> allUsers = new HashSet<>();
    public final Set<Manager> allManagers = new HashSet<>();
    public final Set<Administrator> allAdministrators = new HashSet<>();
    public final static Set<Object> allUsersWithRoles = new HashSet<>();
    public final static Set<Object> allEmails = new HashSet<>();
    private Object consumer;


    public void authorization() throws IOException {
        int choice = menu.authorizationQuestion(allUsersWithRoles.isEmpty());
            switch (choice) {
                case 1:
                    register();
                    authorization();
                    break;
                case 2:
                    consumer = findingConsumer();  //перевіряє чи існує запитаний користувач для входу (optional)
                    login();
                    //System.out.println("current status: " + status);  //видалити після перевірок
                    break;
            }

    }







    private void login() throws IOException {
        String password = checkInput.checkString("=== Вкажіть пароль ===","Ви не ввели пароль.");

        if(password!=null && consumer instanceof User){
            String c = ((User) consumer).getPassword();
            if(password.equals(c)){
                System.out.println("Ви успішно увійшли у свій обліковий запис!");
                status = 1;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
        if(password!=null && consumer instanceof Manager){
            String c = ((Manager) consumer).getPassword();
            if(password.equals(c)){
                System.out.println("Ви успішно увійшли у свій обліковий запис!");
                status = 2;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
        if(password!=null && consumer instanceof Administrator){
            String c = ((Administrator) consumer).getPassword();
            if(password.equals(c)){
                System.out.println("Ви успішно увійшли у свій обліковий запис!");
                status = 3;
                return;
            }
            else System.out.println("Введено невірний пароль!");
            login();
        }
    }






    private void register() throws IOException {
        while (true) {  //checking whether there is user with same emil or not using Set features
            String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");
            String password = checkInput.checkString("=== Вкажіть пароль ===","Ви не ввели пароль.");
            int role = menu.roleAuthorizationQuestion();

            switch (role) {
                case 1:
                    boolean isAddedU = allUsersWithRoles.add(new User(email, password));  //вюди додаєм юзера шоб були однакові типи -> для ефективної перевірки на індивідуальність в сеті allUsersWithRoles (він вроді для тільки цього і юзається)
                    if(isAddedU && !allEmails.contains(email) ) {
                        allUsers.add(new User(email, password));
                        allEmails.add(email);
                        return;
                    }
                    else System.out.println("Обліковий запис з такою електронною поштою вже існує!");
                    break;

                case 2:
                    boolean isAddedM = allUsersWithRoles.add(new Manager(email, password));  //вюди додаєм юзера шоб були однакові типи -> для ефективної перевірки на індивідуальність в сеті allUsersWithRoles (він вроді для тільки цього і юзається)
                    if(isAddedM && !allEmails.contains(email)){
                        allManagers.add(new Manager(email, password));
                        allEmails.add(email);
                        return;
                    }
                    else System.out.println("Обліковий запис з такою електронною поштою вже існує!");
                    break;
                case 3:
                    boolean isAddedA = allUsersWithRoles.add(new Administrator(email, password));  //вюди додаєм юзера шоб були однакові типи -> для ефективної перевірки на індивідуальність в сеті allUsersWithRoles (він вроді для тільки цього і юзається)
                    if(isAddedA && !allEmails.contains(email)) {
                        allAdministrators.add(new Administrator(email, password));
                        allEmails.add(email);
                        return;
                    }

                    else System.out.println("Обліковий запис з такою електронною поштою вже існує!");

                    break;
            }
        }




    }



    public Object findingConsumer() throws IOException {
        String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");

        Object consumer = getConsumerOrDefault(email);
        if (consumer != null) {
            //System.out.println("Знайдено: " + consumer);
                return consumer;
        }
        else return findingConsumer();
    }



    public static Object getConsumerOrDefault(String email) throws IOException {
        return findEmail(email)
                .orElseGet(
                        () -> {System.out.println("Користувача з такою поштою не існує");
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