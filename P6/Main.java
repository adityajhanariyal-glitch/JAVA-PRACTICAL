

class InvalidAmountException extends Exception {
    InvalidAmountException(String message) {
        super(message);
    }
}

class BankAccount {
    static String bankName = "ABC Bank";
    private double balance;

    final int accountNumber;

    BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    static void showBankName() {
        System.out.println("Bank: " + bankName);
    }

    void deposit(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException(
                "Amount must be positive."
            );
        }
        balance += amount;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

public class Practical6 {
    public static void main(String[] args) {
        BankAccount.showBankName();

        BankAccount account = new BankAccount(101, 5000);

        try {
            account.deposit(2000);
            account.deposit(-500);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Transaction completed.");
        }

        account.display();
    }
}
