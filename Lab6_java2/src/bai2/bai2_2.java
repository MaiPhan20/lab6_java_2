package bai2;

import java.sql.*;

public class bai2_2 {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement statement = connection.createStatement();
        ) {
            String strupdate = "update customers set Address = '1A Yet Kieu - Ha Noi' where CustomerID = 'FRANK'";
            statement.executeUpdate(strupdate);
            System.out.println("Updated the SQL statement: "+strupdate);
            String strselect = "Select * from customers where CustomerID = 'FRANK'";
            ResultSet resultSet = statement.executeQuery(strselect);
            ResultSetMetaData rstMD = resultSet.getMetaData();
            for(int i =  1 ; i<rstMD.getColumnCount();i++){
                System.out.printf("%-40s",rstMD.getColumnName(i));
            }
            System.out.println();
            while (resultSet.next()){
                for(int i =1;i<rstMD.getColumnCount();i++){
                    System.out.printf("%-40s",resultSet.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
