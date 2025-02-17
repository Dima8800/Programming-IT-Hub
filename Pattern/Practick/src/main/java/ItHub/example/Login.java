package ItHub.example;

public class Login implements AuthStrategy {
    String login;
    String password;

    public Login(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public void auth() {
        System.out.print("Успешно авторизован через - ");
        System.err.println("Login - Pass");
    }
}
