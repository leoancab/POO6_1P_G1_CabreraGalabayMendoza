package Servicios;

import Usuarios.Conductor;
import Usuarios.Ruta;
import Usuarios.TipoEncomienda;
import Usuarios.TipoPago;
import Usuarios.TipoEncomienda;
import Usuarios.TipoVehiculo;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

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

    private static int nServicio = 1223;
    private TipoEncomienda tipoEncomienda;
    private int cantProd;
    
    public ServicioEncomienda(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago, TipoEncomienda tipoEncomienda, int cantProd ){
        super(ruta,fecha,hora,tipoDePago);
        this.cantProd = cantProd;
        nServicio++;
        
    }

    public int getNServicio() {
        return nServicio;
    }

//    public void setNServicio(int nServicio) {
//        this.nServicio = nServicio;
//    }
    
    public TipoEncomienda getTipoEncomienda() {
        return tipoEncomienda;
    }

    public void setTipoEncomienda(TipoEncomienda tipoEncomienda) {
        this.tipoEncomienda = tipoEncomienda;
    }

    public int getCantProd() {
        return cantProd;
    }

    public void setCantProd(int cantProd) {
        this.cantProd = cantProd;
    }
    
    
    @Override
    public Conductor seleccionarCond(ArrayList<Conductor> conductores) {
        ArrayList<Conductor> cDisp = condDisp(conductores);
        for (int i = 0; i < cDisp.size(); i++) {
            if (cDisp.get(i).getVehiculo().equals(TipoVehiculo.MOTO)) {

                return cDisp.get(i);
            }
        }
        return null;
    }
}
