package com.gcash.revision;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();
    public String createAccount(String name, Double initialBalance) {
        String id = UUID.randomUUID().toString();
        Account account = new Account(id, name, initialBalance);
        accounts.add(account);
        return id;
    }

    public void updateAccount(String id, Double amount) {
        String name = this.getAccount(id).name();

        // delete the previous record
        this.deleteAccount(id);

        // create a new account with the updated balance
        Account account = new Account(id, name, amount);
        accounts.add(account);
    }
    public Account getAccount(String id) {
        return accounts
                .stream()
                .filter(account -> id.equals(account.id()))
                .findFirst()
                .orElse(null);
    }

    public void deleteAccount(String id) {
        accounts
                .stream()
                .filter(account -> id.equals(account.id()))
                .findFirst()
                .ifPresent(accounts::remove);
    }
    public Integer getNumberOfAccounts() {
        return accounts.size();
    }

    public boolean noRegisteredAccount() {
        return accounts.isEmpty();
    }
}