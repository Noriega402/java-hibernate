/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.test;

import com.alura.dao.CategoryDao;
import com.alura.dao.ProductDao;
import com.alura.model.Category;
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
        Category categories = new Category("CELULARES");
        Product celular  = new Product("Xiaomi", "Celular POCO X3 PRO", new BigDecimal("1000"), categories);
        EntityManager em = JPAUtils.getEntityManager();//tomar la conexion a la DB
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        
        em.getTransaction().begin();// inicio de la transaccion a la DB
        
        categoryDao.save(categories);
        productDao.save(celular);//persistencia en la DB

        em.getTransaction().commit();//en caso se ejecute la transaccion
        em.close();//cerrar conexion
    }
}
