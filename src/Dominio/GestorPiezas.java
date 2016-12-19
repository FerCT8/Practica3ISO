package Dominio;

public class GestorPiezas {

    public void CerrarSesion() {
        // TODO - implement GestorPiezas.CerrarSesion
        throw new UnsupportedOperationException();
    }

    public void EliminarPieza() {
        // TODO - implement GestorPiezas.EliminarPieza
        throw new UnsupportedOperationException();
    }




    public static boolean nuevoPieza(String Codigo, String Nombre) throws Exception {
        boolean insertado = false;

        Piezas u = new Piezas(Codigo, Nombre);
        if (u.insert() == 1) {
            insertado = true;
        }
        return insertado;
    }

}
