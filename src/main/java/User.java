public class User {
    String email;
    String password;
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString(){  //видалити після всіх тестувань
        return "Електронна пошта: " + email + " пароль:" +  password;
    }
    public String getEmail() {return email;}
    public String getPassword() {return password;}
}
