package dao;

//@author Paulo Cassola

import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<User> lista = new ArrayList<>();

    public UserDAO() {

        conn = new ConnectionFactory().getConexao();

    }

    public void inserir(User user) {
        String sql = "INSERT INTO users (nome_user, login_user, senha_user) VALUES (?,?,?) ";
        try {
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getNome_user());
            stmt.setString(2, user.getLogin_user());
            stmt.setString(3, user.getSenha_user());
            
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 2:" + erro);
        }

    }

    public void alterar(User user) {
        String sql = "UPDATE users SET nome_user =?, login_user =?, senha_user =? WHERE id_user =?";
        try {
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, user.getNome_user());
            stmt.setString(2, user.getLogin_user());
            stmt.setString(3, user.getSenha_user());
            stmt.setInt(4, user.getId_user());
            
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 3:" + erro);
        }

    }

    public void excluir(User use) {
        String sql = "DELETE FROM users WHERE id_user =" + use.getId_user();
        try {

            st = conn.createStatement();
            st.execute(sql);
            st.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 4:" + erro);
        }

    }

    public ArrayList<User> listarTodos() {
        String sql = "SELECT * FROM users";
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                User use = new User();
                use.setId_user(rs.getInt("id_user"));
                use.setNome_user(rs.getString("nome_user"));
                use.setLogin_user(rs.getString("login_user"));
                use.setSenha_user(rs.getString("senha_user"));
                lista.add(use);
            }
            
        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

    public ArrayList<User> listarTodosDescricao(String valor) {
        String sql = "SELECT * FROM users WHERE nome_user LIKE '%" + valor + "%'";
        try {
            
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                User use = new User();
                use.setId_user(rs.getInt("id_user"));
                use.setNome_user(rs.getString("nome_user"));
                use.setLogin_user(rs.getString("login_user"));
                use.setSenha_user(rs.getString("senha_user"));
                lista.add(use);
            }
            
        } catch (Exception erro) {
            throw new RuntimeException("Erro 6:" + erro);
        }
        return lista;
    }

}

