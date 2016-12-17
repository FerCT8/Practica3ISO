package Persistencia;

import java.sql.Connection;
import java.sql.*;

public class AgenteUsuarios {

    protected static AgenteUsuarios mInstancia = null;
    protected static Connection mBD;
    private static String url = null;
    private static String driver="com.mysql.jdbc.Driver";
    
public static AgenteUsuarios getAgente() throws Exception{
          if (mInstancia==null){
          mInstancia=new AgenteUsuarios();

        }
        return mInstancia;
     }
     private void conectar() throws Exception {
         Class.forName(driver);
         mBD=DriverManager.getConnection(url);
    }
       public void desconectar() throws Exception{
    	mBD.close();
    }
    public int Insert(String SQL) throws SQLException,Exception{
        conectar();
    	PreparedStatement stmt = mBD.prepareStatement(SQL);
    	int res=stmt.executeUpdate();
    	stmt.close();
    	desconectar();
    	return res;
        
      
    }

    public void Select(int SQL) {

        throw new UnsupportedOperationException();
    }

}
