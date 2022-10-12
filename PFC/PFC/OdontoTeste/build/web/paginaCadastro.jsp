<%-- 
    Document   : PaginaPrincipal
    Created on : 14/10/2020, 14:19:33
    Author     : paulo
--%>

<%@page import="java.sql.Connection"%>
<%@page import="dao.ConnectionFactory"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User" %>
<%@page import="Servlet.executa_login" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaCadastro.css">
        <title>Pagina de Cadastros</title>
    </head>
    <body>
        
        <div id="imagem">
        
        <div id="banner-cadastro">
            <h1>Cadastro</h1>
        </div>

        
        </div>

        <div id="lateral">

            <form action="CadastroUsuario.jsp" method="post">
                <input type="hidden" name="txtFlag" value="Flag2" id="txtFlag" />
                <button type="submit" class="BotaoUsuario">
                    Usuário
                </button>
            </form>

            <form action="CadastroDoutores.jsp" method="post">
                <button type="submit" class="BotaoDoutores">
                    Doutor
                </button>  
            </form>

            <form action="CadastroPaciente.jsp" method="post">
                <button type="submit" class="BotaoPacientes">
                    Paciente
                </button>
            </form>

            <form action="paginaPrincipal.jsp" method="post">
                <button type="submit" class="BotaoSair">
                    Sair
                </button>
            </form>

        </div>

    </body>
</html>