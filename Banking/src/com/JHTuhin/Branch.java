package com.JHTuhin;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String nameOfBranch) {
        this.name = nameOfBranch;
        this.customers=new ArrayList<Customer>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public boolean newCustomer(String nameOfCustomer, double initialTransaction){
        if(findCustomer(nameOfCustomer)==null){
            this.customers.add(new Customer(nameOfCustomer,initialTransaction));
            return true;
        }
        return false;
    }

    public boolean addCustomerTransaction(String nameOfCustomer,double transaction){
        Customer existingCustomer=findCustomer(nameOfCustomer);
        if(existingCustomer!=null){
            existingCustomer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    private Customer findCustomer(String nameOfCustomer){
        for (int i=0;i<customers.size();i++){
            Customer customer= this.customers.get(i);
            if(customer.getName().equals(nameOfCustomer)){
                return customer;
            }
        }
        return null;
    }
}
