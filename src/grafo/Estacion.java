/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;


public class Estacion {
    
    private String ID;
    private float latitud;
    private float longitud;

    public Estacion(String ID, float latitud, float longitud) {
        this.ID = ID;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "ID=" + ID + ", latitud=" + latitud + ", longitud=" + longitud ;
    }
    
}
