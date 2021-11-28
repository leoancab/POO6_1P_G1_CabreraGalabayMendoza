package Servicios;

import Usuarios.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Marti
 */
public class Servicio {

    protected Ruta ruta;
    protected LocalDate fecha;
    protected LocalTime hora;
    protected TipoPago tipoDePago;
    protected static int identificador = 100;

    public Servicio(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDePago = tipoDePago;
        //this.identificador = 100;
        identificador++;
    }

    public Ruta getRuta() {
        return ruta;
    }

    public void setRuta(Ruta ruta) {
        this.ruta = ruta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public TipoPago getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(TipoPago tipoDePago) {
        this.tipoDePago = tipoDePago;
    }

    public int getIdentificador() {
        return identificador;
    }

    public double calcularPrecio(TipoPago tipoDePago) {
        double precio = Math.random() * 10 + 1;
        if (TipoPago.EFECTIVO.equals(tipoDePago)) {
            return precio;
        } else {
            double pfinal = precio * 0.1 + precio;
            return pfinal;
        }
    }

    public ArrayList<Conductor> condDisp(ArrayList<Conductor> conductores) {
        ArrayList<Conductor> cDisponibles = new ArrayList<>();
        for (int i = 0; i < conductores.size(); i++) {
            if (conductores.get(i).getEstado().equals(TipoEstado.valueOf("DISPONIBLE"))) {
                cDisponibles.add(conductores.get(i));
            }
        }
        return cDisponibles;
    }

    public Conductor seleccionarCond(ArrayList<Conductor> conductores) {
        //Conductor conductor = new Conductor();
        return conductores.get(1);
    }
}
