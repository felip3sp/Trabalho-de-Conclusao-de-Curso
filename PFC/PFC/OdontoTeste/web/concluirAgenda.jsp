<%-- 
    Document   : concluirAgenda
    Created on : 22/10/2020, 11:35:11
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concluir Agendamento</title>
    </head>
    <body>
        <h1>Deseja concluir este agendamento?</h1>

        <form action="executa_alterar" method="post">
            <label>Id:</label><br>
            <label><%=request.getParameter("id")%></label><br>
            <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />

            <label>Nome do Paciente:</label><br>
            <input type="text" name="nomePaci" value="<%=request.getParameter("nomePaci")%>"><br>

            <label>Cpf:</label><br>
            <input type="text" name="cpf" value="<%=request.getParameter("cpf")%>"><br>

            <label>Nome do Doutor:</label><br>
            <input type="text" name="nomeDoutor" value="<%=request.getParameter("nomeDoutor")%>"><br>

            <label>Cro:</label><br>
            <input type="text" name="cro" value="<%=request.getParameter("cro")%>"><br>

            <label>Motivo:</label><br>
            <textarea name="motivo" rows="3" cols="22"><%=request.getParameter("motivo")%></textarea><br>


            <label>Status:</label><br>
            <input type="text" name="status" value="<%=request.getParameter("status")%>"><br>

            <input type="hidden" name="FLAG" value="flag4"><br>

            <button type="submit">
                Sim
            </button>

        </form>

        <form action="Agenda.jsp" method="post">
            <button type="submit">
                Cancelar
            </button>
        </form>



    </body>
</html>
