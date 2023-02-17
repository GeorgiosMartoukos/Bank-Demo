package bank.service.exceptions;

public class LoanDeclinedException extends Exception{
    private final static long serialVersionUID = 1L;

    public  LoanDeclinedException(String iban) {
        super("Your account can not take a loan");
    }

}
