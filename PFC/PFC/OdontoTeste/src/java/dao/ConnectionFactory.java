package dao;

//@author Paulo Cassola
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConexao() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/Odonto", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException erro) {
            throw new RuntimeException("Erro 1:" + erro);
        }
    }
}
