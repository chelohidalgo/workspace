package exceptions.throwearly;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public void withdrawBadWay(BigDecimal amount) {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) >= 0) {
            if (amount.compareTo(balance) <= 0) {
                this.balance = balance.subtract(amount);
            } else {
                throw new InsufficientFundsException(balance, amount);
            }
        } else {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
    }

    public void withdrawGoodWay(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        if (amount.compareTo(balance) > 0) {
            throw new InsufficientFundsException(balance, amount);
        }
        this.balance = balance.subtract(amount);
    }

}
