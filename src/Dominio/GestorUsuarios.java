package Dominio;

public class GestorUsuarios {
    

    public Empleados ComprobarEmpleado(String login, String password) throws Exception {

        Empleados e = null;
        if (Empleados.read(login, password) != null) {
            e = new Empleados(login, password);
        }
        return e;

    }
    public static boolean nuevoUsuario(String Login, String Password, String DNI, String Nombre, int Permiso) throws Exception{
		boolean insertado = false;
		
		Empleados u = new Empleados(Login,Password,DNI,Nombre,Permiso);
		if(u.insert() ==1)
			insertado = true;
		return insertado;		
	}
    
}
