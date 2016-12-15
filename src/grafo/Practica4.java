package grafo;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practica4 {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Trayectos t = new Trayectos();
        boolean salir = false;
        try {
            t.rellenarGrafo("trayectos.csv"); //P1
            do {
                System.out.println("\nElige una opcion:");
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
            }while(salir==false);
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        

}
}
