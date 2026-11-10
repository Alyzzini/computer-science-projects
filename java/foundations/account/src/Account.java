// Account model and demonstration. See README.md for usage.
import java.util.Date;

/** Small educational model; double currency is retained from the original exercise. */
public class Account {
    private int id;
    private double balance;
    private double annualInterestRate;
    private final Date dateCreated;

    public Account() { this(0, 0.0); }
    public Account(int id, double balance) {
        if (id < 0) throw new IllegalArgumentException("ID must be non-negative.");
        requireNonNegativeFinite(balance, "Balance");
        this.id = id;
        this.balance = balance;
        annualInterestRate = 0.0;
        dateCreated = new Date();
    }
    public int getId() { return id; }
    public void setId(int id) {
        if (id < 0) throw new IllegalArgumentException("ID must be non-negative.");
        this.id = id;
    }
    public double getBalance() { return balance; }
    public void setBalance(double balance) {
        requireNonNegativeFinite(balance, "Balance");
        this.balance = balance;
    }
    public double getAnnualInterestRate() { return annualInterestRate; }
    public void setAnnualInterestRate(double annualInterestRate) {
        requireNonNegativeFinite(annualInterestRate, "Annual interest rate");
        if (annualInterestRate > 100.0) throw new IllegalArgumentException("Annual interest rate must not exceed 100 percent.");
        this.annualInterestRate = annualInterestRate;
    }
    public Date getDateCreated() { return new Date(dateCreated.getTime()); }
    public double getMonthlyInterestRate() { return annualInterestRate / 12.0; }
    public double getMonthlyInterestAmount() { return balance * (getMonthlyInterestRate() / 100.0); }
    public void withdraw(double amount) {
        requireNonNegativeFinite(amount, "Withdrawal");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds.");
        balance -= amount;
    }
    public void deposit(double amount) {
        requireNonNegativeFinite(amount, "Deposit");
        double nextBalance = balance + amount;
        if (!Double.isFinite(nextBalance)) throw new IllegalArgumentException("Deposit would overflow the balance.");
        balance = nextBalance;
    }
    private static void requireNonNegativeFinite(double value, String label) {
        if (!Double.isFinite(value) || value < 0.0)
            throw new IllegalArgumentException(label + " must be finite and non-negative.");
    }
}
