package org.example.controller;
import org.example.model.ClientModel;
import org.example.repository.ClientRepository;
public class ClientController {
    static ClientRepository clientRepository = new ClientRepository();
    static ClientModel clientModel = new ClientModel();
    public ClientController(){}
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public boolean registerClient(String name,String cpf,String address) {
        clientModel.setName(name);
        clientModel.setCpf(cpf);
        clientModel.setAddress(address);

        return clientRepository.registerClient(
                clientModel.getName(),
                clientModel.getCpf(),
                clientModel.getAddress());
    }
    public boolean deleteClient(String cpf) {
        clientModel.setCpf(cpf);
        return clientRepository.deleteClient(clientModel.getCpf());
    }
    public boolean login(String cpf){
        clientModel.setCpf(cpf);

        return clientRepository.login(clientModel.getCpf());
    }
}