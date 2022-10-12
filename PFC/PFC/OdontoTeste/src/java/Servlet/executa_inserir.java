package Servlet;

//@author Paulo Cassola
import dao.AgendaDAO;
import dao.ConnectionFactory;
import dao.DoutorDAO;
import dao.PacienteDAO;
import dao.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Doutor;
import model.Paciente;
import model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import model.Agenda;

@WebServlet(name = "executa_inserir", urlPatterns = {"/executa_inserir"})
public class executa_inserir extends HttpServlet {

    private Connection conn;
    private PreparedStatement stmt;
    private Statement st, st2;
    private ResultSet rs, rs2;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            User use = new User();
            UserDAO useDao = new UserDAO();

            Paciente paci = new Paciente();
            PacienteDAO paciDao = new PacienteDAO();

            Doutor doutor = new Doutor();
            DoutorDAO doutorDao = new DoutorDAO();
            
            Agenda agenda = new Agenda();
            AgendaDAO agendaDao = new AgendaDAO();

            try {

                if (request.getParameter("FLAG").equals("flag1")) {

                    if (request.getParameter("nome").equals("") || request.getParameter("login").equals("") || request.getParameter("senha").equals("")) {

                        response.sendRedirect("CadastroUsuario.jsp");

                    } else {

                        use.setNome_user(request.getParameter("nome"));
                        use.setLogin_user(request.getParameter("login"));
                        use.setSenha_user(request.getParameter("senha"));

                        useDao.inserir(use);

                        response.sendRedirect("CadastroUsuario.jsp");

                    }

                } else if (request.getParameter("FLAG").equals("flag2")) {

                    if (request.getParameter("nome").equals("") || request.getParameter("rg").equals("") || request.getParameter("cpf").equals("") || request.getParameter("telefone1").equals("")) {

                        response.sendRedirect("CadastroPaciente.jsp");

                    } else {

                        paci.setNome_paciente(request.getParameter("nome"));
                        paci.setRg_paciente(request.getParameter("rg"));
                        paci.setCpf_paciente(request.getParameter("cpf"));
                        paci.setTelefone_paciente(request.getParameter("telefone1"));
                        paci.setTelefone2_paciente(request.getParameter("telefone2"));
                        paci.setCep_paciente(request.getParameter("cep"));
                        paci.setCidade_paciente(request.getParameter("cidade"));
                        paci.setBairro_paciente(request.getParameter("bairro"));
                        paci.setRua_paciente(request.getParameter("rua"));
                        paci.setComplemento_paciente(request.getParameter("complemento"));

                        paciDao.inserir(paci);

                        response.sendRedirect("CadastroPaciente.jsp");

                    }
                } else if (request.getParameter("FLAG").equals("flag3")) {

                    if (request.getParameter("nome").equals("") || request.getParameter("cro").equals("") || request.getParameter("especialidade").equals("")) {

                        response.sendRedirect("CadastroDoutores.jsp");

                    } else {

                        doutor.setNome_doutor(request.getParameter("nome"));
                        doutor.setCro_doutor(request.getParameter("cro"));
                        doutor.setTelefone1_doutor(request.getParameter("telefone1"));
                        doutor.setTelefone2_doutor(request.getParameter("telefone2"));
                        doutor.setEspecialidade_doutor(request.getParameter("especialidade"));

                        doutorDao.inserir(doutor);

                        response.sendRedirect("CadastroDoutores.jsp");

                    }

                } else if (request.getParameter("FLAG").equals("flag4")) {

                    if (request.getParameter("data").equals("") || request.getParameter("hora").equals("") || request.getParameter("motivo").equals("")) {

                        response.sendRedirect("agendamento.jsp");
                        
                    } else {

                        conn = new ConnectionFactory().getConexao();

                        String sql = "SELECT id_paciente FROM public.pacientes where nome_paciente = '" + request.getParameter("fk_paci") + "';";
                        String sql2 = "SELECT id_doutor FROM public.doutores where nome_doutor = '" + request.getParameter("fk_doutor") + "';";

                        st = conn.createStatement();
                        rs = st.executeQuery(sql);
                        st2 = conn.createStatement();
                        rs2 = st2.executeQuery(sql2);

                        while (rs.next()) {

                            paci.setId_paciente(rs.getInt("id_paciente"));

                            out.print(paci.getId_paciente());

                        }
                        while (rs2.next()) {
                            doutor.setId_doutor(rs2.getInt("id_doutor"));

                            out.print(doutor.getId_doutor());
                        }
                        
                        agenda.setFk_paci(paci.getId_paciente());
                        agenda.setFk_doutor(doutor.getId_doutor());
                        agenda.setData(Date.valueOf(request.getParameter("data")));
                        agenda.setHora(request.getParameter("hora"));
                        agenda.setMotivo(request.getParameter("motivo"));
                        agenda.setStatus(request.getParameter("status"));
                        
                        agendaDao.inserir(agenda);
                                
                        response.sendRedirect("agendamento.jsp");
                    }
                }
            } catch (Exception erro) {
                throw new RuntimeException("Erro 7:" + erro);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
