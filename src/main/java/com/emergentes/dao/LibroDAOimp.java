/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Libro;
import com.emergentes.util.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALEX
 */
public class LibroDAOimp extends DatabaseConnection implements LibroDAO {

    @Override
    public void insert(Libro libro) throws Exception {
        try {
            this.getConnection();
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO libros (titulo,autor,disponible,categoria) VALUES (?,?,?,?)");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
            ps.setInt(4, libro.getId_categoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void update(Libro libro) throws Exception {

        try {
            this.getConnection();
            PreparedStatement ps = this.connection.prepareStatement("UPDATE libros SET titulo = ?, autor = ?, disponible = ? , categoria = ?  WHERE id = ?");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getDisponible());
            ps.setInt(4, libro.getId_categoria());

            ps.setInt(5, libro.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }

    }

    @Override
    public void delete(int id) throws Exception {

        try {
            this.getConnection();
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM libros WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }

    }

    @Override
    public Libro getById(int id) throws Exception {
        Libro libro = new Libro();
        try {
            this.getConnection();
            String sql = "SELECT * FROM libros WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setDisponible(rs.getString("disponible"));
                libro.setId_categoria(rs.getInt("categoria"));
            }

        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }
        return libro;

    }

    @Override
    public List<Libro> getAll() throws Exception {
        List<Libro> lista = null;

        try {
            this.getConnection();
            String sql = "SELECT\n"
                    + "    L.ID AS \"id\",\n"
                    + "    L.TITULO AS \"titulo\",\n"
                    + "    L.AUTOR AS \"autor\",\n"
                    + "    L.DISPONIBLE AS \"disponible\",\n"
                    + "    C.ID AS \"id_categoria\",\n"
                    + "    C.CATEGORIA AS \"categoria\"\n"
                    + "FROM LIBROS L\n"
                    + "INNER JOIN CATEGORIAS C ON L.CATEGORIA = C.ID\n"
                    + "ORDER BY \"id\";";

            PreparedStatement ps = this.connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<>();

            while (rs.next()) {
                Libro libro = new Libro();

                libro.setId(rs.getInt("id"));
                libro.setTitulo(rs.getString("titulo"));
                libro.setAutor(rs.getString("autor"));
                libro.setDisponible(rs.getString("disponible"));
                libro.setCategoria(rs.getString("categoria"));
                libro.setId_categoria(rs.getInt("id_categoria"));
                lista.add(libro);

            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }
        return lista;

    }

}
