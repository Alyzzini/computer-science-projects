// Bank account collection exercise. See README.md for usage.
public class BankAccountTester {
    public static void main(String[] args) {

        // Synthetic fictional identities; original numeric balances retained for this study copy.
        BankAccount[] accounts = {
            new BankAccount("DEMO001", "Sample One", 67670),
            new BankAccount("DEMO002", "Sample Two", 167.00),
            new BankAccount("DEMO003", "Sample Three", 467.00),
            new BankAccount("DEMO004", "Sample Four", 167.00),
            new BankAccount("DEMO005", "Sample Five", 5670.00)
        };

        // Call some methods to test them
        accounts[0].deposit(100);      // Sample One becomes 67770.00.
        accounts[1].withdraw(200);     // Sample Two becomes -33.00; overdrafts are allowed for this filtering exercise.

        System.out.println("All accounts:");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        // Calculate and display total amount of all balances
        double total = 0;
        for (BankAccount acc : accounts) {
            total += acc.getBalance();
        }
        System.out.printf("%nTotal of all balances: %.2f%n", total);

        // Display bank account info with balance higher than 3500
        System.out.println("\nAccounts with balance > 3500:");
        for (BankAccount acc : accounts) {
            if (acc.getBalance() > 3500) {
                System.out.println(acc);
            }
        }

        // Remove all bank accounts with negative balances (create a new array without them)
        int countNonNegative = 0;
        for (BankAccount acc : accounts) {
            if (acc.getBalance() >= 0) countNonNegative++;
        }

        BankAccount[] nonNegativeAccounts = new BankAccount[countNonNegative];
        int idx = 0;
        for (BankAccount acc : accounts) {
            if (acc.getBalance() >= 0) {
                nonNegativeAccounts[idx++] = acc;
            }
        }

        accounts = nonNegativeAccounts;

        System.out.println("\nAfter removing negative balances:");
        for (BankAccount acc : accounts) {
            System.out.println(acc);
        }

        // Display the balance of the account holder named "Sample Four"
        System.out.println("\nBalance for Sample Four:");
        boolean found = false;
        for (BankAccount acc : accounts) {
            if (acc.getName().equals("Sample Four")) {
                System.out.printf("%.2f%n", acc.getBalance());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Sample Four not found.");
        }
    }
}
