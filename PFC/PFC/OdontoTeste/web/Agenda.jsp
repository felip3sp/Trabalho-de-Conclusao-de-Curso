<%-- 
    Document   : CadastroUsuario
    Created on : 15/10/2020, 19:55:45
    Author     : paulo
--%>

<%@page import="dao.AgendaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Agenda" %>
<%@page import="dao.DoutorDAO"%>
<%@page import="model.Paciente"%>
<%@page import="dao.PacienteDAO"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaAgendamento.css">
        <title>Agenda</title>
    </head>
    <body>
        <div id="banner-cadastro">
            <h1>Agenda</h1>
        </div>

        <div class="plataformaUsuario">

            <form action="executa_inserir" method="post">
                
                            <%
                try {

                    out.print("<table class='TabelaAgenda'>");
                    out.print("<thead>");
                    out.print("<tr>");
                    out.print("<th>Id</th><th>Nome do Paciente</th><th>Cpf</th><th>Doutor</th><th>Cro</th><th>Data</th><th>Hora</th><th>Motivo</th><th>Status</th><th>Conclusão</th>");
                    out.print("</tr>");
                    out.print("</thead>");
                    out.print("<tbody>");
                    AgendaDAO agendaDao = new AgendaDAO();

             ArrayList<Agenda> lista = agendaDao.listarTodos();
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_agenda() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_paci() + "</td>");
                            out.print("<td>" + lista.get(num).getCpf_paci() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getCro_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getData() + "</td>");
                            out.print("<td>" + lista.get(num).getHora() + "</td>");
                            out.print("<td>" + lista.get(num).getMotivo() + "</td>");
                            out.print("<td>" + lista.get(num).getStatus() + "</td>");
                            out.print("<td><a class='BotaoConcluir' href='concluirAgenda.jsp?id=" + lista.get(num).getId_agenda() + "&nomePaci=" + lista.get(num).getNome_paci() + "&cpf=" + lista.get(num).getCpf_paci() + "&nomeDoutor=" + lista.get(num).getNome_doutor() + "&cro=" + lista.get(num).getCro_doutor() + "&motivo=" + lista.get(num).getMotivo() + "&status=" + lista.get(num).getStatus() + " '>Concluir</a></td>");
                            out.print("</tr>");
                        }

                    out.print("</tbody>");
                    out.print("</tr>");
                    out.print("</table>");

                } catch (Exception erro) {
                    throw new RuntimeException("Erro 57:" + erro);
                }

            %>
                
            </form>

        </div>

        <form action="paginaPrincipal.jsp" method="post">
            <button type="submit" class="Voltar">
                Voltar
            </button>
        </form>
        <form action="Arquivados.jsp" method="post">
            <button type="submit" class="Arquivados">
                Arquivados
            </button>
        </form>

    </body>
</html>
