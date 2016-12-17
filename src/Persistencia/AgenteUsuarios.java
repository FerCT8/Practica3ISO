package Persistencia;

import java.sql.Connection;
import java.sql.*;
import java.util.Vector;

public class AgenteUsuarios {

    protected static AgenteUsuarios mInstancia = null;
    protected static Connection mBD;
    private static String url = "jdbc:mysql://localhost:3306/practica3db?user=root&password=admin";
    private static String driver = "com.mysql.jdbc.Driver";

    public static AgenteUsuarios getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteUsuarios();

        }
        return mInstancia;
    }

    private void conectar() throws Exception {
        Class.forName(driver);
        mBD = DriverManager.getConnection(url);
    }

    public int delete(String SQL) throws SQLException, Exception {
        PreparedStatement stmt = mBD.prepareStatement(SQL);
        int res = stmt.executeUpdate();
        stmt.close();
        desconectar();
        return res;
    }

    public void desconectar() throws Exception {
        mBD.close();
    }

    public int Insert(String SQL) throws SQLException, Exception {
        conectar();
        PreparedStatement stmt = mBD.prepareStatement(SQL);
        int res = stmt.executeUpdate();
        stmt.close();
        desconectar();
        return res;

    }

    public int update(String SQL) throws SQLException, Exception {
        conectar();
        PreparedStatement stmt = mBD.prepareStatement(SQL);
        int res = stmt.executeUpdate();
        stmt.close();
        desconectar();
        return res;
    }

    public Vector<Object> select(String SQL) throws SQLException, Exception {

        conectar();

        PreparedStatement stmt = mBD.prepareStatement(SQL);
        ResultSet res = stmt.executeQuery();

        Vector<Object> lista = new Vector<Object>();

        while (res.next()) {

            Vector<Object> usuario = new Vector<Object>();

            usuario.add(res.getString("Login"));
            usuario.add(res.getString("Password"));
            usuario.add(res.getString("DNI"));
            usuario.add(res.getString("Nombre"));
            usuario.add(res.getInt("Permiso"));
            lista.add(usuario);
        }
        return lista;

    }
}
