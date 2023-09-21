package org.example.service;
public class ValidationService {
    public boolean validateCpf(String cpf){
        if(cpf.isBlank() || !(cpf.matches("\\d+")) || cpf.length() != 11){
            return false;
        }
        return true;
    }
    public boolean validateName(String name){
        if(name.isBlank() || name.matches(".*\\d.*") || name.length() <= 3 ){
            return false;
        }
        return true;
    }
    public boolean validateAddress(String address){
        return address.matches("^[0-9a-zA-Z\\s,^~´]*$");
    }
}