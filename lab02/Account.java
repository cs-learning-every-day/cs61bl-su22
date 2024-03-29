/**
 * This class represents a bank account whose current balance is a nonnegative
 * amount in US dollars.
 */
public class Account {

    private int balance;
    private Account parentAccount;

    /**
     * Initialize an account with the given balance.
     */
    public Account(int balance) {
        this(balance, null);
    }

    public Account(int balance, Account parentAccount) {
        this.balance = balance;
        this.parentAccount = parentAccount;
    }

    /**
     * Returns the balance for the current account.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Deposits amount into the current account.
     */
    public void deposit(int amount) {
        if (amount < 0) {
            System.out.println("Cannot deposit negative amount.");
        } else {
            balance += amount;
        }
    }

    /**
     * Subtract amount from the account if possible. If subtracting amount
     * would leave a negative balance, print an error message and leave the
     * balance unchanged.
     */
    public boolean withdraw(int amount) {
        if (amount < 0) {
            System.out.println("Cannot withdraw negative amount.");
            return false;
        } else if (balance < amount) {
            int total = balance;
            Account p = this.parentAccount;
            while (p != null) {
                total += p.balance;
                p = p.parentAccount;
            }
            if (total < amount) {
                System.out.println("Insufficient funds");
                return false;
            }
            amount -= this.balance;
            this.balance = 0;
            p = this.parentAccount;
            while (amount != 0) {
                if (amount > p.balance) {
                    p.balance = 0;
                    amount -= p.balance;
                } else {
                    p.balance -= amount;
                    amount = 0;
                }
                p = p.parentAccount;
            }
            return true;
        } else {
            balance -= amount;
            return true;
        }
    }

    /**
     * Merge account other into this account by removing all money from other
     * and depositing it into this account.
     */
    public void merge(Account other) {
        this.balance += other.balance;
        other.balance = 0;
    }
}
