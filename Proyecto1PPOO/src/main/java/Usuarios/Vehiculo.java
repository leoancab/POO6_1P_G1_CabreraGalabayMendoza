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

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Vehiculo getTipoVehiculo() {
        return TipoVehiculo;
    }

    public void setTipoVehiculo(Vehiculo TipoVehiculo) {
        this.TipoVehiculo = TipoVehiculo;
    }
    
}
