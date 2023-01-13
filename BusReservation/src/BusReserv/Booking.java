package BusReserv;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
	String passengerName;
	int busNo;
	Date date;
	ArrayList<Booking> booking=new ArrayList<Booking>();	
	Scanner sc=new Scanner(System.in);
	
	
	
	public void bookingDetails()
	{
		System.out.println("Enter the Passenger Name : ");
		passengerName=sc.next();
		System.out.println("Enter the Bus No :");
		busNo=sc.nextInt();
		System.out.println("Enter the Date(dd-mm-yyyy) : ");
		String dateInput = sc.next();
		
		/*SimpleDateFormat sp=new SimpleDateFormat("dd-MM-yyyy");
		try {
			date=(Date) sp.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		Booking b1=new Booking(passengerName,busNo);
		booking.add(b1);
		//java.sql.Date date1=new java.sql.Date(date); 
	}
	Booking(String passengerName,int busNo)
	{
		this.passengerName=passengerName;
		this.busNo=busNo;
		
	}
	public Booking() {
		// TODO Auto-generated constructor stub
	}
	public void conn()
	{
		String bookingQuery="insert into booking"+"(passenger_name,bus_no,date)"+"values(?,?,?)";
		Connection con = Connect.getConnection();
		try {
			PreparedStatement stt=con.prepareStatement(bookingQuery);
			stt.setString(1, passengerName);
			stt.setInt(2, busNo);
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = new Date(date.getTime());
			stt.setDate(3,  sqlDate);
			stt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void bookingValues()
	{
		Connection con = Connect.getConnection();
		try {
			String query="select * from booking";
			PreparedStatement pre =con.prepareStatement(query);
			ResultSet rs=pre.executeQuery();
			while(rs.next())
			{
				String s=rs.getString("passenger_name");
				int n=rs.getInt("bus_no");
				Date d=rs.getDate("date");
				//Booking b1=new Booking(s,n,d);
				//b1.display();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void display()
	{
		System.out.println("Name : "+this.passengerName+" BusNo : "+this.busNo+" Date You Booked : "+this.date);
	}
	public void deleteTableValues()
	{
		String delete="truncate table booking";
		Connection con = Connect.getConnection();
		try {
			PreparedStatement stt=con.prepareStatement(delete);
			stt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean isAvailable(ArrayList<Bus> buses2) {
		//ArrayList<Booking> booking;
		int capacity=0;
		for(Bus i:buses2)
		{
			if(i.getBusNo()==this.busNo)
			{
				capacity=i.getCapacity();
			}
		}
		
		int booked=0;
		for(Booking book:booking)
		{
			if(book.busNo==busNo)
			{
				booked++;
			}
		}
		return booked<capacity?true:false;
		
	}
			
	}
	
	
