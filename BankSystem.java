import java.util.ArrayList;
import java.util.Scanner;

class Account {
    int accountNumber;
    String name;
    double balance;

    // Constructor
    Account(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    // Deposit
    void deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Amount deposited successfully!");
        } else {
            System.out.println("Invalid amount!");
        }
    }

    // Withdraw
    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } 
        else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } 
        else {
            balance = balance - amount;
            System.out.println("Amount withdrawn successfully!");
        }
    }

    // Check Balance
    void checkBalance() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Name           : " + name);
        System.out.println("Balance        : Rs." + balance);
    }
}

public class BankSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ArrayList to store accounts
        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                // CREATE ACCOUNT
                case 1:
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    Account newAccount =
                            new Account(accNo, name, balance);

                    accounts.add(newAccount);

                    System.out.println("Account created successfully!");
                    break;

                // DEPOSIT
                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAcc = sc.nextInt();

                    Account depositAccount = null;

                    for (Account acc : accounts) {
                        if (acc.accountNumber == depositAcc) {
                            depositAccount = acc;
                            break;
                        }
                    }

                    if (depositAccount != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amount = sc.nextDouble();

                        depositAccount.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }

                    break;

                // WITHDRAW
                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAcc = sc.nextInt();

                    Account withdrawAccount = null;

                    for (Account acc : accounts) {
                        if (acc.accountNumber == withdrawAcc) {
                            withdrawAccount = acc;
                            break;
                        }
                    }

                    if (withdrawAccount != null) {
                        System.out.print("Enter Withdrawal Amount: ");
                        double amount = sc.nextDouble();

                        withdrawAccount.withdraw(amount);
                    } else {
                        System.out.println("Account not found!");
                    }

                    break;

                // CHECK BALANCE
                case 4:
                    System.out.print("Enter Account Number: ");
                    int checkAcc = sc.nextInt();

                    Account checkAccount = null;

                    for (Account acc : accounts) {
                        if (acc.accountNumber == checkAcc) {
                            checkAccount = acc;
                            break;
                        }
                    }

                    if (checkAccount != null) {
                        checkAccount.checkBalance();
                    } else {
                        System.out.println("Account not found!");
                    }

                    break;

                // EXIT
                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}