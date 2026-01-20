package exceptions.throwearly;

import java.math.BigDecimal;

public class ThrowIfBlocksSample {

    public static void main(String[] args) {
        var account = new BankAccount(BigDecimal.valueOf(1000.0));
        account.withdrawBadWay(BigDecimal.valueOf(20.0));
        account.withdrawGoodWay(BigDecimal.valueOf(20.0));
    }

}
