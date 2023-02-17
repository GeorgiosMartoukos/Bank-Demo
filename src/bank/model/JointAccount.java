package bank.model;

public class JointAccount extends AbstractEntity{
    private String iban;
    private User holder1;
    private User holder2;
    private double balance;

    public JointAccount() {};

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public User getHolder1() {
        return holder1;
    }

    public void setHolder1(User holder1) {
        this.holder1 = holder1;
    }

    public User getHolder2() {
        return holder2;
    }

    public void setHolder2(User holder2) {
        this.holder2 = holder2;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "JointAccount{" +
                "iban='" + iban + '\'' +
                ", holder1=" + holder1 +
                ", holder2=" + holder2 +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JointAccount that = (JointAccount) o;

        if (Double.compare(that.getBalance(), getBalance()) != 0) return false;
        if (getIban() != null ? !getIban().equals(that.getIban()) : that.getIban() != null) return false;
        if (getHolder1() != null ? !getHolder1().equals(that.getHolder1()) : that.getHolder1() != null) return false;
        return getHolder2() != null ? getHolder2().equals(that.getHolder2()) : that.getHolder2() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getIban() != null ? getIban().hashCode() : 0;
        result = 31 * result + (getHolder1() != null ? getHolder1().hashCode() : 0);
        result = 31 * result + (getHolder2() != null ? getHolder2().hashCode() : 0);
        temp = Double.doubleToLongBits(getBalance());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
