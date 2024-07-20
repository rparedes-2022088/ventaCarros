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
import org.rubenparedes.modelo.detalle_proveedor_carro;

/**
 *
 * @author r
 */
public class ControladorDetalle_proveedor_carro {
    private static ArrayList<detalle_proveedor_carro> detalles_proveedor_carro;
    private static ControladorDetalle_proveedor_carro instancia = null;
   
    private ControladorDetalle_proveedor_carro(){
        detalles_proveedor_carro = new ArrayList<detalle_proveedor_carro>();
        enlistarDetalle_proveedor_carro();
    }
    
    /**
     * 
     * @return instancia del controlador detalle proveedor carro
     */
    public static ControladorDetalle_proveedor_carro getInstancia(){
        if(instancia == null){
            instancia = new ControladorDetalle_proveedor_carro();
        }
        return instancia;
    }
    
    detalle_proveedor_carro detalle_proveedor_carros = new detalle_proveedor_carro();
    Conexion conexion = new Conexion();
    
    /**
     * metodo que crea una nueva relacion de proveedor con carros, dentro de la base de datos
     * @param detalle_proveedor_carros 
     */
    public void agregarDetalle_proveedor_carro(detalle_proveedor_carro detalle_proveedor_carros){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarDetalleProveedorCarro(?,?)");
            sentencia.setInt(1, detalle_proveedor_carros.getId_detalle_proveedor_carro());
            sentencia.setInt(2, detalle_proveedor_carros.getId_proveedor());
            sentencia.setInt(3, detalle_proveedor_carros.getId_carro());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }

    /**
     * metodo para mostrar detalles proveedor carro en pantalla
     */
    public void enlistarDetalle_proveedor_carro(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarDetalleProveedorCarro()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            detalle_proveedor_carro detalle_proveedor_carros = new detalle_proveedor_carro();
            detalle_proveedor_carros.setId_detalle_proveedor_carro(resultado.getInt(1));
            detalle_proveedor_carros.setId_proveedor(resultado.getInt(2));
            detalle_proveedor_carros.setId_carro(resultado.getInt(3));
            
            
            detalles_proveedor_carro.add(detalle_proveedor_carros);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
     * 
     * @return tamaño del array de detalle proveedor carro
     */
    public int cantidadDetalleProveedorCarro(){
        return detalles_proveedor_carro.size();
    }
    
    /**
     * 
     * @return Array de detalle proveedor carro
     */
    public ArrayList<detalle_proveedor_carro> listaDetalleProveedorCarro(){
        return detalles_proveedor_carro;
    }
    
    /**
     * 
     * @param entrada
     * @return cantidad de detalles que se han agregado
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
