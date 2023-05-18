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
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Daniel Noriega
 */
public class RegistroProduct {
    public static void main(String[] args) {
        registerProduct();
        EntityManager em = JPAUtils.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        Product product = productDao.consultaId(1l);//buscar por id
        System.out.println(product.getName());//imprimir nombre del producto
        
        List<Product> products = productDao.consultaTodos();
        System.out.println("Lista de productos:");
        products.forEach(prod -> System.out.println(prod.getDescription()));
    }
    
    public static void registerProduct(){
        Category categories = new Category("VIDEOJUEGOS");
        
        Product game = new Product("The legend of zelda: Tears of the kingdoom",
                "An epic adventure awaits in the Legend of Zelda: TEars of the kingdoom game",
                new BigDecimal("1500"),
                categories);
        
        EntityManager em = JPAUtils.getEntityManager();
        ProductDao productDao = new ProductDao(em);
        CategoryDao categoryDao = new CategoryDao(em);
        
        em.getTransaction().begin();
        categoryDao.save(categories);
        productDao.save(game);
        
        em.getTransaction().commit();
        em.close();
    }
}
