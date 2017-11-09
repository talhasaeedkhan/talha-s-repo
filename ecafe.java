/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//import java.sql.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class ecafe {
	
	 public static void main(String[] args) throws SQLException {
		 String pass="";
		 String name="root";
	        System.out.println("Hello World!"); //Display the string.
	        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/e-cafe",name,pass);
	        Statement statement = connection.createStatement();
                
                System.out.println("WELCOME TO THE CAFE!!");
                
                System.out.println("APPETIZERS");
                ResultSet appetizers = statement.executeQuery("SELECT * FROM appetizer");

	        		
	        		while (appetizers.next()){
	        			System.out.print(appetizers.getInt(1));
	        			System.out.print("\t");
	        			System.out.print(appetizers.getString(2));
	        			System.out.print("\t");
	        			System.out.print(appetizers.getInt(3));
	        			System.out.print("\n");
	        			}
                
               
                                
                                System.out.println("SOUPS:");
	        ResultSet souprs = statement.executeQuery("SELECT * FROM soup");

	        		
	        		while (souprs.next()){
	        			System.out.print(souprs.getInt(1));
	        			System.out.print("\t");
	        			System.out.print(souprs.getString(2));
	        			System.out.print("\t");
	        			System.out.print(souprs.getInt(3));
	        			System.out.print("\n");
	        			}
                                System.out.println("MAIN:");
	        ResultSet mainrs = statement.executeQuery("SELECT * FROM main");

	        		
	        		while (mainrs.next()){
	        			System.out.print(mainrs.getInt(1));
	        			System.out.print("\t");
	        			System.out.print(mainrs.getString(2));
	        			System.out.print("\t");
	        			System.out.print(mainrs.getInt(3));
	        			System.out.print("\n");
	        			}
                                
                                System.out.println("SIDE:");
	        ResultSet siderrs = statement.executeQuery("SELECT * FROM side");	        		
	        		while (siderrs.next()){
	        			System.out.print(siderrs.getInt(1));
	        			System.out.print("\t");
	        			System.out.print(siderrs.getString(2));
	        			System.out.print("\t");
	        			System.out.print(siderrs.getInt(3));
	        			System.out.print("\n"); 
                                }
         

                                                                               
      // create the mysql insert preparedstatement
      String query="UPDATE `main` SET Price=? where Name=? ";
      PreparedStatement preparedStmt = connection.prepareStatement(query);
      preparedStmt.setInt (1,550);
      preparedStmt.setString (2, "Lasagna");
      
      // execute the preparedstatement
      preparedStmt.executeUpdate();
      
    String query1 = "Insert into `order` (item_id,Name,Price,prep_time) values(?,?,?,?)";
          PreparedStatement preparedStmt1 = connection.prepareStatement(query1);

    preparedStmt1.setInt (1,1);
    preparedStmt1.setString (2, "Lasagna");
    preparedStmt1.setInt (3,300);
    preparedStmt1.setInt(4, 20);
    preparedStmt1.executeUpdate();

    
            String query2="SELECT Name,Price FROM `side` WHERE Name= ?";
    PreparedStatement preparedStmt2 = connection.prepareStatement(query2);
     preparedStmt2.setString (1,"Corn");
   
ResultSet rs = preparedStmt2.executeQuery();
			while (rs.next()) {
String Dname = rs.getString("Name");
String Dprice = rs.getString("Price");
System.out.println("Dish Name : " + Dname);
System.out.println("Price : " + Dprice);
                        }
                        
                        String query3="SELECT * FROM `soup`";
    PreparedStatement preparedStmt3 = connection.prepareStatement(query3);
                        ResultSet rs1 = preparedStmt3.executeQuery();
			while (rs1.next()) {
String Dname = rs1.getString("Name");
String Dprice = rs1.getString("Price");
String Dprep = rs1.getString("prep_time");

System.out.println("Soup Name : " + Dname);
System.out.println("Price : " + Dprice);
System.out.println("Price : " + Dprep);
                        }
CallableStatement cstmt = null;
String SQL = "{call insertitem (?,?,?,?)}";
cstmt = connection.prepareCall (SQL);
cstmt.setInt(1, 8);
cstmt.setString(2, "Chicken Roast");
cstmt.setInt(3, 500);
cstmt.setInt(4, 15);
cstmt.execute();
         }   
}

	        
                                


