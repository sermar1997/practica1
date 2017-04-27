/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejersqltocho;

import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio
 */
public class DataBase {

    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public boolean cargarDriver() {
        try {
            DriverManager.registerDriver(new Driver());
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Conectar(String host, String puerto, String database, String usuario, String password) {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + puerto + "/" + database, usuario, usuario);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean Desconectar() {
        try {
            conexion.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public PreparedStatement prepararSentencia(String sentencia) throws SQLException {
        PreparedStatement ps = null;
            ps = conexion.prepareStatement(sentencia);
        return ps;
    }
    public ResultSet consultaSinParamtros(String consulta) throws SQLException{
        ResultSet rs = null;
        rs = prepararSentencia(consulta).executeQuery();
        return rs;
    }
}
