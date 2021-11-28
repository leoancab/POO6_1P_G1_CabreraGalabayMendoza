/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuarios;

//import Restaurantes.Comida;
import Aplicacion.ManejoArchivos;
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
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private int num_tarjeta_credito;
    private int edad;
    private Conductor conductor;
    
    Scanner sc = new Scanner(System.in);

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
        System.out.println("/**********Servicios Solicitados**********/\n"
                         + "/*                                       */\n"
                         + "/*****************************************/\n");
        
        //Se recorre la lista de Servicios del cliente.
        for (Servicio s: servicios) {
            if (s instanceof ServicioTaxi) {
                ServicioTaxi otro_s = (ServicioTaxi) s;
                System.out.println("Tipo: Viaje\n"
                        + "Cantidad de pasajeros: " + otro_s.getNPasajeros() + "\n"
                        + "Fecha: " + otro_s.getFecha() + "\n"
                        + "Hora: " + otro_s.getHora() + "\n"
                        + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                        + "Hasta: " + otro_s.getRuta().getDestino()+ "\n");
            } else if (s instanceof ServicioEncomienda) { 
                ServicioEncomienda otro_s = (ServicioEncomienda) s;
                System.out.println("Tipo: Encomienda\n"
                        + "Tipo: " + otro_s.getTipoEncomienda()
                        + "Cantidad : " + otro_s.getCantProd() + "\n"
                        + "Fecha: " + otro_s.getFecha() + "\n"
                        + "Hora: " + otro_s.getHora() + "\n"
                        + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                        + "Hasta: " + otro_s.getRuta().getDestino()+ "\n");
            } else {
                ServicioDelivery otro_s = (ServicioDelivery) s;
                System.out.println("Tipo: Viaje\n"
                        + "Restaurante: " + otro_s.g + "\n"
                        + "Fecha: " + otro_s.getFecha() + "\n"
                        + "Hora: " + otro_s.getHora() + "\n"
                        + "Desde: " + otro_s.getRuta().getSalida() + "\n"
                        + "Hasta: " + otro_s.getRuta().getDestino()+ "\n");
            }
        }
        
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
        
        double valor_pagar = 0;
        Conductor conductor = null;
        if (confirmar.equals("si")) {
            //Se crea el servicio de taxi
            ServicioTaxi servicio_taxi = new ServicioTaxi(ruta, fecha, hora, tipo, cant_pasajeros);
            //Se agrega a el servicio a la lista de servicios del cliente.
            servicios.add(servicio_taxi);
            //Se obtiene a un condcutor disponible y con carro.
            conductor = servicio_taxi.seleccionarCond(conductores);
            
            
            if (tipo_pago.equals("2")) {
                valor_pagar = servicio_taxi.calcularPrecio(tipo);
                //return valor_pagar;
            } else { 
                valor_pagar = servicio_taxi.calcularPrecio(tipo);
                
            }
            
            //Se obtiene la información para escribir el archivo
            String informacion = servicio_taxi.getIdentificador() + "," +
                    nombre + "," + conductor.getNombre() + " " + ruta.getSalida() + "," + ruta.getDestino()
                    + ","  + fecha + "," + hora + "," + cant_pasajeros
                    + "," + tipo + valor_pagar;
            //Se genera el viajes.txt
            ManejoArchivos.EscribirArchivo("viajes.txt", informacion);
            
            //Se muestran los detalles del viaje
            System.out.println("ID: " + servicio_taxi.getIdentificador());
            System.out.println("Conductor: " + conductor);
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
            System.out.println("Cantidad de pasajeros: " + cant_pasajeros);
            
            //Retornar valor
            return valor_pagar;
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
        
        double valor_pagar = 0;
        if (confirmar.equals("si")) {
            //Se crea el servicio de encomienda.
            ServicioEncomienda serv_enc = new ServicioEncomienda(ruta, fecha, hora, tipo, enco, cant_prod);
            //Se agrega el servicio a la lita de servicios del cliente.
            servicios.add(serv_enc);
            //Se selecciona un conductor con moto.
            conductor = serv_enc.seleccionarCond(conductores);

            if (tipo_pago.equals("2")) {
                valor_pagar = serv_enc.calcularPrecio(tipo);
                //return valor_pagar;
            } else {
                valor_pagar = serv_enc.calcularPrecio(tipo);
            }
            
            //Se obtiene la información para escribir el archivo
            String informacion = serv_enc.getNServicio() + "," +
                    nombre + "," + conductor.getNombre() + " " + ruta.getSalida() + "," + ruta.getDestino()
                    + ","  + fecha + "," + hora + "," + enco + " " + cant_prod + " " + tipo + " " + valor_pagar;
            //Se genera el encomiendas.txt
            ManejoArchivos.EscribirArchivo("encomiendas.txt", informacion);
            
            //Se muestran los detalles del viaje
            System.out.println("ID: " + serv_enc.calcularPrecio(tipo));
            System.out.println("Conductor: " + conductor.getNombre());
            System.out.println("Tipo de Encomienda: " + enco);
            System.out.println("Cantidad de productos: " + cant_prod);
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
            
            //Se retorna el valor a pagar
            return valor_pagar;
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

            /*Agredar plato a la lista de platos pedidos por el cliente
            Se usa un for para comparar los platos y ver cual selecciono el
            cliente y ser agrado a su lista de platos*/
            for (Comida p : menu) {
                if (p.getNombre().equals(plato)) {
                    platos.add(p);
                }
            }

            //Preguntar si se continua agregando platos.
            System.out.println("Desea seguir agregando platos? (SI/NO)");
            ingreso = sc.nextLine().toUpperCase();
        } while (ingreso.equals("SI"));

        Pedido pedido = new Pedido(platos);

        System.out.println("Desea confirmar su pedido (SI/NO)");

        String confirmar = sc.nextLine().toLowerCase();
        
        double valor_pagar = 0;
        
        if (confirmar.equals("si")) {
            //Se crea el servicio de delivery
            ServicioDelivery serv_del = new ServicioDelivery(ruta, fecha, hora, tipo, pedido, platos.size(), restaurantes);
            //Se agrega el servicio delivery a la lista de servicios del cliente.
            servicios.add(serv_del);
            //Se seleccioan un conductor como moto.
            Conductor conductor = serv_del.seleccionarCond(conductores);
            
            if (tipo_pago.equals("2")) {
                valor_pagar = serv_del.calcularPrecio(tipo) + serv_del.calcPrecioPedido(platos);
                //return valor_pagar;
            } else {
                valor_pagar = serv_del.calcularPrecio(tipo) + serv_del.calcPrecioPedido(platos);
            }
            
            //Se obtiene la información para escribir el archivo
            String informacion = serv_del.getIdentificador() + "," +
                    nombre + "," + conductor.getNombre() + " " + ruta.getSalida() + "," + ruta.getDestino()
                    + ","  + fecha + "," + hora + "," + serv_del.getIdentificador() + " " + tipo + " " + valor_pagar;
            //Se genera el delivery.txt
            ManejoArchivos.EscribirArchivo("delivery.txt", informacion);
            
            /*Se genera el archivo de pedidos.
            Se recorre la lista de pedidos del cliente y se obtienen la
            informacion necesaria de cada plato.*/
            
            for (Comida p: pedido.getOpSeleccionadas()) {
                String info_pedido = serv_del.getIdentificador() + "," +
                    p.getNombre() + " " + p.getPrecio();
                ManejoArchivos.EscribirArchivo("delivery.txt", info_pedido);
            }
            
            
            
            //Se muestran los detalles del viaje
            System.out.println("ID: " + serv_del.getIdentificador());
            System.out.println("Conductor: " + conductor.getNombre());
            System.out.println("Restaurante: " + rest);
            System.out.println("Pedido: " + pedido);
            System.out.println("Punto de inicio: " + inicio);
            System.out.println("Punto de llegada: " + fin);
            System.out.println("Fecha: " + fecha);
            System.out.println("Hora: " + hora);
            
            //Se retorna el valor a pagar
            return valor_pagar;
        }
        return -1;
    }
}
