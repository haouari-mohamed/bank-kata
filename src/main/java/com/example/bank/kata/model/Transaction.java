package com.example.bank.kata.model;

import java.time.LocalDate;

public class Transaction {
    private LocalDate date;
    private int amount;
    private int balance;

    public Transaction(LocalDate date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getAmount() {
        return amount;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return date + " | " + amount + " | " + balance;
    }
}