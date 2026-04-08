import java.io.IOException;
import java.util.*;

public class Authorization {
    Menu menu = new Menu();
    CheckInput checkInput = Main.checkInput;

    public sealed interface BaseUser permits Administrator, Manager, User{
        Email email();
        String password();
    }


    public record Email(String value) {
        public Email {
            Objects.requireNonNull(value, "email");
            value = value.trim().toLowerCase();
            if (!value.contains("@")) throw new IllegalArgumentException("Пошта вказана не правильно (відсутність @): " + value);
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
    public final static Set<User> allUsers = new HashSet<>();
    public final static Set<Manager> allManagers = new HashSet<>();
    public static final Set<Administrator> allAdministrators = new HashSet<>();
    public final static Set<BaseUser> allUsersWithRoles = new HashSet<>();
    //  public final static Set<Object> allEmails = new HashSet<>();
    private BaseUser consumer;

    public static void baseSet(){
        Email e = new Email("@");
        Administrator a = new Administrator(e, "1");
        allAdministrators.add(a);
        allUsersWithRoles.add(a);
    }


    public void authorization() throws IOException {
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







    private void login(BaseUser consumer) throws IOException {
        boolean loggedIn = false;
        while (!loggedIn) {
            String password = checkInput.checkString("=== Вкажіть пароль ===", "Ви не ввели пароль.");
            if (password == null) return;


            switch (consumer) {
                case User u -> {
                    if (password.equals(u.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 1;
                        loggedIn = true;
                    } else System.out.println("Введено невірний пароль!");
                }

                case Manager m -> {
                    if (password.equals(m.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 2;
                        loggedIn = true;
                    } else System.out.println("Введено невірний пароль!");
                }

                case Administrator a -> {
                    if (password.equals(a.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 3;
                        loggedIn = true;
                    } else System.out.println("Введено невірний пароль!");
                }
            }
        }
    }






    private void register() throws IOException {
        boolean added = false; // така перевірка чи додався користувач??
        while (!added) {  //checking whether there is user with same emil or not using Set features та нє
            String email1 = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");
            String password = checkInput.checkString("=== Вкажіть пароль ===","Ви не ввели пароль.");

            try {
                Email email2 = new Email(email1);
                boolean isEmailUnique = allUsersWithRoles.stream()
                        .noneMatch(u -> u.email().equals(email2));

                        if(!isEmailUnique){
                            System.out.println("Обліковий запис з такою електронною поштою вже існує!");
                            continue;
                        }
                        allUsers.add(new User(email2, password));
                        allUsersWithRoles.add(new User(email2, password));
                        added = true;
                        System.out.println("Ви успішно створили новий обліковий запис!");
                        break;
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
        }
    }



    public BaseUser findingConsumer() throws IOException {
        while (true) {
            String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");

            try {
                Email emaill = new Email(email);

                Optional<BaseUser> result = findEmail(emaill);

                if (result.isPresent())
                    return result.get();
                else
                    System.out.println("Користувача з такою поштою не існує.");

            }
            catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
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

}