package Dominio;

import Persistencia.AgenteUsuarios;

public class Administrador extends Empleados {

    public Administrador(String Login, String Password) {
        super(Login,Password);
        
    }

    /**
     *
     * @param ID
     */
    public void Otorgarpermiso() {
        // TODO - implement Administrador.Otorgarpermiso
        throw new UnsupportedOperationException();
    }
    public static boolean nuevoUsuario(String Login, String Password, String DNI, String Nombre, int Permiso) throws Exception{
		boolean insertado = false;
		
		Empleados u = new Empleados(Login,Password,DNI,Nombre,Permiso);
		if(u.insert() ==1)
			insertado = true;
		return insertado;		
    }
}
