/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega
 */
public class JPAUtils {
    //Creacion del factory para conexion a la DB
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("tienda"); // viene de la opcion de xml
    public static EntityManager getEntityManager(){
        return factory.createEntityManager();
    }
}
