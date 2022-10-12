package dao;

//@author Paulo Cassola
import model.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Paciente;

public class AgendaDAO {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st;
    private ResultSet rs;
    private ArrayList<Agenda> lista = new ArrayList<>();

    public AgendaDAO() {

        conn = new ConnectionFactory().getConexao();

    }

    public void inserir(Agenda agenda) {
        String sql = "INSERT INTO public.agenda (fk_paci, fk_doutor, data, hora, motivo, status) VALUES (?, ?, ?, ?, ?, ?);";
        try {

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, agenda.getFk_paci());
            stmt.setInt(2, agenda.getFk_doutor());
            stmt.setDate(3, agenda.getData());
            stmt.setString(4, agenda.getHora());
            stmt.setString(5, agenda.getMotivo());
            stmt.setString(6, agenda.getStatus());
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {
            throw new RuntimeException("Erro 2:" + erro);
        }

    }

    public ArrayList<Agenda> listarTodos() {
        String sql = "SELECT id_agenda, nome_paciente, cpf_paciente, nome_doutor, cro_doutor, data, hora, motivo, status FROM agenda inner join pacientes on fk_paci = id_paciente inner join doutores on fk_doutor = id_doutor where status = 'Aberto' order by data, hora;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Agenda agenda = new Agenda();

                agenda.setId_agenda(rs.getInt("id_agenda"));
                agenda.setNome_paci(rs.getString("nome_paciente"));
                agenda.setCpf_paci(rs.getString("cpf_paciente"));
                agenda.setNome_doutor(rs.getString("nome_doutor"));
                agenda.setCro_doutor(rs.getString("cro_doutor"));
                agenda.setData(rs.getDate("data"));
                agenda.setHora(rs.getString("hora"));
                agenda.setMotivo(rs.getString("motivo"));
                agenda.setStatus(rs.getString("status"));

                lista.add(agenda);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

    public ArrayList<Agenda> listarTodosArquivados() {
        String sql = "SELECT id_agenda, nome_paciente, cpf_paciente, nome_doutor, cro_doutor, data, hora, motivo, status FROM agenda inner join pacientes on fk_paci = id_paciente inner join doutores on fk_doutor = id_doutor where status = 'Concluido' order by data, hora;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Agenda agenda = new Agenda();

                agenda.setId_agenda(rs.getInt("id_agenda"));
                agenda.setNome_paci(rs.getString("nome_paciente"));
                agenda.setCpf_paci(rs.getString("cpf_paciente"));
                agenda.setNome_doutor(rs.getString("nome_doutor"));
                agenda.setCro_doutor(rs.getString("cro_doutor"));
                agenda.setData(rs.getDate("data"));
                agenda.setHora(rs.getString("hora"));
                agenda.setMotivo(rs.getString("motivo"));
                agenda.setStatus(rs.getString("status"));

                lista.add(agenda);
            }

        } catch (Exception erro) {
            throw new RuntimeException("Erro 5:" + erro);
        }
        return lista;
    }

    public void alterar(Agenda agenda) {
        String sql = "UPDATE public.agenda SET status = 'Concluido' WHERE id_agenda =?;";
        try {

            stmt = conn.prepareStatement(sql);
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, agenda.getId_agenda());
            stmt.execute();
            stmt.close();

        } catch (SQLException erro) {
            throw new RuntimeException("Erro 3:" + erro);
        }

    }

}
