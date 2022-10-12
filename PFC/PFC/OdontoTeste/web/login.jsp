<%-- 
    Document   : login
    Created on : 14/10/2020, 12:25:03
    Author     : paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/_login.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js" charset=""></script>
        <title>Login</title>
    </head>
    <body> 

        <form action="executa_login" class="login" method="post">
            <h1>Login</h1>

            <div class="CampoLoginESenha">
                <input type="text" name="txtLog" value="" id="txtLog" />
                <span data-placeholder="Login"></span>
            </div><br>

            <div class="CampoLoginESenha">
                <input type="password" name="txtSenha" value="" id="txtSenha" />
                <span data-placeholder="Senha"></span>
            </div>


            <input type="submit" class="BotaoPadrao1" value="Logar" name="btnLogin" />
            
            

        </form>

        <script type="text/javascript">
            $(".CampoLoginESenha input").on("focus", function () {
                $(this).addClass("focus");
            })

            $(".CampoLoginESenha input").on("blur", function () {
                if($(this).val() == "")
                $(this).removeClass("focus");
            })
        </script>
    </body>
</html>