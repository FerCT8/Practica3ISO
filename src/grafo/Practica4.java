/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

import java.io.FileNotFoundException;

public class Practica4 {

    public static void main(String[] args) {
        Trayectos t = new Trayectos();
        try {
            t.rellenarGrafo("trayectos.csv"); //P1
            System.out.println("Estaciones: "+t.numeroEstaciones()); //P1
            System.out.println("Caminos: "+t.numeroCaminos());//P1
            t.conexiones();//P2
            t.pedirEstaciones();//P3
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

}
