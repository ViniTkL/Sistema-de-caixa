import Controle.ClienteC;
import Controle.CompraC;
import Controle.ProdutoC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }

    public static void  menu(){
        ClienteC clienteC = new ClienteC();
        ProdutoC produtoC = new ProdutoC();
        CompraC compraC = new CompraC();
        Scanner scanner = new Scanner(System.in);
        int opc;
        try {
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("--------------------Selecione a operação a ser realizada------------------------");
            System.out.println("--------------------------------------------------------------------------------");
            System.out.println("||                  1 - Cadastrar cliente no sistema                          ||");
            System.out.println("||                  2 - Verificar cadastro do cliente no sistema              ||");
            System.out.println("||                  3 - Realizar compra                                       ||");
            System.out.println("||                  4 - Adicionar item no estoque                             ||");
            System.out.println("||                  5 - Verificar item no estoque                             ||");
            System.out.println("||                 -1 - Sair                                                  ||");

            opc = scanner.nextInt();

            switch (opc) {
                case 1:
                    clienteC.cadastrarCliente();
                    break;
                case 2:
                    clienteC.verificarCadastroCliente();
                    break;
                case 3:
                    compraC.realizarCompra();
                    break;
                case 4:
                    produtoC.digitalizarProduto();
                    break;
                case 5:
                    produtoC.verificarItemDoEstoque();
                    break;
                case -1:
                    System.out.println("Finalizando programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Valor inválido, tente novamente");
                    menu();
            }
        }catch (Exception e){
            System.out.println("---------------VALOR INVÁLIDO - POR FAVOR, INSIRA UM VALOR VÁLIDO!!!-------------");
            e.printStackTrace();
        }
    }
}
