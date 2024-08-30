import java.util.Scanner;

class Account {
    private String userName;
    private String pin;
    private double balance;

    public Account(String userName, String pin, double balance) {
        this.userName = userName;
        this.pin = pin;
        this.balance = balance;
    }

    public String getUserName() {
        return userName;
    }

    public boolean validatePin(String inputPin) {
        return pin.equals(inputPin);
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount);
            System.out.println("Remaining Balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Account account = new Account("Vignaesh", "1234", 1000.00);

        System.out.println("Welcome to the ATM Interface");

        System.out.print("Enter your username: ");
        String inputUserName = scanner.nextLine();

        System.out.print("Enter your PIN: ");
        String inputPin = scanner.nextLine();

        if (!account.getUserName().equals(inputUserName) || !account.validatePin(inputPin)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting the system. Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
