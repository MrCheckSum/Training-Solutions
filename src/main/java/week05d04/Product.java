package week05d04;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {

    private String name;
    private LocalDate expDate;

    public Product(String name, int expYear, int expMonth, int expDay) {
        this.name = name;
        expDate = LocalDate.of(expYear, expMonth, expDay);
    }

    public String getName() {
        return name;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public boolean isExpired() {
        if (expDate.isBefore(LocalDate.now())) {
            return true;
        }
        return false;
    }
}
