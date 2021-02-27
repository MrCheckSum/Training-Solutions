package initializer.initializer;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {

    private static final List<Rate> RATE_LIST = new ArrayList<>();

    private long balance;

    public CreditCard(long balance, Currency currency, List<Rate> rateUpload) {
        RATE_LIST.addAll(rateUpload);
        this.balance = Math.round(balance * getConversionRate(currency));
    }

    private double getConversionRate(Currency currency) {
        for (Rate rate : RATE_LIST) {
            if (rate.getCurrency() == currency) {
                return rate.getConversionFactor();
            }
        }
        return 1.0;
    }

    public CreditCard(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public boolean payment(long amount, Currency currency) {
        long value = Math.round(amount * getConversionRate(currency));
        if (value <= balance) {
            balance -= value;
            return true;
        }
        return false;
    }

    public boolean payment(long amount) {
        return payment(amount, Currency.HUF);
    }

}
