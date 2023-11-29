package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        // Each digit of an account number can lie between 0 and 9 (both inclusive)
        // Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        // If it is not possible, throw "Account Number can not be generated" exception

        if (digits <= 0 || sum < 0 || sum > 9 * digits) {
            throw new Exception("Invalid input parameters");
        }

        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < digits; i++) {
            int maxPossibleDigit = Math.min(9, sum);
            int randomDigit = random.nextInt(maxPossibleDigit + 1);
            accountNumber.append(randomDigit);
            sum -= randomDigit;
        }

        if (sum != 0) {
            throw new Exception("Account Number can not be generated");
        }

        return accountNumber.toString();
    }

    public void deposit(double amount) {
        // Add amount to balance
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception if the remaining amount would be less than minimum balance
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}
