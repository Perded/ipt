package rzd.oao.zrw.rcs2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnector {
 //   private static final String URL = "jdbc:mysql://10.122.111.151:3306/ipTables";
 //   private static final String USERNAME = "iptablesuser";
 //   private static final String PASSWORD = "123";
    public void initProp(){
        Properties property = new Properties();
        try {
            property.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static PreparedStatement getPreparedStatment(String sql){
        PreparedStatement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Load config
            Properties property = new Properties();
            property.load(DBConnector.class.getClassLoader().getResourceAsStream("config.properties"));
            // Get connection with attributes from config file
            Connection connection = DriverManager.getConnection(
                    property.getProperty("url"),
                    property.getProperty("user"),
                    property.getProperty("password"));
//            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return statement;
    }
}
