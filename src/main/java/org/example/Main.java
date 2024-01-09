package org.example;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            // Сценарій 1: Створення рахунку і здійснення операцій з ним
            BankAccount account1 = bank.createAccount("John Doe", 1000.0);
            System.out.println(account1.getAccountSummary());

            account1.deposit(500.0);
            System.out.println("After deposit: " + account1.getBalance());

            account1.withdraw(200.0);
            System.out.println("After withdrawal: " + account1.getBalance());

            // Сценарій 2: Переказ коштів між рахунками
            BankAccount account2 = bank.createAccount("Jane Doe", 1500.0);
            System.out.println(account2.getAccountSummary());

            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300.0);
            System.out.println("After transfer: " + account1.getBalance() + " | " + account2.getBalance());

            // Сценарій 3: Обробка виняткових ситуацій
            account1.withdraw(2000.0);  // InsufficientFundsException
        } catch (NegativeAmountException | InsufficientFundsException | AccountNotFoundException e) {
            System.err.println("Exception: " + e.getMessage());
        }
    }
}