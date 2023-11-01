<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : libros
    Created on : 31 oct 2023, 22:30:03
    Author     : ALEX
--%>




<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>LIBROS</title>
        <style>
            table {
                width: 80%;
                margin: 20px auto;
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
            <h2>LIBROS</h2>
            <a href="LibroControlador?action=add"><button>NUEVO</button></a>
            <a href="biblioteca.jsp"><button>SALIR</button></a>



            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>TITULO</th>
                        <th>AUTOR</th>
                        <th>DISPONIBLE</th>
                        <th>CATEGORIA</th>
                        <th>OPCIONES</th>

                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="item" items="${libros}">


                        <tr>

                            <td>${item.id}</td>
                            <td>${item.titulo}</td>
                            <td>${item.autor}</td>
                            <td>${item.disponible}</td>
                            <td>${item.categoria}</td>



                            <td>
                                <a href="LibroControlador?action=edit&id=${item.id}"><button>EDITAR</button></a>
                                <a href="LibroControlador?action=delete&id=${item.id}" onclick="return(confirm('ESTA SEGURO DE ELIMINAR EL LIBRO ?'))"><button>ELIMINAR</button></a>
                            </td>

                        </tr>
                    </c:forEach>



                </tbody>
            </table>


        </div>
    </body>
</html>
