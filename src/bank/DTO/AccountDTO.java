package bank.DTO;

public class AccountDTO {
    private Long id;
    private String iban;
    private UserDTO holder;
    private double balance;


    public AccountDTO() {};

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserDTO getHolder() {
        return holder;
    }

    public void setHolder(UserDTO holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
