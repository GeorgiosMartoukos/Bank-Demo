package bank.service.exceptions;

public class InsufficientBalanceException extends Exception{
    private static final long serialVersionUID = 1l;

    public InsufficientBalanceException(double balance, double amount) {
        super("Insufficient balance " + balance + "for amount " + amount);
    }
}
