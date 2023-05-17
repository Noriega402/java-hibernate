/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.test;

import com.alura.dao.ProductDao;
import com.alura.model.Category;
import com.alura.model.Product;
import com.alura.utils.JPAUtils;
import java.math.BigDecimal;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega
 */
public class RegistroProduct {
    public static void main(String[] args) {
        Product celular  = new Product("Xiaomi", "Celular POCO X3 PRO", new BigDecimal("1000"), Category.CELULARES);
        EntityManager em = JPAUtils.getEntityManager();//tomar la conexion a la DB
        ProductDao productDao = new ProductDao(em);
        
        em.getTransaction().begin();// inicio de la transaccion a la DB
        
        productDao.save(celular);//persistencia en la DB

        em.getTransaction().commit();//en caso se ejecute la transaccion
        em.close();//cerrar conexion
    }
}
