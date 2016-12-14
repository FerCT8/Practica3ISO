/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import graphsDSESIUCLM.Element;

public class AristaDecorada<T> implements Element {
    
    private String id;
    private int duracionTiempo;
    
    public AristaDecorada(String id, int duracion){
        this.id = id;
        
        this.duracionTiempo=duracion;
    }

    public int getDuracion() {
        return duracionTiempo;
    }

    public void setDuracion(int duracion) {
        this.duracionTiempo = duracion;
    }
    
    @Override
    public String getID() {
        return id;
    }

    @Override
    public String toString() {
        return "AristaDecorada{" + "id=" + id + ", duracionTiempo=" + duracionTiempo + '}';
    }

    
    
}
