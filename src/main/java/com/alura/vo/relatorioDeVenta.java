/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alura.vo;

import java.time.LocalDate;

/**
 *
 * @author Dnaiel Noriega
 */
public class relatorioDeVenta {
    private String nombreDelProducto;
    private Long CantidadDeProducto;
    private LocalDate FechaUltimaVenta;

    public relatorioDeVenta(String nombreDelProducto, Long CantidadDeProducto, LocalDate FechaUltimaVenta) {
        this.nombreDelProducto = nombreDelProducto;
        this.CantidadDeProducto = CantidadDeProducto;
        this.FechaUltimaVenta = FechaUltimaVenta;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public void setNombreDelProducto(String nombreDelProducto) {
        this.nombreDelProducto = nombreDelProducto;
    }

    public Long getCantidadDeProducto() {
        return CantidadDeProducto;
    }

    public void setCantidadDeProducto(Long CantidadDeProducto) {
        this.CantidadDeProducto = CantidadDeProducto;
    }

    public LocalDate getFechaUltimaVenta() {
        return FechaUltimaVenta;
    }

    public void setFechaUltimaVenta(LocalDate FechaUltimaVenta) {
        this.FechaUltimaVenta = FechaUltimaVenta;
    }

    @Override
    public String toString() {
        return "realatorioDeVenta{" + "nombreDelProducto=" + nombreDelProducto + ", CantidadDeProducto=" + CantidadDeProducto + ", FechaUltimaVenta=" + FechaUltimaVenta + '}';
    }

    
}
