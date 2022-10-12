<%-- 
    Document   : CadastroUsuario
    Created on : 15/10/2020, 19:55:45
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Doutor" %>
<%@page import="dao.DoutorDAO"%>
<%@page import="model.Paciente"%>
<%@page import="dao.PacienteDAO"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaAgendamento.css">
        <title>Agendamento</title>
    </head>
    <body>
        <div id="banner-cadastro">
            <h1>Agendar Consulta</h1>
        </div>

        <div class="plataformaUsuario">

            <form action="executa_inserir" method="post">

                <label>Paciente:</label>
                <select name="fk_paci">
                    <%
                        PacienteDAO paciDao = new PacienteDAO();
                        ArrayList<Paciente> lista1 = paciDao.listarTodosAgendaPaci();
                        for (int num1 = 0; num1 < lista1.size(); num1++) {

                            out.print("<option>" + lista1.get(num1).getNome_paciente() + "</option>");

                        }
                    %>
                </select>

                <label>Doutor:</label>
                <select name="fk_doutor">
                    <%
                        DoutorDAO doutorDao = new DoutorDAO();
                        ArrayList<Doutor> lista2 = doutorDao.listarTodosAgendaDoutor();
                        for (int num2 = 0; num2 < lista2.size(); num2++) {

                            out.print("<option>" + lista2.get(num2).getNome_doutor() + "</option>");

                        }
                    %>
                </select>

                <label>Data:</label>
                <input type="date" name="data" value="" />

                <label>Hora:</label>
                <input type="time" name="hora" value="" /><br><br>

                <label>Motivo:</label><br>
                <textarea name="motivo" rows="10" cols="74">
                </textarea><br><br>

                <label>Status:</label>
                <label>Abrir</label><br>
                <input type="hidden" name="status" value="Aberto" />

                <input type="hidden" name="FLAG" value="flag4"><br>

                <button type="submit" class="Agendar">Agendar</button>
                
            </form>

        </div>

        <form action="paginaPrincipal.jsp" method="post">
            <button type="submit" class="Voltar">
                Voltar
            </button>
        </form>

    </body>
</html>
