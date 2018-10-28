<%-- 
    Document   : Videos
    Created on : 27-oct-2018, 13:13:45
    Author     : DanielEsteban
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creacion de videos</title>
    </head>
    <body>
           <body>
        <h1>Gestion de productos</h1>
        <form action="./Videos" method="POST">
            <div><input type="hidden" name="Isan" value=""</div>
            <div><label for="nombre">Titulo: </label><input type="text" name="Titulo"></div>
            <div><label for="duracion">Duracion: </label><input type="time" name="duracion"></div>
            <div><label for="AñoProduccion">Año de produccion: </label><input type="date" name="AñoProduccion"></div>
            <div><input type="hidden" type="text" name="cod_idioma"></div>
            <div><input type="hidden" type="text" name="IdSerie"></div> <!--posible prblema porque no tiene name-->
            <div><label for="valor">Valor: $</label><input type="text" min="0"></div>
            <input type="submit" value="Enviar!">
        </form>
    </body>
    </body>
</html>
