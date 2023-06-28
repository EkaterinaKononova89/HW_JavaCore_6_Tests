public class CreditAccount extends Account {
    protected long creditLimit;

    public CreditAccount(long creditLimit) {
        //super(balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public boolean add(long amount) {
        if (getBalance() + amount <= 0) {
            balance += amount;
        } else {
            return false;
        }
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (getBalance() - amount >= creditLimit) {
            balance -= amount;
        } else {
            return false;
        }
        return true;
    }
}
