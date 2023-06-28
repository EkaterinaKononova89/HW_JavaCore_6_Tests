public abstract class Account {
    long balance;

    abstract public boolean add(long amount);

    abstract public boolean pay(long amount);

    public boolean transfer(Account account, long amount) {
        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                add(amount);
                return false;
            }
        } else {
            return false;
        }
    }

    public long getBalance() {

        return this.balance;
    }

    public void setBalance(long balance) {

        this.balance = balance;
    }
}

