package Servlet;

//@author Paulo Cassola

import dao.ConnectionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "executa_login", urlPatterns = {"/executa_login"})
public class executa_login extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            out.print("<link rel=\"stylesheet\" type=\"text/css\" href=\"_css/_loginResposta.css\">");

            ConnectionFactory conn = new ConnectionFactory();
            Connection conexao = conn.getConexao();

            if ((request.getParameter("txtLog").equals(null)) || (request.getParameter("txtLog").equals(""))) {

                out.print("<form action=\"login.jsp\" class=\"login\" method=\"post\">");
                out.print("<h1>Preencha o Campo Login</h1>");
                out.print("<input type=\"submit\" class=\"BotaoPadrao1\" value=\"Voltar\" name=\"btnLogin\" />");
                out.print("</form>");

            } else {
                if ((request.getParameter("txtSenha").equals(null)) || (request.getParameter("txtSenha").equals(""))) {

                    out.print("<form action=\"login.jsp\" class=\"login\" method=\"post\">");
                    out.print("<h1>Preencha o Campo Senha</h1>");
                    out.print("<input type=\"submit\" class=\"BotaoPadrao1\" value=\"Voltar\" name=\"btnLogin\" />");
                    out.print("</form>");

                } else {
                    
                    Statement st;
                    ResultSet rs;
                    
                    st = conexao.createStatement();
                    rs = st.executeQuery("select * from users where login_user='" + request.getParameter("txtLog") + "'and senha_user='" + request.getParameter("txtSenha") + "'");
                   
                    if (rs.next()) {

                        response.sendRedirect("paginaCadastro.jsp");

                    } else {

                        out.print("<form action=\"login.jsp\" class=\"login\" method=\"post\">");
                        out.print("<h1>Login ou Senha estão Incorretos</h1>");
                        out.print("<input type=\"submit\" class=\"BotaoPadrao1\" value=\"Voltar\" name=\"btnLogin\" />");
                        out.print("</form>");

                    }
                }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(executa_login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(executa_login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
