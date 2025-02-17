package ItHub.example;

import java.util.UUID;

public class ldap implements AuthStrategy{
    UUID uuid;
    String password;

    public ldap(String uuid, String password) {
        this.uuid = UUID.fromString(uuid);
        this.password = password;
    }

    @Override
    public void auth() {
        System.out.print("Успешно авторизован через - ");
        System.err.println("LDAP");
    }
}
