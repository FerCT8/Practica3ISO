package Dominio;

public class GestorListado {

    public void CerrarSesion() {
        // TODO - implement GestorListado.CerrarSesion
        throw new UnsupportedOperationException();
    }

    public static boolean ComprobarEnLista(String Codigo, String Nombre) throws Exception {
        boolean autenticado = false;
        if (Listado.read(Codigo, Nombre) != null) {
            autenticado = true;
        }
        return autenticado;
    }

    public void EliminarElemento() {
        // TODO - implement GestorListado.EliminarElemento
        throw new UnsupportedOperationException();
    }

}
