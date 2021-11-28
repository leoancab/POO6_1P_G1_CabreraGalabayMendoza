package Servicios;

import Usuarios.Ruta;
import Usuarios.Conductor;
import Usuarios.Conductor;
import Usuarios.TipoPago;
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
public class ServicioTaxi extends Servicio {

    private int nPasajeros;

    public ServicioTaxi(Ruta ruta, LocalDate fecha, LocalTime hora,
            TipoPago tipoDePago, int nPasajeros) {
        super(ruta, fecha, hora, tipoDePago);
        this.nPasajeros = nPasajeros;
    }

    public int getNPasajeros() {
        return nPasajeros;
    }

    public void setRuta(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    @Override
    public Conductor seleccionarCond(ArrayList<Conductor> conductores) {
        ArrayList<Conductor> cDisp = condDisp(conductores);
        for (int i = 0; i < cDisp.size(); i++) {
            if (cDisp.get(i).getVehiculo().equals(TipoVehiculo.AUTO)) {
                return cDisp.get(i);
            }
        }
        return null;
    }
    }
    
}
