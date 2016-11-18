package rzd.oao.zrw.rcs2.Controllers;

import rzd.oao.zrw.rcs2.Models.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;

import static java.lang.Long.valueOf;

public class DataAccess {
    static Connection connection = null;

    /** DB-connection property initialization **/
    public void initProp(){
        Properties property = new Properties();
        try {
            property.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /** Preparing database connection **/
    public static PreparedStatement getPreparedStatment(String sql){
        PreparedStatement statement = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Load config
            Properties property = new Properties();
            property.load(DataAccess.class.getClassLoader().getResourceAsStream("config.properties"));
            // Get connection with attributes from config file
            connection = DriverManager.getConnection(
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
    /** Check user exists **/
    public static boolean checkUser(String login, String password)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("SELECT password FROM users WHERE username = ? ");
            prepStmt.setString(1, login);
            ResultSet resultSet = prepStmt.executeQuery();
            resultSet.next();
            if (resultSet.getString(1).equals(password)) return true;
            else resultSet.close();
        } catch (SQLException e) {
           // e.printStackTrace();
           // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return false;
    }
    /** Get user's ID using user's name **/
    public static int getUserId(String login)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("SELECT id FROM users WHERE username = ? ");
            prepStmt.setString(1, login);
            ResultSet resultSet = prepStmt.executeQuery();
            resultSet.next();
            return resultSet.getInt(1);
        } catch (SQLException e) {
         //   System.out.println(e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }
    /** remove user from DB **/
    public static boolean removeUser(int id)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("DELETE FROM users where id = ?");
            prepStmt.setInt(1, id);
            prepStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
         //   System.out.println("Ошибка удаления пользователя: " + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    /** Add new user **/
    public static boolean addUser(String username, String password, String fio, String position, String department){
        try {
            PreparedStatement prepStmt = getPreparedStatment("INSERT INTO users (username, password, fio, position, department)" +
                    " value(?, ?, ?, ?, ?)");
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);
            prepStmt.setString(3,fio);
            prepStmt.setString(4,position);
            prepStmt.setString(5,department);
            prepStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
         //   System.out.println("Ошибка сохранения нового пользователя: " + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
    /** Save user's changes **/
    public static boolean saveUser(int id, String username, String password, String fio, String position, String department){
        try {
            PreparedStatement prepStmt = getPreparedStatment("UPDATE users SET username = ?, password = ?, fio = ?, " +
                    "position = ?, department = ? WHERE id = ?");
            prepStmt.setString(1,username);
            prepStmt.setString(2,password);
            prepStmt.setString(3,fio);
            prepStmt.setString(4,position);
            prepStmt.setString(5,department);
            prepStmt.setInt(6,id);
            prepStmt.executeUpdate();
            return true;
        } catch (SQLException e) {
        //    System.out.println("Ошибка сохранения изменений в данных пользователя: " + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** Get permitions **/
    public static List<TablePermition> getPermitions(int id)  {
        List<Table> tables = new ArrayList<Table>();
        List<TablePermition> permitions = new ArrayList<TablePermition>();
        try {
            PreparedStatement prepStmt1 = getPreparedStatment("SELECT * FROM tnames");
            ResultSet resultSet1 = prepStmt1.executeQuery();
            while (resultSet1.next()){
                tables.add(new Table(resultSet1.getString(2), resultSet1.getString(1)));
            }
            PreparedStatement prepStmt = getPreparedStatment("SELECT * FROM permitions WHERE id = ?");
            prepStmt.setInt(1, id);
            ResultSet resultSet = prepStmt.executeQuery();

            while (resultSet.next()){
                for(Table table: tables){
                    if (resultSet.getInt(2) == valueOf(table.getId())) {
                        permitions.add(new TablePermition(resultSet.getInt(2), Integer.parseInt(table.getId()), table.getName(), resultSet.getInt(3)));
                    }
                }
            }
            return permitions;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /** Get one table permition **/
    public static int getPermition(int id, int tblId)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("SELECT permition FROM permitions WHERE id = ? AND tableid = ?");
            prepStmt.setInt(1, id);
            prepStmt.setInt(2, tblId);
            ResultSet resultSet = prepStmt.executeQuery();
            return resultSet.next() ? resultSet.getInt(1) : 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    public static boolean setPermitions(int id, Map<Integer, Integer> permitions, Map<String, Integer> mainpermitions)  {
        try {
            PreparedStatement prepStmt1 = getPreparedStatment("DELETE FROM permitions WHERE id = ?");
            prepStmt1.setInt(1, id);
            prepStmt1.executeUpdate();
            for (Map.Entry pare: permitions.entrySet()) {
                PreparedStatement prepStmt2 = getPreparedStatment("INSERT INTO permitions (id, tableid, permition) VALUE(?, ?, ?)");
                prepStmt2.setInt(1, id);
                prepStmt2.setInt(2, (Integer) pare.getKey());
                prepStmt2.setInt(3, (Integer) pare.getValue());
                prepStmt2.executeUpdate();
            }
            PreparedStatement prepStmt3 = getPreparedStatment("UPDATE mainpermitions SET addtable = ?, removetable = ?, runsusers = ?, viewtable = ?, edittable = ? WHERE id = ?");
            prepStmt3.setInt(1, 0);
            prepStmt3.setInt(2, 0);
            prepStmt3.setInt(3, 0);
            prepStmt3.setInt(4, 0);
            prepStmt3.setInt(5, 0);
            for (Map.Entry pare: mainpermitions.entrySet()) {
                if (pare.getKey().equals("addTable")) prepStmt3.setInt(1, (Integer) pare.getValue());
                else if (pare.getKey().equals("removeTable")) prepStmt3.setInt(2, (Integer) pare.getValue());
                else if (pare.getKey().equals("editUsers")) prepStmt3.setInt(3, (Integer) pare.getValue());
                else if (pare.getKey().equals("viewTable")) prepStmt3.setInt(4, (Integer) pare.getValue());
                else if (pare.getKey().equals("editTable")) prepStmt3.setInt(5, (Integer) pare.getValue());
            }
            prepStmt3.setInt(6, id);
            prepStmt3.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** Get main permitions **/
    public static MainPermition getMainPermitions(int id)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("SELECT * FROM mainpermitions WHERE id = ?");
            prepStmt.setInt(1, id);
            ResultSet resultSet = prepStmt.executeQuery();
            resultSet.next();
            return new MainPermition(resultSet.getInt(1), resultSet.getBoolean(2), resultSet.getBoolean(3), resultSet.getBoolean(4), resultSet.getBoolean(5), resultSet.getBoolean(6));
            //return null;
        } catch (SQLException e) {
         //   System.out.println("Главные полномочия ошибка! " + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /** Set default main permitions **/
    public static MainPermition addMainPermitions(int userId)  {
        try {
            PreparedStatement prepStmt = getPreparedStatment("INSERT INTO mainpermitions (id) VALUE(?)");
            prepStmt.setInt(1, userId);
            prepStmt.executeUpdate();
        } catch (SQLException e) {
          //  System.out.println("Не удалось добавить полномочия 1 уровня! " + e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /** Add whole table's information to the list of <Table> objects. **/
    public static List<Table> listNamesOfTables(){
        ArrayList<Table> list = new ArrayList<Table>();
        try {
            PreparedStatement statement = getPreparedStatment("SELECT * FROM tnames");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Table tables = new Table(resultSet.getString(2),resultSet.getString(1));
                list.add(tables);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /** Получение ID последней созданной таблицы с конкретным именем **/
    public static int idTable(String tname){
        try {
            PreparedStatement statement = getPreparedStatment("SELECT * FROM tnames where name = ? ORDER by id");
            statement.setString(1, tname);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return resultSet.getInt(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return 0;
    }

    /** List elements of one row **/
    public static List<String> listRow(int rowId){
        List<String> list = new ArrayList<String>();
        try {
            PreparedStatement preparedStatement = getPreparedStatment("SELECT * FROM iptn001 where rowid = ?");
            preparedStatement.setInt(1, rowId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            for (int i = 2; i < 21; i++) {
              list.add(resultSet.getString(i));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /** Save row of tabel to DB **/
    public static boolean saveRow(int rowId, String station, String place, String panel, String port, String ip, String cname, String type, String department,
                                  String fio, String position, String phone, String login1, String login2, String login3, String description, String description1, String description2, String description3){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("UPDATE iptn001 SET station = ?, place = ?, panel = ?" +
                               ", port = ?, ip = ?, cname = ?, type = ?, department = ?, fio = ?, position = ?, phone = ?" +
                               ", login = ?, login2 = ?, login3 = ?, description = ?, description2 = ?, description3 = ?, description4 = ? where rowid = ?");
            preparedStatement.setString(1, station);
            preparedStatement.setString(2, place);
            preparedStatement.setString(3, panel);
            preparedStatement.setString(4, port);
            preparedStatement.setString(5, ip);
            preparedStatement.setString(6, cname);
            preparedStatement.setString(7, type);
            preparedStatement.setString(8, department);
            preparedStatement.setString(9, fio);
            preparedStatement.setString(10, position);
            preparedStatement.setString(11, phone);
            preparedStatement.setString(12, login1);
            preparedStatement.setString(13, login2);
            preparedStatement.setString(14, login3);
            preparedStatement.setString(15, description);
            preparedStatement.setString(16, description1);
            preparedStatement.setString(17, description2);
            preparedStatement.setString(18, description3);
            preparedStatement.setInt(19, rowId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** Remooving row of table from DB **/
    public static void deleteRow(int rowId){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("DELETE FROM iptn001 where rowid = ?");
            preparedStatement.setInt(1, rowId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    public static boolean addNewRow(String station, String place, String panel, String port, String ip, String cname, String type, String department,
                                  String fio, String position, String phone, String login1, String login2, String login3, String description,
                                  String description1, String description2, String description3, int tableId){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("INSERT INTO iptn001 (station, place, panel" +
                    ", port, ip, cname, type, department, fio, position, phone" +
                    ",login, login2, login3, description, description2, description3, description4, tableID) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, station);
            preparedStatement.setString(2, place);
            preparedStatement.setString(3, panel);
            preparedStatement.setString(4, port);
            preparedStatement.setString(5, ip);
            preparedStatement.setString(6, cname);
            preparedStatement.setString(7, type);
            preparedStatement.setString(8, department);
            preparedStatement.setString(9, fio);
            preparedStatement.setString(10, position);
            preparedStatement.setString(11, phone);
            preparedStatement.setString(12, login1);
            preparedStatement.setString(13, login2);
            preparedStatement.setString(14, login3);
            preparedStatement.setString(15, description);
            preparedStatement.setString(16, description1);
            preparedStatement.setString(17, description2);
            preparedStatement.setString(18, description3);
            preparedStatement.setInt(19, tableId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** Add new table **/
    public static boolean addNewTable(String name){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("INSERT INTO tnames (name)  value(?)");
            preparedStatement.setString(1, name);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** List table using ID **/
    public static List<ArmData> listIpTable(String id){
        ArrayList<ArmData> list = new ArrayList<ArmData>();
        try {
            PreparedStatement preparedStatement = getPreparedStatment("SELECT * FROM iptn001 where tableid = ?");
            preparedStatement.setString(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               ArmData armData = new ArmData(resultSet.getInt(1),resultSet.getString(13),resultSet.getString(14),resultSet.getString(2),resultSet.getString(3),
                       resultSet.getString(4), resultSet.getString(5), resultSet.getString(18), resultSet.getString(6), resultSet.getString(7),
                       resultSet.getString(8), resultSet.getString(9), resultSet.getString(15), resultSet.getString(16), resultSet.getString(17),
                       resultSet.getString(10), resultSet.getString(12), resultSet.getString(19), resultSet.getString(20), resultSet.getInt(11));
               list.add(armData);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /** Save new name of table **/
    public static boolean savenewtablename(int tableId, String name){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("UPDATE tnames SET name = ? where id = ?");
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, tableId);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /** Add all rows into the table **/
    public static boolean addAllRows(List<ArmData> rows){
    for (ArmData oneArm: rows) {
        try {
            PreparedStatement preparedStatement = getPreparedStatment("INSERT INTO iptn001 (station, place, panel" +
                    ", port, ip, cname, type, department, fio, position, phone" +
                    ",login, login2, login3, description, description2, description3, description4, tableID) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

//            PreparedStatement preparedStatement = getPreparedStatment("INSERT INTO iptn001 (panel" +
//                    ", port, ip, cname, department, fio, position, phone" +
//                    ", description, tableID) value(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, oneArm.getStation());
            preparedStatement.setString(2, oneArm.getPlace());
            preparedStatement.setString(3, oneArm.getPanel());
            preparedStatement.setString(4, oneArm.getPort());
            preparedStatement.setString(5, oneArm.getIp());
            preparedStatement.setString(6, oneArm.getCname());
            preparedStatement.setString(7, oneArm.getType());
            preparedStatement.setString(8, oneArm.getDepartment());
            preparedStatement.setString(9, oneArm.getFio());
            preparedStatement.setString(10, oneArm.getPosition());
            preparedStatement.setString(11, oneArm.getPhone());
            preparedStatement.setString(12, oneArm.getLogin1());
            preparedStatement.setString(13, oneArm.getLogin2());
            preparedStatement.setString(14, oneArm.getLogin3());
            preparedStatement.setString(15, oneArm.getDescription());
            preparedStatement.setString(16, oneArm.getDescription1());
            preparedStatement.setString(17, oneArm.getDescription2());
            preparedStatement.setString(18, oneArm.getDescription3());
            preparedStatement.setInt(19, oneArm.getTableId());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    return true;
    }

    /** Removing table from DB **/
    public static void deleteTable(int tableId){

        try {
            // Можно сделать в одном запросе, переделав id в tableid
            PreparedStatement preparedStatement = getPreparedStatment("DELETE FROM iptn001 where tableid = ?");
            preparedStatement.setInt(1, tableId);
            preparedStatement.executeUpdate();
            PreparedStatement preparedStatement2 = getPreparedStatment("DELETE FROM tnames where id = ?");
            preparedStatement2.setInt(1, tableId);
            preparedStatement2.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }

    /** List of user's permitions **/
    public static Map<Integer,Integer> listPermitions(int userId){
        Map<Integer,Integer> permitions = new HashMap<Integer, Integer>();
        try {
            PreparedStatement preparedStatement = getPreparedStatment("SELECT * FROM permitions where id = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                permitions.put(resultSet.getInt(2), resultSet.getInt(3));
            }
            return permitions;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    /** List of all users **/
    public static List<User> listUsers(){
        List<User> users = new ArrayList<User>();
        try {
            PreparedStatement preparedStatement = getPreparedStatment("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)));
            }
            resultSet.close();

            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    /** List user's data for ID **/
    public static User listUserForId(int id){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getString(5), resultSet.getString(6));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /** Adding permition for table **/
    public static void addPermition(int userId, int tableId){
        try {
            PreparedStatement preparedStatement = getPreparedStatment("INSERT INTO permitions(id , tableId, permition) value(?, ?, 3)");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, tableId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    /** Removing user permition for table **/
    public static void deletePermition(int userId, int tableId){

        try {
            PreparedStatement preparedStatement = getPreparedStatment("DELETE FROM permitions WHERE id = ? AND tableid = ?");
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, tableId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    /** Search content with table permissions**/
    public static List<ArmData> searchContent(String query, int userId)  {
        List<ArmData> arms = new ArrayList<ArmData>();
        try {
//            PreparedStatement prepStmt = getPreparedStatment("SELECT * FROM iptn001 WHERE concat(ip,cname,fio, phone, login) LIKE '%" + query + "%' LIMIT 100");
            PreparedStatement prepStmt = getPreparedStatment("SELECT * FROM iptn001 WHERE tableid IN (SELECT tableid FROM permitions WHERE permition > 0 AND id = ?) AND concat(ip,cname,fio, phone, login) LIKE '%" + query + "%' LIMIT 100");
            prepStmt.setInt(1, userId);
            ResultSet resultSet = prepStmt.executeQuery();

            while (resultSet.next()){
                ArmData armData = new ArmData(resultSet.getInt(1),resultSet.getString(13),resultSet.getString(14),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(18), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(15), resultSet.getString(16), resultSet.getString(17),
                        resultSet.getString(10), resultSet.getString(12), resultSet.getString(19), resultSet.getString(20), resultSet.getInt(11));
                arms.add(armData);
            }
            return arms;

        } catch (SQLException e) {
             e.printStackTrace();
            // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    /** Search whole content **/
    public static List<ArmData> searchWholeContent(String query)  {
        List<ArmData> arms = new ArrayList<ArmData>();
        try {
            PreparedStatement prepStmt = getPreparedStatment("SELECT * FROM iptn001 WHERE concat(ip,cname,fio, phone, login) LIKE '%" + query + "%' LIMIT 100");
            ResultSet resultSet = prepStmt.executeQuery();

            while (resultSet.next()){
                ArmData armData = new ArmData(resultSet.getInt(1),resultSet.getString(13),resultSet.getString(14),resultSet.getString(2),resultSet.getString(3),
                        resultSet.getString(4), resultSet.getString(5), resultSet.getString(18), resultSet.getString(6), resultSet.getString(7),
                        resultSet.getString(8), resultSet.getString(9), resultSet.getString(15), resultSet.getString(16), resultSet.getString(17),
                        resultSet.getString(10), resultSet.getString(12), resultSet.getString(19), resultSet.getString(20), resultSet.getInt(11));
                arms.add(armData);
            }
            return arms;

        } catch (SQLException e) {
            e.printStackTrace();
            // Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, e);
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }


}
