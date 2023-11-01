/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;


import com.emergentes.modelo.Categoria;
import java.util.List;

/**
 *
 * @author ALEX
 */
public interface CategoriaDAO {
    
public void insert(Categoria categoria) throws Exception;

public void update(Categoria categoria) throws Exception;

public void delete(int id) throws Exception;

public Categoria getById(int id) throws Exception;

public List<Categoria> getAll() throws Exception;

    
    
}
