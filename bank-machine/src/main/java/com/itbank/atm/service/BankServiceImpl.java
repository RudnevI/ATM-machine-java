package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

public class BankServiceImpl implements BankService {
    @Override
    public BankAccount getClient(String accountNumber, String pincode) {
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (account.getAccountNumber().equals(accountNumber) &&
            account.getPinCode().equals(pincode)) {
               return account;
            }
        }
        return null;

    }

    @Override
    public String getAccountNumber(BankAccount client) {
        String accountNumber = null;
        for (BankAccount listAccount :
                Database.getBankAccountList()) {
            if (listAccount.equals(client)) accountNumber = listAccount.getAccountNumber();
        }
        return accountNumber;

    }

    @Override
    public String getPinCode(BankAccount client) {
        String pincode = null;
        for (BankAccount listAccount :
                Database.getBankAccountList()) {
            if (listAccount.equals(client)) pincode = listAccount.getPinCode();
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
        money = validateTransaction(money);
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                account.setBalance(account.getBalance() - money);
            }
        }
    }

    @Override
    public void replenishment(BankAccount client, Integer money) {
        money = validateTransaction(money);
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                account.setBalance(client.getBalance() + money);
            }
        }
    }

    @Override
    public String accountData(BankAccount client) {
        for (BankAccount account :
                Database.getBankAccountList()) {
            if (client.equals(account)) {
                return account.toString();
            }
        }
        return null;
    }
    private Integer validateTransaction(Integer money) {
        if(money < 0)  money=Math.abs(money);
        return money;
    }
}
