package localvariables;



public class LocalVariablesMain {
    public static void main(String[] args) {
        boolean b = false;
        System.out.println(b);
        b = false;
        int a = 2;
        var i = 3; var j = 4;
        int k = i;
        System.out.println(k);
        String s = "Hello World";
        String t = s;
        System.out.println(t);


        {
            int x = 0;
            System.out.println(t);
        }
        System.out.println(x);
    }
}
