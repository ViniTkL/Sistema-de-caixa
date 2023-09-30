package Modelo;

import java.util.Date;

public class CompraM {
    private int idCompra;
    private String cpf;
    private String nome_cliente;
    private String sobrenome_cliente;
    private double preco_total;
    private int quantidade_produtos;
    private Date data_compra;

    public CompraM(String cpf, String nome_cliente, String sobrenome_cliente, double preco_total, int quantidade_produtos) {
        this.cpf = cpf;
        this.nome_cliente = nome_cliente;
        this.sobrenome_cliente = sobrenome_cliente;
        this.preco_total = preco_total;
        this.quantidade_produtos = quantidade_produtos;
        this.data_compra = new Date();
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getSobrenome_cliente() {
        return sobrenome_cliente;
    }

    public void setSobrenome_cliente(String sobrenome_cliente) {
        this.sobrenome_cliente = sobrenome_cliente;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }

    public int getQuantidade_produtos() {
        return quantidade_produtos;
    }

    public void setQuantidade_produtos(int quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }

    public Date getData_compra() {
        return data_compra;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }
}
