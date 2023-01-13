package BusReserv;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Bus {
	private int busNo;
	private String ac;
	private int capacity;
	String date="20-10-2022";
	public ArrayList<Bus> buses1=new ArrayList<Bus>();
	
    public ArrayList<Bus> getArrayList() {
        return this.buses1;
    }
    
	Bus()
	{
		
	}
	Bus(int no,String ac,int capacity)
	{
		this.busNo=no;
		this.ac=ac;
		this.capacity=capacity;
	}

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String isAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void busInfo()
	{
		Connection con = Connect.getConnection();
		try {
			String query="select * from bus";
			PreparedStatement pre =con.prepareStatement(query);
			ResultSet rs=pre.executeQuery();
			Bus b1=new Bus();
			b1.welcome();
			while(rs.next())
			{
				int x=rs.getInt("bus_no");
				String y=rs.getString("ac");
				int z=rs.getInt("capacity");
				b1=new Bus(x,y,z);
				buses1.add(new Bus(x,y,z));
				System.out.println(b1.getBusNo());
				b1.displayBusInfo();
				b1.driverInfo();
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBusValues()
	{
		String delete="truncate table bus";
		Connection con = Connect.getConnection();
		try {
			PreparedStatement stt=con.prepareStatement(delete);
			stt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void busValueImpliment()
	{
		/*String busQuery="insert into bus"+"(bus_no,ac,capacity)"+"values(?,?,?)";
		Connection con = Connect.getConnection();
		try {
			PreparedStatement pre =con.prepareStatement(busQuery);
			pre.setInt(1, 1003);
			pre.setString(2, "false");
			pre.setInt(3, 45);
			pre.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//buses.add(new Bus(1001,"true",25));
		//buses.add(new Bus(1002,"false",45));
	}
	public void displayBusInfo()
	{
		if(this.busNo==1001)
		{
			System.out.println("From Chennai to Bangalore");
			System.out.println("Bus No : "+busNo+"|| Ac : "+ac+" || Capacity : "+capacity);
		}
		else if(this.busNo==1002)
		{
			System.out.println("From Kochi to Bangalore");
			System.out.println("Bus No : "+busNo+"|| Ac : "+ac+" || Capacity : "+capacity);
		}else
		{
			System.out.println("Not Available");
		}
		
	}
	public void driverInfo()
	{
		
		if(this.busNo==1001)
		{
			System.out.println("**********************************************************");
			System.out.println("Driver Information:");
			System.out.println("Name        : Rook ");
			System.out.println("Contact info: 89572 XXX25");
			
		}else if(this.busNo==1002)
		{
			System.out.println("**********************************************************");
			System.out.println("Driver Information:");
			System.out.println("Name        : Rook ");
			System.out.println("Contact info: 89572 XXX25");	
		}
		System.out.println("**********************************************************");
		System.out.println("                                        ");
		
	}
	public void welcome()
	{
		System.out.println("**** // Welcome to Busss Booking \\ ****");
		System.out.println("                                        ");
		System.out.println("               ********                  ");
	}
	/*public void bookingdetails()
	{
		System.out.println("Your Booking Details........");
		System.out.println(" ");
		System.out.println("Bus No:"+this.busNo);
		driverInfo();
	}*/
	
	
}
