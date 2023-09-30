package Modelo;
//Classe controle vai criar um cliente atraves de enviar os dados para essa classe
public class ClienteM {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String cep;
    private long numeroCelularCliente;
    private String email;
    private  char sexo;


    public ClienteM(String nome, String sobrenome, String cpf, String cep, long numeroCelularCliente, String email, char sexo) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.cep = cep;
        this.numeroCelularCliente = numeroCelularCliente;
        this.email = email;
        this.sexo = sexo;
    }

    public ClienteM(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public long getNumeroCelularCliente() {
        return numeroCelularCliente;
    }

    public void setNumeroCelularCliente(long numeroCelularCliente) {
        this.numeroCelularCliente = numeroCelularCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
}
