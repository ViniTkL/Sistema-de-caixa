package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class ClienteDAO {
    public void salvarCliente(ClienteM cliente){

        String sql = "INSERT INTO clientes(nome, sobrenome, cpf, cep, numeroCelular, email, sexo) VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;


        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getSobrenome());
            pstm.setString(3, cliente.getCpf());
            pstm.setString(4, cliente.getCep());
            pstm.setString(5, String.valueOf(cliente.getNumeroCelularCliente()));
            pstm.setString(6, cliente.getEmail());
            pstm.setString(7, String.valueOf(cliente.getSexo()));

            pstm.execute();
            System.out.println("CADASTRO REALIZADO COM SUCESSO!!!\n");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(conn!=null){
                    conn.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void verficaCadastro(String cpf){
        String sql = "SELECT nome, sobrenome, cpf FROM clientes WHERE cpf ="+ "'" + cpf + "'" + ";";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

         if(rset.next()) {
             System.out.println("--------------------------------------------------------------------------------");
             System.out.println("Nome.....: " + rset.getString("nome") + "\n" +
                     "Sobrenome: " + rset.getString("sobrenome") + "\n" +
                     "Cpf......: " + rset.getString("cpf"));
             System.out.println("--------------------------------------------------------------------------------");
         }else{
             System.out.println("Cliente ainda não possui cadastro!!!");
         }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(rset!=null){
                    rset.close();
                }
                if(pstm!=null){
                    pstm.close();
                }
                if(conn!=null){
                    conn.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public ClienteM resgatInformacaoCliente(String cpf){
        String sql = "SELECT nome, sobrenome FROM clientes WHERE cpf=" + "'" + cpf + "'" + ";";
        ClienteM cliente = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();
            if(rset.next()){
                cliente = new ClienteM(rset.getString("nome"),rset.getString("sobrenome"), cpf);
                return cliente;
            }else{
                System.out.println("Cliente não encontrado!!!!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rset != null) {
                    rset.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cliente;
    }


}
