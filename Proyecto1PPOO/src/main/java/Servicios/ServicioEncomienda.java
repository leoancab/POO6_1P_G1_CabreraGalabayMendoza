package Servicios;

import Usuarios.Ruta;
import Usuarios.TipoEncomienda;
import Usuarios.TipoPago;
import Usuarios.TipoEncomienda;
import java.time.LocalDate;
import java.time.LocalTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marti
 */
public class ServicioEncomienda extends Servicio {

    private int nServicio;
    private TipoEncomienda tipoEncomienda;
    private int cantProd;
<<<<<<< HEAD
    
    public ServicioEncomienda(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago,int identificador, 
            int nServicio, TipoEncomienda tipoEncomienda, int cantProd ){
        super(ruta,fecha,hora,tipoDePago,identificador);
=======

    public ServicioEncomienda(Ruta ruta, LocalDate fecha, LocalTime hora, 
            TipoPago tipoDePago, int identificador, int nServicio, TipoEncomienda tipoEncomienda, int cantProd) {
        super(ruta, fecha, hora, tipoDePago, identificador);
>>>>>>> b0273cf91c67e151af6684d725baaa5a08e560d1
        this.nServicio = nServicio;
        this.cantProd = cantProd;
    }

    public int getNServicio() {
        return nServicio;
    }

    public void setNServicio(int nServicio) {
        this.nServicio = nServicio;

    }
<<<<<<< HEAD
    
    public TipoEncomienda getTipoEncomienda() {
=======

    public String getTipoEncomienda() {
>>>>>>> b0273cf91c67e151af6684d725baaa5a08e560d1
        return tipoEncomienda;
    }

    public void setNServicio(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }
}
