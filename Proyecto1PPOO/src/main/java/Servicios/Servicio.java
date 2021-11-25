package Servicios;

import Usuarios.Ruta;
import Usuarios.TipoPago;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Marti
 */
public class Servicio {

    protected Ruta ruta;
    protected LocalDate fecha;
    protected LocalTime hora;
    protected TipoPago tipoDePago;
    protected int identificador;

    public Servicio(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago, int identificador) {
        this.ruta = ruta;
        this.fecha = fecha;
        this.hora = hora;
        this.tipoDePago = tipoDePago;
        this.identificador = identificador;
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

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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
}
