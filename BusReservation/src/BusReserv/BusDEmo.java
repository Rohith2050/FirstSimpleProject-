package BusReserv;
import java.util.*;
public class BusDEmo {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		Bus b1=new Bus();
		b1.busInfo();
		Booking bookings=new Booking();
		int userOpt=1;
		
		while(userOpt==1)
		{
			System.out.println("**********-------************");
			System.out.println(" ");
			System.out.println("Enter 1 to Book a Bus");
			System.out.println(" ");
			System.out.println("Enter 2 to Exit from Booking");
			System.out.println(" ");
			System.out.println("**********-------************");
			System.out.println("      ");
			System.out.println("Now!!!......Enter the number:");
			userOpt=sc.nextInt();
			if(userOpt==1)
			{
				//bookings.conn();
				bookings.bookingDetails();
				b1.busValueImpliment();
				//Available.isAvailable();
				if(bookings.isAvailable(b1.getArrayList()))
				{
					bookings.conn();
					bookings.bookingValues();
					System.out.println(" ");
					System.out.println("**********-------***********");
					System.out.println("Thank you!!....Your Booking is Confirmed:)");
					System.out.println(" ");
					/*System.out.println("If you want details of your booking.Enter Yes:)");
					String y=sc.next();
					if(y.equalsIgnoreCase("yes")) {
						b.bookingdetails();
					}*/
				}else
				{
					//bookings.deleteTableValues();
					System.out.println("Sorry:(!!!!! The Bus is Booked try another day...");
					
				}
				
		}
	}
	}

}
