package Servicios;

import Restaurantes.Pedido;
import Usuarios.Ruta;
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
public class ServicioDelivery extends Servicio {

    private Pedido pedido;
<<<<<<< HEAD
    private int nPlatos;
    
    public ServicioDelivery(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago,
            int identificador, Pedido pedido, int nPlatos){
    super(ruta,fecha,hora,tipoDePago,identificador);
    this.pedido = pedido;
    this.nPlatos = nPlatos;
=======
    private String nPlatos;

    public ServicioDelivery(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago, int identificador, int nPasajeros, Pedido pedido, String nPlatos) {
        super(ruta, fecha, hora, tipoDePago, identificador);
        this.pedido = pedido;
        this.nPlatos = nPlatos;
>>>>>>> b0273cf91c67e151af6684d725baaa5a08e560d1
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
<<<<<<< HEAD
    
    public int getNPlatos() {
=======

    public String getNPlatos() {
>>>>>>> b0273cf91c67e151af6684d725baaa5a08e560d1
        return nPlatos;
    }

    public void setNPlatos(int nPlatos) {
        this.nPlatos = nPlatos;
    }
}
