package references.parameters;

public class ReferencesMain {

    public static void main(String[] args) {
        Person person1 = new Person("person1",11);
        Person person2 = person1;

        person2.setName("person2");

        System.out.println(person1.getName());
        System.out.println(person2.getName());

        int a = 24;
        int b = a;
        b = b +1;
        System.out.println(a);
        System.out.println(b);

        Person person3 = new Person("person3", 30);
        person2 = person3;
        System.out.println(person3.getName());
        System.out.println(person2.getName());
        System.out.println(person1.getName());

    }

}
