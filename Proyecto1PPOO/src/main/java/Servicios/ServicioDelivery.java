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
public class ServicioDelivery extends Servicio{
    
    private Pedido pedido;
    private int nPlatos;
    
    public ServicioDelivery(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago,
            int identificador, Pedido pedido, int nPlatos){
    super(ruta,fecha,hora,tipoDePago,identificador);
    this.pedido = pedido;
    this.nPlatos = nPlatos;
    }
    
     public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    public int getNPlatos() {
        return nPlatos;
    }

    public void setNPlatos(int nPlatos) {
        this.nPlatos = nPlatos;
    }
    
}
