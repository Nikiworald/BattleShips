package db;

import com.mysql.cj.conf.DatabaseUrlContainer;
import com.mysql.cj.conf.HostInfo;
import com.mysql.cj.jdbc.ConnectionImpl;

import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class DbConnection {
    static Connection connection;
    public static Connection getConnection() {
        if(connection==null){
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/battleships","root","niki");
            } catch (SQLException e) {
                System.out.println("couldn't connect to db:"+ Arrays.toString(e.getStackTrace()));
            }
        }
        return connection;
    }


}
