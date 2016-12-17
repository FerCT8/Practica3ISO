package Dominio;

import Persistencia.AgenteUsuarios;
import java.util.Vector;

public class Empleados {

    String Login;
    String Password;
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private int Telefono;
    private int Permiso;

    Empleados(String Login, String Password) {
        this.Login = Login;
        this.Password = Password;
    }

    Empleados(String Login, String Password, String DNI, String Nombre, String Apellidos, int Telefono, int Permiso) {
        this.Login = Login;
        this.Password = Password;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Telefono = Telefono;
        this.Permiso = Permiso;

    }

    public String getLogin() {
        return this.Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getDNI() {
        return this.DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return this.Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public int getTelefono() {
        return this.Telefono;
    }

    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }

    public int getPermiso() {
        return this.Permiso;
    }

    public void setPermiso(int Permiso) {
        this.Permiso = Permiso;
    }

    public static Empleados read(String login, String password) throws Exception {
        String l, g;
        Empleados u = null;
        Vector<Object> aux = null;

        String SQL_Consulta = "SELECT login, pass FROM usuario WHERE login = '" + login + "' AND pass = '" + password + "';";

        AgenteUsuarios a = AgenteUsuarios.getAgente();

        Vector<Object> res = a.select(SQL_Consulta);

        if (res.size() == 1) {
            aux = (Vector<Object>) res.elementAt(0);
            u = new Empleados((String) aux.elementAt(0), (String) aux.elementAt(1));
        }
        return u;
    }

}
