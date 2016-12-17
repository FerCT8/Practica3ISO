package Dominio;

public class GestorUsuarios {
    

    public Empleados ComprobarEmpleado(String login, String password) throws Exception {

        Empleados e = null;
        if (Empleados.read(login, password) != null) {
            e = new Empleados(login, password);
        }
        return e;

    }
    
    
}
