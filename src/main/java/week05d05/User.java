package week05d05;

/*
Készíts egy osztályt week05d05.User néven, melynek van egy firstName (String), egy lastName (String) és egy email (String) mezője.
Legyen ellenőrzés az User konstruktorában, mely hibát jelez, ha nincs @ és . (pont) az e-mail cimben! Készíts egy metódust is getFullName névvel,
 mely visszaadja a firstName és a lastName változókat összefűzve. Legyen közöttük egy whitespace (" ").
Bónusz feladat: írjunk teszteket
 */

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String fullName;

    public User(String firstName, String lastName, String email) throws IllegalArgumentException {
        this.firstName = firstName;
        this.lastName = lastName;
        checkEmail(email);
    }

    public void checkEmail(String email) {
        if (!email.contains(".") || !email.contains("@")) {
            throw new IllegalArgumentException("Hibás emailcím!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    public String getFullName() {
        fullName=getFirstName() + " "+ getLastName();
        return fullName;
    }

   public static void main(String[] args) {
       User user = new User("Karoly", "Kiss", "karolykiss@kisskft.hu");

       System.out.println(user.getFullName());



    }
}