package exceptions.throwearly;

import java.math.BigDecimal;

class InsufficientFundsException extends RuntimeException {
    public InsufficientFundsException(BigDecimal balance, BigDecimal amountToWithdraw) {
        super(String.format("balance=%s, amountToWithdraw=%s", balance.toString(), amountToWithdraw.toString()));
    }
}
