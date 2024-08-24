package codesoft;

import java.util.Scanner;

class ATM {
    int PIN = 4321;
    private double balance;
    private boolean isAuthenticated;

    public ATM() {
        this.balance = 0.0;
        this.isAuthenticated = false;
    }

    public void authenticateUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();
        if (pin == PIN) {
            isAuthenticated = true;
            System.out.println("Authentication Successful...... ");
        } else {
            System.out.println("Invalid PIN. Please try again.");
            authenticateUser();  // Recursively ask for PIN until correct
        }
    }

    // Check Balance
    public void checkBalance() {
        if (isAuthenticated) {
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Please authenticate first.");
        }
    }

    // Withdraw
    public void withdraw() {
        if (isAuthenticated) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Money Withdrawal Successful.");
            } else {
                System.out.println("Insufficient Balance!!");
            }
        } else {
            System.out.println("Please authenticate first.");
        }
    }

    // Deposit
    public void deposit() {
        if (isAuthenticated) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            balance += amount;
            System.out.println("Deposit Successful.");
        } else {
            System.out.println("Please authenticate first.");
        }
    }
}

public class Task3 {
    public static void main(String[] args) {
        ATM a = new ATM();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Authenticate");
            System.out.println("2. Check Balance");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Deposit Money");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    a.authenticateUser();
                    break;
                case 2:
                    a.checkBalance();
                    break;
                case 3:
                    a.withdraw();
                    break;
                case 4:
                    a.deposit();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);
        
        scanner.close();  // Closing the scanner to prevent resource leaks
    }
}
