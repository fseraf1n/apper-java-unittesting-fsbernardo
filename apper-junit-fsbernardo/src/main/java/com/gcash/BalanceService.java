package com.gcash;

public class BalanceService {
    AccountRepository repository = new AccountRepository();
    public Double getBalance(String id) {
        return repository.getAccount(id).getBalance();
    }

    public void debit(String id, Double amount) {
        repository.getAccount(id).balance -= amount;
    }

    public void credit(String id, Double amount) {
        repository.getAccount(id).balance += amount;
    }

    public void transfer(String from, String to, Double amount) {
        debit(from, amount);
        credit(to, amount);
    }
}