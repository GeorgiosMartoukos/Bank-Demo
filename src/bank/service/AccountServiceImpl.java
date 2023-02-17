package bank.service;



import bank.DAO.IAccountDAO;
import bank.DTO.AccountDTO;
import bank.DTO.UserDTO;
import bank.model.Account;
import bank.model.User;
import bank.service.exceptions.*;

import java.util.List;

public class AccountServiceImpl implements  IAccountService{
    private final IAccountDAO dao;

    public AccountServiceImpl(IAccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public Account createAccount(AccountDTO accountDTO) throws IbanAlreadyExistsException, IdAlreadyExistsException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (dao.ibanExists(account.getIban())) {
                throw new IbanAlreadyExistsException(account);
            }
            if (dao.idExists(account.getId())) {
                throw new IdAlreadyExistsException(account);
            }
            return dao.create(account);
        } catch (IbanAlreadyExistsException | IdAlreadyExistsException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account updateAccount(Long id ,AccountDTO accountDTO) throws  AccountNotFoundException {
        Account account;
        try {
            account = new Account();
            mapAccount(account, accountDTO);

            if (!dao.idExists(account.getId())) {
                throw  new AccountNotFoundException(account.getId());
            }
            return dao.update(id,account);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void deleteAccount(String iban) throws AccountNotFoundException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            dao.delete(iban);
        } catch (AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void withdrawAccount(String iban, double amount, String ssn) throws AccountNotFoundException, InsufficientBalanceException, SsnNotValidException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            if (!dao.ssnValid(iban,ssn)) {
                throw new SsnNotValidException(ssn);
            }
            if (amount > dao.get(iban).getBalance()) {
                throw new InsufficientBalanceException(dao.get(iban).getBalance(),amount);
            }
            dao.withdraw(iban,amount);
        } catch (AccountNotFoundException | InsufficientBalanceException | SsnNotValidException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public void depositAccount(String iban, double amount) throws InsufficientAmountException, AccountNotFoundException {
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }
            if (amount < 0) {
                throw new InsufficientAmountException(amount);
            }
            dao.deposit(iban, amount);
        } catch (InsufficientAmountException | AccountNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public Account getAccount(String iban) throws AccountNotFoundException {
        return null;
    }

    @Override
    public Account getAccount(Long id) throws AccountNotFoundException {
        return null;
    }

    public Boolean LoanApplication(String iban, double amount) throws AccountNotFoundException ,LoanDeclinedException{
        try {
            if (!dao.ibanExists(iban)) {
                throw new AccountNotFoundException(iban);
            }

            if (dao.get(iban).getBalance() < 5000) {
                throw new LoanDeclinedException(iban);
            }

            System.out.println("You took the loan mr/miss " + dao.get(iban).getHolder().getLastname());
            return true;
        } catch (AccountNotFoundException | LoanDeclinedException e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Override
    public List<Account> getAllAccounts() {
        return dao.getAll();
    }

    private void mapAccount (Account account, AccountDTO accountDTO) {
        account.setId(accountDTO.getId());
        account.setBalance(accountDTO.getBalance());
        account.setIban(accountDTO.getIban());
        User user = new User();
        mapUser(user, accountDTO.getHolder());
        account.setHolder(user);
    }

    private void mapUser (User user, UserDTO userDTO) {
        user.setId(userDTO.getId());
        user.setFirstname(userDTO.getFirstname());
        user.setLastname(userDTO.getLastname());
        user.setSsn(userDTO.getSsn());
    }
}
