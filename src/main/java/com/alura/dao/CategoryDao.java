/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Category;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class CategoryDao {
    private EntityManager em;

    public CategoryDao(EntityManager em) {
        this.em = em;
    }
    
    public void save(Category category){
        this.em.persist(category);
        
    }
    
    public void update(Category category){
        this.em.merge(category);
    }
    
    public void remove(Category category){
        category = this.em.merge(category);
        this.em.remove(category);
    }
}
