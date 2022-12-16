/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Giao_Dien;
import java.sql.*;
import java.sql.DriverManager;
public class Database {  
    public static Connection getConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:sqlserver://THINH\\SQLEXPRESSO:1433;databaseName=DO_AN;encrypt=false";
        
        return DriverManager.getConnection(url,"sa","bintapdoan");
    }

}
