package com.itbank.atm.service;
import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

public class BankServiceImpl implements BankService {
    @Override
    public BankAccount getClient(String accountNumber, String pincode) {

    }

    @Override
    public String getAccountNumber(BankAccount client) {
        return null;
    }

    @Override
    public String getPinCode(BankAccount client) {
        return null;
    }

    @Override
    public void setPinCode(BankAccount client, String pinCode) {

    }

    @Override
    public Integer totalBalance(BankAccount client) {
        return null;
    }

    @Override
    public void withdrawal(BankAccount client, Integer money) {

    }

    @Override
    public void replenishment(BankAccount client, Integer money) {

    }

    @Override
    public String accountData(BankAccount client) {
        return null;
    }
}
