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

    public void AnadirPieza(String Codigo, String Nombre) {

		//AQUI SUPONGO QUE VA LA SENTENCIA DE INSERTAR PERO NO LO SE
        //PREGUNTAR A FERNANDO Y PREGUNTARLE LO DE LA SENTENCIA
        throw new UnsupportedOperationException();
    }

    public void ActualizarLista() {
        // TODO - implement GestorPiezas.ActualizarLista
        throw new UnsupportedOperationException();
    }

    public Piezas ComprobarPiezas(String login, String password) throws Exception {

        Piezas e = null;
        if (Piezas.read(login, password) != null) {
            e = new Piezas(login, password);
        }
    
        return e;

    }

}
