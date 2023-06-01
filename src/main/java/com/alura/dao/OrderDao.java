/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.dao;

import com.alura.model.Order;
import com.alura.vo.relatorioDeVenta;
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

    public void save(Order order) {
        this.em.persist(order);
    }

    public Order consultaId(Long id) {
        return em.find(Order.class, id);
    }

    public List<Order> consultaTodos() {
        String jpql = "SELECT P FROM Order AS P";
        return em.createQuery(jpql, Order.class).getResultList();
    }

    public List<Order> consultaForName(String name) {
        String jpql = "SELECT P FROM Order AS P WHERE P.name = :name";
        return em.createQuery(jpql, Order.class).setParameter("name", name).getResultList();
    }

    public List<Order> consultaForCategory(String name) {
        String jpql = "SELECT P FROM Order AS P WHERE P.category.name = :name";
        return em.createQuery(jpql, Order.class).setParameter("name", name).getResultList();
    }

    public BigDecimal consultaForPriceOfOrder(String name) {
        String jpql = "SELECT P.price FROM Order AS P WHERE P.name = :name";
        return em.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }

    public BigDecimal valueTotalSale() {
        String jpql = "SELECT SUM(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public BigDecimal valueTotalMax() {
        String jpql = "SELECT MAX(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public BigDecimal valueTotalAVG() {
        String jpql = "SELECT AVG(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public BigDecimal valueTotalMin() {
        String jpql = "SELECT MIN(p.valorTotal) FROM Order AS p";
        return em.createQuery(jpql, BigDecimal.class).getSingleResult();
    }

    public List<Object[]> relatorioDeVentas() {
        String jpql = "SELECT p.name, "
                + "SUM(i.quantity), "
                + "MAX(o.fecha) "
                + "FROM Order o "
                + "JOIN o.items i "
                + "JOIN i.product p "
                + "GROUP BY p.name, i.quantity " // Agregamos i.quantity a la cláusula GROUP BY
                + "ORDER BY SUM(i.quantity) DESC"; // Utilizamos SUM(i.quantity) en la cláusula ORDER BY
        return em.createQuery(jpql, Object[].class).getResultList();
    }
    
    public List<relatorioDeVenta> relatorioDeVentasVO() {
        String jpql = "SELECT new com.alura.vo. relatorioDeVenta(p.name, SUM(i.quantity), MAX(o.fecha)) FROM com.alura.model.Order o JOIN o.items i JOIN i.product p GROUP BY p.name, i.quantity ORDER BY SUM(i.quantity) DESC";
        return em.createQuery(jpql, relatorioDeVenta.class).getResultList();
    }

}
