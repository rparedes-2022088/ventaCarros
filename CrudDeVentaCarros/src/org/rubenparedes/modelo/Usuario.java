/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.modelo;

/**
 *
 * @author r
 */
public class Usuario {
    private int id_usuario;
    private String usuario;
    private String contraseña;
    private int id_cliente;
    private boolean estado_activo;
    private boolean rol;
    
    public Usuario(){}
    
    /**
     * 
     * @param id_usuario
     * @param usuario
     * @param contraseña
     * @param id_cliente
     * @param estado_activo
     * @param rol 
     */
    public Usuario(int id_usuario, String usuario, String contraseña, int id_cliente, boolean estado_activo, boolean rol){
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.id_cliente = id_cliente;
        this.estado_activo = estado_activo;
        this.rol = rol;
    }
    
    /**
     * 
     * @return id usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * 
     * @param id_usuario 
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * 
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * 
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * 
     * @return contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * 
     * @param contraseña 
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * 
     * @return id cliente que es dueño del usuario de la base de datos
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
     * @return estado activo del usuario
     */
    public boolean isEstado_activo() {
        return estado_activo;
    }

    /**
     * 
     * @param estado_activo 
     */
    public void setEstado_activo(boolean estado_activo) {
        this.estado_activo = estado_activo;
    }

    /**
     * 
     * @return rol del usuario
     */
    public boolean isRol() {
        return rol;
    }

    /**
     * 
     * @param rol 
     */
    public void setRol(boolean rol) {
        this.rol = rol;
    }
}
