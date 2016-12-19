package Dominio;

public class GestorVentas {

	public void CerrarSesion() {
		// TODO - implement GestorVentas.CerrarSesion
		throw new UnsupportedOperationException();
	}

	public void MarcarVendido() {
		// TODO - implement GestorVentas.MarcarVendido
		throw new UnsupportedOperationException();
	}


	public void CompararLista() {
		// TODO - implement GestorVentas.CompararLista
		throw new UnsupportedOperationException();
	}

        public static boolean nuevoPieza(String Codigo, String Nombre) throws Exception {
        boolean insertado = false;

        Producto p = new Producto(Codigo, Nombre);
        if (p.insert() == 1) {
            insertado = true;
        }
        return insertado;
    }
}