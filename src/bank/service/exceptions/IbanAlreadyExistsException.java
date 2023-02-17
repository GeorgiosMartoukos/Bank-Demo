package bank.service.exceptions;


import bank.model.Account;

public class IbanAlreadyExistsException extends Exception {
    private final static long serialVersionUID = 1L;

    public IbanAlreadyExistsException(Account account) {
        super("The account with iban = " + account.getIban() + " already exists");
    }

}
