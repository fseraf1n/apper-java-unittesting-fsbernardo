package com.gcash;

import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

public class AccountRepository {
    private final List<Account> accounts = new ArrayList<>();
    //private final Map<String, Account> accounts = new HashMap<>();

    public String createAccount(String name, Double initialBalance) {
        String id = UUID.randomUUID().toString();
        Account account = new Account(id, name, initialBalance);
        accounts.add(account);
        return id;
    }

    public Account getAccount(String id) {
        for (Account account: accounts) {
            if (account.id().equals(id)) {
                return account;
            }
        }
        return null;
    }

    public void deleteAccount(String id) {
        //accounts.removeIf(account -> account.id().equals(id));
        for (Account account:accounts) {
            if (account.id().equals(id)) {
                accounts.remove(account);
                return;
            }
        }
    }

    public Integer getNumberOfAccounts() {
        return accounts.size();
    }
}