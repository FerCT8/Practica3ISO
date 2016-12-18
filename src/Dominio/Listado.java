package Dominio;

import java.util.ArrayList;

public class Listado {

	private int Fecha;
	private int Cantidad;
	private ArrayList ListaCompleta;

	public int getCantidad() {
		return this.Cantidad;
	}

	public void setCantidad(int Cantidad) {
		this.Cantidad = Cantidad;
	}

	public ArrayList getListaCompleta() {
		// TODO - implement Listado.getListaCompleta
		return this.ListaCompleta;
	}

	/**
	 * 
	 * @param ListaCompleta
	 */
	public void setListaCompleta(ArrayList ListaCompleta) {
		// TODO - implement Listado.setListaCompleta
		this.ListaCompleta=ListaCompleta;
	}

}