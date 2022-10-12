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
                <label>Cro:</label><br>
                <input type="text" name="cro"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Telefone 1:</label><br>
                <input type="text" name="telefone1"><br>
            </div><br>
            <div class="CampoLoginESenha">
                <label>Telefone 2:</label><br>
                <input type="text" name="telefone2"><br>
            </div><br>

            <label>Especialidade:</label><br><br>
            <div class="select">
                <select name="especialidade">
                    <option>Clinico Geral</option>
                    <option>Bucomaxilo</option>
                    <option>Pediatra</option>
                    <option>Ortodontico</option>
                    <option>Estetica</option>      
                </select><br>
                <div class="select_arrow">
                </div>
            </div>

            <input type="hidden" name="FLAG" value="flag3"><br>

            <button class="BotaoPadrao1" type="submit">
                OK
            </button>

        </form>
    </body>
</html>