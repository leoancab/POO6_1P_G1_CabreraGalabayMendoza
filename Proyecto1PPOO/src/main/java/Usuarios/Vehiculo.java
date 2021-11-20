/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author leonel
 */
public class Vehiculo {

    private String placa;
    private String modelo;
    private String marca;
    private Vehiculo TipoVehiculo;

    public Vehiculo(String placa, String modelo, String marca, Vehiculo TipoVehiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.TipoVehiculo = TipoVehiculo;
    }
}
