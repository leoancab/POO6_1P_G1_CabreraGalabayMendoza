/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;
import Servicios.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author cgala
 */
public class Cliente extends Usuario{
    Scanner sc = new Scanner(System.in);
    private int num_tarjeta_credito;
    private int edad;
    

    public Cliente(int num_tarjeta_credito, int edad, String num_cedula, String nombre, String apellido, String user, String contraseña, String cedula) {
        super(num_cedula, nombre, apellido, user, contraseña, cedula);
        this.num_tarjeta_credito = num_tarjeta_credito;
        this.edad = edad;
    }
    
    //Getters
    public int getNum_tarjeta_credito() {
        return num_tarjeta_credito;
    }

    public int getEdad() {
        return edad;
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
    public void setNum_tarjeta_credito(int num_tarjeta_credito) {
        this.num_tarjeta_credito = num_tarjeta_credito;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
        
    }
    
    public void solicitarTaxi() {
        System.out.println("Ingrese su ubicacion actual:");
        String inicio = sc.nextLine();
        
        System.out.println("Ingrese su destino:");
        String fin = sc.nextLine();
        
        LocalDate fecha = LocalDate.now();
        System.out.println("Fecha actual: " + fecha);
        
        LocalTime hora = LocalTime.now();
        System.out.println("Hora del viaje: " + hora);
        
        
        System.out.println("Seleccione el tipo de pago (1 - 2):"
                         + "1. Efectivo"
                         + "2. Tarjeta de credito");
        String tipo_pago = sc.nextLine();
        
        TipoPago tipo = null;
        
        if (tipo_pago.equals("1")){
            tipo = TipoPago.EFECTIVO;
        } else {
            tipo = TipoPago.CREDITO;
        }
        
        System.out.println("Ingrese numero de personas:");
        int cant_pasajeros = sc.nextInt();
        sc.nextLine();
        
        Ruta ruta = new Ruta(inicio, fin);
        
        System.out.println("Desea confirmar su viaje? (SI/NO)");
        
        String confrimar  = sc.nextLine().toLowerCase();
        
        ServicioTaxi servicio_taxi = new ServicioTaxi(ruta, fecha, hora, tipo, 10202, cant_pasajeros);

    }
    
    public void solicitarEcomienda() {
        //Code here.
    }
    
    public void solicitarDelivery() {
        //Code here.
    }
    
}
