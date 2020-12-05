package operators;

public class Operators {

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public int multyplyByPowerOfTwo(int number, int powerNumber) {
        return number << powerNumber;
    }

    public void cannotConvertNumber() {

        int number = -1;
        String nrInBinaryString = Integer.toBinaryString(number);
        System.out.println(nrInBinaryString);
    }

    public void convertNumber() {
        int number = 1;
        String nrInBinaryString = Integer.toBinaryString(number);
        System.out.println(nrInBinaryString);
    }


}
