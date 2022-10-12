<%-- 
    Document   : CadastroUsuario
    Created on : 15/10/2020, 19:55:45
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Paciente" %>
<%@page import="dao.PacienteDAO" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaCadastroPadrao.css">
        <title>Cadastro de Pacientes</title>
    </head>
    <body>
        <div id="banner-cadastro">
            <h1>Cadastro de Pacientes</h1>
        </div>

        <div class="plataformaPaciente">

            <form action="CadastroPaciente.jsp" method="post" class="CampoDeBusca">
                <label>Nome:</label>
                <input type="text" name="nome_paci">
                <button type="submit" class="BotaoBuscar">
                    Buscar
                </button><br>
            </form>
            
            <%
                try {

                    out.print("<table class='TabelaPacientes'>");
                    out.print("<thead>");
                    out.print("<tr>");
                    out.print("<th>id</th><th>nome</th><th>rg</th><th>cpf</th><th>telefone 1</th><th>telefone 2</th><th>cep</th><th>cidade</th><th>bairro</th><th>rua</th><th>complemento</th><th>Edição</th><th>Exclusão</th>");
                    out.print("</tr>");
                    out.print("</thead>");
                    out.print("<tbody>");
                    PacienteDAO paciDao = new PacienteDAO();

                    if (request.getParameter("nome_paci") == "" || request.getParameter("nome_paci") == null) {
                        ArrayList<Paciente> lista = paciDao.listarTodos();
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getRg_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCpf_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone2_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCep_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCidade_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getBairro_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getRua_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getComplemento_paciente() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='alterarPaci.jsp?id=" + lista.get(num).getId_paciente() + "&nome=" + lista.get(num).getNome_paciente() + "&rg=" + lista.get(num).getRg_paciente() + "&cpf=" + lista.get(num).getCpf_paciente() + "&telefone1=" + lista.get(num).getTelefone_paciente() + "&telefone2=" + lista.get(num).getTelefone2_paciente() + "&cep=" + lista.get(num).getCep_paciente() + "&cidade=" + lista.get(num).getCidade_paciente() + "&bairro=" + lista.get(num).getBairro_paciente() + "&rua=" + lista.get(num).getRua_paciente() + "&complemento=" + lista.get(num).getComplemento_paciente() + " '>Editar</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='excluirPaci.jsp?id=" + lista.get(num).getId_paciente() + "&nome=" + lista.get(num).getNome_paciente() + "&rg=" + lista.get(num).getRg_paciente() + "&cpf=" + lista.get(num).getCpf_paciente() + "&telefone1=" + lista.get(num).getTelefone_paciente() + " '>Excluir</a></td>");
                            out.print("</tr>");
                        }
                    } else {
                        ArrayList<Paciente> lista = paciDao.listarTodosDescricao(request.getParameter("nome_paci"));
                        for (int num = 0; num < lista.size(); num++) {
                            out.print("<tr>");
                            out.print("<td>" + lista.get(num).getId_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getNome_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getRg_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCpf_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getTelefone2_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCep_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getCidade_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getBairro_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getRua_paciente() + "</td>");
                            out.print("<td>" + lista.get(num).getComplemento_paciente() + "</td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='alterarPaci.jsp?id=" + lista.get(num).getId_paciente() + "&nome=" + lista.get(num).getNome_paciente() + "&rg=" + lista.get(num).getRg_paciente() + "&cpf=" + lista.get(num).getCpf_paciente() + "&telefone1=" + lista.get(num).getTelefone_paciente() + "&telefone2=" + lista.get(num).getTelefone2_paciente() + "&cep=" + lista.get(num).getCep_paciente() + "&cidade=" + lista.get(num).getCidade_paciente() + "&bairro=" + lista.get(num).getBairro_paciente() + "&rua=" + lista.get(num).getRua_paciente() + "&complemento=" + lista.get(num).getComplemento_paciente() + " '>Editar</a></td>");
                            out.print("<td><a class='BotaoExcluirAlterar' href='excluirPaci.jsp?id=" + lista.get(num).getId_paciente() + "&nome=" + lista.get(num).getNome_paciente() + "&rg=" + lista.get(num).getRg_paciente() + "&cpf=" + lista.get(num).getCpf_paciente() + "&telefone1=" + lista.get(num).getTelefone_paciente() + " '>Excluir</a></td>");
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

            <form action="inserirPaci.jsp" method="post">
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