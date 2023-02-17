package bank.service.exceptions;


import bank.model.Account;

public class IdAlreadyExistsException extends Exception{
    private final static long serialVersionUID = 1L;

    public IdAlreadyExistsException(Account account) {
        super("The account with id =" + account.getId() + " already exists!");
    }
}
