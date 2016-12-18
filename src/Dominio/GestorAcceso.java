package Dominio;

public class GestorAcceso {

    public static boolean autenticar(String login, String password) throws Exception {
        boolean autenticado = false;
        if (Empleados.read(login, password) != null) {
            autenticado = true;
        }
        return autenticado;
    }

}
