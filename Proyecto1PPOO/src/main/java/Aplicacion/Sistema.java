package Aplicacion;

//import Aplicacion.ManejoArchivos;
import Usuarios.*;
import java.util.Scanner;
//import java.io.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author cgala
 */
public class Sistema {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> users = new ArrayList<>();
        ArrayList<String> contraseñas = new ArrayList<>();
        ArrayList<TipoUsuario> tipoUsuarios = new ArrayList<>();

        ManejoArchivos.LeeFichero("usuarios.txt");
        ManejoArchivos.LeeFichero("clientes.txt");

        String usuario1 = ManejoArchivos.LeeFichero("usuarios.txt").get(1);
        String usuario2 = ManejoArchivos.LeeFichero("usuarios.txt").get(2);
        String usuario3 = ManejoArchivos.LeeFichero("usuarios.txt").get(3);

        Usuario u1 = Usuario.obtenerUsuario(usuario1);
        Usuario u2 = Usuario.obtenerUsuario(usuario2);
        Usuario u3 = Usuario.obtenerUsuario(usuario3);
        
        usuarios.add(u1);
        usuarios.add(u2);
        usuarios.add(u3);

        users.add(u1.getUser());
        users.add(u2.getUser());
        users.add(u3.getUser());

        contraseñas.add(u1.getContraseña());
        contraseñas.add(u2.getContraseña());
        contraseñas.add(u3.getContraseña());

        tipoUsuarios.add(u1.getTipoUsuario());
        tipoUsuarios.add(u2.getTipoUsuario());
        tipoUsuarios.add(u3.getTipoUsuario());

        Scanner sc = new Scanner(System.in);
        System.out.println("+++++++++++++++++++++++++++++++++++++\n");
        System.out.println("\tBIENVENIDO AL SISTEMA\n");
        System.out.println("+++++++++++++++++++++++++++++++++++++\n");

        String usuario = "";
        String contraseña = "";

        do {
            System.out.println("USUARIO: ");
            usuario = sc.nextLine();

            System.out.println("CONTRASEÑA: ");
            contraseña = sc.nextLine();

        } while (!users.contains(usuario) || !contraseñas.contains(contraseña));

        for (int i = 0; i < tipoUsuarios.size(); i++) {
            if (tipoUsuarios.get(i).equals(TipoUsuario.C)) {
                if (!clientes.get(i).getUser().equals(users.get(i))){
                    System.out.println("Ingrese edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingrese tarjeta de credito: ");
                    String tarjetaCredito = sc.nextLine();
                    ManejoArchivos.EscribirArchivo("clientes.txt",usuarios.get(i).getNum_cedula()+","+edad+","+tarjetaCredito);
                }
            }
        }
        
        System.out.println("/*****MENU*****/"
                        +"\n/*                              *"
                        +"\n/************/");
        System.out.println("1. Solicitar servicio de taxi\n"
                         + "2. Solicitar comida a domicilio\n"
                         + "3. Solicitar entrega encomienda\n"
                         + "4. Consultar Servicios");
        System.out.println("Ingrese una opcion: ");
        String opcion = sc.nextLine();
        switch(opcion){
            case "1":
                cliente.servicioTaxi();
                break;
            case "2":
                cliente.servicioDelivery();
                break;
            case "3":
                cliente.servicioEncomienda();
                break;
            case "4":
                cliente.consultarServicio();
        }

    }

}