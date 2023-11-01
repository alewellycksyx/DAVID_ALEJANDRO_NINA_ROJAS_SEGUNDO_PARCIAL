/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
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
public class CategoriaDAOimp extends DatabaseConnection implements CategoriaDAO {

    @Override
    public void insert(Categoria categoria) throws Exception {
        try {
            this.getConnection();
            PreparedStatement ps = this.connection.prepareStatement("INSERT INTO categorias (categoria) VALUES (?)");
            ps.setString(1, categoria.getCategoria());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            this.getConnection();
            PreparedStatement ps = this.connection.prepareStatement("UPDATE categorias SET categoria = ? WHERE id = ?");
            ps.setString(1, categoria.getCategoria());
            ps.setInt(2, categoria.getId());
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
            PreparedStatement ps = this.connection.prepareStatement("DELETE FROM categorias WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }
    }

    @Override
    public Categoria getById(int id) throws Exception {
        Categoria categoria = new Categoria();
        try {
            this.getConnection();
            String sql = "SELECT * FROM categorias WHERE id = ?";
            PreparedStatement ps = this.connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));

            }

        } catch (SQLException e) {
            throw e;

        } finally {
            this.closeConnection();
        }
        return categoria;
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        List<Categoria> lista = null;
        try {
            this.getConnection();
            String sql = "SELECT * FROM categorias";
            PreparedStatement ps = this.connection.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<>();

            while (rs.next()) {
                Categoria categoria = new Categoria();

                categoria.setId(rs.getInt("id"));
                categoria.setCategoria(rs.getString("categoria"));

                lista.add(categoria);

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
