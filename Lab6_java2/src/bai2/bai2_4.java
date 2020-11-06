package bai2;

import java.sql.*;

public class bai2_4 {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement statement = connection.createStatement();
        ) {
            String strupdate = "update orders set ShipVia = 3 where OrderID= 10313";
            statement.executeUpdate(strupdate);
            System.out.println("Updated the SQL statement: " + strupdate);

            String strselect = "Select * from orders where OrderID= 10313";
            ResultSet resultSet = statement.executeQuery(strselect);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                System.out.printf("%-40s", resultSetMetaData.getColumnName(i));
            }
            System.out.println(strselect);
            while (resultSet.next()) {
                for (int i = 1; i < resultSetMetaData.getColumnCount(); i++) {
                    System.out.printf("%-40s", resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
