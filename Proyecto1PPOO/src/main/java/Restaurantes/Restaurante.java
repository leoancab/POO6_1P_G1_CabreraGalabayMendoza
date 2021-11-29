package Restaurantes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;

/**
 *
 * @author Marti
 */
public class Restaurante {

    private int cod;
    private String nombre;
    private ArrayList<Comida> menu;
    

    public Restaurante(int cod, String nombre, ArrayList<Comida> menu) {
        this.cod = cod;
        this.nombre = nombre;
        this.menu = menu;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Comida> getMenu() {
        return menu;
    }

    public void setMenu(ArrayList<Comida> menu) {
        this.menu = menu;
    }
}
