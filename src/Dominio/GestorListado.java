package Dominio;

public class GestorListado {

    public void CerrarSesion() {
        // TODO - implement GestorListado.CerrarSesion
        throw new UnsupportedOperationException();
    }

    public Producto ComprobaProductos(String Codigo, String Nombre) throws Exception {

        Producto p = null;
        if (Producto.read(Codigo, Nombre) != null) {
            p = new Producto(Codigo, Nombre);
        }
        return p;

    }

    public void EliminarElemento() {
        // TODO - implement GestorListado.EliminarElemento
        throw new UnsupportedOperationException();
    }

}
