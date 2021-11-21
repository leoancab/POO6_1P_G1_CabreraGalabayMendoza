/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marti
 */
public class ServicioTaxi extends Servicio{
    private int nPasajeros;
    
    public Servicio(Ruta ruta, Date fecha,Hour hora, String tipoDePago,int identificador, int nPasajeros){
        super(ruta,fecha,hora,tipoDePago,identificador);
        this.nPasajeros = nPasajeros;
    }
    
     public int getNPasajeros() {
        return nPasajeros;
    }

    public void setRuta(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    
    
    
}
