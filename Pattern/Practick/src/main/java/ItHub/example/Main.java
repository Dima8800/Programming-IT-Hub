package ItHub.example;

public class Main {
    static String login = "aga";
    static String pass = "12345678";

    static AuthType type = AuthType.login;

    public static void main(String[] args) {
        AuthStrategy auth;

        switch (type){
            case google:
                auth = new Google(login, pass);
                auth.auth();
                break;
            case ldap:
                auth = new ldap(login, pass);
                auth.auth();
                break;
            case Gos:
                auth = new Gos(login, pass);
                auth.auth();
                break;
            case login:
                auth = new Login(login, pass);
                auth.auth();
                break;
            default:
                System.err.println("err");
                break;
        }


    }
}