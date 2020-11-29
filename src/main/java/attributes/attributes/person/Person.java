package attributes.attributes.person;

public class Person {

    private String name;
    private String identificationCard;
    private Address address;

    public Person(String name, String identification) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", identificationCard='" + identificationCard + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getIdentificationCard() {
        return identificationCard;
    }

    public Address getAddress() {
        return address;
    }

    public void correctData(String name, String identificationCard) {
        this.name = name;
        this.identificationCard = identificationCard;
    }

    public void moveToNewAddress(Address address) {
        this.address = address;
    }
}
