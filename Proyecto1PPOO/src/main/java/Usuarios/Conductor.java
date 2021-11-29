/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

/**
 *
 * @author cgala
 */
public class Conductor extends Usuario {

    private int num_lic;
    private TipoEstado estado;
    private Vehiculo vehiculo;

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

    //Metodos
    @Override
    public void consultarServicio() {
        //Code here.
    }
}
