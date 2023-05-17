/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Product;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class ProductDao {
    private EntityManager em;

    public ProductDao(EntityManager em) {
        this.em = em;
    }
    
    
    public void save(Product product){
        this.em.persist(product);
        
    }
}
