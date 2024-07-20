/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.rubenparedes.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.rubenparedes.db.Conexion;
import org.rubenparedes.modelo.Usuario;

/**
 *
 * @author r
 */
public class ControladorUsuario {
    private static ArrayList<Usuario> usuarios;
    private static ControladorUsuario instancia = null;
   
    private ControladorUsuario(){
        usuarios = new ArrayList<Usuario>();
        enlistarUsuarios();
    }
    
    /**
     * 
     * @return instancia del controlador de usuarios
     */
    public static ControladorUsuario getInstancia(){
        if(instancia == null){
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    
    Usuario usuario = new Usuario();
    Conexion conexion = new Conexion();
    
    /**
     * metodo para añadir un nuevo usuario en la base de datos
     * @param usuario 
     */
    public void agregarUsuario(Usuario usuario){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarUsuario(?,?,?,?,?)");
            sentencia.setString(1, usuario.getUsuario());
            sentencia.setString(2, usuario.getContraseña());
            sentencia.setInt(3, usuario.getId_cliente());
            sentencia.setBoolean(4, usuario.isEstado_activo());
            sentencia.setBoolean(5, usuario.isRol());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    /**
     * 
     * @param usuario
     * @return usuario que se buscó por medio del id
     */
    public Usuario buscarUsuario(Usuario usuario){
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarUsuario(?);");
        sentencia.setInt(1, usuario.getId_usuario());        
        ResultSet resultado = sentencia.executeQuery();
        if(resultado.next()==true){
            usuario.setId_usuario(resultado.getInt(1));
            usuario.setUsuario(resultado.getString(2));
            usuario.setContraseña(resultado.getString(3));
            usuario.setId_cliente(resultado.getInt(4));
            usuario.setEstado_activo(resultado.getBoolean(5));
            usuario.setRol(resultado.getBoolean(6));
            
        } else            
            usuario = null;
        } catch(Exception error){
            error.printStackTrace();
        }
        return usuario;
    }
    
    /**
     * metodo que muestra los usuarios en su panel
     */
    public void enlistarUsuarios(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarUsuario()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Usuario usuario = new Usuario();
            usuario.setId_usuario(resultado.getInt(1));
            usuario.setUsuario(resultado.getString(2));
            usuario.setContraseña(resultado.getString(3));
            usuario.setId_cliente(resultado.getInt(4));
            usuario.setEstado_activo(resultado.getBoolean(5));
            usuario.setRol(resultado.getBoolean(6));
            
            usuarios.add(usuario);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
     * metodo que actualiza un usuario dentro de la base de datos
     * @param usuario 
     */
    public void actualizarUsuario(Usuario usuario){
        try{
            int posicionEnArray = usuarios.indexOf(usuario);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarUsuario(?,?,?,?,?,?);");
            sentencia.setInt(1,usuario.getId_usuario());
            sentencia.setString(2, usuario.getUsuario());
            sentencia.setString(3, usuario.getContraseña());
            sentencia.setInt(4, usuario.getId_cliente());
            sentencia.setBoolean(5, usuario.isEstado_activo());
            sentencia.setBoolean(6, usuario.isRol());
            
            sentencia.execute();
            usuarios.set(posicionEnArray,usuario);
            JOptionPane.showMessageDialog(null,"Ha actualizado un usuario en la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }   
    }
    
    
    
    /**
     * 
     * @return cantidad de usuarios que se han agregado dentro de la base de datos
     */
    public int cantidadDeUsuarios(){
        return usuarios.size();
    }
    
    /**
     * 
     * @return Array de usuarios
     */
    public ArrayList<Usuario> listaDeUsuarios(){
        return usuarios;
    }
    
    /**
     * 
     * @param entrada
     * @return cantidad de usuarios que se han ingresado dentro de la base de datos
     */
    private int cantidadDeRegistros(ResultSet entrada){
        int cantidadDeRegistros = 0;
        try{
            if(entrada.last())
                cantidadDeRegistros = entrada.getRow();                
        }catch(Exception error){
            error.printStackTrace();
        }
        return cantidadDeRegistros;
    }
}
