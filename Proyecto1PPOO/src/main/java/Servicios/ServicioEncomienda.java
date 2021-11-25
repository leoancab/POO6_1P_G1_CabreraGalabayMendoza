package Servicios;

import Usuarios.Ruta;
import Usuarios.TipoEncomienda;
import Usuarios.TipoPago;
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
    private String tipoEncomienda;
    private int cantProd;

    public ServicioEncomienda(Ruta ruta, LocalDate fecha, LocalTime hora, 
            TipoPago tipoDePago, int identificador, int nServicio, TipoEncomienda tipoEncomienda, int cantProd) {
        super(ruta, fecha, hora, tipoDePago, identificador);
        this.nServicio = nServicio;
        this.cantProd = cantProd;
    }

    public int getNServicio() {
        return nServicio;
    }

    public void setNServicio(int nServicio) {
        this.nServicio = nServicio;

    }

    public String getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setNServicio(String tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }
}
