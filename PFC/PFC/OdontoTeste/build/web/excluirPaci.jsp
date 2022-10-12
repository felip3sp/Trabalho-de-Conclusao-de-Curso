<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Exclusão</title>
        <link rel="stylesheet" type="text/css" href="_css/_cadastrosResposta.css">
    </head>
    <body>
        <form action="executa_excluir" method="post" class="login">
            <div class="CampoLoginESenha">
                <label>Id:</label><br>
                <label><%=request.getParameter("id")%></label><br>
                <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
            </div>
            <div class="CampoLoginESenha">
                <label>Nome:</label><br>
                <input type="text" name="nome" value="<%=request.getParameter("nome")%>"><br>
            </div>
            <div class="CampoLoginESenha">
                <label>Rg:</label><br>
                <input type="text" name="rg" value="<%=request.getParameter("rg")%>"><br>
            </div>
            <div class="CampoLoginESenha">
                <label>Cpf:</label><br>
                <input type="text" name="cpf" value="<%=request.getParameter("cpf")%>"><br>
            </div>
            <div class="CampoLoginESenha">
                <label>Telefone 1:</label><br>
                <input type="text" name="telefone1" value="<%=request.getParameter("telefone1")%>"><br>
            </div>
            <input type="hidden" name="FLAG" value="flag2"><br>

            <button type="submit" class="BotaoPadrao2">
                OK
            </button>

        </form>
    </body>
</html>