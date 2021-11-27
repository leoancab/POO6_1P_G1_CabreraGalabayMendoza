/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

import Servicios.Servicio;

/**
 *
 * @author leonel
 */
public class Pago {

    private Cliente cliente;
    private Servicio servicio;

    public Pago(Cliente cliente, Servicio servicio) {
        this.cliente = cliente;
        this.servicio = servicio;
    }
}
