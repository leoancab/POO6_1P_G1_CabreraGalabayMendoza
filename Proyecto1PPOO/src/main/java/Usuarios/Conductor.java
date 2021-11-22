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
public class Conductor extends Usuario{
    private int num_lic;
    private Estado estado;
    private Vehiculo vehiculo;

    public Conductor(int num_lic, Estado estado, Vehiculo vehiculo, String num_cedula, String nombre, String apellido, String user, String contraseña, String cedula) {
        super(num_cedula, nombre, apellido, user, contraseña, cedula);
        this.num_lic = num_lic;
        this.estado = estado;
        this.vehiculo = vehiculo;
    }
           
    //Getters
    public int getNum_lic() {
        return num_lic;
    }

    public Estado getEstado() {
        return estado;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public String getNum_cedula() {
        return num_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUser() {
        return user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getCedula() {
        return cedula;
    }
    
    //Setters
    public void setNum_lic(int num_lic) {
        this.num_lic = num_lic;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void setNum_cedula(String num_cedula) {
        this.num_cedula = num_cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    //Metodos
    @Override
    public void consultarServicio() {
        //Code here.
    }
    
}
