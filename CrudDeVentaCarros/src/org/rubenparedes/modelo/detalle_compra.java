/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class detalle_compra {
    private int id_detalle_compra;
    private int id_compra;
    private int id_carro;
    private int cantidad;
    
    public detalle_compra(){}
    
    /**
     * 
     * @param id_detalle_compra
     * @param id_compra
     * @param id_carro
     * @param cantidad 
     */
    public detalle_compra(int id_detalle_compra, int id_compra, int id_carro, int cantidad){
        this.id_detalle_compra = id_detalle_compra;
        this.id_compra = id_compra;
        this.id_carro = id_carro;
        this.cantidad = cantidad;
    }
    
    /**
     * 
     * @return id detalle compra
     */
    public int getId_detalle_compra() {
        return id_detalle_compra;
    }

    /**
     * 
     * @param id_detalle_compra 
     */
    public void setId_detalle_compra(int id_detalle_compra) {
        this.id_detalle_compra = id_detalle_compra;
    }

    /**
     * 
     * @return id compra del detalle
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
     * @return id carro
     */
    public int getId_carro() {
        return id_carro;
    }

    /**
     * 
     * @param id_carro 
     */
    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    /**
     * 
     * @return cantidad de productos que se han comprado
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * 
     * @param cantidad 
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }   
}
