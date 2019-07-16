package Lesson_2;

import java.sql.SQLException;

public class TestCRUD {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        CRUD.tryConnect();
        CRUD.createDB();
        CRUD.insertDB();
        CRUD.updateDB();
        CRUD.deleteFromDB();
        CRUD.selectAllDB();
        CRUD.closeConnection();
    }
}
