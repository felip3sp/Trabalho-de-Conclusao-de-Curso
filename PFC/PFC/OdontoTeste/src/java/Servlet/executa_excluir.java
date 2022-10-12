package Servlet;

//@author Paulo Cassola

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

@WebServlet(name = "executa_excluir", urlPatterns = {"/executa_excluir"})
public class executa_excluir extends HttpServlet {

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

            UserDAO useDao = new UserDAO();
            User use = new User();
            PacienteDAO paciDao = new PacienteDAO();
            Paciente paci = new Paciente();
            DoutorDAO doutorDao = new DoutorDAO();
            Doutor doutor = new Doutor();
            

            try {

                if (request.getParameter("FLAG").equals("flag1")) {
                    
                    use.setId_user(Integer.parseInt(request.getParameter("id")));
                    
                    useDao.excluir(use);
                    
                    response.sendRedirect("CadastroUsuario.jsp");

                } else if (request.getParameter("FLAG").equals("flag2")) {
                    
                    paci.setId_paciente(Integer.parseInt(request.getParameter("id")));

                    paciDao.excluir(paci);
                    
                    response.sendRedirect("CadastroPaciente.jsp");

                } else if (request.getParameter("FLAG").equals("flag3")) {

                    doutor.setId_doutor(Integer.parseInt(request.getParameter("id")));
                    
                    doutorDao.excluir(doutor);
                    
                    response.sendRedirect("CadastroDoutores.jsp");
                    
                }
            } catch (Exception erro) {
                throw new RuntimeException("Erro 9:" + erro);
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
