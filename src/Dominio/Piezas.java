package Dominio;

import Persistencia.AgenteListado;
import java.util.Vector;

public class Piezas {

    private int Codigo;
    private int Nombre;

    Piezas(String Codigo, String Nombre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getCodigo() {
        return this.Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getNombre() {
        return this.Nombre;
    }

    public void setNombre(int Nombre) {
        this.Nombre = Nombre;
    }

    public static Empleados read(String login, String password) throws Exception {
        String l, g;
        Empleados u = null;
        Vector<Object> aux = null;

        String SQL_Consulta = "SELECT * FROM practica3db.empleados WHERE Login = '" + login + "' AND Password = '" + password + "';";

        AgenteListado a = AgenteListado.getAgente();

        Vector<Object> res = a.select(SQL_Consulta);

        if (res.size() == 1) {
            aux = (Vector<Object>) res.elementAt(0);
            u = new Empleados((String) aux.elementAt(0), (String) aux.elementAt(1), (String) aux.elementAt(2), (String) aux.elementAt(3), (int) aux.elementAt(4));
        }
        return u;
    }

    public int insert() throws Exception {

        String SQL_Consulta = "INSERT INTO practica3db.empleados VALUES('" + this.Codigo + "','" + this.Nombre + "')";

        AgenteListado a = AgenteListado.getAgente();

        a.Insert(SQL_Consulta);

        return 1;
    }
    
    
    @Override
    public String toString() {

        String mensaje = "Codigo: " + this.Codigo + "-Nombre: " + this.Nombre;
        return mensaje;
    }

}
