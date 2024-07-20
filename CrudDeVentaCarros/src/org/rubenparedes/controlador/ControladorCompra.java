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
import org.rubenparedes.modelo.Compra;

/**
 *
 * @author r
 */
public class ControladorCompra {
    private static ArrayList<Compra> compras;
    private static ControladorCompra instancia = null;
   
    private ControladorCompra(){
        compras = new ArrayList<Compra>();
        enlistarCompras();
    }
    
    /**
     * 
     * @return instancia del controlador compra
     */
    public static ControladorCompra getInstancia(){
        if(instancia == null){
            instancia = new ControladorCompra();
        }
        return instancia;
    }
    
    Compra compra = new Compra();
    Conexion conexion = new Conexion();
    
    /**
     * metodo para ingresar una nueva compra
     * @param compra 
     */
    public void agregarCompra(Compra compra){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarCompra(?,?)");
            sentencia.setInt(1, compra.getId_compra());
            sentencia.setString(2, compra.getFecha_de_compra());
            sentencia.setInt(3, compra.getId_cliente());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    /**
     * 
     * @param compra
     * @return compra que se busco por medio del id
     */
    public Compra buscarCompra(Compra compra){
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarCompra(?);");
        sentencia.setInt(1, compra.getId_compra());        
        ResultSet resultado = sentencia.executeQuery();
        if(resultado.next()==true){
            compra.setId_compra(resultado.getInt(1));
            compra.setFecha_de_compra(resultado.getString(2));
            compra.setId_cliente(resultado.getInt(3));
            
        } else            
            compra = null;
        } catch(Exception error){
            error.printStackTrace();
        }
        return compra;
    }
    
    /**
     * metodo para mostrar compras en una tabla
     */
    public void enlistarCompras(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarCompra()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Compra compra = new Compra();
            compra.setId_compra(resultado.getInt(1));
            compra.setFecha_de_compra(resultado.getString(2));
            compra.setId_cliente(resultado.getInt(3));
            
            
            compras.add(compra);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
    * metodo que actualiza compra en la base de datos
    * @param compra 
    */
    public void actualizarCompra(Compra compra){
        try{
            int posicionEnArray = compras.indexOf(compra);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarCompra(?,?,?);");
            sentencia.setInt(1,compra.getId_compra());
            sentencia.setString(2, compra.getFecha_de_compra());
            sentencia.setInt(3, compra.getId_cliente());
            
            sentencia.execute();
            compras.set(posicionEnArray,compra);
            JOptionPane.showMessageDialog(null,"Ha actualizado una compra en la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }   
    }
    
    /**
     * 
     * @return tamaño del array de compras
     */
    public int cantidadDeCompras(){
        return compras.size();
    }
    
    /**
     * 
     * @return el array de compras
     */
    public ArrayList<Compra> listaDeCompras(){
        return compras;
    }
    
    /**
     * 
     * @param entrada
     * @return cuantas compras hay
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
