//import java.util.Objects;
//
//public class User {
//    String email;
//    String password;
//    public User(String email, String password) {
//        this.email = email;
//        this.password = password;
//    }
////    @Override
////    public String toString(){  //видалити після всіх тестувань
////        return "Електронна пошта: " + email + " пароль:" +  password;
////    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(email, user.email);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(email);
//    }
//
//    public String getEmail() {return email;}
//    public String getPassword() {return password;}
//}
