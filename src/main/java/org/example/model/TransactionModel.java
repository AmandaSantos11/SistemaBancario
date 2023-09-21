package org.example.model;
public class TransactionModel {
    private String date;
    private double value;
    private int id_origin_account;
    private int id_destination_account;
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getValue() {
        return value;
    }
    public void setValue(double value) {
        this.value = value;
    }
    public int getId_origin_account() {
        return id_origin_account;
    }
    public void setId_origin_account(int id_origin_account) {
        this.id_origin_account = id_origin_account;
    }
    public int getId_destination_account() {
        return id_destination_account;
    }
    public void setId_destination_account(int id_destination_account) {
        this.id_destination_account = id_destination_account;
    }
}