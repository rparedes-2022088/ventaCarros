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
import org.rubenparedes.modelo.detalle_compra;

/**
 *
 * @author r
 */
public class ControladorDetalle_compra {
    private static ArrayList<detalle_compra> detalles_compra;
    private static ControladorDetalle_compra instancia = null;
   
    private ControladorDetalle_compra(){
        detalles_compra = new ArrayList<detalle_compra>();
        enlistarDetalles_compra();
    }
    
    /**
     * 
     * @return instancia del controlador de detalle compra
     */
    public static ControladorDetalle_compra getInstancia(){
        if(instancia == null){
            instancia = new ControladorDetalle_compra();
        }
        return instancia;
    }
    
    detalle_compra detalle_compras = new detalle_compra();
    Conexion conexion = new Conexion();
    
    /**
     * metodo que manda a la base de datos de la relacion de compras con el carro
     * @param detalle_compras 
     */
    public void agregarDetalle_compra(detalle_compra detalle_compras){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarDetalleCompra(?,?,?)");
            sentencia.setInt(1, detalle_compras.getId_detalle_compra());
            sentencia.setInt(2, detalle_compras.getId_carro());
            sentencia.setInt(3, detalle_compras.getId_compra());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    /**
     * metodo para mostrar los detalles en la tabla del panel de detalle compra
     */
    public void enlistarDetalles_compra(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarDetalleCompra()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            detalle_compra detalle_compras = new detalle_compra();
            detalle_compras.setId_detalle_compra(resultado.getInt(1));
            detalle_compras.setId_carro(resultado.getInt(2));
            detalle_compras.setId_compra(resultado.getInt(3));
            detalle_compras.setCantidad(resultado.getInt(4));
            
            
            detalles_compra.add(detalle_compras);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
     * 
     * @return el tamaño de detalles compra
     */
    public int cantidadDetalleCompras(){
        return detalles_compra.size();
    }
    
    /**
     * 
     * @return el array de detalles compras
     */
    public ArrayList<detalle_compra> listaDetalleCompras(){
        return detalles_compra;
    }
    
    /**
     * 
     * @param entrada
     * @return cantidad de detalles que encuentra en la base de datos de detalle compra
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
