package Lesson_2_class;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseApp {
    static final String DATABASE_URL = "jdbc:sqlite:javadb.db";
    static Connection connection;
    static Statement statement;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection(DATABASE_URL);
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) throws SQLException {
        DatabaseApp databaseApp = new DatabaseApp();
        databaseApp.createTable();
        databaseApp.insertNewBike("bike1", "001");
        databaseApp.insertNewBikePS("bike", "");
        databaseApp.insertNewBike("bike3", "003");
        System.out.println (databaseApp.searchForBike());
        //databaseApp.dropTable();
    }

    public void createTable() throws SQLException {
        String createTable = "create table if not exists bike (" +
                "id integer not null primary key," +
                "model varchar(30) not null, " +
                "serial_no varchar(10))";
        statement.execute(createTable);
    }

    public void insertNewBike(String model, String serial) throws SQLException {
        String insertSql = "insert into bike(" +
                "model, serial_no)" +
                "values ('" + model + "', '" + serial + "')";
        statement.execute(insertSql);
    }

    public void insertNewBikePS(String model, String serial) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("insert into bike(model, serial_no)values(?,?)");
        for (int i = 1; i < 11; i++) {
            preparedStatement.setString(1, model + " " + i);
            preparedStatement.setString(2, serial + " " + (i + 10));
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();

    }

    public void dropTable() throws SQLException {
        String dropSql = "drop table bike";
        statement.execute(dropSql);
    }

    public List<Bike> searchForBike() throws SQLException {
        String sql = "select * from bike";
        List<Bike> bikeList = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            bikeList.add(new Bike(resultSet.getInt("id"),
                    resultSet.getString("model"),
                    resultSet.getString("serial_no")));
            System.out.println(resultSet.getInt("id") + " "
                    + resultSet.getString("model") + " "
                    + resultSet.getString("serial_no"));
        }
        return bikeList;
    }
}
