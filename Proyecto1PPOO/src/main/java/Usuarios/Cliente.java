/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

//import Restaurantes.Comida;
import Servicios.*;
import Restaurantes.*;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author cgala
 */
public class Cliente extends Usuario {

    Scanner sc = new Scanner(System.in);
    private int num_tarjeta_credito;
    private int edad;
    private Conductor conductor;

    public Cliente(int num_tarjeta_credito, int edad, String num_cedula,
            String nombre, String apellido, String user, String contraseña, String cedula) {
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

    public String getNum_celular() {
        return num_celular;
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

    public void setNum_celular(String num_celular) {
        this.num_celular = num_celular;
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

    public double solicitarTaxi() {
        //Se pide ubicacion de origen
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

        if (tipo_pago.equals("1")) {
            tipo = TipoPago.EFECTIVO;
        } else {
            tipo = TipoPago.CREDITO;
        }

        System.out.println("Ingrese numero de personas:");
        int cant_pasajeros = sc.nextInt();
        sc.nextLine();

        Ruta ruta = new Ruta(inicio, fin);

        System.out.println("Desea confirmar su viaje? (SI/NO)");

        String confirmar = sc.nextLine().toLowerCase();

        if (confirmar.equals("si")) {
            ServicioTaxi servicio_taxi = new ServicioTaxi(ruta, fecha, hora, tipo, cant_pasajeros);

            if (tipo_pago.equals("2")) {
                double valor_pagar = servicio_taxi.calcularPrecio(tipo);
                return valor_pagar;
            }
            System.out.println("ID: " + Servicio.obtenerIdentificador());
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
            System.out.println("Cantidad de pasajeros: " + cant_pasajeros);

        }
        return -1;
    }

    public double solicitarEcomienda() {
        //Se pide ubicacion de origen
        System.out.println("Ingrese su ubicacion actual: ");
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

        if (tipo_pago.equals("1")) {
            tipo = TipoPago.EFECTIVO;
        } else {
            tipo = TipoPago.CREDITO;
        }

        System.out.println("Seleccione el tipo de encomienda (1 - 2 - 3):"
                + "1. Documento"
                + "2. Medicamento"
                + "3. Ropa");
        String tipo_enc = sc.nextLine();

        TipoEncomienda enco = null;

        switch (tipo_enc) {
            case "1":
                enco = TipoEncomienda.DOCUMENTO;
                break;
            case "2":
                enco = TipoEncomienda.MEDICAMENTO;
                break;
            default:
                enco = TipoEncomienda.ROPA;
                break;
        }

        System.out.println("Ingrese la cantidad del productos: ");
        int cant_prod = sc.nextInt();
        sc.nextLine();

        Ruta ruta = new Ruta(inicio, fin);

        System.out.println("Desea confirmar su viaje? (SI/NO)");

        String confirmar = sc.nextLine().toLowerCase();

        if (confirmar.equals("si")) {
            ServicioEncomienda serv_enc = new ServicioEncomienda(ruta, fecha, hora, tipo, Servicio.obtenerIdentificador(), enco, cant_prod);

            if (tipo_pago.equals("2")) {
                double valor_pagar = serv_enc.calcularPrecio(tipo);
                return valor_pagar;
            }
            System.out.println("ID: " + Servicio.obtenerIdentificador());
            System.out.println("Tipo de Encomienda: " + enco);
            System.out.println("Cantidad de productos: " + cant_prod);
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
        }
        return -1;
    }

    public double solicitarDelivery(ArrayList<Restaurante> restaurantes) {
        //Lista de platos pedidos
        ArrayList<Comida> platos = new ArrayList<>();

        //Se pide ubicacion de origen
        System.out.println("Ingrese su ubicacion actual: ");
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

        if (tipo_pago.equals("1")) {
            tipo = TipoPago.EFECTIVO;
        } else {
            tipo = TipoPago.CREDITO;
        }

        Ruta ruta = new Ruta(inicio, fin);

        System.out.println("Restaurantes disponibles: ");
        for (int i = 0; i < restaurantes.size(); i++) {
            System.out.println(restaurantes.get(i).getNombre());
        }

        System.out.println("Ingrese nombre de restaurante a elegir: ");
        String rest = sc.nextLine();

        /*Mostrar menu del restaurante
        Se recorre la lista y se comparan los nobres de cada restaurante,
        tambien se obtiene y se muestra el menu.
         */
        ArrayList<Comida> menu = new ArrayList<>();
        for (int i = 0; i < restaurantes.size(); i++) {
            if (restaurantes.get(i).getNombre().equals(rest)) {
                menu = restaurantes.get(i).getMenu();
                System.out.println(menu);
            }
        }

        System.out.println("Ingrese nombre de plato a elegir: ");
        String plato = sc.nextLine();

        String ingreso = "SI";
        do {
            System.out.println("Ingrese nombre de plato a elegir: ");
            plato = sc.nextLine().toUpperCase();

            //Agredar plato a la lista de platos pedidos por el cliente.
            for (Comida p : menu) {
                if (p.getNombre().equals(plato)) {
                    platos.add(p);
                }
            }

            //Preguntar si se continua agregando mas platos.
            System.out.println("Desea seguir agregando platos? (SI/NO)");
            ingreso = sc.nextLine().toUpperCase();
        } while (ingreso.equals("SI"));

        Pedido pedido = new Pedido(platos);

        System.out.println("Desea confirmar su viaje? (SI/NO)");

        String confirmar = sc.nextLine().toLowerCase();

        if (confirmar.equals("si")) {
            ServicioDelivery serv_del = new ServicioDelivery(ruta, fecha, hora, tipo, pedido, platos.size(), restaurantes);

            if (tipo_pago.equals("2")) {
                double valor_pagar = serv_del.calcularPrecio(tipo) + serv_del.calcPrecioPedido(platos);
                return valor_pagar;
            }
            System.out.println("ID: " + Servicio.obtenerIdentificador());
            System.out.println("Restaurante: " + rest);
            System.out.println("Pedido: " + pedido);
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
        }
        return -1;
    }
}
