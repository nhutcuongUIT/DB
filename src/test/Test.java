/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author CUONGUIT
 */
public class Test {
    private static String  DB_URL = "jdbc:sqlserver://localhost:1433;"
            +"databaseName = testdb;"
            +"intergratedSecurity=true";
    private static  String user_name ="sa";
    private static String pass_word = "sa";
    public static void main(String[] args)  {
        // TODO code application logic here
        try
        {
            //connect to database testdb
            Connection conn = getConnection(DB_URL,user_name,pass_word);
            //create stmt 
            java.sql.Statement stmt = conn.createStatement();
            // get data from table "student"
            ResultSet rs = stmt.executeQuery("select * from student");
            //show data
            while(rs.next())
            {
                System.out.println("\n"+rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
            }
            conn.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(String dbURL,String username,String password)
    {
        Connection conn = null;
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL,username,password);
            System.out.print("connect successfully");
            
        }catch(Exception ex)
        {
            System.out.print("connect fail!");
            ex.printStackTrace();
        }
        return conn;
    }
}
