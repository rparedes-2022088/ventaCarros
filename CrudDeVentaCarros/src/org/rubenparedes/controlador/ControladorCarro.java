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
import org.rubenparedes.modelo.Carro;

/**
 *
 * @author r
 */
public class ControladorCarro {
    private static ArrayList<Carro> carros;
    private static ControladorCarro instancia = null;
   
    private ControladorCarro(){
        carros = new ArrayList<Carro>();
        enlistarCarros();
    }
    
    
    /**
     * 
     * @return instancia controlador carro
     */
    public static ControladorCarro getInstancia(){
        if(instancia == null){
            instancia = new ControladorCarro();
        }
        return instancia;
    }
    
    Carro carro = new Carro();
    Conexion conexion = new Conexion();
    
    /**
     * metodo para agregar un nuevo carro en la base de datos :D
     * @param carro 
     */
    public void agregarCarro(Carro carro){
        
        try{
            PreparedStatement sentencia = conexion.getInstancia().getConexion().prepareCall("call sp_agregarCarro(?,?,?)");
            sentencia.setString(1, carro.getCarro());
            sentencia.setString(2, carro.getModelo());
            sentencia.setFloat(3, carro.getPrecio());
            
            
            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Ha enviado un dato a la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    /**
     * 
     * @param carro
     * @return carro que se busco, por medio del id
     */
    public Carro buscarCarro(Carro carro){
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_buscarCarro(?);");
        sentencia.setInt(1, carro.getId_carro());        
        ResultSet resultado = sentencia.executeQuery();
        if(resultado.next()==true){
            carro.setId_carro(resultado.getInt(1));
            carro.setCarro(resultado.getString(2));
            carro.setModelo(resultado.getString(3));
            carro.setPrecio(resultado.getFloat(4));
        } else            
            carro = null;
        } catch(Exception error){
            error.printStackTrace();
        }
        return carro;
    }
    
    /**
     * metodo para devolver la lista de autos que tenemos en nuestra tienda
     */
    public void enlistarCarros(){        
        try{
        PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_enlistarCarro()");
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Carro carro = new Carro();
            carro.setId_carro(resultado.getInt(1));
            carro.setCarro(resultado.getString(2));
            carro.setModelo(resultado.getString(3));
            carro.setPrecio(resultado.getFloat(4));
            carros.add(carro);
        }
        }catch(Exception error){
            error.printStackTrace();
        }        
    }
    
    /**
     * metodo que sirve para actualizar a un carro de la base de datos
     * @param carro 
     */
    public void actualizarCarro(Carro carro){
        try{
            int posicionEnArray = carros.indexOf(carro);
            PreparedStatement sentencia = Conexion.getInstancia().getConexion().prepareCall("call sp_actualizarCarro(?,?,?,?);");
            sentencia.setInt(1,carro.getId_carro());
            sentencia.setString(2, carro.getCarro());
            sentencia.setString(3, carro.getModelo());
            sentencia.setFloat(4, carro.getPrecio());

            sentencia.execute();
            carros.set(posicionEnArray,carro);
            JOptionPane.showMessageDialog(null,"Ha actualizado un carro en la BD.");
        }catch(Exception error){
            error.printStackTrace();
        }   
    }
    
    /**
     * 
     * @return tamaño lista de carros
     */
    public int cantidadDeCarros(){
        return carros.size();
    }
    
    /**
     * 
     * @return array de los carros
     */
    public ArrayList<Carro> listaDeCarros(){
        return carros;
    }
    
    /**
     * 
     * @param entrada
     * @return cantidadDeCarros ingresados
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
