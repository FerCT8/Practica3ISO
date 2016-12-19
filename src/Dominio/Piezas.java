package Dominio;

import Persistencia.AgenteListado;
import java.util.Vector;

public class Piezas extends Listado {

    Piezas(String Codigo, String Nombre) {
        super(Codigo, Nombre);
    }

    public int insert() throws Exception {

        String SQL_Consulta = "INSERT INTO practica3db.productos VALUES('" + getCodigo() + "','" + getNombre() + "')";

        AgenteListado a = AgenteListado.getAgente();

        a.Insert(SQL_Consulta);

        return 1;
    }
}
