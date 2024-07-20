/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class Cliente {
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String email;
    
    public Cliente(){}
    /**
     * 
     * @param id_cliente
     * @param nombre
     * @param apellido
     * @param direccion
     * @param telefono
     * @param email 
     */
    public Cliente(int id_cliente,String nombre, String apellido, String direccion, String telefono, String email){
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
    /**
     * 
     * @return id cliente 
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

    /**
     * 
     * @return nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * 
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * 
     * @return apellido del cliente
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * 
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * 
     * @return direccion del cliente
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * 
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * 
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * 
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * 
     * @return email del cliente
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
