<%-- 
    Document   : formCategorias
    Created on : 1 nov 2023, 4:21:39
    Author     : ALEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <style>
            /* Estilos CSS para el formulario */
            body {
                font-family: Arial, sans-serif;
            }

            .formulario {
                width: 300px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f5f5f5;
                border: 1px solid #ccc;
                border-radius: 5px;
            }

            .formulario label {
                display: block;
                margin-bottom: 5px;
            }

            .formulario input {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            .formulario select {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }

            .formulario button {
                background-color: #007BFF;
                color: #fff;
                padding: 10px 15px;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }

            .formulario button:hover {
                background-color: #0056b3;
            }
        </style>
    </head>
    <body>
        <div class="formulario">
            <h2>Formulario de Categorias</h2>
            <form action="CategoriaControlador" method="post">
                <input type="hidden" name="id" value="${categoria.id}">
                
                <label for="categoria">Categoría:</label>
                <input type="text" id="categoria" name="categoria" value="${categoria.categoria}" placeholder="Escriba la categoria">

                <button type="submit">Enviar</button>
            </form>
        </div>
    </body>
</html>

