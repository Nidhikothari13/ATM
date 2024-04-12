import java.util.Scanner;

class User {
    private String username;
    private String password;
    private double balance;

    // Constructor
    public User(String username, String password, double balance) {
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }
}

class Admin {
    private String username;
    private String password;

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method to check credentials
    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("admin", "admin123");
        User user = new User("user1", "pass123", 1000.0);

        System.out.println("Welcome to the ATM");

        // Authentication
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (admin.authenticate(username, password)) {
            System.out.println("Admin login successful");
            adminMenu(user, scanner);
        } else if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
            System.out.println("User login successful");
            userMenu(user, scanner);
        } else {
            System.out.println("Invalid username or password");
        }
        scanner.close(); // Close scanner to prevent resource leak
    }

    // Function to display admin menu
    public static void adminMenu(User user, Scanner scanner) {
        boolean adminLoggedIn = true;
        while (adminLoggedIn) {
            System.out.println("\nAdmin Menu");
            System.out.println("1. Withdrawal");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    user.withdraw(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Balance: $" + user.getBalance());
                    break;
                case 4:
                    adminLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // Function to display user menu
    public static void userMenu(User user, Scanner scanner) {
        boolean userLoggedIn = true;
        while (userLoggedIn) {
            System.out.println("\nUser Menu");
            System.out.println("1. Withdrawal");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    user.withdraw(withdrawalAmount);
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    user.deposit(depositAmount);
                    break;
                case 3:
                    System.out.println("Balance: $" + user.getBalance());
                    break;
                case 4:
                    userLoggedIn = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
