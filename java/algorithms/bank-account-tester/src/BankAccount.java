// Bank account collection exercise. See README.md for usage.
import java.util.Locale;

/**
 * Reconstructed dependency: the original export did not include BankAccount.
 * This minimal class implements only the interface used by BankAccountTester.
 * Negative balances are permitted so the original negative-balance filter is meaningful.
 */
public class BankAccount {
    private final String accountId;
    private final String name;
    private double balance;

    public BankAccount(String accountId, String name, double balance) {
        if (accountId == null || accountId.trim().isEmpty() || name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Account ID and name are required.");
        if (!Double.isFinite(balance)) throw new IllegalArgumentException("Balance must be finite.");
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public String getName() { return name; }
    public double getBalance() { return balance; }

    public void deposit(double amount) { changeBalance(amount, false); }
    public void withdraw(double amount) { changeBalance(amount, true); }

    private void changeBalance(double amount, boolean withdrawal) {
        if (!Double.isFinite(amount) || amount < 0)
            throw new IllegalArgumentException("Amount must be finite and nonnegative.");
        double updated = withdrawal ? balance - amount : balance + amount;
        if (!Double.isFinite(updated)) throw new IllegalArgumentException("Balance would exceed the supported range.");
        balance = updated;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s %s %.2f", accountId, name, balance);
    }
}
