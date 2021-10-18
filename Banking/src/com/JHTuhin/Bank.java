package com.JHTuhin;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String nameOfTheBank) {
        this.name = nameOfTheBank;
        branches = new ArrayList<Branch>();
    }

    public boolean addBranch(String nameOfTheBranch) {
        if (findBranch(nameOfTheBranch) == null) {
            this.branches.add(new Branch(nameOfTheBranch));
            return true;
        }
        return false;
    }

    public boolean addCustomer(String nameOfTheBranch,
                               String nameOfTheCustomer, double initialTransaction) {
        Branch branch = findBranch(nameOfTheBranch);
        if (branch != null) {
            return branch.newCustomer(nameOfTheCustomer, initialTransaction);
        }
        return false;
    }

    public boolean addCustomerTransaction(
            String nameOfTheBranch, String nameOfTheCustomer, double initialTransaction) {
        Branch branch = findBranch(nameOfTheBranch);
        if (branch != null) {
            return branch.addCustomerTransaction(nameOfTheCustomer, initialTransaction);
        }

        return false;
    }

    private Branch findBranch(String nameOfTheBranch) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getName().equals(nameOfTheBranch)) {
                return branch;
            }
        }
        return null;
    }

    public boolean listCustomers(String nameOfTheBranch, boolean printTransactions) {
        Branch branch = findBranch(nameOfTheBranch);
        if (branch != null) {
            System.out.println("Customer details for branch " + branch.getName());
            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i = 0; i < branchCustomers.size(); i++) {
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i + 1) + "]");
                if (printTransactions) {
                    System.out.println("Transactions");
                    ArrayList<Double> transactions = branchCustomer.getTransactions();
                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("[" + (j + 1) + "]  Amount " + transactions.get(j));
                    }
                }

            }
           return true;
        }
        return false;
    }
}
