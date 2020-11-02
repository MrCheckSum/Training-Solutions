package classstructureattributes;

public class ClientMain {
    public static void main(String[] args) {
        Client client = new Client();
        client.name = "James Bond";
        client.yearOfBirth = 1970;
        client.address = "MI5";
        System.out.println(client.name + ";" + client.yearOfBirth + ";" + client.address);
    }
}
