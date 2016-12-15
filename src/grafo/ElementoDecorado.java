/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import graphsDSESIUCLM.Element;

public class ElementoDecorado<T> implements Element {

   private String id;
    private T estacion;
    private boolean visitado;
    private int duracionTiempo;
    private ElementoDecorado<T> parent;
    
    public ElementoDecorado(String id, T estacion){
        this.id=id;
        this.estacion=estacion;
        visitado=false;
        parent = null;
        duracionTiempo = 0;
    }
    
    @Override
    public String getID() {
        return id;
    }

    public T getEstacion() {
        return estacion;
    }

    public void setEstacion(T estacion) {
        this.estacion = estacion;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
    public ElementoDecorado<T> getParent() {
        return parent;
      }
    public void setParent(ElementoDecorado<T> u) {
      parent = u;
    }
    
    public int getDuracion() {
        return duracionTiempo;
    }

    public void setDuracion(int duracion) {
        this.duracionTiempo = duracion;
    }
    public boolean equals (Object n) {
        return (id.equals(((ElementoDecorado) n).getID())
        && estacion.equals(((ElementoDecorado<T>) n).getEstacion()));
    }
    @Override
    public String toString(){
        return estacion.toString();
    }

}
