package rzd.oao.zrw.rcs2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DatabaseConnector {
    private Connection connection;
    private Driver driver;

    public boolean connect() {
        InputStream config;
        Properties property = new Properties();
        try {
            Class clazz = Class.forName("com.mysql.jdbc.Driver");
            driver = (Driver) (clazz.newInstance());
            DriverManager.registerDriver(driver);
            config =  getClass().getClassLoader().getResourceAsStream("config.properties");
            property.load(config);
            connection = DriverManager.getConnection(
                    property.getProperty("url"),
                    property.getProperty("user"),
                    property.getProperty("password"));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return false;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void disconnect(){
        try {
            if (!connection.isClosed()) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String login, String password)  {
        Statement statement = null;
        try {
            String selectStatement = "SELECT password FROM users WHERE username = ? ";
            PreparedStatement prepStmt = connection.prepareStatement(selectStatement);
            prepStmt.setString(1, login);
            ResultSet resultSet = prepStmt.executeQuery();
            resultSet.next();

            if (resultSet.getString(1).equals(password)) return true;
            else return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
