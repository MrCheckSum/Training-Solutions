package classstructuremethods;

import java.sql.SQLOutput;

public class ClientMain {
    public static void main(String[] args) {

        Client client = new Client();
        client.setName("Kötvény János");
        client.setYear(1990);
        client.setAddress("London");
        System.out.println(client.getName());
        System.out.println(client.getYear());
        System.out.println(client.getAddress());

        client.migrate("Budapest");
        System.out.println(client.getAddress());
    }

}
