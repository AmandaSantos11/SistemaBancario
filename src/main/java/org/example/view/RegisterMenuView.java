package org.example.view;
import org.example.controller.ClientController;
import org.example.service.ValidationService;
import java.util.Scanner;
public class RegisterMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ValidationService validationService = new ValidationService();
    static ClientController clientController = new ClientController();
    static MainMenuView mainMenuView = new MainMenuView();
    private String name;
    private String cpf;
    private String address;
    public void registerClient(){
        System.out.println("== Registrar ==");
        if (registerName() && registerCpf() && registerAddress()){
            clientController.registerClient(name,cpf,address);
        }
        System.out.println("Você foi cadastrado como cliente com sucesso!");
        mainMenuView.mainMenu();
    }
    private boolean registerName(){
        boolean loop=false;
        System.out.println("Digite o nome:");
        name = scanner.nextLine();
        do {
            if (validationService.validateName(name)){
                loop=true;
            }
            else {
                System.out.println("Nome inválido,digite novamente");
                name = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerCpf(){
        boolean loop=false;
        System.out.println("Digite seu cpf:");
        cpf = scanner.nextLine();
        do {
            if (validationService.validateCpf(cpf)){
                loop=true;
            }
            else {
                System.out.println("Cpf inválido,digite novamente");
                cpf = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
    private boolean registerAddress(){
        boolean loop=false;
        System.out.println("Digite seu endereço:");
        address = scanner.nextLine();
        do {
            if (validationService.validateAddress(address)){
                loop=true;
            }
            else {
                System.out.println("Email inválido,digite novamente");
                address = scanner.nextLine();
            }
        }while (!loop);
        return true;
    }
}