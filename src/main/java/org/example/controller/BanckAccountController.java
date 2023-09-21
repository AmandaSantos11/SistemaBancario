package org.example.controller;
import org.example.model.BankAccountModel;
import org.example.repository.BankAccountRepository;
public class BanckAccountController {
    static BankAccountRepository bankAccountRepository = new BankAccountRepository();
    static BankAccountModel bankAccountModel = new BankAccountModel();
    public BanckAccountController(){}
    public BanckAccountController(BankAccountRepository bankAccountRepository){
        this.bankAccountRepository = bankAccountRepository;
    }
    public boolean registerAccount(String number_account,double balance,int id_client){
        bankAccountModel.setNumber_account(number_account);
        bankAccountModel.setBalance(balance);
        bankAccountModel.setId_client(id_client);

        return bankAccountRepository.registerAccount(
                bankAccountModel.getNumber_account(),
                bankAccountModel.getBalance(),
                bankAccountModel.getId_client()
        );
    }
    public boolean deleteAccount(String number_account){
        bankAccountModel.setNumber_account(number_account);

        return bankAccountRepository.deleteAccount(bankAccountModel.getNumber_account());
    }
    public boolean showBalance(String number_account){
        bankAccountModel.setNumber_account(number_account);

        return bankAccountRepository.showBalance(bankAccountModel.getNumber_account());
    }
    public boolean subtractBalanceAccount(int id_account_bank,double value){
        bankAccountModel.setId_account_bank(id_account_bank);

        return bankAccountRepository.subtractBalanceAccount(
                bankAccountModel.getId_account_bank(),
                value
        );
    }
    public boolean addBalanceAccount(int id_account_bank,double value){
        bankAccountModel.setId_account_bank(id_account_bank);

        return bankAccountRepository.addBalanceAccount(
                bankAccountModel.getId_account_bank(),
                value
        );
    }
    public boolean showClientAccounts(int id_cliente){
        bankAccountModel.setId_client(id_cliente);

        return bankAccountRepository.showClientAccounts(bankAccountModel.getId_client());
    }
}