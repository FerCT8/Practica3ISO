/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Trayectos {

    private TreeMapGraph<ElementoDecorado, ElementoDecorado> grafo;

    public Trayectos() {
        grafo = new TreeMapGraph<>();
    }

    public void rellenarGrafo(String file) throws FileNotFoundException {

        Scanner sn = new Scanner(new File(file));
        sn.useDelimiter(",");
        String dato;

        String estacion_origen="";
        String estacion_destino="";
        float lat_estacion_origen=0;
        float lon_estacion_origen=0;
        float lat_estacion_destino=0;
        float lon_estacion_destino=0;
        int duracion=0;
        Estacion origen=null;
        Estacion destino=null;
        ElementoDecorado eo;
        ElementoDecorado ed;

        int columna = 0;
        boolean registroCompleto = false;
        sn.nextLine();
        while (sn.hasNext()) {

            dato = sn.next();

            switch (columna) {
                case 1:
                    duracion = Integer.parseInt(dato);
                    break;
                case 4:
                    estacion_origen = dato;
                    break;
                case 5:
                    lat_estacion_origen = Float.parseFloat(dato);
                    break;
                case 6:
                    lon_estacion_origen= Float.parseFloat(dato);
                    break;
                case 7:
                    estacion_destino= dato;
                    break;
                case 8:
                    lat_estacion_destino = Float.parseFloat(dato);
                    break;
                case 9:
                    lon_estacion_destino= Float.parseFloat(dato);
                    break;
                case 13:
                    registroCompleto=true;
                    break;
            }

            columna++;

            if (registroCompleto) {
                if (duracion <= 300 && !estacion_origen.equals(estacion_destino)) {

                    //creamos las estaciones
                    origen = new Estacion(estacion_origen, lat_estacion_origen, lon_estacion_origen);
                    destino = new Estacion(estacion_destino, lat_estacion_destino, lon_estacion_destino);

                    //Creamos las estaciones decoradas
                    eo = new ElementoDecorado(estacion_origen, origen);
                    ed = new ElementoDecorado(estacion_destino, destino);

                    //Creamos los vertices
                    Vertex<ElementoDecorado> v_origen = grafo.insertVertex(eo);
                    Vertex<ElementoDecorado> v_destino = grafo.insertVertex(ed);

                    if (!grafo.areAdjacent(v_origen, v_destino)) {
                        ElementoDecorado de = new ElementoDecorado(String.valueOf(eo.getID() + "-" + ed.getID()), duracion);
                        grafo.insertEdge(v_origen, v_destino, de);
                    }

                }

                registroCompleto = false;
                columna=1;
            }

        }

    }

    public int numeroEstaciones() {
        return grafo.getN();
    }

    public int numeroCaminos() {
        return grafo.getM();
    }

    public void conexiones() {

        Iterator<Vertex<ElementoDecorado>> vertices = grafo.getVertices();
        Iterator<Edge<ElementoDecorado>> aristas;

        Vertex<ElementoDecorado> vertice;
        Vertex<ElementoDecorado> verticeOpuesto;
        Edge<ElementoDecorado> arista;

        while (vertices.hasNext()) {

            vertice = vertices.next();

            System.out.println( vertice.getElement());
           
            aristas = grafo.incidentEdges(vertice);
            while (aristas.hasNext()) {
                arista = aristas.next();

                verticeOpuesto = grafo.opposite(vertice, arista);

                System.out.println("                " + verticeOpuesto.getElement() + "  ");

            }
        }

    }

    private Vertex<ElementoDecorado>[] pedirEstaciones() {

        Scanner datos = new Scanner(System.in);

        String id_origen, id_destino;

        System.out.println("\nEscribe el id de la estacion de origen");
        id_origen = datos.next();

        System.out.println("Escribe el id de la estacion de destino");
        id_destino = datos.next();

        if (grafo.getVertex(id_origen) != null && grafo.getVertex(id_destino) != null && !id_origen.equals(id_destino)) {
            Vertex<ElementoDecorado>[] estaciones = new Vertex[2];
            estaciones[0] = grafo.getVertex(id_origen);
            estaciones[1] = grafo.getVertex(id_destino);
            return estaciones;
        }

        return null;

    }

    public void busqueda() {

        Vertex<ElementoDecorado>[] estaciones = pedirEstaciones();

        if (estaciones == null) {
            System.out.println("\nError, introduce estaciones que existan y que no sean iguales");
            busqueda();
        } else {
            
            Stack<Edge> camino = new Stack<>();
            ShortPath(estaciones[0], estaciones[1], camino);
            System.out.println("\nCamino mas corto");
            while (!camino.isEmpty()) {
                //El orden de los vertices no es importante, se crea de menor a mayor
                Vertex[] v = grafo.endVertices(camino.pop());
                System.out.print("-ID_origen: "+v[0].getID());
                System.out.print("-ID_destino: "+v[1].getID());
                System.out.println("");
            }

        }

    }

    
    public boolean ShortPath(Vertex<ElementoDecorado> v, Vertex<ElementoDecorado> z, Stack<Edge> camino) {

        boolean noEnd = !v.equals(z);
        Edge e;
        Iterator<Edge<ElementoDecorado>> it;
        Vertex<ElementoDecorado> w;

        v.getElement().setVisitado(true);

        it = grafo.incidentEdges(v);
        while (it.hasNext() && noEnd) {
            e = it.next();
            w = grafo.opposite(v, e);
            if (!w.getElement().isVisitado()) {
                camino.push(e);
                noEnd = ShortPath(w, z, camino);
                if (noEnd) {
                    camino.pop();
                }
            }
        }

        return noEnd;
    }

}
