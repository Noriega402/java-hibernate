/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Customer;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class CustomerDao {
    private EntityManager em;

    public CustomerDao (EntityManager em) {
        this.em = em;
    }
    
    public void save(Customer customer){
        this.em.persist(customer);
    }
    
    public Customer consultaId(Long id){
        return em.find(Customer.class, id);
    }
    
    public List<Customer> consultaTodos(){
        String jpql = "SELECT P FROM Customer AS P";
        return em.createQuery(jpql, Customer.class).getResultList();
    }
    
    public List<Customer> consultaForName(String name){
        String jpql = "SELECT P FROM Customer AS P WHERE P.name = :name";
        return em.createQuery(jpql, Customer.class).setParameter("name", name).getResultList();
    }
    
    public List<Customer> consultaForCategory(String name){
        String jpql = "SELECT P FROM Customer AS P WHERE P.category.name = :name";
        return em.createQuery(jpql, Customer.class).setParameter("name", name).getResultList();
    }
    
    public BigDecimal consultaForPriceOfCustomer(String name){
        String jpql = "SELECT P.price FROM Customer AS P WHERE P.name = :name";
        return em.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }
}
