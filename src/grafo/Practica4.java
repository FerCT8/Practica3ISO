/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package grafo;

import java.io.FileNotFoundException;
import java.util.*;

public class Practica4 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Trayectos t = new Trayectos();
        boolean salir = false;
        do {
        try {
            t.rellenarGrafo("trayectos.csv"); //P1
            System.out.println("Elige una opcion:");
            System.out.println("1: Muestra estaciones\n"+ "2: Muestra caminos\n"+"3: Muestra el camino mas corto entre dos estaciones\n"+"4: Salir del programa");
            int menu=leer.nextInt();
            switch(menu){
                case 1:
            
            System.out.println("Estaciones: "+t.numeroEstaciones()); //P1
                 break;
                case 2:
                    
            System.out.println("Caminos: "+t.numeroCaminos());//P1
            break;
                case 3:
                  
            t.conexiones();//P2
            t.pedirEstaciones();//P3
            break;
                case 4:
                salir = true;
                System.out.println ("El programa ha finalizado");
                break;             
                default:
                    System.out.println("Vuelve a marcar una opcion");
                    break;
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        }while(salir==false);

}
}
