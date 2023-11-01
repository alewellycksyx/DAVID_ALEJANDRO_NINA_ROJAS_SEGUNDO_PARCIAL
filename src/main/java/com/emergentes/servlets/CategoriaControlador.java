/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.servlets;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimp;
import com.emergentes.dao.LibroDAO;
import com.emergentes.dao.LibroDAOimp;

import com.emergentes.modelo.Categoria;


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
@WebServlet(name = "CategoriaControlador", urlPatterns = {"/CategoriaControlador"})
public class CategoriaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Categoria cat = new Categoria();
            int id;
            CategoriaDAO dao = new CategoriaDAOimp();
            String action = request.getParameter("action");
            if(action==null){
            action="view";
            }
            switch (action) {
                case "add":
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("formCategorias.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    cat = dao.getById(id);
                    request.setAttribute("categoria", cat);
                    request.getRequestDispatcher("formCategorias.jsp").forward(request, response);

                    break;
                case "delete":
                    
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("CategoriaControlador");

                    break;
                case "view":
                    List<Categoria> lista = null;
                    lista = dao.getAll();
                    request.setAttribute("categorias", lista);
                    request.getRequestDispatcher("categorias.jsp").forward(request, response);

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

       
        String categoria = request.getParameter("categoria");
       
        
        Categoria cat = new Categoria();
       
        cat.setId(id);
        
        cat.setCategoria(categoria);

        CategoriaDAO dao = new CategoriaDAOimp();

        if (id == 0) {
            try {
                dao.insert(cat);
            } catch (Exception ex) {
               request.getRequestDispatcher("error.jsp?inf=insert").forward(request, response);
                Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            try {
                dao.update(cat);
            } catch (Exception ex) {
              request.getRequestDispatcher("error.jsp?inf=update").forward(request, response);
                Logger.getLogger(LibroControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("CategoriaControlador");

    }

}
