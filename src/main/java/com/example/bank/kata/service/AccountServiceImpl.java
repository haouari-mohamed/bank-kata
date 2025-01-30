package com.example.bank.kata.service;

import com.example.bank.kata.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private int balance = 0;
    private List<Transaction> transactions = new ArrayList<>();

    @Override
    public void deposit(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
        transactions.add(new Transaction(LocalDate.now(), amount, balance));
    }

    @Override
    public void withdraw(int amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
        transactions.add(new Transaction(LocalDate.now(), -amount, balance));
    }

    @Override
    public String printStatement() {
        StringBuilder statement = new StringBuilder("Date | Amount | Balance\n");
        for (Transaction transaction : transactions) {
            statement.append(transaction.toString()).append("\n");
        }
        return statement.toString();
    }
}