<%-- 
    Document   : PaginaPrincipal
    Created on : 14/10/2020, 14:19:33
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_paginaPrincipal.css">
        <title>HOME</title>
    </head>
    <body>
        
        <div id="banner-home">
            <h1>Sistema Odontológico</h1>
        </div>


        <div id="lateral">

            <form action="login.jsp" method="post">
                <button type="submit" class="BotaoCadastro">
                    Pagina de Cadastros
                </button>
            </form>

            <form action="agendamento.jsp" method="post">
                <button type="submit" class="BotaoAgendar">
                    Agendar Consulta
                </button>
            </form>

            <form action="Agenda.jsp" method="post">
                <button type="submit" class="BotaoVerAgenda">
                    Ver Agenda
                </button>
            </form>

            <form action="index.jsp" method="post">
                <button type="submit" class="BotaoSair">
                    Sair
                </button>
            </form>

        </div>

    </body>
</html>