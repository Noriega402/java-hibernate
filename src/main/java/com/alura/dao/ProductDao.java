/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Category;
import com.alura.model.Product;
import java.math.BigDecimal;
import java.util.List;
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
    
    public Product consultaId(Long id){
        return em.find(Product.class, id);
    }
    
    public List<Product> consultaTodos(){
        String jpql = "SELECT P FROM Product AS P";
        return em.createQuery(jpql, Product.class).getResultList();
    }
    
    public List<Product> consultaForName(String name){
        String jpql = "SELECT P FROM Product AS P WHERE P.name = :name";
        return em.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
    
    public List<Product> consultaForCategory(String name){
        String jpql = "SELECT P FROM Product AS P WHERE P.category.name = :name";
        return em.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
    
    public BigDecimal consultaForPriceOfProduct(String name){
        String jpql = "SELECT P.price FROM Product AS P WHERE P.name = :name";
        return em.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }
}
