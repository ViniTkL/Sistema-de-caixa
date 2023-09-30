package Controle;

import Modelo.ClienteDAO;
import Modelo.ClienteM;
import Modelo.ProdutoM;

import java.util.Scanner;

public class ClienteC {
    private ClienteM cliente;
    private ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteC() {

    }

    public void cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do cliente: ");
        String nome = scanner.nextLine().toUpperCase();

        System.out.println("Digite o sobrenome do cliente: ");
        String sobrenome = scanner.nextLine().toUpperCase();

        System.out.println("Digite o CPF do cliente: ");
        String cpf = removeCaracteresEspeciais(scanner.nextLine());
        if(cpf.length()>11 || cpf.length()<11){
            System.out.println("CPF INVÁLIDO, TENTE NOVAMENTE: ");
            while (cpf.length()>11 || cpf.length()<11){
                System.out.println("Digite o CPF do cliente: ");
                cpf = removeCaracteresEspeciais(scanner.nextLine());
            }
        }

        System.out.println("Digite o CEP do cliente: ");
        String cep = removeCaracteresEspeciais(scanner.nextLine());
        if(cep.length()>8 || cep.length()<8){
            System.out.println("CEP INVÁLIDO, TENTE NOVAMENTE: ");
            while (cep.length()>8 || cep.length()<8){
                System.out.println("Digite o CEP do cliente: ");
                cep = removeCaracteresEspeciais(scanner.nextLine());
            }
        }

        System.out.println("Digite o numero de celular do cliente: ");
        long numeroCelular = scanner.nextLong();

        scanner.nextLine();

        System.out.println("Digite o email do cliente: ");
        String email  = scanner.nextLine();

        System.out.println("Digite o sexo do cliente: ");
        char sexo = Character.toUpperCase(scanner.nextLine().charAt(0));
        if(sexo!= 'M' && sexo!='F') {
            System.out.println("Sexo inválido, TENTE NOVAMENTE: ");
            while (sexo != 'M' && sexo != 'F') {
                System.out.println("Digite o sexo do cliente: ");
                sexo = Character.toUpperCase(scanner.nextLine().charAt(0));
            }
        }

        cliente = new ClienteM(nome, sobrenome, cpf, cep, numeroCelular, email, sexo);
        clienteDAO.salvarCliente(cliente);
    }

    public void verificarCadastroCliente(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o CPF do cliente: ");
        String cpf = removeCaracteresEspeciais(scanner.nextLine());
        if(cpf.length()>11 || cpf.length()<11){
            System.out.println("CPF INVÁLIDO, TENTE NOVAMENTE: ");
            while (cpf.length()>11 || cpf.length()<11){
                System.out.println("Digite o CPF do cliente: ");
                cpf = removeCaracteresEspeciais(scanner.nextLine());
            }
        }
        clienteDAO.verficaCadastro(cpf);

    }

    public String removeCaracteresEspeciais(String texto){
        return texto.replaceAll("[^0-9]+","");

    }

    public ClienteM resgataInformacaoCliente(String cpf){
        cliente = clienteDAO.resgatInformacaoCliente(cpf);
        return cliente;
    }
}
