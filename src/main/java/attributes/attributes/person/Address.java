package attributes.attributes.person;

public class Address {

    String country;
    String city;
    String streetAndNumber;
    String zipCode;

    public Address(String country, String city, String streetAndNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", streetAndnumber='" + streetAndNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreetAndnumber() {
        return streetAndNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void correctData(String country, String city, String streetAndNumber, String zipCode) {
        this.country = country;
        this.city = city;
        this.streetAndNumber = streetAndNumber;
        this.zipCode = zipCode;
    }
}
