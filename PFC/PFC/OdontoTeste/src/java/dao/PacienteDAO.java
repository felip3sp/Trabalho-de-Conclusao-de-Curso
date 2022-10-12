package dao;

//@author Paulo Cassola
import model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Paciente> lista = new ArrayList<>();

    public PacienteDAO() {

        conn = new ConnectionFactory().getConexao();

    }

    public void inserir(Paciente paci) {
        String sql = "INSERT INTO public.pacientes(nome_paciente, rg_paciente, cpf_paciente, telefone1_paciente, telefone2_paciente, cep_paciente, cidade_paciente, bairro_paciente, rua_paciente, complemento_paciente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, paci.getNome_paciente());
            stmt.setString(2, paci.getRg_paciente());
            stmt.setString(3, paci.getCpf_paciente());
            stmt.setString(4, paci.getTelefone_paciente());
            stmt.setString(5, paci.getTelefone2_paciente());
            stmt.setString(6, paci.getCep_paciente());
            stmt.setString(7, paci.getCidade_paciente());
            stmt.setString(8, paci.getBairro_paciente());
            stmt.setString(9, paci.getRua_paciente());
            stmt.setString(10, paci.getComplemento_paciente());

            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 2:" + erro);
        }

    }

    public void alterar(Paciente paci) {
        String sql = "UPDATE public.pacientes SET nome_paciente=?, rg_paciente=?, cpf_paciente=?, telefone1_paciente=?, telefone2_paciente=?, cep_paciente=?, cidade_paciente=?, bairro_paciente=?, rua_paciente=?, complemento_paciente=? WHERE id_paciente =?;";
        try {

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, paci.getNome_paciente());
            stmt.setString(2, paci.getRg_paciente());
            stmt.setString(3, paci.getCpf_paciente());
            stmt.setString(4, paci.getTelefone_paciente());
            stmt.setString(5, paci.getTelefone2_paciente());
            stmt.setString(6, paci.getCep_paciente());
            stmt.setString(7, paci.getCidade_paciente());
            stmt.setString(8, paci.getBairro_paciente());
            stmt.setString(9, paci.getRua_paciente());
            stmt.setString(10, paci.getComplemento_paciente());
            stmt.setInt(11, paci.getId_paciente());

            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro 3:" + erro);
        }

    }

    public void excluir(Paciente paci) {
        String sql = "DELETE FROM public.pacientes WHERE id_paciente =" + paci.getId_paciente();
        try {

            st = conn.createStatement();
            st.execute(sql);
            st.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro 4:" + erro);
        }

    }

    public ArrayList<Paciente> listarTodos() {
        String sql = "SELECT * FROM pacientes";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Paciente paci = new Paciente();

                paci.setId_paciente(rs.getInt("id_paciente"));
                paci.setNome_paciente(rs.getString("nome_paciente"));
                paci.setRg_paciente(rs.getString("rg_paciente"));
                paci.setCpf_paciente(rs.getString("cpf_paciente"));
                paci.setTelefone_paciente(rs.getString("telefone1_paciente"));
                paci.setTelefone2_paciente(rs.getString("telefone2_paciente"));
                paci.setCep_paciente(rs.getString("cep_paciente"));
                paci.setCidade_paciente(rs.getString("cidade_paciente"));
                paci.setBairro_paciente(rs.getString("bairro_paciente"));
                paci.setRua_paciente(rs.getString("rua_paciente"));
                paci.setComplemento_paciente(rs.getString("complemento_paciente"));

                lista.add(paci);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

    public ArrayList<Paciente> listarTodosDescricao(String valor) {
        String sql = "SELECT * FROM pacientes WHERE nome_paciente LIKE '%" + valor + "%'";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Paciente paci = new Paciente();

                paci.setId_paciente(rs.getInt("id_paciente"));
                paci.setNome_paciente(rs.getString("nome_paciente"));
                paci.setRg_paciente(rs.getString("rg_paciente"));
                paci.setCpf_paciente(rs.getString("cpf_paciente"));
                paci.setTelefone_paciente(rs.getString("telefone1_paciente"));
                paci.setTelefone2_paciente(rs.getString("telefone2_paciente"));
                paci.setCep_paciente(rs.getString("cep_paciente"));
                paci.setCidade_paciente(rs.getString("cidade_paciente"));
                paci.setBairro_paciente(rs.getString("bairro_paciente"));
                paci.setRua_paciente(rs.getString("rua_paciente"));
                paci.setComplemento_paciente(rs.getString("complemento_paciente"));

                lista.add(paci);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 6:" + erro);
        }
        return lista;
    }

    public ArrayList<Paciente> listarTodosAgendaPaci() {
        String sql = "SELECT nome_paciente FROM public.pacientes;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Paciente paci = new Paciente();

                paci.setNome_paciente(rs.getString("nome_paciente"));

                lista.add(paci);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }


}
