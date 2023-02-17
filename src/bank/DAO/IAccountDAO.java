package bank.DAO;

import bank.model.Account;
import bank.DTO.AccountDTO;
import java.util.List;

public interface IAccountDAO {
    /**
     * Insert an {@link Account} in the datatsource
     *
     * @param account   the new account instance
     *
     * @return          the account that has been created
     */

    Account create(Account account);

    /**
     * Update the data of an existing account
     *
     * @param id        the id of the account that we want to update
     *
     * @param account   the data that will replace the account
     *
     * @return          the updated account
     */
    Account update(Long id, Account account);

    /**
     * Delete an {@link Account} in the datatsource
     *
     * @param iban      the iban of the account that we will erase
     */
    void delete(String iban);

    /**
     * Returns an account based on the id we give
     *
     * @param id    the id of the account
     * @return      the account
     */
    Account get(Long id);

    /**
     * Returns an account based on the iban we give
     *
     * @param iban    the iban of the account
     * @return      the account
     */
    Account get(String iban);

    /**
     * Executes a withdrawal in an account
     *
     * @param iban      the iban of the account
     * @param amount    the amount we want to withdraw
     * @return          true if the withdrawal was successful
     *                  false otherwise
     */
    boolean withdraw(String iban, double amount);

    /**
     * Executes a deposit in an account
     *
     * @param iban      the iban of the account
     * @param amount    the amount we want to deposit
     * @return          true if the deposit was successful
     *                  false otherwise
     */
    boolean deposit(String iban, double amount);

    /**
     * It searches if an iban already exists in the datasource
     *
     * @param iban      the iban
     * @return          true if it exists, false otherwise
     */
    boolean ibanExists(String iban);

    /**
     * It searches if an id already exists in the datasource
     *
     * @param id        the id
     * @return          true if it exists, false otherwise
     */
    boolean idExists(Long id);

    /**
     * It searches if a ssn of a { User} is valid
     *
     * @param iban  user's iban
     * @param ssn   user's ssn
     * @return      true if its valid, false otherwise
     */
    boolean ssnValid (String iban,String ssn);

    /**
     *
     * @return It returns all the Accounts int the datasource
     */
    List<Account> getAll();

}
