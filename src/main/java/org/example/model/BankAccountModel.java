package org.example.model;
public class BankAccountModel {
    private int id_account_bank;
    private String number_account;
    private double balance;
    private int id_client;
    public int getId_account_bank() {
        return id_account_bank;
    }
    public void setId_account_bank(int id_account_bank) {
        this.id_account_bank = id_account_bank;
    }
    public String getNumber_account() {
        return number_account;
    }
    public void setNumber_account(String number_account) {
        this.number_account = number_account;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public int getId_client() {
        return id_client;
    }
    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
}