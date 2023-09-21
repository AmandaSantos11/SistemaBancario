package org.example.view;
import org.example.controller.BanckAccountController;
import java.util.Scanner;
public class MainMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ClientMenuView clientMenuView = new ClientMenuView();
    static RegisterMenuView registerMenuView = new RegisterMenuView();
    static BanckAccountController banckAccountController = new BanckAccountController();
    public void mainMenu(){
        mainMenuOptions();
        int choice;

        do {
            System.out.print("Digite sua escolha: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    clientMenuView.login();
                    break;

                case 2:
                    registerMenuView.registerClient();
                    break;

                case 3:
                    if (registerAccount()){
                        System.out.println("Conta registrada!");
                    }
                    else {
                        System.out.println("Ocorreu um error no registro da conta!");
                    }
                    break;

                case 4:
                    System.out.println("Digite o número da conta que deseja deletar");
                    String number_account = scanner.next();
                    banckAccountController.deleteAccount(number_account);
                    System.out.println("Conta deletada com sucesso!");
                    break;

                case 5:
                    System.out.println("Obrigado(a) por utilizar nosso sistema!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (choice!=5);
    }
    private void mainMenuOptions(){
        System.out.println("==== BEM-VINDO ====");
        System.out.println("1-Logar | 2-Se registrar como cliente");
        System.out.println("3-Registrar uma conta | 4-Deletar conta");
        System.out.println("5-Sair\n");
    }
    private boolean registerAccount(){
        System.out.println("Digite o número da conta:");
        String number_account = scanner.next();
        System.out.println("Digite o valor do saldo:");
        double balance = scanner.nextDouble();
        System.out.println("Digite o seu id de cliente:");
        int id_client = scanner.nextInt();

        banckAccountController.registerAccount(number_account,balance,id_client);
        return true;
    }
}