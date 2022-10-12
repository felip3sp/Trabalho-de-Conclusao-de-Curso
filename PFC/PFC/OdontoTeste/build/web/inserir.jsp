<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Inserção</title>
        <link rel="stylesheet" type="text/css" href="_css/_cadastrosResposta.css">
    </head>
    <body>
        <form action="executa_inserir" class="login" method="post">
            <!--<label>Id:</label><br>
                <input type="text" name="id"><br>-->
            <div class="CampoLoginESenha">
                <label>Nome:</label><br>
                <input type="text" name="nome"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Login:</label><br>
                <input type="text" name="login"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Senha:</label><br>
                <input type="text" name="senha"><br>
            </div><br>

                <input type="hidden" name="FLAG" value="flag1"><br>

            <button class="BotaoPadrao1" type="submit">
                OK
            </button>

        </form>
    </body>
</html>
