/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class Carro {
    private int id_carro;
    private String carro;
    private String modelo;
    private float precio;
    
    public Carro(){}
    
    /**
     * 
     * @param id_carro
     * @param carro
     * @param modelo
     * @param precio 
     */
    public Carro(int id_carro, String carro, String modelo, float precio){
        this.id_carro = id_carro;
        this.carro = carro;
        this.modelo = modelo;
        this.precio = precio;
    }
    /**
     * 
     * @return id_carro
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
     * @return carro
     */
    public String getCarro() {
        return carro;
    }

    /**
     * 
     * @param carro 
     */
    public void setCarro(String carro) {
        this.carro = carro;
    }

    /**
     * 
     * @return modelo de carro
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * 
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * 
     * @return precio del carro
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * 
     * @param precio 
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
