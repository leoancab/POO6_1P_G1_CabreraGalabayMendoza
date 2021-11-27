package Servicios;

import Usuarios.Ruta;
<<<<<<< HEAD
<<<<<<< HEAD:Proyecto1PPOO/src/main/java/Servicios/ServicioTaxi.java
import Usuarios.Conductor;
=======
>>>>>>> b2234bbbe9a038e34a270786c9047bdc1dc62eae:Proyecto1PPOO/src/main/java/ServicioTaxi.java
=======
import Usuarios.Conductor;
>>>>>>> b0273cf91c67e151af6684d725baaa5a08e560d1
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
public class ServicioTaxi extends Servicio {

    private int nPasajeros;

    public ServicioTaxi(Ruta ruta, LocalDate fecha, LocalTime hora, 
            TipoPago tipoDePago, int identificador, int nPasajeros) {
        super(ruta, fecha, hora, tipoDePago, identificador);
        this.nPasajeros = nPasajeros;
    }

    public int getNPasajeros() {
        return nPasajeros;
    }

    public void setRuta(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    public Conductor seleccionarConductor() {

    }
}
