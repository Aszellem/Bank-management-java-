package src.main.model.account;

public class Chequing extends Account {

    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = -200.00;

    public Chequing(Account source) {
        super(source);
    }

    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void deposit(double amount) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean withdraw(double amount) {
        if (super.getBalance() - amount < OVERDRAFT_LIMIT) {
            return false;
        } else if (super.getBalance() - amount < 0) {
            super.setBalance(super.round(super.getBalance() - amount - OVERDRAFT_FEE));
            return true;
        } else {
            super.setBalance(super.round(super.getBalance() - amount));
            return true;
        }

    }

}
