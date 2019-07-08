package Lesson_2.Chat.gb.server;

import java.sql.*;
import java.util.ArrayList;

public class AuthService {

    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:userTestDB.db");
            stmt = connection.createStatement();
            stmt.executeUpdate("CREATE TABLE if not exists messages (id INTEGER PRIMARY KEY AUTOINCREMENT, message STRING);"); // создаю таблицу для хранения сообщений
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static String getNickByLoginAndPass(String login, String pass) {

        String sql = String.format("select nickname FROM userTable where" +
                " login = '%s' and password = '%s'", login, pass);
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void saveMsg(String msg){
        String sql = String.format("INSERT INTO messages (message) VALUES ('%s');", msg);
        try {
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getLastMsg(){
        String sql = ("SELECT message FROM (SELECT * FROM messages ORDER BY id DESC LIMIT 20) sub ORDER BY id ASC");
        ArrayList<String> msg = new ArrayList<>();

        try {
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                msg.add(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return msg;

    }

}
