import java.io.IOException;
import java.util.*;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class Authorization {
    Menu menu = new Menu();
    CheckInput checkInput = Main.checkInput;
    //static Logger logger = Logger.getLogger(Authorization.class.getName());

    public sealed interface BaseUser permits Administrator, Manager, User{
        Email email();
        String password();
    }


    public record Email(String value) {
        public Email {
            Objects.requireNonNull(value, "email");
            value = value.trim().toLowerCase();
            if (!value.contains("@")) {
                //log.warn("Пошта вказана не правильно (відсутність @): " + value);
                throw new IllegalArgumentException("Пошта вказана не правильно (відсутність @): " + value);
            }
        }
        @Override
        public String toString() {
            return value;
        }
    }

    public record Administrator(Email email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails among all users (without including roles)
            if (this == o) return true;
            if (!(o instanceof BaseUser that)) return false;
            return Objects.equals(this.email(), that.email());
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
        @Override
        public String toString() {
            return "Роль: Адміністратор; електронна пошта: " + email() +  "; пароль: " + password();
        }
    }
    public record Manager(Email email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails
            if (this == o) return true;
            if (!(o instanceof BaseUser that)) return false;
            return Objects.equals(this.email(), that.email());
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
        @Override
        public String toString() {
            return "Роль: Менеджер; електронна пошта: " + email() +  "; пароль: " + password();
        }
    }
    public record User(Email email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails
            if (this == o) return true;
            if (!(o instanceof BaseUser that)) return false;
            return Objects.equals(this.email(), that.email());
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
        @Override
        public String toString() {
            return "Роль: Користувач; електронна пошта: " + email() +  "; пароль: " + password();
        }
    }


    public static int status;           //захистити
    public static Set<User> allUsers = new HashSet<>();
    public static Set<Manager> allManagers = new HashSet<>();
    public static Set<Administrator> allAdministrators = new HashSet<>();
    public final static Set<BaseUser> allUsersWithRoles = new HashSet<>();
    //  public final static Set<Object> allEmails = new HashSet<>();
    private BaseUser consumer;

    public static void baseSet(){
        Email e = new Email("@");
        Administrator a = new Administrator(e, "1");
        allAdministrators.add(a);
        allUsersWithRoles.add(a);
    }


    public void authorization() throws Exception {
        int choice = menu.authorizationQuestion(allUsersWithRoles.isEmpty());
        switch (choice) {
            case 1:
                register();
                authorization();
                break;
            case 2:
                consumer = findingConsumer();  //перевіряє чи існує запитаний користувач для входу (optional)
                login(consumer);

  //              System.out.println("current status: " + status);  //видалити після перевірок
                break;
        }
    }







    private void login(BaseUser consumer) throws Exception {
        boolean loggedIn = false;
        while (!loggedIn) {
            String password = checkInput.checkString("=== Вкажіть пароль ===", "Ви не ввели пароль.");
            if (password == null) return;



            if (password.equals(consumer.password())) {
                //System.out.println("Ви успішно увійшли у свій обліковий запис!");
                //logger.log(Level.INFO, "Ви успішно увійшли у свій обліковий запис!");
                log.info("Ви успішно увійшли у свій обліковий запис!");
                switch (consumer) {
                    case User _ -> status = 1;
                    case Manager _ -> status = 2;
                    case Administrator _ -> status = 3;
                }
                loggedIn = true;
            } else  log.warn("Введено невірний пароль!");
        }
    }






    public void register() throws Exception {
        boolean added = false; // така перевірка чи додався користувач??
        while (!added) {  //checking whether there is user with same emil or not using Set features та нє
            String email1 = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");
            String password = checkInput.checkString("=== Вкажіть пароль ===","Ви не ввели пароль.");

            try {
                Email email2 = new Email(email1);
                boolean isEmailUnique = allUsersWithRoles.stream()
                        .noneMatch(u -> u.email().equals(email2));

                        if(!isEmailUnique){
                            log.warn("Обліковий запис з такою електронною поштою вже існує!");
                            continue;
                        }
                        allUsers.add(new User(email2, password));
                        allUsersWithRoles.add(new User(email2, password));
                        added = true;
                        log.info("Ви успішно створили новий обліковий запис!");
                        break;
                    }
                    catch (IllegalArgumentException e) {
                        log.warn(e.getMessage());
                        break;
                    }
        }
    }



    public BaseUser findingConsumer() throws Exception {
        while (true) {
            String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");

            try {
                Email emaill = new Email(email);

                Optional<BaseUser> result = findEmail(emaill);

                if (result.isPresent())
                    return result.get();
                else
                    log.warn("Користувача з такою поштою не існує.");

            }
            catch (IllegalArgumentException e) {
                log.warn(e.getMessage());
            }
        }
    }




     public static Optional<BaseUser> findEmail(Email email) {
        for (BaseUser consumer : allUsersWithRoles) {
            if (email.equals(consumer.email()))
                return Optional.of(consumer);
        }
        return Optional.empty();
    }

    public static void setAllUsersWithRoles(){
        allUsersWithRoles.addAll(allUsers);
        allUsersWithRoles.addAll(allManagers);
        allUsersWithRoles.addAll(allAdministrators);
    }
}