package bank.service.exceptions;


import bank.model.Account;

public class AccountNotFoundException extends Exception{
    private final static long serialVersionUID = 1L;

    public AccountNotFoundException(Long id) {
        super("The account with id = " + id + " was not found");
    }

    public AccountNotFoundException(String iban) {
        super("The account with iban = " + iban + " was not found");
    }

    public AccountNotFoundException(Account account) {
        super("The account with id = " + account.getId() + " and iban = " + account.getIban() + " was not found");
    }
}
