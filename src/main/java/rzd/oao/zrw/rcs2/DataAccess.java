package rzd.oao.zrw.rcs2;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    public static boolean checkUser(String login, String password)  {
        try {
            PreparedStatement prepStmt = DBConnector.getPreparedStatment("SELECT password FROM users WHERE username = ? ");
            prepStmt.setString(1, login);
            ResultSet resultSet = prepStmt.executeQuery();
            resultSet.next();
            if (resultSet.getString(1).equals(password)) return true;
        } catch (SQLException e) {
            e.printStackTrace();
           // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    public static List<Tables> listNamesOFTables(){
        List<Tables> list = new ArrayList<Tables>();
        try {
            PreparedStatement statement = DBConnector.getPreparedStatment("SELECT * FROM tnames");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
            Tables tables = new Tables(resultSet.getString(3),resultSet.getString(1),resultSet.getString(2));
                list.add(tables);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<Table> viewTable(String id){
        List<String> cells = new ArrayList<String>();
        List<Table> rows = new ArrayList<Table>();
        String bdTableName;
        PreparedStatement statement = DBConnector.getPreparedStatment("SELECT tablename FROM tnames WHERE id = ?");
        try {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            bdTableName = resultSet.getString(1);
            PreparedStatement tableStatement = DBConnector.getPreparedStatment("SELECT * FROM " + bdTableName);
            ResultSet tableResultSet = tableStatement.executeQuery();
            while (tableResultSet.next()){
                for (int i = 1; i < tableResultSet.getMetaData().getColumnCount(); i++) {
                    cells.add(tableResultSet.getString(i));
                }
                rows.add(new Table(cells));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rows;
    }
}
