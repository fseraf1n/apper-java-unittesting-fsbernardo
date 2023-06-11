package com.gcash;

public class Account {
    protected String id;
    protected String name;
    protected Double balance;
    public Account(String id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Double getBalance() {
        return this.balance;
    }
}