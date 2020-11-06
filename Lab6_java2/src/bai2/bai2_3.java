package bai2;

import java.sql.*;

public class bai2_3 {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement statement = connection.createStatement();
        ) {
            String strupdate = "update products set UnitPrice = UnitPrice * 0.01+UnitPrice where CategoryID in (5,7,8)";
            statement.executeUpdate(strupdate);
            System.out.println("The SQL statement: "+strupdate);

            String strselect = "Select * from products where CategoryID in (5,7,8)";
            ResultSet resultSet = statement.executeQuery(strselect);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for(int i =  1 ; i<resultSetMetaData.getColumnCount();i++){
                System.out.printf("%-40s",resultSetMetaData.getColumnName(i));
            }
            System.out.println(strselect);
            while (resultSet.next()){
                for(int i =1;i<resultSetMetaData.getColumnCount();i++){
                    System.out.printf("%-40s",resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
