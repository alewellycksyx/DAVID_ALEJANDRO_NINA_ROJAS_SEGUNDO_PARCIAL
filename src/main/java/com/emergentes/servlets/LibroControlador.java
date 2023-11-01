/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.servlets;

import com.emergentes.dao.LibroDAO;
import com.emergentes.dao.LibroDAOimp;

import com.emergentes.modelo.Libro;
import java.io.IOException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ALEX
 */
@WebServlet(name = "LibroControlador", urlPatterns = {"/LibroControlador"})
public class LibroControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Libro lib = new Libro();
            int id;
            LibroDAO dao = new LibroDAOimp();
            String action = request.getParameter("action");
            if (action == null) {
                action = "view";
            }
            switch (action) {
                case "add":
                    request.setAttribute("libro", lib);
                    request.getRequestDispatcher("formLibros.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    lib = dao.getById(id);
                    request.setAttribute("libro", lib);
                    request.getRequestDispatcher("formLibros.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("LibroControlador");

                    break;
                case "view":
                    List<Libro> lista = null;

                    lista = dao.getAll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("libros.jsp").forward(request, response);

                    break;

            }
        } catch (Exception ex) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
            Logger.getLogger(CategoriaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        int categoria = Integer.parseInt(request.getParameter("id_categoria"));
        
        Libro lib = new Libro();
        lib.setId(id);
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setDisponible(disponible);
        lib.setId_categoria(categoria);

        LibroDAO dao = new LibroDAOimp();

        if (id == 0) {
            try {
                dao.insert(lib);
            } catch (Exception ex) {
               request.getRequestDispatcher("error.jsp?inf=insert").forward(request, response);
                Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                dao.update(lib);
            } catch (Exception ex) {
              request.getRequestDispatcher("error.jsp?inf=update").forward(request, response);
                Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("LibroControlador");
    }

}
