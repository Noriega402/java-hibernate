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
        EntityManager em = JPAUtils.getEntityManager();//tomar la conexion a la DB
        
        em.getTransaction().begin();// inicio de la transaccion a la DB
        
        em.persist(categories);
        categories.setName("LIBROS");
        em.flush();//sincrinoza cambios pendientes en la DB y cierra la conexion
        em.clear();//limpia la persitencia
        
        categories = em.merge(categories);
        categories.setName("Videojuegos");
        em.flush();
        em.remove(categories);//eliminar los datos del objeto
        em.flush();
    }
}
