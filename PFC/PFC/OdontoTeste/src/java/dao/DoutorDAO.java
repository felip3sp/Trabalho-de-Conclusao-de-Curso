package dao;

//@author Paulo Cassola

import model.Doutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class DoutorDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Doutor> lista = new ArrayList<>();

    public DoutorDAO() {

        conn = new ConnectionFactory().getConexao();

    }

    public void inserir(Doutor doutor) {
        String sql = "INSERT INTO public.doutores(nome_doutor, cro_doutor, telefone1_doutor, telefone2_doutor, especialidade_doutor) VALUES (?, ?, ?, ?, ?);";
        try {
            
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, doutor.getNome_doutor());
            stmt.setString(2, doutor.getCro_doutor());
            stmt.setString(3, doutor.getTelefone1_doutor());
            stmt.setString(4, doutor.getTelefone2_doutor());
            stmt.setString(5, doutor.getEspecialidade_doutor());
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 2:" + erro);
        }

    }

    public void alterar(Doutor doutor) {
        String sql = "UPDATE public.doutores SET nome_doutor=?, cro_doutor=?, telefone1_doutor=?, telefone2_doutor=?, especialidade_doutor=? WHERE id_doutor =?;";
        try {
            
            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, doutor.getNome_doutor());
            stmt.setString(2, doutor.getCro_doutor());
            stmt.setString(3, doutor.getTelefone1_doutor());
            stmt.setString(4, doutor.getTelefone2_doutor());
            stmt.setString(5, doutor.getEspecialidade_doutor());
            stmt.setInt(6, doutor.getId_doutor());
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro 3:" + erro);
        }

    }

    public void excluir(Doutor doutor) {
        String sql = "DELETE FROM public.doutores WHERE id_doutor =" + doutor.getId_doutor();
        try {
            
            st = conn.createStatement();
            st.execute(sql);
            st.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro 4:" + erro);
        }

    }

    public ArrayList<Doutor> listarTodos() {
        String sql = "SELECT * FROM doutores";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Doutor doutor = new Doutor();

                doutor.setId_doutor(rs.getInt("id_doutor"));
                doutor.setNome_doutor(rs.getString("nome_doutor"));
                doutor.setCro_doutor(rs.getString("cro_doutor"));
                doutor.setTelefone1_doutor(rs.getString("telefone1_doutor"));
                doutor.setTelefone2_doutor(rs.getString("telefone2_doutor"));
                doutor.setEspecialidade_doutor(rs.getString("especialidade_doutor"));
                lista.add(doutor);
            }
            
        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

    public ArrayList<Doutor> listarTodosDescricao(String valor) {
        String sql = "SELECT * FROM doutores WHERE nome_doutor LIKE '%" + valor + "%'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Doutor doutor = new Doutor();

                doutor.setId_doutor(rs.getInt("id_doutor"));
                doutor.setNome_doutor(rs.getString("nome_doutor"));
                doutor.setCro_doutor(rs.getString("cro_doutor"));
                doutor.setTelefone1_doutor(rs.getString("telefone1_doutor"));
                doutor.setTelefone2_doutor(rs.getString("telefone2_doutor"));
                doutor.setEspecialidade_doutor(rs.getString("especialidade_doutor"));
                lista.add(doutor);
            }
            
        } catch (Exception erro) {
            throw new RuntimeException("Erro 6:" + erro);
        }
        return lista;
    }
    
        public ArrayList<Doutor> listarTodosAgendaDoutor() {
        String sql = "SELECT nome_doutor FROM public.doutores;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Doutor doutor = new Doutor();

                doutor.setNome_doutor(rs.getString("nome_doutor"));
                
                lista.add(doutor);
            }
            
        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

}

