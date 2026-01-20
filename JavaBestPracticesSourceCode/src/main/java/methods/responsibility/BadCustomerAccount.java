package methods.responsibility;

import java.math.BigDecimal;

public class BadCustomerAccount {

    private final String id;
    private BigDecimal balance;


    public BadCustomerAccount(String id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public BigDecimal processTransaction(String transactionType, BigDecimal amount) {
        if (transactionType.equals("deposit")) {
            this.balance = this.balance.add(amount);
            System.out.println("Deposited $" + amount);
            return balance;
        } else if (transactionType.equals("withdraw")) {
            if (amount.compareTo(this.balance) > 0) {
                throw new IllegalArgumentException("Insufficient balance! balance=" + this.balance + ", amount=" + amount);
            }
            this.balance = this.balance.subtract(amount);
            System.out.println("Withdrawn $" + amount);
            return balance;
        } else {
            System.out.println("Invalid transaction type.");
            return balance;
        }
    }

}
