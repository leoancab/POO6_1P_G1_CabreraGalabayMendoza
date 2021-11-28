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
public abstract class Usuario {

    protected String num_celular;
    protected String nombre;
    protected String apellido;
    protected String user;
    protected String contraseña;
    protected String cedula;

    public Usuario(String num_celular, String nombre, String apellido, String user, String contraseña, String cedula) {
        this.num_celular = num_celular;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.cedula = cedula;
    }

    protected abstract void consultarServicio();

}
