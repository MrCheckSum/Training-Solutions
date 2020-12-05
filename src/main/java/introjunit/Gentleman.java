package introjunit;

public class Gentleman {

    public String sayHello(String name) {
        if (name == null) {
            return "Hello Anonymous!";
        } else {
            return "Hello " + name + "!";
        }
    }

    public static void main(String[] args) {
        Gentleman gentleman = new Gentleman();
        System.out.println(gentleman.sayHello("Peter"));
    }
}
