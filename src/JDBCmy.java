import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class JDBCmy {
    //        Запускается только через терминал "java -cp sqlite-jdbc-3.20.1.jar:. JDBCmy.java"

    static final String JDBC_DRIVER = "org.sqlite.JDBC";
    static final String DATABASE_URL = "jdbc:sqlite:my.db";
    public static String table;

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("С какой таблицей будем работать?");
        table = sc.next();


        Connection connection = null;
        Statement statement = null;

        System.out.println("Registering JDBC driver...");

        Class.forName(JDBC_DRIVER);

        System.out.println("Creating database connection...");
        connection = DriverManager.getConnection(DATABASE_URL);

        System.out.println("Executing statement...");
        statement = connection.createStatement();


        showTable(statement);


        System.out.println("Closing connection and releasing resources...");
        statement.close();
        connection.close();
    }

    public static void showTable(Statement st) throws SQLException {

        String sql;
        sql = "SELECT * FROM " + table;

        Statement statement = st;
        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\n" + table + ":");
            if (Objects.equals(table, "shops")) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int adress = resultSet.getInt("adress");
                    System.out.println("Name: " + name);
                    System.out.println("Adress: " + adress);
                    System.out.println("\n================\n");
                }
            }
//            name TEXT, color TEXT, model TEXT, speed CHAR
            if (Objects.equals(table, "cars")) {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String color = resultSet.getString("color");
                        String model = resultSet.getString("model");
                        int speed = resultSet.getInt("speed");
                        System.out.println("Name: " + name);
                        System.out.println("Сolor: " + color);
                        System.out.println("Model: " + model);
                        System.out.println("Speed: " + speed);
                        System.out.println("\n================\n");
                    }
                }
            if (Objects.equals(table, "users")) {
                    while (resultSet.next()) {
                        String name = resultSet.getString("name");
                        String surname = resultSet.getString("surname");
                        int money = resultSet.getInt("money");
                        int birthday = resultSet.getInt("birthday");
                        System.out.println("Name: " + name);
                        System.out.println("Surname: " + surname);
                        System.out.println("Money: " + money);
                        System.out.println("Birthday: " + birthday);
                        System.out.println("\n================\n");
                    }
                }
                resultSet.close();

            }
    }
