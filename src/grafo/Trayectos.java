/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import graphsDSESIUCLM.Edge;
import graphsDSESIUCLM.Graph;
import graphsDSESIUCLM.TreeMapGraph;
import graphsDSESIUCLM.Vertex;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
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
        Estacion origen;
        Estacion destino;
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
                        grafo.insertEdge(v_origen, v_destino);
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

    public void pedirEstaciones() {
        
        ElementoDecorado startNode, endNode, nx, node = null;
        Iterator<Vertex<ElementoDecorado>> it;
        Stack <ElementoDecorado> sp = new Stack();
        Vertex<ElementoDecorado> aux, s = null, t = null;
        int size;
        boolean bool1 = true, bool2 = true;
        Scanner datos = new Scanner(System.in);

        String id_origen, id_destino;

        System.out.println("\nEscribe el id de la estacion de origen");
        id_origen = datos.next();

        System.out.println("Escribe el id de la estacion de destino");
        id_destino = datos.next();

        if (grafo.getVertex(id_origen) != null && grafo.getVertex(id_destino) != null && !id_origen.equals(id_destino)) {
        startNode=grafo.getVertex(id_origen).getElement();
        endNode=grafo.getVertex(id_destino).getElement();
        it = grafo.getVertices();
            while (it.hasNext() && (bool1 || bool2)) {
              aux = it.next();
              nx = aux.getElement();
              if (nx.equals(startNode)) {
               s = aux;
               bool1 = false;
              }
              if (nx.equals(endNode)) {
                t = aux;
                bool2 = false;
              }
            }
        }
            if (!(bool1 || bool2)) {
              node = pathBFS(grafo, s, t);

              if (node.getParent() == null) {
                System.out.println("\nNo hya camino entre estas dos estaciones");
              } else {
                System.out.println("\nCamino más corto ");
                while (node.getParent() != null) {
                  sp.push(node);
                  node = node.getParent();
                }
                sp.push(node);

                size = sp.size();
                for (int i = 0; i<size-1; i++){
                  node = sp.pop();
                  System.out.print(node.getEstacion().toString() + "("
                              + node.getDuracion() + ")" + "-");
                }
                node = sp.pop();
                System.out.print(node.getEstacion().toString() + "("
                              + node.getDuracion() + ")");
              }
            }
            else {
              System.out.println("\nUno de las dos estaciones escritas no esta en el grafo");
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
    public static ElementoDecorado pathBFS(Graph g,Vertex<ElementoDecorado> s,Vertex<ElementoDecorado> t) {
        Queue<Vertex<ElementoDecorado>> q = new LinkedList();
        boolean noEnd = true;
        Vertex<ElementoDecorado> u, v = null;
        Edge e;
        Iterator<Edge> it;

        s.getElement().setVisitado(true);
        q.offer(s);
        while (!q.isEmpty() && noEnd) {
          u = q.poll();
          it = g.incidentEdges(u);
          while (it.hasNext() && noEnd) {
            e = it.next();
            v = g.opposite(u, e);
            if (!(v.getElement()).isVisitado()) {
              (v.getElement()).setVisitado(true);
              (v.getElement()).setParent(u.getElement());
              (v.getElement()).setDuracion(((u.getElement()).getDuracion()) + 1);
              q.offer(v);
              noEnd = !(v.getElement().equals(t.getElement()));
            }
          }
        }
        if (noEnd)
          v.getElement().setParent(null);
        return v.getElement();
      }

}
