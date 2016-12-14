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
    
    public ElementoDecorado(String id, T estacion){
        this.id=id;
        this.estacion=estacion;
        visitado=false;
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
    
    public String toString(){
        return estacion.toString();
    }
    
    
}
