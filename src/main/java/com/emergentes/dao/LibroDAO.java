/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.emergentes.dao;

import com.emergentes.modelo.Libro;
import java.util.List;

/**
 *
 * @author ALEX
 */
public interface LibroDAO {

    public void insert(Libro libro) throws Exception;

    public void update(Libro libro) throws Exception;

    public void delete(int id) throws Exception;

    public Libro getById(int id)  throws Exception;
    
    public List<Libro> getAll()throws Exception;
    

}
