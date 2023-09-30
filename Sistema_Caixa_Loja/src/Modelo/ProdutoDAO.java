package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProdutoDAO {
    public void digitalizarProduto(ProdutoM produto){
        String sql = "INSERT INTO produtos(nome_produto,marca_produto,preco_produto,quantidade_produto) VALUES(?, ?, ?, ?) ";

        Connection conn = null;
        PreparedStatement pstm  = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, produto.getNomeProduto());
            pstm.setString(2, produto.getMarcaProduto());
            pstm.setDouble(3, produto.getPrecoProduto());
            pstm.setInt(4,produto.getQuantidadeProduto());

            pstm.execute();
            System.out.println("Produto digitalizado com sucesso!!!!!!!!");
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void buscarItem(String nome, String marca){
         String sql = "SELECT id_produto, nome_produto, marca_produto, preco_produto, quantidade_produto FROM produtos WHERE nome_produto =" +"'"+nome+"'"+"AND marca_produto =" +"'"+marca+"'"+";";

         Connection conn = null;
         PreparedStatement pstm = null;
         ResultSet rset = null;

         try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            if(rset.next()){
             System.out.println("id........: " + rset.getInt("id_produto"));
             System.out.println("nome......: " + rset.getString("nome_produto"));
             System.out.println("marca.....: " + rset.getString("marca_produto"));
             System.out.println("preço.....: " + rset.getDouble("preco_produto"));
             System.out.println("quantidade: " + rset.getInt("quantidade_produto"));
            }else{
                System.out.println("ERRO: PRODUTO NÃO ENCONTRADO NO BANCO DE DADOS.");
            }

         }catch(Exception e){
             e.printStackTrace();
         }finally{
             try{
                 if(conn!=null){
                     conn.close();
                 }
                 if(pstm!=null){
                     pstm.close();
                 }
                 if(rset!=null){
                     rset.close();
                 }
             }catch(Exception e){
                 e.printStackTrace();
             }
         }
    }

    public ProdutoM retornaProduto(String idProduto){
        int id = Integer.valueOf(idProduto);
        ProdutoM produto = null;
        String sql = "SELECT id_produto, preco_produto, quantidade_produto, nome_produto FROM produtos WHERE id_produto ="+ id +";";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            if(rset.next()){
                produto = new ProdutoM(rset.getInt("id_produto"),  rset.getString("nome_produto"), rset.getDouble("preco_produto"), rset.getInt("quantidade_produto"));
                return produto;

            }else{
                System.out.println("ERRO: PRODUTO NÃO ENCONTRADO NO BANCO DE DADOS.");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(rset!=null){
                    rset.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return produto;
    }

    public void atualizarItemQuantidade(ProdutoM produto, int quantidade){
        int quantidadeNova = produto.getQuantidadeProduto() - quantidade;
        String sql = "UPDATE produtos SET quantidade_produto = ? WHERE id_produto = ? ;";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1,quantidadeNova);
            pstm.setInt(2, produto.getIdProduto());

            pstm.execute();
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            try{
                if(conn != null){
                    conn.close();
                }
                if(pstm != null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
