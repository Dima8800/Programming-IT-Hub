package ItHub.example;

public class Gos implements AuthStrategy{
    String token;
    int PhoneCode;

    public Gos(String token, String phoneCode) {
        this.token = token;
        PhoneCode = Integer.parseInt(phoneCode);
    }

    @Override
    public void auth() {
        System.out.print("Успешно авторизован через - ");
        System.err.println("Госуслуги");
    }
}
