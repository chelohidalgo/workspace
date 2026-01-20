package methods.responsibility;

import java.math.BigDecimal;

public class GoodCustomerAccount {

    private final String id;
    private BigDecimal balance;


    public GoodCustomerAccount(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(this.balance) > 0) {
            throw new IllegalArgumentException("Insufficient balance! balance=" + this.balance +", amount=" + amount);
        }
        this.balance = this.balance.subtract(amount);
    }


}
