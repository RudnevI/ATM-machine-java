package com.itbank.atm.service;

import com.itbank.atm.dao.Database;
import com.itbank.atm.model.BankAccount;
import com.itbank.atm.model.CityBankAccount;
import com.itbank.atm.model.NationalBankAccount;

import java.util.Scanner;

public class CityBankATM {
    private static void displayMenu() {
        System.out.println("PRESS [1] TO CASH WITHDRAWAL\n" +
                "\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "\n" +
                "PRESS [3] TO CHANGE PIN CODE\n" +
                "\n" +
                "PRESS [4] TO REFILL ACCOUNT\n" +
                "\n" +
                "PRESS [5] TO VIEW ACCOUNT DATA\n" +
                "\n" +
                "PRESS [6] TO EXIT");
        line();
    }

    private static void displayShortenedMenu() {
        System.out.println("PRESS [1] TO CASH WITHDRAWAL\n" +
                "PRESS [2] TO VIEW BALANCE\n" +
                "PRESS [3] TO EXIT");
        line();
    }

    private static void line() {
        System.out.println("\n-----------------------------------------------------------------");
    }

    public static void main(String[] args) {
        BankService service = new BankServiceImpl();

        Scanner input = new Scanner(System.in);
        System.out.print("Account number: ");
        String accountNumber = input.nextLine();
        System.out.print("Pin code: ");
        String pinCode = input.nextLine();
        String tmp = "";
        BankAccount client = service.getClient(accountNumber, pinCode);
        int option;
        if (client == null) System.out.println("Client not found");
        else if (client.getClass().isInstance(new CityBankAccount())) {
            while (true) {
                displayMenu();
                option = input.nextInt();
                if (option == 1) {
                    System.out.print("Amount of cash to withdraw: ");
                    int money = Math.abs(input.nextInt());
                    service.withdrawal(client, money);
                } else if (option == 2) {
                    System.out.println(service.totalBalance(client));

                } else if (option == 3) {
                    System.out.print("New pin code: ");
                    String newPinCode = input.nextLine();
                    service.setPinCode(client, newPinCode);
                } else if (option == 4) {
                    System.out.println("Amount of money to replenish balance: ");
                    int money = Math.abs(input.nextInt());
                    service.replenishment(client, money);
                } else if (option == 5) {
                    System.out.println(client.toString());

                } else if (option == 6) {
                    break;
                } else {
                    System.out.println("Invalid option");

                }
                System.out.println(tmp);
                tmp = input.nextLine();

            }

        } else if (client.getClass().isInstance(new NationalBankAccount())) {
            while (true) {
                displayShortenedMenu();
                option = input.nextInt();
                if (option == 1) {
                    System.out.print("Amount of cash to withdraw: ");
                    int money = input.nextInt();
                    if (service.totalBalance(client) < 200
                            || service.totalBalance(client) < money) {
                        System.out.println("Not enough money");

                    } else {
                        money += 200;
                        service.withdrawal(client, money);
                    }
                } else if (option == 2) {
                    System.out.println(service.totalBalance(client));

                } else if (option == 3) {
                    break;
                } else {
                    System.out.println("Invalid option");

                }
                System.out.println(tmp);
                tmp = input.nextLine();

            }
        } else {
            System.out.println("Service for this bank is yet to be implemented");
        }

    }
}
