import java.util.*;
import java.io.*;

public class atm {
    private static double balance = 1000.00;
    private static List<String> transactionHistory = new ArrayList<>();

    public static void choice() {
        System.out.println("------ATM Interface------");
        System.out.println("1. Transactions History");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Check Balance");
        System.out.println("6. Quit");
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1:
                showTransactionHistory();
                break;
            case 2:
                withdraw(sc);
                break;
            case 3:
                deposit(sc);
                break;
            case 4:
                transfer(sc);
                break;
            case 5:
                checkBalance();
                break;
            case 6:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void showTransactionHistory() {
        System.out.println("Transaction History:");
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public static void withdraw(Scanner sc) {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        if (balance < amount) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdraw: $" + amount);
            System.out.println("Successfully withdrew $" + amount);
        }
    }

    public static void deposit(Scanner sc) {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        balance += amount;
        transactionHistory.add("Deposit: $" + amount);
        System.out.println("Successfully deposited $" + amount);
    }

    public static void transfer(Scanner sc) {
        System.out.print("Enter amount to transfer: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter recipient's account number: ");
        String accountNumber = sc.nextLine();

        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Transfer: $" + amount + " to account " + accountNumber);
            System.out.println("Successfully transferred $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void checkBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public static void main(String[] args) {
        while (true) {
            choice();
        }
    }
}
