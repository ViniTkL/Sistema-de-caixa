package Controle;

import Modelo.ProdutoDAO;
import Modelo.ProdutoM;

import java.util.Scanner;

import static java.awt.SystemColor.menu;

public class ProdutoC {
    private ProdutoM produto;
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    //Notificação quando produtos estiverem acabando

    public void digitalizarProduto(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o nome do produto: ");
            String nome = scanner.nextLine().toUpperCase();

            System.out.println("Digite a marca do produto: ");
            String marca = scanner.nextLine().toUpperCase();

            System.out.println("Digite o preço do produto: ");
            Double preco = scanner.nextDouble();

            System.out.println("Digite a quantidade do produto: ");
            int quantidade = scanner.nextInt();

            produto = new ProdutoM(nome,marca,preco,quantidade);
            produtoDAO.digitalizarProduto(produto);
        }catch (Exception e){
            System.out.println("ERRO AO DIGITALIZAR PRODUTO.");
        }


    }

    public void verificarItemDoEstoque(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite o nome do produto: ");
            String nome = scanner.nextLine().toUpperCase();

            System.out.println("Digite a marca do produto: ");
            String marca = scanner.nextLine().toUpperCase();

            produtoDAO.buscarItem(nome, marca);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Será utilizado para compôr o método de compra que posteriormente será implementado
    public ProdutoM informacoesProduto(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Em caso de duvida do ID item digite -> buscar");
        System.out.println("Digite o ID do produto a ser comprado pelo cliente[Digite SAIR para voltar ao menu principal]: ");
        String idProduto = scanner.nextLine().toLowerCase();
        if(idProduto.equals("buscar")){
            verificarItemDoEstoque();
            informacoesProduto();

        }else if(idProduto.equals("sair")){
            return null;

        }else{
            produto = produtoDAO.retornaProduto(idProduto);
            return produto;

        }
        return produto;
    }
    //Será utilizado para compôr o método de compra que posteriormente será implementado
    public void atualizaQuantidadeItemCheckout(ProdutoM produto, int quantidade){
        produtoDAO.atualizarItemQuantidade(produto, quantidade);
    }
}
