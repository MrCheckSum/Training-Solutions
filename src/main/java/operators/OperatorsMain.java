package operators;



public class OperatorsMain {

    public static void main(String[] args) {
        Operators operators = new Operators();
        System.out.println(operators.isEven(12));
        System.out.println(operators.isEven(9));

        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(50));
        System.out.println(Integer.toBinaryString(17));

        System.out.println(16 >> 1);
        System.out.println(16 << 1);
        System.out.println(13 >> 1);
        System.out.println(16 << 1);

        System.out.println(operators.multyplyByPowerOfTwo(3,5)); //3* 2^5 = 96
        System.out.println(operators.multyplyByPowerOfTwo(2,4)); //2* 2^4 = 32
        System.out.println(operators.multyplyByPowerOfTwo(5,3)); //5* 2^3 = 40

        operators.convertNumber();
        operators.cannotConvertNumber();
    }


}
