package Aplicacion;
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
        ManejoArchivos.LeeFichero("usuarios.txt");
        ManejoArchivos.LeeFichero("archivo.txt");
    }

}
