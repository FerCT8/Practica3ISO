package Persistencia;

import java.sql.Connection;
import java.sql.*;
import java.util.Vector;

public class AgenteListado {

	protected static AgenteListado mInstancia = null;
    protected static Connection mBD;
    private static String url = "jdbc:mysql://localhost:3306/practica3db?user=root&password=admin";
    private static String driver = "com.mysql.jdbc.Driver";

    public static AgenteListado getAgente() throws Exception {
        if (mInstancia == null) {
            mInstancia = new AgenteListado();

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

            Vector<Object> producto = new Vector<Object>();

            producto.add(res.getString("Codigo"));
            producto.add(res.getString("Nombre"));
            lista.add(producto);
        }
        return lista;

    }
}