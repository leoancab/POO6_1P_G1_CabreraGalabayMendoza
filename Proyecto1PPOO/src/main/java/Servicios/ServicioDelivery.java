package Servicios;

import java.util.ArrayList;
import Restaurantes.*;
import Usuarios.Conductor;
import Usuarios.Ruta;
import Usuarios.TipoPago;
import Usuarios.TipoVehiculo;
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
    private int nPlatos;
    private ArrayList<Restaurante> restaurantes;
    private Restaurante restaurante;

    public ServicioDelivery(Ruta ruta, LocalDate fecha, LocalTime hora, TipoPago tipoDePago,
            Pedido pedido, int nPlatos, ArrayList<Restaurante> restaurantes, Restaurante restaurante) {
        super(ruta, fecha, hora, tipoDePago);
        this.pedido = pedido;
        this.nPlatos = nPlatos;
        this.restaurantes = restaurantes;
        this.restaurante = restaurante;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
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

    public double calcPrecioPedido(ArrayList<Comida> platos) {
        double precio = 0.0;
        for (int i = 0; i < platos.size(); i++) {
            precio += platos.get(i).getPrecio();
        }
        return precio;
    }

    public Restaurante getRestaurante() {
        return restaurante;
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
