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
public class Pedido {

    private ArrayList<Comida> opSeleccionadas;

    public Pedido(ArrayList<Comida> opSeleccionadas) {
        this.opSeleccionadas = opSeleccionadas;
    }

    public ArrayList<Comida> getOpSeleccionadas() {
        return opSeleccionadas;
    }

    public void setOpSeleccionadas(ArrayList<Comida> opSeleccionadas) {
        this.opSeleccionadas = opSeleccionadas;
    }
}
