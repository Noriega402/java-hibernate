/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.test;

import com.alura.dao.CategoryDao;
import com.alura.dao.CustomerDao;
import com.alura.dao.OrderDao;
import com.alura.dao.ProductDao;
import com.alura.model.Category;
import com.alura.model.Customer;
import com.alura.model.Items_order;
import com.alura.model.Order;
import com.alura.model.Product;
import com.alura.utils.JPAUtils;
import java.math.BigDecimal;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class RegistroProduct {
    public static void main(String[] args) {
        EntityManager em = JPAUtils.getEntityManager();
        registerProduct();
        ProductDao productDao = new ProductDao(em);
        OrderDao orderDao = new OrderDao(em);
        CustomerDao customerDao = new CustomerDao(em);

        Product find = productDao.consultaId(1L);
        Customer customer = new Customer("Daniel", "jdvs234f");

        Order order = new Order(customer);
        order.addItems(new Items_order(3, find, order));

        em.getTransaction().begin(); // iniciando transaccion
        customerDao.save(customer);
        orderDao.save(order);
        em.getTransaction().commit(); //haciendo commit (insertar) si todo va bien
        
        BigDecimal valorMinimo = orderDao.valueTotalMin();
        BigDecimal valorMaximo = orderDao.valueTotalMax();
        BigDecimal valorVentas = orderDao.valueTotalSale();
        
        System.out.println("El valor total de ventas es: " + valorVentas);
        System.out.println("El valor total minimo es: " + valorMinimo);
        System.out.println("El valor total de maximo es: " + valorMaximo);
    }
    
    public static void registerProduct(){
        Category categories = new Category("VIDEOJUEGOS");
        
        Product game = new Product("The legend of zelda: Tears of the kingdoom",
                "An epic adventure awaits in the Legend of Zelda: TEars of the kingdoom game",
                new BigDecimal(500),
                categories);
        
        EntityManager em = JPAUtils.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        
        em.getTransaction().begin(); // iniciando transaccion

        categoryDao.save(categories);
        productDao.save(game);

        em.getTransaction().commit(); //haciendo commit (insertar) si todo va bien
        em.close(); // cerrando conexion
    }
}
