package com.driver;

import java.util.Arrays;

public class CurrentAccount extends BankAccount {
    private String tradeLicenseId; // consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        super(name, balance, 5000); // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        this.tradeLicenseId = tradeLicenseId;

        if (balance < 5000) {
            throw new Exception("Insufficient Balance");
        }
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are the same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception

        if (!isValidLicenseId(tradeLicenseId)) {
            char[] chars = tradeLicenseId.toCharArray();
            Arrays.sort(chars);
            String sortedLicenseId = new String(chars);
            if (!isValidLicenseId(sortedLicenseId)) {
                throw new Exception("Valid License can not be generated");
            }
            tradeLicenseId = sortedLicenseId;
        }
    }

    private boolean isValidLicenseId(String licenseId) {
        for (int i = 0; i < licenseId.length() - 1; i++) {
            if (licenseId.charAt(i) == licenseId.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }
}
