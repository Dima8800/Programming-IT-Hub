package ItHub.example;

public class Google implements AuthStrategy{
    String gmail;
    String password;

    public Google(String gmail, String password) {
        this.gmail = gmail;
        this.password = password;
    }

    @Override
    public void auth() {
        System.out.print("Успешно авторизован через - ");
        System.err.println("Гугл");
    }
}
