package com.driver;

public class Main {
    public static void main(String[] args) {
        try {
            // Creating a BankAccount
            BankAccount bankAccount = new BankAccount("John Doe", 1000, 500);

            // Depositing and Withdrawing from the BankAccount
            bankAccount.deposit(200);
            System.out.println("Balance after deposit: " + bankAccount.getBalance());

            bankAccount.withdraw(300);
            System.out.println("Balance after withdrawal: " + bankAccount.getBalance());

            // Generating an account number
            String accountNumber = bankAccount.generateAccountNumber(8, 20);
            System.out.println("Generated Account Number: " + accountNumber);

            // Creating a CurrentAccount
            CurrentAccount currentAccount = new CurrentAccount("Jane Doe", 6000, "TRADE123");

            // Validating the trade license ID
            currentAccount.validateLicenseId();
            System.out.println("Validated Trade License ID: " + currentAccount.getTradeLicenseId());

            // Creating a SavingsAccount
            SavingsAccount savingsAccount = new SavingsAccount("Bob Smith", 3000, 500, 3.5);

            // Withdrawing from SavingsAccount
            savingsAccount.withdraw(200);
            System.out.println("Balance after withdrawal from Savings: " + savingsAccount.getBalance());

            // Calculating Simple Interest
            double simpleInterest = savingsAccount.getSimpleInterest(2);
            System.out.println("Simple Interest after 2 years: " + simpleInterest);

            // Calculating Compound Interest
            double compoundInterest = savingsAccount.getCompoundInterest(4, 3);
            System.out.println("Compound Interest after 3 years compounded quarterly: " + compoundInterest);

            // Creating a StudentAccount
            StudentAccount studentAccount = new StudentAccount("Alice Johnson", 0, "ABC University");

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }
}
