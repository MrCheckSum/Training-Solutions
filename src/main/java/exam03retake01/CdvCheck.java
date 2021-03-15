package exam03retake01;

public class CdvCheck {


    public boolean check(String s) {
        if (s.length() != 10 || notNumber(s)) {
            throw new IllegalArgumentException("Not valid tax number!");
        }

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int digit = Integer.parseInt(s.substring(i, i + 1));
//            int digit = Integer.parseInt(Character.toString(s.charAt(i)));      így is lehet
            sum += digit * (i + 1);
        }
        int lastDigit = Integer.parseInt(s.substring(9));


        return sum % 11 == lastDigit;
    }

    private boolean notNumber(String s) {
        try {
            Long.parseLong(s);
            return false;
        } catch (NumberFormatException numberFormatException) {
            return true;
        }
    }

}
