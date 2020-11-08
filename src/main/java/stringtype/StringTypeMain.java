package stringtype;

public class StringTypeMain {
    public static void main(String[] args) {

        String prefix = "Hello ";
        String name = "John Doe";
        String message = prefix + name;
        System.out.println(message);

        message = message + "444";
        System.out.println(message);

        boolean b = "Hello John Doe".equals(message);
        System.out.println(b);

        boolean c = "Hello John Doe444".equals(message);
        System.out.println(c);

        String emptyText = "" + "";
        System.out.println(emptyText.length());

        String testText = "Abcde";
        System.out.println(testText.length());
        System.out.println(testText.substring(0, 1) + ", " + testText.substring(2, 3));
        System.out.println(testText.substring(0, 2));

    }

}
