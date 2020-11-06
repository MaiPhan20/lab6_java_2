package bai2;

import java.sql.*;

public class bai2_1 {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind", "root", "");
                Statement statememt = connection.createStatement();
        ) {
            String strupdate = "update categories set CategoryName = 'SeaFood VN' where CategoryName = 'Seafood'";
            statememt.executeUpdate(strupdate);
            System.out.println("The SQL statement: "+strupdate+"\n");

            String strselect = "Select * from categories";
            ResultSet resultSet = statememt.executeQuery(strselect);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            for(int i = 1 ; i<resultSetMetaData.getColumnCount();i++){
                System.out.printf("%-40s",resultSetMetaData.getColumnName(i));
            }
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
