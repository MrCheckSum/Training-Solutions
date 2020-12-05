package typeconversion.dataloss;

public class DataLoss {

    public static final int MAX_NUMBER_OF_LOSS = 3;

    public void dataLoss() {

        long originalNumber = 0;
        for (long i = 0; i < MAX_NUMBER_OF_LOSS;) {

            long convertedNumber = (long) (float) originalNumber;
            if (convertedNumber != originalNumber) {
                System.out.println("Original: " + originalNumber + " in binary: " + Long.toBinaryString(originalNumber));
                System.out.println("Converted: " + convertedNumber + " in binary: " + Long.toBinaryString(convertedNumber));
                i++;
            }
            originalNumber++;
        }

    }

    public static void main(String[] args) {
        DataLoss dataLoss = new DataLoss();   //rövidebben: new DataLoss().dataLoss();
        dataLoss.dataLoss();
    }

}
