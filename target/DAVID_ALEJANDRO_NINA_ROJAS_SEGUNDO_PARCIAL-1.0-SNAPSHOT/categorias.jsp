<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : categorias
    Created on : 31 oct 2023, 22:30:11
    Author     : ALEX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                width: 40%;
                margin: 30px auto;
                border-collapse: collapse;
            }

            th, td {
                border: 1px solid #ccc;
                padding: 8px;
            }

            th {
                background-color: greenyellow;
            }

            .container {
                text-align: center;
            }
        </style>
    </head>
    <body>

        <div class="container">
            <h1>CATEGORIAS</h1>
            <a href="CategoriaControlador?action=add"><button>NUEVO</button></a>
            <a href="biblioteca.jsp"><button>SALIR</button></a>
            <table>
                <thead>

                    <tr>
                        <th>ID</th>
                        <th>CATEGORIA</th>
                        <th>OPCIONES</th>

                    </tr>
                </thead>
                <tbody>


                    <c:forEach var="item" items="${categorias}">


                        <tr>

                            <td>${item.id}</td>
                            <td>${item.categoria}</td>



                            <td>
                                <a href="CategoriaControlador?action=edit&id=${item.id}"><button>EDITAR</button></a>
                                <a href="CategoriaControlador?action=delete&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR LA CATEGORIA ?'))"><button>ELIMINAR</button></a>
                            </td>

                        </tr>
                    </c:forEach>



                </tbody>
            </table>
        </div>



    </body>
</html>
