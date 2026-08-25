import java.util.Scanner;
public class BankingInformationSystem {

    static Scanner scanner = new Scanner(System.in);
    static String accountHolder = "";
    static long accountNumber;
    static double balance = 0.0;
    static boolean accountCreated = false;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BANKING INFORMATION SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account Information");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;

                case 2:
                    depositMoney();
                    break;

                case 3:
                    withdrawMoney();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    displayAccount();
                    break;

                case 6:
                    System.out.println("Thank you for using the Banking Information System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        scanner.close();
    }

    static void createAccount() {

        if (accountCreated) {
            System.out.println("An account already exists.");
            return;
        }

        scanner.nextLine();

        System.out.print("Enter account holder name: ");
        accountHolder = scanner.nextLine();

        System.out.print("Enter account number: ");
        accountNumber = scanner.nextLong();

        System.out.print("Enter initial deposit: ");
        balance = scanner.nextDouble();

        if (balance < 0) {
            System.out.println("Initial deposit cannot be negative.");
            balance = 0;
        }

        accountCreated = true;

        System.out.println("Account created successfully!");
    }

    static void depositMoney() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else {
            balance += amount;
            System.out.println("Deposit successful.");
            System.out.println("Current balance: " + balance);
        }
    }

    static void withdrawMoney() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount <= 0) {
            System.out.println("Amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            System.out.println("Current balance: " + balance);
        }
    }

    static void checkBalance() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.println("Current balance: " + balance);
    }

    static void displayAccount() {

        if (!accountCreated) {
            System.out.println("Please create an account first.");
            return;
        }

        System.out.println("\n===== ACCOUNT INFORMATION =====");
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Balance        : " + balance);
    }
}