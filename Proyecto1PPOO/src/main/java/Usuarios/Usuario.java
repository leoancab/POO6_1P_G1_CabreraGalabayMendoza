/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

import java.util.ArrayList;

/**
 *
 * @author cgala
 */
public class Usuario {

    protected String num_cedula;
    protected String nombre;
    protected String apellido;
    protected String user;
    protected String contraseña;
    protected String celular;
    protected TipoUsuario tipoUsuario;

    public Usuario(String num_cedula, String nombre, String apellido, String user, String contraseña, String celular, TipoUsuario tipoUsuario) {
        this.num_cedula = num_cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.contraseña = contraseña;
        this.celular = celular;
        this.tipoUsuario = tipoUsuario;
    }

    public String getNum_cedula() {
        return num_cedula;
    }

    public void setNum_cedula(String num_cedula) {
        this.num_cedula = num_cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public static Usuario obtenerUsuario(String usuario) {
        String[] partes = usuario.split(",");
        String cedula = partes[0];
        String nombre = partes[1];
        String apellido = partes[2];
        String user = partes[3];
        String contraseña = partes[4];
        String celular = partes[5];
        TipoUsuario tipoUsuario = TipoUsuario.valueOf(partes[6]);
        Usuario nUsuario = new Usuario(cedula, nombre, apellido, user, contraseña, celular, tipoUsuario);
        return nUsuario;
    }

    protected void consultarServicio() {
        System.out.println("Consultando Servicios");
    }

    @Override
    public String toString() {
        return num_cedula + "," + nombre + "," + apellido + "," + user + "," + contraseña + "," + celular + "," + tipoUsuario;
    }

}
