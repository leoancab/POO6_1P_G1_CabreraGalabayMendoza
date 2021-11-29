/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
import Servicios.Servicio;
import Servicios.*;
import java.util.Scanner;

/**
 *
 * @author cgala
 */
public class Conductor extends Usuario {
    private Servicio serv_asginado;
    private int num_lic;
    private TipoEstado estado;
    private Vehiculo vehiculo;
    
    Scanner sc = new Scanner(System.in);

    public Conductor(int num_lic, TipoEstado estado, Vehiculo vehiculo,
            String num_cedula, String nombre, String apellido, String user, String contraseña, String celular, TipoUsuario TipoUsuario) {
        super(num_cedula, nombre, apellido, user, contraseña, celular, TipoUsuario);
        this.num_lic = num_lic;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }

    //Getters
    public int getNum_lic() {
        return num_lic;
    }

    public TipoEstado getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    //Setters
    public void setNum_lic(int num_lic) {
        this.num_lic = num_lic;
    }

    public void setEstado(TipoEstado estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

//    public Servicio getServ_asginados() {
//        return serv_asginado;
//    }

    public void setServ_asginado(Servicio serv_asginado) {
        this.serv_asginado = serv_asginado;
    }
    
    
    
    

    //Metodos
    @Override
    public void consultarServicio() {
        System.out.println("/**************Menu Conductor**************/\n"
                         + "/*                                        */\n"
                         + "/******************************************/\n");
        System.out.println("1. Consultar Servicios Asignados");
        System.out.println("Eliga una opcion: ");
        String opcion = sc.nextLine();
        
        if (opcion.equals("1")) { 
            System.out.println("/***********Servicios Asignados***********/\n"
                             + "/*                                       */\n"
                             + "/*****************************************/\n");
            
            if (serv_asginado instanceof ServicioTaxi) {
                ServicioTaxi otro_s = (ServicioTaxi) serv_asginado;
                    System.out.println("Uted tiene asignado el servicio de taxi\n"
                            + "Cantidad de pasajeros: " + otro_s.getNPasajeros() + "\n"
                            + "Fecha: " + otro_s.getFecha() + "\n"
                            + "Hora: " + otro_s.getHora() + "\n"
                            + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                            + "Hasta: " + otro_s.getRuta().getDestino() + "\n"
                            + "Dirigase al sitio a recoger al cliente.");
            }else if (serv_asginado instanceof ServicioEncomienda) {
                    ServicioEncomienda otro_s = (ServicioEncomienda) serv_asginado;
                    System.out.println("Uted tiene asignado el servicio de encomienda\n"
                            + "Tipo: " + otro_s.getTipoEncomienda()
                            + "Cantidad : " + otro_s.getCantProd() + "\n"
                            + "Fecha: " + otro_s.getFecha() + "\n"
                            + "Hora: " + otro_s.getHora() + "\n"
                            + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                            + "Hasta: " + otro_s.getRuta().getDestino() + "\n"
                            + "Dirigase al sitio a recoger el pedido.");
                } else if (serv_asginado instanceof ServicioDelivery){
                    ServicioDelivery otro_s = (ServicioDelivery) serv_asginado;
                    System.out.println("(\"Uted tiene asignado el servicio Delivery de comida\n"
                            + "Restaurante: " + otro_s.getRestaurante() + "\n"
                            + "Pedido: " + otro_s.getPedido() + "\n"
                            + "Fecha: " + otro_s.getFecha() + "\n"
                            + "Hora: " + otro_s.getHora() + "\n"
                            + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                            + "Hasta: " + otro_s.getRuta().getDestino() + "\n"
                            + "Dirigase al sitio a recoger el pedido.");
                }
            
            
        } else {
            System.out.println("No cuenta con servicios asignados");
        }
        
    }

    @Override
    public String toString() {
        return contraseña + "," + num_lic + "," + estado + "," + vehiculo.getPlaca();
    }
    
    
}
