package Lesson_2;

import java.sql.*;

public class CRUD {

    private static Connection conn;
    private static Statement stmt;

    public static void tryConnect() throws SQLException, ClassNotFoundException {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:DBUser.db");

        System.out.println("Подключено");

        stmt = conn.createStatement();
    }

    public static void createDB() throws SQLException {
        String sql = ("CREATE TABLE if not exists worker (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name STRING  NOT NULL, position STRING, salary INT);");

    stmt.execute(sql);
        System.out.println("Таблица создана");
    }
    public static void insertDB() throws SQLException {
        stmt.executeUpdate("INSERT INTO worker (name, position, salary) VALUES ('Александр', 'инженер','35000');");
        stmt.executeUpdate("INSERT INTO worker (name, position, salary) VALUES ('Анастасия', 'администратор','45000');");
        stmt.executeUpdate("INSERT INTO worker (name, position, salary) VALUES ('Владимир', 'токарь','55000');");
        stmt.executeUpdate("INSERT INTO worker (name, position, salary) VALUES ('Анастасия', 'конструктор','35000');");
        stmt.executeUpdate("INSERT INTO worker (name, position, salary) VALUES ('Инокентий', 'ничальник','95000');");
    }

    public static void updateDB() throws SQLException {
        stmt.executeUpdate("UPDATE worker SET salary = '45000' WHERE name = 'Владимир' AND position = 'токарь';");
    }

    public static void deleteFromDB() throws SQLException {
        stmt.executeUpdate("DELETE FROM worker WHERE name = 'Анастасия' AND position = 'конструктор';");
    }

    public static void selectAllDB() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM worker;");

        while (rs.next()){
            System.out.println(rs.getString(1) + "  " + rs.getString(2));
        }
    }

    public static void closeConnection() throws SQLException {
        conn.close();
        stmt.close();
    }

}
