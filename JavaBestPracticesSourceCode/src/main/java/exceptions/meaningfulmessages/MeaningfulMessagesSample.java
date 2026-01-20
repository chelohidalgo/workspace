package exceptions.meaningfulmessages;

import java.math.BigDecimal;

public class MeaningfulMessagesSample {

    public static void main(String[] args) {
        var account = new BankAccount(BigDecimal.valueOf(10.0));
//        account.withdraw(BigDecimal.valueOf(-20.0));
        account.withdraw(BigDecimal.valueOf(20.0));
    }

}
