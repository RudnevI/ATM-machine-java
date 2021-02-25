package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;

public interface BankService {
    BankAccount getClient(String accountNumber, String pincode);
    String getAccountNumber(BankAccount client);
    String getPinCode(BankAccount client);
    void setPinCode(BankAccount client, String pinCode);
    Integer totalBalance(BankAccount client);
    void withdrawal(BankAccount client, Integer money);
    void replenishment(BankAccount client, Integer money);
    String accountData(BankAccount client);

}
