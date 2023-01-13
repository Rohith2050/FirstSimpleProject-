package BusReserv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect{
	
	 public static Connection getConnection()
	 {
		 //Class.forName("com.mysql.jdbc.Driver");
		 Connection con = null;
		 try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/busreservation","root","N#@98wrft45");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	 }
}
