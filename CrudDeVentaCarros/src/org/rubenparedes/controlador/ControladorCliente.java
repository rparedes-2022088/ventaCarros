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
import org.rubenparedes.modelo.Cliente;

/**
 *
 * @author r
 */
public class ControladorCliente {
    private static ArrayList<Cliente> clientes;
    private static ControladorCliente instancia = null;
   
    private ControladorCliente(){
        clientes = new ArrayList<Cliente>();
        enlistarClientes();
    }
    
    /**
     * 
     * @return instancia del controlador cliente, del tipo cliente
     */
    public static ControladorCliente getInstancia(){
        if(instancia == null){
            instancia = new ControladorCliente();
        }
        return instancia;
    }
    
    Cliente cliente = new Cliente();
    Conexion conexion = new Conexion();
    
    /**
     * metodo para agregar un nuevo cliente
     * @param cliente 
     */
    public void agregarCliente(Cliente cliente){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarCliente(?,?,?,?,?)");
            sentencia.setString(1, cliente.getNombre());
            sentencia.setString(2, cliente.getApellido());
            sentencia.setString(3,cliente.getDireccion());
            sentencia.setString(4, cliente.getTelefono());
            sentencia.setString(5, cliente.getEmail());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    /**
     * 
     * @param cliente
     * @return cliente
     */
    public Cliente buscarCliente(Cliente cliente){
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarCliente(?);");
        sentencia.setInt(1, cliente.getId_cliente());        
        ResultSet resultado = sentencia.executeQuery();
        if(resultado.next()==true){
            cliente.setId_cliente(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDireccion(resultado.getString(4));
            cliente.setTelefono(resultado.getString(5));                
            cliente.setEmail(resultado.getString(6));
        } else            
            cliente = null;
        } catch(Exception error){
            error.printStackTrace();
        }
        return cliente;
    }
    
    /**
     * Metodo para mostrar los clientes en el panel de clientes, en la vistaVentaCarros
     */
    public void enlistarClientes(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarCliente()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Cliente cliente = new Cliente();
            cliente.setId_cliente(resultado.getInt(1));
            cliente.setNombre(resultado.getString(2));
            cliente.setApellido(resultado.getString(3));
            cliente.setDireccion(resultado.getString(4));
            cliente.setTelefono(resultado.getString(5));                
            cliente.setEmail(resultado.getString(6));
            
            clientes.add(cliente);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
     * 
     * @param cliente 
     */
    public void actualizarCliente(Cliente cliente){
        try{
            int posicionEnArray = clientes.indexOf(cliente);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarCliente(?,?,?,?,?,?);");
            sentencia.setInt(1,cliente.getId_cliente());
            sentencia.setString(2, cliente.getNombre());
            sentencia.setString(3, cliente.getApellido());
            sentencia.setString(4, cliente.getDireccion());
            sentencia.setString(5,cliente.getTelefono());
            sentencia.setString(6,cliente.getEmail());
            
            sentencia.execute();
            clientes.set(posicionEnArray,cliente);
            JOptionPane.showMessageDialog(null,"Ha actualizado un cliente en la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }   
    }
    
    /**
     * 
     * @return tamaño de clientes
     */
    public int cantidadDeClientes(){
        return clientes.size();
    }
    
    /**
     * 
     * @return clientes
     */
    public ArrayList<Cliente> listaDeClientes(){
        return clientes;
    }
    
    /**
     * 
     * @param entrada
     * @return cantidad de clientes que se han agregado
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
