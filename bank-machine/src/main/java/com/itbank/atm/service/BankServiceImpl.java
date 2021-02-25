package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

import javax.xml.crypto.Data;
import java.util.Optional;

public class BankServiceImpl implements BankService {
    @Override
    public BankAccount getClient(String accountNumber, String pincode) {
        return Database.getBankAccountList()
                .stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber) && account.getPinCode().equals(pincode))
                .findAny()
                .orElse(null);

    }

    @Override
    public String getAccountNumber(BankAccount client) {
        String accountNumber = null;
        for (BankAccount listAccount :
                Database.getBankAccountList()) {
            if (listAccount.equals(client)) accountNumber = new String(listAccount.getAccountNumber());
        }
        return accountNumber;

    }

    @Override
    public String getPinCode(BankAccount client) {
        String pincode = null;
        for (BankAccount listAccount :
                Database.getBankAccountList()) {
            if (listAccount.equals(client)) pincode = new String(listAccount.getPinCode());
        }
        return pincode;
    }

    @Override
    public void setPinCode(BankAccount client, String pinCode) {
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                account.setPinCode(pinCode);
                break;
            }
        }
    }

    @Override
    public Integer totalBalance(BankAccount client) {
        int balance = -1;
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                balance = account.getBalance();
            }
        }
        return balance;
    }

    @Override
    public void withdrawal(BankAccount client, Integer money) {
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                account.setBalance(account.getBalance() - money);
            }
        }
    }

    @Override
    public void replenishment(BankAccount client, Integer money) {
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                account.setBalance(client.getBalance() + money);
            }
        }
    }

    @Override
    public String accountData(BankAccount client) {
        return null;
    }
}
