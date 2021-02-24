package com.itbank.atm.model;

public class NationalBankAccount extends BankAccount {
    private String fullname;



    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public NationalBankAccount(String fullnam, Integer balance, String accountNumber, String pinCode) {
        super(balance, accountNumber, pinCode);
        this.fullname = fullname;
    }

}