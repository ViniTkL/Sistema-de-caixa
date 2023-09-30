package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class CompraDAO {

    public void salvarCompra(CompraM compra){
        String sql = "INSERT INTO compras(cpf, nome_cliente, sobrenome_cliente, preco_total, quantidade_produtos, data_compra) VALUE(?, ?, ?, ?, ?, ?);";

        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, compra.getCpf());
            pstm.setString(2, compra.getNome_cliente());
            pstm.setString(3, compra.getSobrenome_cliente());
            pstm.setDouble(4, compra.getPreco_total());
            pstm.setInt(5, compra.getQuantidade_produtos());
            pstm.setDate(6, new Date(compra.getData_compra().getTime()));
            pstm.execute();
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
}
