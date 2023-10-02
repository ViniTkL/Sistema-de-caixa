package Modelo;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    //nome de usuário da database
    private static final String USERNAME = "sqluser";

    //senha da database
    private static final String PASSWORD = "password";

    //caminho da database
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/loja?useTimezone=true&serverTimezone=UTC";

    //conexão com a database
    public static Connection createConnectionToMySQL() throws Exception {
        //faz com que a classe seja carregada pela JVM
        Class.forName("com.mysql.cj.jdbc.Driver");

        //cria conexão com a database
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        //recuperar uma conexão com o banco de dados se tiver
        Connection con = createConnectionToMySQL();

        //Testar se a conexão é nula
        if(con!=null){
            System.out.println("Conexão estabelecida!");
            con.close();
        }
    }
}
