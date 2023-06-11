package com.gcash.revision;

public class BalanceService {
    AccountRepository repository = new AccountRepository();
    public Double getBalance(String id) {
        return repository.getAccount(id).balance();
    }

    public void debit(String id, Double amount) {
        repository.updateAccount(id, getBalance(id) - amount);
    }

    public void credit(String id, Double amount) {
        repository.updateAccount(id, getBalance(id) + amount);
    }

    public void transfer(String from, String to, Double amount) {
        debit(from, amount);
        credit(to, amount);
    }
}