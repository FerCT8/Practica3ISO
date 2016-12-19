package Dominio;

import Persistencia.AgenteListado;

public class Producto extends Listado {

    Producto(String Codigo, String Nombre) {
        super(Codigo, Nombre);
    }

    public int insert() throws Exception {

        String SQL_Consulta = "INSERT INTO practica3db.productos VALUES('" + getCodigo() + "','" + getNombre() + "')";

        AgenteListado a = AgenteListado.getAgente();

        a.Insert(SQL_Consulta);

        return 1;
    }

}
