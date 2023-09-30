package Controle;

import Modelo.ClienteM;
import Modelo.CompraDAO;
import Modelo.CompraM;
import Modelo.ProdutoM;

import javax.swing.*;
import java.util.Scanner;

public class CompraC {
    private ProdutoC produtoC = new ProdutoC();
    private ClienteC clienteC = new ClienteC();
    private CompraDAO compraDAO = new CompraDAO();
    public CompraC() {
    }

    public void realizarCompra(){
        Scanner scanner = new Scanner(System.in);
        ClienteM cliente;
        ProdutoM produto;
        System.out.println("Cliente possui cadastro?[s/n]: ");
        char opcCadastro = Character.toUpperCase(scanner.nextLine().charAt(0));
        if(opcCadastro == 'S'){

            System.out.println("Digite o cpf do cliente: ");
            String cpf = clienteC.removeCaracteresEspeciais(scanner.nextLine());
            if(cpf.length()>11 || cpf.length()<11){
                System.out.println("CPF INVÁLIDO, TENTE NOVAMENTE: ");
                while (cpf.length()>11 || cpf.length()<11){
                    System.out.println("Digite o CPF do cliente: ");
                    cpf = clienteC.removeCaracteresEspeciais(scanner.nextLine());
                }
            }
            cliente = clienteC.resgataInformacaoCliente(cpf);

            System.out.println("Digite a quantidade de produtos a serem comprados: ");
            int quantidadeCompra = scanner.nextInt();

            int cont = quantidadeCompra;
            double precoTotal = 0;
            while(cont > 0) {
                produto = produtoC.informacoesProduto();

                System.out.println("Digite a quantidade de " + produto.getNomeProduto() + " a ser comprada: ");
                int quantidadeProduto = scanner.nextInt();

                precoTotal += (produto.getPrecoProduto()*quantidadeProduto);
                cont -= quantidadeProduto;

                produtoC.atualizaQuantidadeItemCheckout(produto, quantidadeProduto);
            }
            CompraM compra = new CompraM(cliente.getCpf(), cliente.getNome(), cliente.getSobrenome(), precoTotal, quantidadeCompra);
            compraDAO.salvarCompra(compra);
            System.out.println("-------------COMPREA REALIZDA COM SUCESSO!!!-------------");

        }else if(opcCadastro == 'N'){

            System.out.println("Digite o nome do Cliente: ");
            String nome = scanner.nextLine();

            System.out.println("Digite o sobrenome do Cliente: ");
            String sobrenome = scanner.nextLine();

            cliente = new ClienteM(nome, sobrenome, null);

            System.out.println("Digite a quantidade total de produtos a serem comprados: ");
            int quantidadeProdutosCompra = scanner.nextInt();

            int cont = quantidadeProdutosCompra;
            double precoTotal = 0;
            while(cont > 0) {
                produto = produtoC.informacoesProduto();

                System.out.println("Digite a quantidade de " + produto.getNomeProduto() + " a ser comprada: ");
                int quantidadeProduto = scanner.nextInt();

                precoTotal += (produto.getPrecoProduto()*quantidadeProduto);
                cont -= quantidadeProduto;

                produtoC.atualizaQuantidadeItemCheckout(produto, quantidadeProduto);
            }

            CompraM compra = new CompraM(cliente.getCpf(), cliente.getNome(), cliente.getSobrenome(), precoTotal, quantidadeProdutosCompra);
            compraDAO.salvarCompra(compra);
            System.out.println("-------------COMPREA REALIZDA COM SUCESSO!!!-------------");
        }else{
            System.out.println("-------------ERRO: Valor inválido - Por favor, insira um valor válido-------------");
        }
    }

}
