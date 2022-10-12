package Servlet;

//@author Paulo Cassola

import dao.AgendaDAO;
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
import model.Agenda;
import model.Doutor;
import model.Paciente;
import model.User;

@WebServlet(name = "executa_alterar", urlPatterns = {"/executa_alterar"})
public class executa_alterar extends HttpServlet {

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

            Paciente paci = new Paciente();
            PacienteDAO paciDao = new PacienteDAO();

            User use = new User();
            UserDAO useDao = new UserDAO();

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
                        use.setId_user(Integer.parseInt(request.getParameter("id")));

                        useDao.alterar(use);

                        response.sendRedirect("CadastroUsuario.jsp");
                    }

                } else if (request.getParameter("FLAG").equals("flag2")) {

                    if (request.getParameter("nome").equals("") || request.getParameter("rg").equals("") || request.getParameter("cpf").equals("") || request.getParameter("telefone1").equals("") || request.getParameter("cidade").equals("")) {

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
                        paci.setId_paciente(Integer.parseInt(request.getParameter("id")));

                        paciDao.alterar(paci);

                        response.sendRedirect("CadastroPaciente.jsp");

                    }

                } else if (request.getParameter("FLAG").equals("flag3")) {

                    if (request.getParameter("nome").equals("") || request.getParameter("cro").equals("") || request.getParameter("telefone1").equals("") || request.getParameter("especialidade").equals("")) {

                        response.sendRedirect("CadastroDoutores.jsp");

                    } else {

                        doutor.setNome_doutor(request.getParameter("nome"));
                        doutor.setCro_doutor(request.getParameter("cro"));
                        doutor.setTelefone1_doutor(request.getParameter("telefone1"));
                        doutor.setTelefone2_doutor(request.getParameter("telefone2"));
                        doutor.setEspecialidade_doutor(request.getParameter("especialidade"));
                        doutor.setId_doutor(Integer.parseInt(request.getParameter("id")));

                        doutorDao.alterar(doutor);

                        response.sendRedirect("CadastroDoutores.jsp");

                    }
                } else if (request.getParameter("FLAG").equals("flag4")) {
                    
                    
                    agenda.setId_agenda(Integer.parseInt(request.getParameter("id")));
                    
                    agendaDao.alterar(agenda);
                    
                    response.sendRedirect("Agenda.jsp");
                    
                }

            } catch (IOException | NumberFormatException erro) {
                throw new RuntimeException("Erro 8:" + erro);

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
