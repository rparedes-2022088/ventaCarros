/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class detalle_proveedor_carro {
    private int id_detalle_proveedor_carro;
    private int id_proveedor;
    private int id_carro;
    
    public detalle_proveedor_carro(){}
    
    /**
     * 
     * @param id_detalle_proveedor_carro
     * @param id_proveedor
     * @param carro 
     */
    public detalle_proveedor_carro(int id_detalle_proveedor_carro, int id_proveedor, int carro){
        this.id_detalle_proveedor_carro = id_detalle_proveedor_carro;
        this.id_proveedor = id_proveedor;
        this.id_carro = id_carro;
    }
    
    /**
     * 
     * @return id detalle proveedor carro
     */
    public int getId_detalle_proveedor_carro() {
        return id_detalle_proveedor_carro;
    }

    /**
     * 
     * @param id_detalle_proveedor_carro 
     */
    public void setId_detalle_proveedor_carro(int id_detalle_proveedor_carro) {
        this.id_detalle_proveedor_carro = id_detalle_proveedor_carro;
    }

    /**
     * 
     * @return id proveedor 
     */
    public int getId_proveedor() {
        return id_proveedor;
    }

    /**
     * 
     * @param id_proveedor 
     */
    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
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
}
