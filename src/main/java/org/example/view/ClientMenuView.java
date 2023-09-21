package org.example.view;
import org.example.controller.BanckAccountController;
import org.example.controller.ClientController;
import org.example.controller.TransactionController;
import org.example.service.ValidationService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class ClientMenuView {
    static Scanner scanner = new Scanner(System.in);
    static ClientController clientController = new ClientController();
    static BanckAccountController banckAccountController = new BanckAccountController();
    static TransactionController transactionController = new TransactionController();
    static MainMenuView mainMenuView = new MainMenuView();
    static ValidationService validationService = new ValidationService();
    private String cpf;
    private int id_account;
    double value;
    private int id_destination_account;
    public void login(){
        boolean loop=false;
        System.out.println("== Login ==");
        do {
            System.out.println("Digite seu cpf:");
            cpf = scanner.nextLine();
            if (clientController.login(cpf)){
                clientMenu();
                loop=true;
            }else{
                System.out.println("CPF inválido, digite novamente:");
            }
        }while (!loop);
    }
    private void clientMenu(){
        int choice;
        do {
            optionsMenu();
            System.out.print("Digite sua escolha: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println("\nDigite o número da conta para ver o saldo:");
                    String account = scanner.next();
                    banckAccountController.showBalance(account);
                    break;

                case 2:
                    System.out.print("\nDigite o id da conta:");
                    id_account = scanner.nextInt();
                    System.out.print("Digite o valor que deseja sacar:");
                    value = scanner.nextDouble();
                    banckAccountController.subtractBalanceAccount(id_account,value);
                    System.out.println("\nDinheiro sacado!");
                    break;

                case 3:
                    System.out.print("\nDigite o id da conta:");
                    id_account = scanner.nextInt();
                    System.out.print("Digite o valor que deseja depositar:");
                    value = scanner.nextDouble();
                    banckAccountController.addBalanceAccount(id_account,value);
                    System.out.println("\nDinheiro depositado!");
                    break;

                case 4:
                    System.out.println("\nDigite o CPF para deletar conta:");
                    String cpf = scanner.next();
                    if (validationService.validateCpf(cpf)){
                        clientController.deleteClient(cpf);
                        System.out.println("Conta deletada!");
                        mainMenuView.mainMenu();
                    }else {
                        System.out.println("Cpf inválido");
                    }
                    break;

                case 5:
                    if (transaction()){
                        System.out.println("Transação realizada com sucesso");
                    }
                    else {
                        System.out.println("Ocorreu um error na transação");
                    }
                    break;

                case 6:
                    System.out.println("Digite seu id:");
                    int id_client = scanner.nextInt();
                    System.out.println("== Suas contas ==");
                    banckAccountController.showClientAccounts(id_client);
                    break;

                case 7:
                    System.out.println("Digite o id da sua conta:");
                    id_account = scanner.nextInt();
                    System.out.println("== Transações realizadas ==");
                    transactionController.showAllTransactionsofaSpecificAccount(id_account);
                    break;

                case 8:
                    mainMenuView.mainMenu();
                    break;

                case 9:
                    System.out.println("Obrigado(a) por utilizar nosso sistema!");
                    System.exit(0);

                default:
                    System.out.println("Opção inválida, digite novamente");
            }
        }while (choice!=9);
    }
    private void optionsMenu(){
        System.out.println("\nVocê deseja:");
        System.out.println("1-Ver saldo | 2-Sacar dinheiro | 3-Depositar | 4-Deletar conta");
        System.out.println("5-Fazer pix | 6-Ver todas as suas contas | 7-Ver suas transações");
        System.out.println("8-Voltar ao menu principal | 9-Sair");
    }
    private boolean transaction(){
        System.out.print("Digite o id da sua conta:");
        id_account = scanner.nextInt();
        System.out.print("Digite o valor que deseja transferir:");
        value = scanner.nextDouble();
        System.out.println("Digite o id da conta para qual deseja transferir:");
        id_destination_account = scanner.nextInt();

        String date = returnsFormattedCurrentDate();

        banckAccountController.subtractBalanceAccount(id_account,value);
        banckAccountController.addBalanceAccount(id_destination_account,value);
        transactionController.registerTransaction(date,value,id_account,id_destination_account);
        return true;
    }
    private String returnsFormattedCurrentDate(){
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return localDate.format(formatter);
    }
}