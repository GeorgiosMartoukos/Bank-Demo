package bank.service;

import bank.DTO.AccountDTO;
import bank.model.Account;
import bank.service.exceptions.*;

import java.util.List;

public interface IAccountService {
    /**
     * Creates an acount based on the data from the AccountDTO
     * @param accountDTO    The data that will create the account
     *
     * @return              the created account
     * @throws IbanAlreadyExistsException   if the iban in the accountDTO already exists in the datasource
     * @throws IdAlreadyExistsException     if the id in the accountDTO already exists in the datasource
     */
    Account createAccount(AccountDTO accountDTO) throws IbanAlreadyExistsException, IdAlreadyExistsException;

    /**
     * Updates the data of an account
     *
     * @param id
     *      the account's id to be updated
     * @param accountDTO
     *      the updated data
     * @return
     *      the updated account
     * @throws AccountNotFoundException
     *      if the id does not exist in the datasource
     */
    Account updateAccount (Long id,AccountDTO accountDTO) throws AccountNotFoundException;

    void deleteAccount (String iban) throws AccountNotFoundException;

    /**
     * Makes a withdrawal for an account for a specific amount.
     * @param iban
     *      the iban of the account.
     * @param amount
     *      the amount to be withdrawn.
     * @param ssn
     *      The ssn of the holder of the account.
     * @throws AccountNotFoundException
     *      If the iban we gave does not exist.
     * @throws InsufficientBalanceException
     *      if the amount is greater than the balance.
     * @throws SsnNotValidException
     *      if the ssn has is not valid
     */
    void withdrawAccount (String iban,double amount, String ssn) throws AccountNotFoundException, InsufficientBalanceException, SsnNotValidException;

    /**
     * Makes a deposit to an account.
     *
     * @param iban
     *      the iban of the account that we want to make the deposit
     * @param amount
     *      the amount to be deposited
     * @throws InsufficientAmountException
     *      if the amountis less than zero
     * @throws AccountNotFoundException
     *      If an account with the iban we gave does not exist.
     */
    void depositAccount (String iban, double amount) throws InsufficientAmountException, AccountNotFoundException;

    Account getAccount (String iban) throws AccountNotFoundException;

    Account getAccount (Long id) throws AccountNotFoundException;

    List<Account> getAllAccounts();

    /**
     * It answers to the client if he is able to get a loan
     * It approves it if the customer has at least a 5000 in his account
     * @param iban  Iban of the account
     * @param amount    amount of money that the customer asking
     * @return          true if he got the loan
     */
    Boolean LoanApplication (String iban, double amount) throws AccountNotFoundException,LoanDeclinedException;


}
