/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class Compra {
    private int id_compra;
    private String fecha_de_compra;
    private int id_cliente;
    
    public Compra(){}
    
    /**
     * 
     * @param id_compra
     * @param fecha_de_compra
     * @param id_cliente 
     */
    public Compra(int id_compra, String fecha_de_compra, int id_cliente){
        this.id_compra = id_compra;
        this.fecha_de_compra = fecha_de_compra;
        this.id_cliente = id_cliente;
    }
    
    /**
     * 
     * @return id compra
     */
    public int getId_compra() {
        return id_compra;
    }

    /**
     * 
     * @param id_compra 
     */
    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    /**
     * 
     * @return fecha de compra
     */
    public String getFecha_de_compra() {
        return fecha_de_compra;
    }

    /**
     * 
     * @param fecha_de_compra 
     */
    public void setFecha_de_compra(String fecha_de_compra) {
        this.fecha_de_compra = fecha_de_compra;
    }

    /**
     * 
     * @return id cliente que hizo la compra
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * 
     * @param id_cliente 
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}
