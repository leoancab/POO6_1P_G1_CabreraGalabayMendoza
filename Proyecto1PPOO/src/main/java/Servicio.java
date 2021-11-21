/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;
/**
 *
 * @author Marti
 */
public class Servicio {
    protected Ruta ruta;
    protected Date fecha;
    protected Hour hora;
    protected String tipoDePago;
    protected int identificador;
    
    public Servicio(Ruta ruta, Date fecha,Hour hora, String tipoDePago,int identificador){
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDePago = tipoDePago;
        this.identificador = identificador;
    }
    
     public String getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    public Hour getHora() {
        return hora;
    }

     public void setHora(Hour hora) {
        this.hora = hora;
    }
    
    public String getTipoDePago() {
        return tipoDePago; 
    }
    
    
    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
    }
    
      public int getIdentificador() {
        return identificador; 
    }
    
    
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
        
    protected double calcularPrecio( String tipoDePago){
        double precio = Math.random()*10;
        if("efectivo".equals(tipoDePago)){
            return  precio;
        }else{
            double pfinal = precio*0.1 + precio;
            return pfinal;
        }
    }
    
    
    
}
    
    
    

