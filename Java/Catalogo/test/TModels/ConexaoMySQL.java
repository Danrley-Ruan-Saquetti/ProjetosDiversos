package TModels;

//import com.mysql.jdbc.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;

/**
 *
 * @author Dan Ruan
 */
public class ConexaoMySQL {
    
//    public ConexaoMySQL() {
//        
//    }
//    
//    public static java.sql.Connection getConexaoMySQL() {
//        Connection connection = null;
//        
//        try {
//            String driverName = "com.mysql.jdbc.Driver";
//            Class.forName("com.mysql.jdbc.Driver");
//            
//            String serverName = "localhost:3306";
//            String databaseName = "catalogo";
//            String url = "jdbc:mysql://" + serverName + "/" + databaseName;
//            String username = "Dan Ruan";
//            String password = "user";
//            
//            connection = (Connection) DriverManager.getConnection(url, username, password);
//            
//            return connection;
//        } catch(ClassNotFoundException n) {
//            return null;
//        } catch (SQLException e) {
//            return null;
//        }
//    }
//    
//    public static boolean fecharConexao() {
//        try {
//            ConexaoMySQL.getConexaoMySQL().close();
//            return true;
//        } catch(SQLException e) {
//            return false;
//        }
//    }
//    
//    public static java.sql.Connection reiniciarConexao() {
//        fecharConexao();
//        return ConexaoMySQL.getConexaoMySQL();
//    }
}
