<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina de Alteração</title>
        <link rel="stylesheet" type="text/css" href="_css/_cadastrosResposta.css">
    </head>
    <body>
        <form action="executa_alterar" method="post" class="login3">
            <div class="bloco2">
                <div class="CampoLoginESenha">
                    <label>Id:</label><br>
                    <label><%=request.getParameter("id")%></label>
                    <input type="hidden" name="id" value="<%=request.getParameter("id")%>" />
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Nome:</label>
                    <input type="text" name="nome" value="<%=request.getParameter("nome")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Rg:</label>
                    <input type="text" name="rg" value="<%=request.getParameter("rg")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Cpf:</label>
                    <input type="text" name="cpf" value="<%=request.getParameter("cpf")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Telefone 1:</label>
                    <input type="text" name="telefone1" value="<%=request.getParameter("telefone1")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Telefone 2:</label>
                    <input type="text" name="telefone2" value="<%=request.getParameter("telefone2")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Cep:</label>
                    <input type="text" name="cep" value="<%=request.getParameter("cep")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Cidade:</label>
                    <input type="text" name="cidade" value="<%=request.getParameter("cidade")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Bairro:</label>
                    <input type="text" name="bairro" value="<%=request.getParameter("bairro")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Rua:</label>
                    <input type="text" name="rua" value="<%=request.getParameter("rua")%>">
                </div><br>
                <div class="CampoLoginESenha">
                    <label>Complemento:</label>
                    <input type="text" name="complemento" value="<%=request.getParameter("complemento")%>">
                </div><br>

                <input type="hidden" name="FLAG" value="flag2"><br>

                <button class="BotaoPadrao3" type="submit">
                    OK
                </button>
            </div>
        </form>
    </body>
</html>
