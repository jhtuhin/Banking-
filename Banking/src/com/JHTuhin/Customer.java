package com.JHTuhin;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String nameOfCustomer, double initialTransactions) {
        this.name = nameOfCustomer;
        this.transactions = new ArrayList<Double>();
        addTransaction(initialTransactions);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public void addTransaction(double transaction){
        this.transactions.add(transaction);
    }
}
