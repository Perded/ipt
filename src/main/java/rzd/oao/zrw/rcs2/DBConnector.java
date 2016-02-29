package rzd.oao.zrw.rcs2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;


public class DBConnector {
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
