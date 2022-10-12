<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Alteração</title>
        <link rel="stylesheet" type="text/css" href="_css/_cadastrosResposta.css">
    </head>
    <body>
        <form action="executa_alterar" class="login" method="post">
            <div class="CampoLoginESenha">
                <label>Id:</label><br>
                <label><%=request.getParameter("id")%></label><br>
                <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
            </div><br>
            <div class="CampoLoginESenha">
                <label>Nome:</label><br>
                <input type="text" name="nome" value="<%=request.getParameter("nome")%>"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Login:</label><br>
                <input type="text" name="login" value="<%=request.getParameter("login")%>"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Senha:</label><br>
                <input type="text" name="senha" value="<%=request.getParameter("senha")%>"><br>
            </div><br>

            <input type="hidden" name="FLAG" value="flag1"><br>

            <button class="BotaoPadrao2" type="submit">
                OK
            </button>

        </form>
    </body>
</html>
