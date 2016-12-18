package Dominio;

import java.util.ArrayList;

public class Listado {

    private int Cantidad;
    private ArrayList ListaCompleta;

    public Listado(int Cantidad, ArrayList ListaCompleta) {
        this.Cantidad = Cantidad;
        this.ListaCompleta = ListaCompleta;
    }

    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public ArrayList getListaCompleta() {
        return this.ListaCompleta;
    }

    /**
     *
     * @param ListaCompleta
     */
    public void setListaCompleta(ArrayList ListaCompleta) {
        // TODO - implement Listado.setListaCompleta
        this.ListaCompleta = ListaCompleta;
    }
    public String toString(){
        String mensaje "-" +this.ListaCompleta;
    }

}
