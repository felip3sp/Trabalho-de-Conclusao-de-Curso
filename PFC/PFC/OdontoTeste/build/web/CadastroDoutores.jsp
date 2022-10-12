<%-- 
    Document   : CadastroUsuario
    Created on : 15/10/2020, 19:55:45
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Doutor" %>
<%@page import="dao.DoutorDAO"%>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaCadastroPadrao.css">
        <title>Cadastro de Doutores</title>
    </head>
    <body>
        <div id="banner-cadastro">
            <h1>Cadastro de Doutores</h1>
        </div>

        <div class="plataformaUsuario">

            <form action="CadastroDoutores.jsp" method="post" class="CampoDeBusca">
                <label>Nome:</label>
                <input type="text" name="nome_doutor">
                <button type="submit" class="BotaoBuscar">
                    Buscar
                </button><br>
            </form>
            <%
                try {

                    out.print("<table class='TabelaPacientes'>");
                    out.print("<thead>");
                    out.print("<tr>");
                    out.print("<th>Id</th><th>Nome</th><th>Cro</th><th>Telefone 1</th><th>Telefone 2</th><th>Especialidade</th><th>Edição</th><th>Exclusão</th>");
                    out.print("</tr>");
                    out.print("</thead>");
                    out.print("<tbody>");
                    DoutorDAO doutorDao = new DoutorDAO();

                    if (request.getParameter("nome_doutor") == "" || request.getParameter("nome_doutor") == null) {
                        ArrayList<Doutor> lista = doutorDao.listarTodos();
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getCro_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone1_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone2_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getEspecialidade_doutor() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='alterarDoutor.jsp?id=" + lista.get(num).getId_doutor() + "&nome=" + lista.get(num).getNome_doutor() + "&cro=" + lista.get(num).getCro_doutor() + "&telefone1=" + lista.get(num).getTelefone1_doutor() + "&telefone2=" + lista.get(num).getTelefone2_doutor() + "&especialidade=" + lista.get(num).getEspecialidade_doutor() + " '>Editar</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='excluirDoutor.jsp?id=" + lista.get(num).getId_doutor() + "&nome=" + lista.get(num).getNome_doutor() + "&cro=" + lista.get(num).getCro_doutor() + "&telefone1=" + lista.get(num).getTelefone1_doutor() + " '>Excluir</a></td>");
                            out.print("</tr>");
                        }
                    } else {
                        ArrayList<Doutor> lista = doutorDao.listarTodosDescricao(request.getParameter("nome_doutor"));
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getCro_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone1_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone2_doutor() + "</td>");
                            out.print("<td>" + lista.get(num).getEspecialidade_doutor() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='alterarDoutor.jsp?id=" + lista.get(num).getId_doutor() + "&nome=" + lista.get(num).getNome_doutor() + "&cro=" + lista.get(num).getCro_doutor() + "&telefone1=" + lista.get(num).getTelefone1_doutor() + "&telefone2=" + lista.get(num).getTelefone2_doutor() + "&especialidade=" + lista.get(num).getEspecialidade_doutor() + " '>CLIQUE</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='excluirDoutor.jsp?id=" + lista.get(num).getId_doutor() + "&nome=" + lista.get(num).getNome_doutor() + "&cro=" + lista.get(num).getCro_doutor() + "&telefone1=" + lista.get(num).getTelefone1_doutor() + " '>CLIQUE</a></td>");
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

            <form action="inserirDoutor.jsp" method="post">
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
