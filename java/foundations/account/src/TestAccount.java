// Account model and demonstration. See README.md for usage.
import java.text.NumberFormat;
import java.util.Locale;

/** Demonstration only, not an automated test suite. */
public class TestAccount {
    public static void main(String[] args) {
        Account account = new Account(1122, 20000.0);
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500.0);
        account.deposit(3000.0);
        NumberFormat money = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Account ID: " + account.getId());
        System.out.println("Balance: " + money.format(account.getBalance()));
        System.out.printf(Locale.US, "Monthly interest rate: %.4f%%%n", account.getMonthlyInterestRate());
        System.out.println("Monthly interest amount: " + money.format(account.getMonthlyInterestAmount()));
        System.out.println("Date created: " + account.getDateCreated());
    }
}
