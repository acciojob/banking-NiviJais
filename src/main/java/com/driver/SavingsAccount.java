package com.driver;

public class SavingsAccount extends BankAccount {
    private double rate;
    private double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super(name, balance, 0); // minimum balance is 0 by default
        this.maxWithdrawalLimit = maxWithdrawalLimit;
        this.rate = rate;
    }

    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance

        if (amount > maxWithdrawalLimit) {
            throw new Exception("Maximum Withdraw Limit Exceeded");
        }

        if (amount > getBalance()) {
            throw new Exception("Insufficient Balance");
        }

        // If no exceptions are thrown, proceed with the withdrawal
        super.withdraw(amount);
    }

    public double getSimpleInterest(int years) {
        // Return the final amount considering that the bank gives simple interest on the current amount
        double interest = getBalance() * rate * years / 100;
        return getBalance() + interest;
    }

    public double getCompoundInterest(int times, int years) {
        // Return the final amount considering that the bank gives compound interest on the current amount given times per year
        double compoundRate = rate / times;
        double compoundAmount = getBalance() * Math.pow(1 + compoundRate / 100, times * years);
        return compoundAmount;
    }
}
