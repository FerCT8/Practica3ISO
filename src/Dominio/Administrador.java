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
    public void Otorgarpermiso(int ID) {
        // TODO - implement Administrador.Otorgarpermiso
        throw new UnsupportedOperationException();
    }

    public int insert() throws Exception {

        String SQL_Consulta = "INSERT INTO usuario VALUES('" + this.Login + "','" + this.Password+"','" + this.getDNI()+ "','" + this.Password+"')" ;

        AgenteUsuarios a = AgenteUsuarios.getAgente();

        a.Insert(SQL_Consulta);

        return 1;
    }

}
