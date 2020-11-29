package attributes.attributes.person;

public class PersonMain {

    public static void main(String[] args) {

        Address address = new Address("Magyarország", "Bp.", "Rákóczi utca 1.", "1052");
        Address address1 = new Address("Magyarország", "Bp.", "Király utca 1.", "1051");
        Person person = new Person("Kis Károly", "123456AB");

        System.out.println(person.toString());
        System.out.println(address.toString());

        person.moveToNewAddress(address1);

        System.out.println(person.toString());
        System.out.println(person.getAddress().toString());


    }

}
