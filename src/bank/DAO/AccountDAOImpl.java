package bank.DAO;



import bank.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements IAccountDAO{
    public static final List<Account> accounts = new ArrayList<>();


    @Override
    public Account create(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(Long id, Account account) {
        //return accounts.set(accounts.indexOf(account), account);
        return accounts.set(getIndexById(id), account);

    }

    @Override
    public void delete(String iban) {
        accounts.removeIf((contacts) -> contacts.getIban().equals(iban));
    }

    @Override
    public Account get(Long id) {
        int pos = getIndexById(id);
        if (pos == -1) return null;
        return accounts.get(pos);
    }

    public Account get(String iban) {
        int pos = getIndexByIban(iban);
        if (pos == -1) return null;
        return accounts.get(pos);
    }

    @Override
    public boolean withdraw(String iban, double amount) {
        for (Account acc : accounts ) {
            if (acc.getIban().equals(iban)) {
                acc.setBalance(acc.getBalance() - amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deposit(String iban, double amount) {
        for (Account acc : accounts ) {
            if (acc.getIban().equals(iban)) {
                acc.setBalance(acc.getBalance() + amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Account> getAll() {
        return new ArrayList<>(accounts);
    }

    public boolean ibanExists(String iban) {
        return getIndexByIban(iban) != -1;
    }

    public boolean idExists(Long id) {
        return getIndexById(id) != -1;
    }

    @Override
    public boolean ssnValid (String iban,String ssn) {
        //return (accounts.get(getIndexById(id)).getHolder().getSsn().equals(ssn));
        return  accounts.get(getIndexByIban(iban)).getHolder().getSsn().equals(ssn);

    }

    public int getIndexById(Long id) {
        int pos = -1;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId().equals(id)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
    public  int getIndexByIban(String iban) {
        int pos = -1;
        for(int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getIban().equals(iban)) {
                pos = i;
                break;
            }
        }
        return pos;
    }
}
