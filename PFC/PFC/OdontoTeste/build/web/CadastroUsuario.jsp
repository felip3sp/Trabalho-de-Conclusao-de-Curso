<%-- 
    Document   : CadastroUsuario
    Created on : 15/10/2020, 19:55:45
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<%@page import="dao.UserDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaCadastroPadrao.css">
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <div id="banner-cadastro">
            <h1>Cadastro de Usuários</h1>
        </div>

        <div class="plataformaUsuario">

            <form action="CadastroUsuario.jsp" method="post" class="CampoDeBusca">   
                <label>Nome:</label>
                <input type="text" name="nome_user">             
                <button type="submit" class="BotaoBuscar">
                    Buscar
                </button><br>
            </form>


            <%
                try {

                    out.print("<table class='TabelaPacientes'>");
                    out.print("<thead>");
                    out.print("<tr>");
                    out.print("<th>Id</th><th>Nome</th><th>Login</th><th>Senha</th><th>Edição</th><th>Exclusão</th>");
                    out.print("</tr>");
                    out.print("</thead>");
                    out.print("<tbody>");
                    UserDAO useDao = new UserDAO();

                    if (request.getParameter("nome_user") == "" || request.getParameter("nome_user") == null) {
                        ArrayList<User> lista = useDao.listarTodos();
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_user() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_user() + "</td>");
                            out.print("<td>" + lista.get(num).getLogin_user() + "</td>");
                            out.print("<td>" + lista.get(num).getSenha_user() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar2' href='alterar.jsp?id=" + lista.get(num).getId_user() + "&nome=" + lista.get(num).getNome_user() + "&login=" + lista.get(num).getLogin_user() + "&senha=" + lista.get(num).getSenha_user() + " '>Editar</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar2' href='excluir.jsp?id=" + lista.get(num).getId_user() + "&nome=" + lista.get(num).getNome_user() + " '>Excluir</a></td>");
                            out.print("</tr>");
                        }
                    } else {
                        ArrayList<User> lista = useDao.listarTodosDescricao(request.getParameter("nome_user"));

                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_user() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_user() + "</td>");
                            out.print("<td>" + lista.get(num).getLogin_user() + "</td>");
                            out.print("<td>" + lista.get(num).getSenha_user() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar2' href='alterar.jsp?id=" + lista.get(num).getId_user() + "&nome=" + lista.get(num).getNome_user() + "&login=" + lista.get(num).getLogin_user() + "&senha=" + " '>Editar</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar2' href='excluir.jsp?id=" + lista.get(num).getId_user() + "&nome=" + lista.get(num).getNome_user() + " '>Excluir</a></td>");
                            out.print("</tr>");
                        }
                    }
                    out.print("</tbody>");
                    out.print("</tr>");
                    out.print("</table>");

                } catch (Exception erro) {
                    throw new RuntimeException("Erro 10:" + erro);
                }

            %>

            <form action="inserir.jsp" method="post">
                <button type="submit" class="Novo">NOVO</button>
            </form>

        </div>

        <form action="paginaCadastro.jsp" method="post">
            <button type="submit" class="Voltar">
                Voltar
            </button>
        </form>

    </body>
</html>
