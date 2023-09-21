package org.example.controller;
import org.example.model.TransactionModel;
import org.example.repository.TransactionRepository;
public class TransactionController {
    static TransactionRepository transactionRepository = new TransactionRepository();
    static TransactionModel transactionModel = new TransactionModel();
    public TransactionController(){}
    public TransactionController(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    public boolean registerTransaction(String date,double value,int id_origin_account,int id_destination_account){
        transactionModel.setDate(date);
        transactionModel.setValue(value);
        transactionModel.setId_origin_account(id_origin_account);
        transactionModel.setId_destination_account(id_destination_account);

        return transactionRepository.registerTransaction(
                transactionModel.getDate(),
                transactionModel.getValue(),
                transactionModel.getId_origin_account(),
                transactionModel.getId_destination_account()
        );
    }
    public boolean showAllTransactionsofaSpecificAccount(int id_origin_account){
        transactionModel.setId_origin_account(id_origin_account);

        return  transactionRepository.showAllTransactionsofaSpecificAccount(transactionModel.getId_origin_account());
    }
}