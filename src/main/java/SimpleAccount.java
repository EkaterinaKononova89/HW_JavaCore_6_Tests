public class SimpleAccount extends Account {

    @Override
    public boolean add(long amount) {
        balance += amount;
        return true;
    }

    @Override
    public boolean pay(long amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            return false;
        }
        return true;
    }
}
