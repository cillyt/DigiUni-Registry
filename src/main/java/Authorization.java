import java.io.IOException;
import java.util.*;

public class Authorization {
    Menu menu = new Menu();
    CheckInput checkInput = Main.checkInput;

    public sealed interface BaseUser permits Administrator, Manager, User{
        String email();
        String password();
    }

    public record Administrator(String email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Administrator admin = (Administrator) o;
            return Objects.equals(email, admin.email);
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }
    public record Manager(String email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Manager manager = (Manager) o;
            return Objects.equals(email, manager.email);
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }
    public record User(String email, String password)implements BaseUser {
        @Override
        public boolean equals(Object o) {           //comparing only emails
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(email, user.email);
        }
        @Override
        public int hashCode() {
            return Objects.hash(email);
        }
    }


    public static int status;           //захистити
    public final Set<User> allUsers = new HashSet<>();
    public final Set<Manager> allManagers = new HashSet<>();
    public final Set<Administrator> allAdministrators = new HashSet<>();
    public final static Set<BaseUser> allUsersWithRoles = new HashSet<>();
  //  public final static Set<Object> allEmails = new HashSet<>();
    private BaseUser consumer;


    public void authorization() throws IOException {
        int choice = menu.authorizationQuestion(allUsersWithRoles.isEmpty());
        switch (choice) {
            case 1:
                register();
                authorization();
                break;
            case 2:
                consumer = (BaseUser) findingConsumer();  //перевіряє чи існує запитаний користувач для входу (optional)
                while (status !=1 || status !=2 || status !=3)   login(consumer);

                System.out.println("current status: " + status);  //видалити після перевірок
                break;
        }
    }







    private void login(BaseUser consumer) throws IOException {
        while (status != 1 || status != 2 || status != 3) {
            String password = checkInput.checkString("=== Вкажіть пароль ===", "Ви не ввели пароль.");
            if (password == null) return;


            switch (consumer) {
                case User u -> {
                    if (password.equals(u.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 1;
                        //return;
                    } else System.out.println("Введено невірний пароль!");
                    return;
                }

                case Manager m -> {
                    if (password.equals(m.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 2;
                        //return;
                    } else System.out.println("Введено невірний пароль!");
                    return;
                }

                case Administrator a -> {
                    // String c = a.password();
                    if (password.equals(a.password())) {
                        System.out.println("Ви успішно увійшли у свій обліковий запис!");
                        status = 3;
                        // return;
                    } else
                        System.out.println("Введено невірний пароль!");
                    return;
                }
            }
        }
    }






    private void register() throws IOException {
        boolean added = false; // така перевірка чи додався користувач??
        while (added == false) {  //checking whether there is user with same emil or not using Set features та нє
            String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");
            String password = checkInput.checkString("=== Вкажіть пароль ===","Ви не ввели пароль.");
            int role = menu.roleAuthorizationQuestion();

            boolean isEmailUnique = allUsersWithRoles.stream()
                    .noneMatch(u -> u.email().equals(email));

            if(!isEmailUnique){
                System.out.println("Обліковий запис з такою електронною поштою вже існує!");
                continue;
            }

            switch (role) {
                case 1:
                    //boolean isAddedU = allUsersWithRoles.add(new User(email, password));  //вюди додаєм юзера шоб були однакові типи -> для ефективної перевірки на індивідуальність в сеті allUsersWithRoles (він вроді для тільки цього і юзається)
                    allUsers.add(new User(email, password));
                    allUsersWithRoles.add(new User(email, password));
                    added = true;
                    break;

                case 2:
                    allManagers.add(new Manager(email, password));
                    allUsersWithRoles.add(new Manager(email, password));
                    added = true;
                    break;
                case 3:
                    allAdministrators.add(new Administrator(email, password));
                    allUsersWithRoles.add(new Administrator(email, password));
                    added = true;
                    break;
            }
        }
    }



    public Object findingConsumer() throws IOException {
        String email = checkInput.checkString("=== Вкажіть пошту ===", "Ви не ввели пошту.");

        BaseUser consumer = (BaseUser)getConsumerOrDefault(email);
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


    public static Optional<Object> findEmail(String email) {
        for (BaseUser consumer : allUsersWithRoles) {
            //if(consumer == null)continue;
            switch (consumer) {
                case User u -> {
                    if (email.equals(u.email()))
                        return Optional.of(consumer);
                }
                case Manager m -> {
                    if (email.equals(m.email()))
                        return Optional.of(consumer);
                }
                case Administrator a -> {
                    if (email.equals(a.email()))
                        return Optional.of(consumer);
                }
            }
        }
        return Optional.empty();
    }

//            if(consumer instanceof User) {
//                String Email= ((User)consumer).email();
//                if (consumer != null && email.equals(Email)) {
//                    return Optional.of(consumer);
//                }
//            }
//            else if(consumer instanceof Manager) {
//                String Email= ((Manager)consumer).email();
//                if (consumer != null && email.equals(Email)) {
//                    return Optional.of(consumer);
//                }
//            }
//            else if(consumer instanceof Administrator) {
//                String Email= ((Administrator)consumer).email();
//                if (consumer != null && email.equals(Email)) {
//                    return Optional.of(consumer);
//                }
//            }



}