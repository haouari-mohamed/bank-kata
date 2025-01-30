package com.example.bank.kata.service;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    String printStatement();
}