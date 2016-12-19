package Dominio;

import Persistencia.AgenteListado;
import java.util.Vector;


public class Listado {

    private int Cantidad;
    private String Codigo;
     private String Nombre;

     
    public Listado(int Cantidad,String Codigo, String Nombre) {
        this.Cantidad = Cantidad;
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        
    }
    public Listado(String Codigo, String Nombre) {
      
        this.Codigo=Codigo;
        this.Nombre=Nombre;
        
    }
    public int getCantidad() {
        return this.Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
    
    @Override
    public String toString(){
        String mensaje = "-" +this.Codigo+"-"+this.Nombre;
        return mensaje;
    }

    
     public int insert() throws Exception {

        String SQL_Consulta = "INSERT INTO practica3db.productos VALUES('" + this.Codigo + "','" + this.Nombre + "')";

        AgenteListado a = AgenteListado.getAgente();

        a.Insert(SQL_Consulta);

        return 1;
    }
     public static Producto read(String Codigo, String Nombre) throws Exception {

        Producto u = null;
        Vector<Object> aux = null;

        String SQL_Consulta = "SELECT * FROM practica3db.productos WHERE Codigo = '" + Codigo + "' AND Nombre = '" + Nombre + "';";

        AgenteListado a = AgenteListado.getAgente();

        Vector<Object> res = a.select(SQL_Consulta);

        if (res.size() == 1) {
            aux = (Vector<Object>) res.elementAt(0);
            u = new Producto((String) aux.elementAt(0), (String) aux.elementAt(1));
        }
        return u;
    }
    
}
