/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author leonel
 */
public class Pago extends Cliente {

    private Cliente cliente;
    private Servicio servicio;

    public Pago(int numTarjetaCredito, int edad, Cliente cliente, Servicio servicio) {
        super(numTarjetaCredito, edad);
        this.cliente = cliente;
        this.servicio = servicio;
    }

}
