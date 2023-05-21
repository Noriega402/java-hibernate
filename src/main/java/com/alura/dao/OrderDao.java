/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Order;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class OrderDao {
    private EntityManager em;

    public OrderDao(EntityManager em) {
        this.em = em;
    }
    
    public void save(Order order){
        this.em.persist(order);
    }
    
    public Order consultaId(Long id){
        return em.find(Order.class, id);
    }
    
    public List<Order> consultaTodos(){
        String jpql = "SELECT P FROM Order AS P";
        return em.createQuery(jpql, Order.class).getResultList();
    }
    
    public List<Order> consultaForName(String name){
        String jpql = "SELECT P FROM Order AS P WHERE P.name = :name";
        return em.createQuery(jpql, Order.class).setParameter("name", name).getResultList();
    }
    
    public List<Order> consultaForCategory(String name){
        String jpql = "SELECT P FROM Order AS P WHERE P.category.name = :name";
        return em.createQuery(jpql, Order.class).setParameter("name", name).getResultList();
    }
    
    public BigDecimal consultaForPriceOfOrder(String name){
        String jpql = "SELECT P.price FROM Order AS P WHERE P.name = :name";
        return em.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }
    
    public BigDecimal valueTotalSale(){
        String jpql = "SELECT SUM(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
    
    public BigDecimal valueTotalMax(){
        String jpql = "SELECT MAX(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
    
    public BigDecimal valueTotalAVG(){
        String jpql = "SELECT AVG(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
    
    public BigDecimal valueTotalMin(){
        String jpql = "SELECT MIN(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
}
