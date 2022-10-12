<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Inserção</title>
        <script src="js/codigo.js" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="_css/_cadastrosResposta.css">
    </head>
    <body onload="aoCarregarPagina()">
        <form action="executa_inserir" method="post" class="login3">
            <div class="bloco">
                <!--<label>Id:</label><br>
                    <input type="text" name="id"><br>-->
                <div class="CampoLoginESenha">
                    <label>Nome:</label><br>
                    <input type="text" name="nome"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Rg:</label><br>
                    <input type="text" name="rg"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Cpf:</label><br>
                    <input type="text" name="cpf"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Telefone 1:</label><br>
                    <input type="text" name="telefone1"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Telefone 2:</label><br>
                    <input type="text" name="telefone2"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Cep:</label><br>
                    <input type="text" name="cep" id="txtcep">
                </div><br>
                <input type="button" id="btnpegar" value="Buscar"/><br>
                <div class="CampoLoginESenha">
                    <label>Cidade:</label><br>
                    <input type="text" name="cidade" id="lblcidade"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Bairro:</label><br>
                    <input type="text" name="bairro" id="lblbairro"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Rua:</label><br>
                    <input type="text" name="rua" id="lblrua"><br>
                </div>
                <div class="CampoLoginESenha">
                    <label>Complemento:</label><br>
                    <input type="text" name="complemento"><br>
                </div>
                <input type="hidden" name="FLAG" value="flag2"><br>

                <button class="BotaoPadrao1" type="submit">
                    OK
                </button>
            </div>
        </form>
    </body>
</html>
